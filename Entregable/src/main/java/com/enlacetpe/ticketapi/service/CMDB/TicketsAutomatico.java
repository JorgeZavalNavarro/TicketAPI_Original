package com.enlacetpe.ticketapi.service.CMDB;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.xml.rpc.holders.StringHolder;

import org.apache.axis.client.Call;
import org.joda.time.DateTime;
import org.joda.time.Period;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ca.www.UnicenterServicePlus.ServiceDesk.USD_WebServiceLocator;
import com.ca.www.UnicenterServicePlus.ServiceDesk.USD_WebServiceSoap;
import com.enlacetpe.ticketapi.caManager.serviceDesk.CALogInValidator;
import com.enlacetpe.ticketapi.caManager.serviceDesk.CAObjectValidator;
import com.enlacetpe.ticketapi.caManager.serviceDesk.CAQueryValidator;
import com.enlacetpe.ticketapi.caMapper.serviceDesk.CATicketMapper;
import com.enlacetpe.ticketapi.caQueryBuilder.TicketQueryBuilder;
import com.enlacetpe.ticketapi.dictionary.TicketDictionary;
import com.enlacetpe.ticketapi.model.SdmCaContactModel;
import com.enlacetpe.ticketapi.model.SdmCaOrganizationModel;
import com.enlacetpe.ticketapi.model.SdmProbCtgModel;
import com.enlacetpe.ticketapi.repository.SdmCaContactRepository;
import com.enlacetpe.ticketapi.repository.SdmCaOrganizationRepository;
import com.enlacetpe.ticketapi.repository.SdmProbCtgRepository;
import com.enlacetpe.ticketapi.request.OperationTicketAutomatico;
import com.enlacetpe.ticketapi.request.OperationTicketRequest;
import com.enlacetpe.ticketapi.request.SolicitudRequest;
import com.enlacetpe.ticketapi.response.CATicket;
import com.enlacetpe.ticketapi.response.CATicketList;

@Service
public class TicketsAutomatico {

	@Autowired
	private CALogInValidator logInValidator;

	@Autowired
	private CAQueryValidator queryValidator;

	@Autowired
	private CAObjectValidator objValidator;

	@Autowired
	private SdmProbCtgRepository sdmProbCtgRepository;

	@Autowired
	private SdmCaContactRepository sdmCaContactRepository;

	@Autowired
	private SdmCaOrganizationRepository sdmCaOrganizationRepository;

	public CATicketList createTicketAutomatico(OperationTicketAutomatico request) {
		DateTime initial = new DateTime();
		ArrayList<CATicket> tickets = new ArrayList<CATicket>();
		Integer token = null;
		Boolean success = true;
		String error = null;
		String mssg = "CrearTicketCMDB-CARE: Exito al crear Ticket";
		try {
			String uuidOrganization = null;
			if (request.getIdItsm().isEmpty() && request.getOrganization().isEmpty()) {
				success = false;
				error = "CrearTicketCMDB-CARE: La organización o el idItsm deben estar llenos";
				mssg = "CreateTicketCMDB-CARE: La organización o el idItsm deben estar llenos";
			} else if (!request.getIdItsm().isEmpty()) {
				SdmCaOrganizationModel idItsmOrg = sdmCaOrganizationRepository.findByAbbreviation(request.getIdItsm());
				if (idItsmOrg != null && idItsmOrg.getInactive() == 0) {
					uuidOrganization = idItsmOrg.getOrganizationUuid().replace("0x", "org:");
				} else if (!request.getOrganization().isEmpty()) {
					SdmCaOrganizationModel org = sdmCaOrganizationRepository.findByOrgName(request.getOrganization());
					if (org != null && org.getInactive() == 0) {
						uuidOrganization = org.getOrganizationUuid().replace("0x", "org:");
					}
				}
			} else {
				SdmCaOrganizationModel org = sdmCaOrganizationRepository.findByOrgName(request.getOrganization());
				if (org != null && org.getInactive() == 0) {
					uuidOrganization = org.getOrganizationUuid().replace("0x", "org:");
				}
			}

			if (uuidOrganization != null) {
				CATicketMapper mapper = new CATicketMapper();
				token = logInValidator.getToken();
				String userHandle = logInValidator.getUserHandle(token);
				String[] propertyValues = {};
				String[] attributes = {};

				// String id = request.getPeack().replace("0x", "");
				// String existetActivos = TicketQueryBuilder.buildQuery(id,
				// "ticketsActivos"); //Busco si hay tickets activos
				// String existetActivosXml = queryValidator.doSelect(token,
				// "cr", existetActivos, 1,TicketDictionary.refNumParam);
				// String ticket = mapper.getValueByAttrName(existetActivosXml,
				// TicketDictionary.refNum);

				// ticket.isEmpty()
				if (true) {
					System.out.println("Entro para generar ticket");
					if (!request.getGroup().isEmpty()) {
						StringHolder newRequestHandle = new StringHolder();
						StringHolder newRequestNumber = new StringHolder();
						// String requestByCriteria =
						// TicketQueryBuilder.buildQuery(request.getRequestBy(),
						// "userCreate"); //Busco por nombre esto lo comente
						// String requestByXml = queryValidator.doSelect(token,
						// "cnt", requestByCriteria,
						// 1,TicketDictionary.persistentIdParam);
						// String requestBy =
						// mapper.getValueByAttrName(requestByXml,
						// TicketDictionary.id);

						// String requestByCriteriaGrupo =
						// TicketQueryBuilder.buildQuery(request.getGroup(),
						// "group"); //Busco por nombre
						// String requestByXmlGrupo =
						// queryValidator.doSelect(token,
						// "cnt",requestByCriteriaGrupo,
						// 1,TicketDictionary.persistentIdParam);
						// String grupoId =
						// mapper.getValueByAttrName(requestByXmlGrupo,
						// TicketDictionary.id);

						String type = TicketQueryBuilder.validateTicketType(request.getType());

						// SdmProbCtgModel categoria =
						// sdmProbCtgRepository.findById(Integer.valueOf(request.getCategoryId()));//buscar
						// Id de categoria
						SdmProbCtgModel categoria = sdmProbCtgRepository.findById(Integer.valueOf(401156));// buscar
																											// Id
																											// de
																											// categoria

						if (categoria != null) {
							String category = categoria.getPersid();
							if (category != null && !category.equals("") && type != null) {
								String[] argsCreate = new String[] { "requested_by", "F053F2A1EF497745BB0D678FF8B2187F", // requestBy
										"customer", "F053F2A1EF497745BB0D678FF8B2187F", // requestby
										"category", category, // "created_via",
																// "3555",
										"summary", request.getSummary(), "description", request.getDesc(), "type", type,
										"zip1", request.getPeack(), "zdiag_inicial", request.getDiagInitial(),
										"ztipo_red", request.getNetworkType(), "zRegCiu_id", request.getRegCiuId(),
										"log_agent", "F053F2A1EF497745BB0D678FF8B2187F", "zorg_id", uuidOrganization,
										"group", "CE0F30D6DE9D864A8D6B3CA107CA1590", "zes_proactivo_reactivo",
										request.getProactivoReactivo(), "external_system_ticket",
										request.getTicketSistemaExterno(), "zNivel_Soporte", "N1", };
								String xml = objValidator.createTicket(token, userHandle, argsCreate, propertyValues,
										attributes, newRequestHandle, newRequestNumber);
								tickets = mapper.mapUnique(xml);
								System.out.println("Se creo el ticket " + tickets.get(0).getRefNum());

								// se crea archivo
								if (!request.getUrl().isEmpty() || request.getUrl() != "") {
									String ServiceDeskDocumentRepository = "doc_rep:1002";
									USD_WebServiceLocator ws = new USD_WebServiceLocator();
									java.net.URL url = new java.net.URL(ws.getUSD_WebServiceSoapAddress());
									USD_WebServiceSoap usd = ws.getUSD_WebServiceSoap(url);
									FileDataSource fds = new FileDataSource(request.getUrl());
									DataHandler dhandler = new DataHandler(fds);
									((org.apache.axis.client.Stub) usd)._setProperty(
											Call.ATTACHMENT_ENCAPSULATION_FORMAT,
											Call.ATTACHMENT_ENCAPSULATION_FORMAT_DIME);
									((org.apache.axis.client.Stub) usd).addAttachment(dhandler);

									String attmntHandle = usd.createAttachment(token, ServiceDeskDocumentRepository,
											newRequestHandle.value, "Archivo creado desde el SMC", request.getUrl());
									if (attmntHandle.length() > 0)
										mssg = "CreateTicket: El ticket y el archivo fueron creados";
								}

							} else {
								success = false;
								error = "CrearTicketCMDB-CARE: Parametros no validos para crear ticket";
								mssg = "CreateTicketCMDB-CARE: Ocurrio un error al crear ticket";

							}
						}
					} else {
						success = false;
						error = "CrearTicketCMDB-CARE: El grupo es campo requerido";
						mssg = "CreateTicketCMDB-CARE: El grupo es campo requerido";
					}

				} else {
					success = false;
					error = "CrearTicketCMDB-CARE: El elemento de configuración ya tiene un tickets activo";
					mssg = "CreateTicketCMDB-CARE: El elemento de configuración ya tiene un tickets activo";
				}
			} else {
				success = false;
				error = "CrearTicketCMDB-CARE: Organización no encontrada o inactiva";
				mssg = "CreateTicketCMDB-CARE: Organización no encontrada o inactiva";
			}
			logInValidator.closeToken(token);
		} catch (Exception e) {
			success = false;
			error = e.toString();
			mssg = "CreateTicketCMDB-CARE: Ocurrio un error al crear ticket" + e;
		} finally {
			try {
				if (token != null)
					logInValidator.closeToken(token);
			} catch (RemoteException e) {
				System.out.println("Error Ticket CARE" + e);
			}
		}

		Period period = new Period(initial, new DateTime());
		if (tickets != null)
			return new CATicketList(success, period, error, mssg, tickets.size(), tickets);
		else
			return new CATicketList(success, period, error, mssg, 0);
	}

}
