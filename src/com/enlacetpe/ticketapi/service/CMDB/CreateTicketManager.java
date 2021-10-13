
package com.enlacetpe.ticketapi.service.CMDB;

import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.xml.rpc.holders.StringHolder;

import org.apache.axis.client.Call;
import org.apache.log4j.Logger;
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
import com.enlacetpe.ticketapi.model.SdmProbCtgModel;
import com.enlacetpe.ticketapi.repository.SdmProbCtgRepository;
import com.enlacetpe.ticketapi.request.CreateTicketRequest;
import com.enlacetpe.ticketapi.response.CATicket;
import com.enlacetpe.ticketapi.response.CATicketList;

@Service
public class CreateTicketManager {
	
	final static Logger logger = Logger.getLogger(CreateTicketManager.class);

	@Autowired
	private CALogInValidator logInValidator;

	@Autowired
	private CAQueryValidator queryValidator;

	@Autowired
	private CAObjectValidator objValidator;

	@Autowired
	private SdmProbCtgRepository sdmProbCtgRepository;


	public CATicketList createTicket(CreateTicketRequest request) {
		DateTime initial = new DateTime();
		ArrayList<CATicket> tickets = new ArrayList<CATicket>();
		Integer token = null;
		Boolean success = true;
		String error = null;
		String mssg = "CrearTicketCMDB-CARE: Exito al crear Ticket";
		try {

				CATicketMapper mapper = new CATicketMapper();
				token = logInValidator.getToken();
				String userHandle = logInValidator.getUserHandle(token);
				String[] propertyValues = {};
				String[] attributes = {};

				logger.info("Tipo de ticket: " + request.getTipo() + " La punta: " + request.getPuntaId());
				String ticket = "";
				if(request.getTipo().equalsIgnoreCase("I")) {
					String id = request.getPuntaId().replace("0x", "");
					String existetActivos = TicketQueryBuilder.buildQuery(id, "ticketsActivos"); // Busco si hay tickets activos
					String existetActivosXml = queryValidator.doSelect(token, "cr", existetActivos, 1,TicketDictionary.refNumParam);
					ticket = mapper.getValueByAttrName(existetActivosXml, TicketDictionary.refNum);
				
				}else if(request.getTipo().equalsIgnoreCase("P")) {
					String id = request.getPuntaId().replace("0x", "");
					String existetActivos = TicketQueryBuilder.buildQuery(id, "ticketsProblemas"); // Busco si hay problemas activos
					String existetActivosXml = queryValidator.doSelect(token, "cr", existetActivos, 1,TicketDictionary.refNumParam);
					ticket = mapper.getValueByAttrName(existetActivosXml, TicketDictionary.refNum);
				}
				
				logger.info("Tiene tickets?  " + ticket);
				if (ticket.isEmpty()) {
					logger.info("Va a generar ticket");
					StringHolder newRequestHandle = new StringHolder();
					StringHolder newRequestNumber = new StringHolder();

					String requestByCriteria = TicketQueryBuilder.buildQuery(request.getSolicitadoPor(), "userCreate"); // Busco solicitante
					String requestByXml = queryValidator.doSelect(token, "cnt", requestByCriteria, 1,TicketDictionary.persistentIdParam);
					String requestBy = mapper.getValueByAttrName(requestByXml, TicketDictionary.id);

					String requestByCriteriaGrupo = TicketQueryBuilder.buildQuery(request.getGrupo(), "group"); // Busco Grupo																				
					String requestByXmlGrupo = queryValidator.doSelect(token, "cnt", requestByCriteriaGrupo, 1,TicketDictionary.persistentIdParam);
					String grupoId = mapper.getValueByAttrName(requestByXmlGrupo, TicketDictionary.id);

					String requestByCriteriaOrganizacion = TicketQueryBuilder.buildQuery(request.getOrganizacion(),"organization"); // Busco organizacion
					String requestByXmlOrganizacion = queryValidator.doSelect(token, "org",requestByCriteriaOrganizacion, 1, TicketDictionary.persistentIdParam);
					String orgId = mapper.getValueByAttrName(requestByXmlOrganizacion, TicketDictionary.id);
					
					String requestByCriteriaTenant = TicketQueryBuilder.buildQuery(request.getTenant(),"tenant"); // Busco tenant
					String requestByXmlTenant = queryValidator.doSelect(token, "tenant",requestByCriteriaTenant, 1, TicketDictionary.persistentIdParam);
					String tenantId = mapper.getValueByAttrName(requestByXmlTenant, TicketDictionary.id);
					
					if (!requestBy.isEmpty()) {
						String type = TicketQueryBuilder.validateTicketType(request.getTipo());
						SdmProbCtgModel categoria = sdmProbCtgRepository.findBySym(request.getCategoria());// buscar nomnre de categoria
						logger.info("Busco la categoria" + categoria);
						if (categoria != null) {
							String category = categoria.getPersid();
							String[] argsCreate = null;
							if (type != null) {
								String[] array = request.getDescripcion();
								if(request.getTipo().equalsIgnoreCase("I")) {
									argsCreate = new String[] { 
											"requested_by", requestBy, 
											"customer", requestBy,
											"category", category, 
											"created_via", "3556", 
											"summary", request.getResumen(),
											"description", array[0], 
											"type", type, 
											"affected_resource",request.getPuntaId().replace("0x", "nr:"), 
											"zorg_id", orgId,
											"group", grupoId,
											"status", request.getEstatus(),
											"log_agent", requestBy,
											
											"zdiag_inicial",request.getDiagnosticoInicial(),
											"ztipo_red",request.getTipoRed(),
											"zRegCiu_id",request.getRegCiuId(),
											"zes_proactivo_reactivo",request.getProactivoReactivo(),
											"external_system_ticket",request.getTicketExterno(),
											"tenant",tenantId
											
											
									};

									System.out.println(requestBy + " " + category + " " + type + " " + request.getPuntaId() +" " + orgId + " " + grupoId + " " + request.getEstatus() + " " + request.getDiagnosticoInicial() + " " + request.getTipoRed()+
											" " + request.getRegCiuId() + " "+ request.getProactivoReactivo() + " "+ request.getTicketExterno() );
								}else if(request.getTipo().equalsIgnoreCase("P")) {
									argsCreate = new String[] { 
											"requested_by", requestBy, 
											"customer", requestBy,
											"category", category, 
											"created_via", "3556", 
											"summary", request.getResumen(),
											"description", array[0], 
											"type", type, 
											"affected_resource",request.getPuntaId().replace("0x", "nr:"), 
											"zorg_id", orgId,
											"group", grupoId,
											"status", request.getEstatus(),
											"log_agent", requestBy,
											
											"zdiag_inicial",request.getDiagnosticoInicial(),
											"ztipo_red",request.getTipoRed(),
											"zRegCiu_id",request.getRegCiuId(),
											"zes_proactivo_reactivo",request.getProactivoReactivo(),
											"external_system_ticket",request.getTicketExterno(),
											
									};
								}
								String xml = objValidator.createTicket(token, userHandle, argsCreate, propertyValues,
										attributes, newRequestHandle, newRequestNumber);
								
								System.out.println();
								tickets = mapper.mapUnique(xml);
								logger.info("Se creo el ticket: " + tickets.get(0).getRefNum() + "para la punta: " +request.getPuntaId());

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
											newRequestHandle.value, "Archivo creado", request.getUrl());
									if (attmntHandle.length() > 0)
										mssg = "CreateTicket: El ticket y el archivo fueron creados";
								}

							} else {
								success = false;
								error = "CrearTicket: Tipo invalido";
								mssg = "CreateTicket: Tipo invalido";
								logger.info("Tipo invalido");

							}
						} else {
							success = false;
							error = "CrearTicket: Categoria no encontrada";
							mssg = "CreateTicket: Categoria no encontrada";
							logger.info("categoria no encontrada");

						}

					} else {
						success = false;
						error = "CrearTicket: Solicitante no encontrado";
						mssg = "CreateTicket: Solicitante no encontrado";
						logger.info("Solicitante no encontrado");
					}

				} else {
					success = false;
					error = "CrearTicket: El elemento de configuración tiene un ticket activo";
					mssg = "CreateTicket: El elemento de configuración tiene un ticket activo";
					logger.info("Ya existe un ticket activo para esta punta");

				}
				boolean cerrado = logInValidator.closeToken(token);
				System.out.println("Se cierra sesion: " + cerrado);
				token = null;
		} catch (Exception e) {
			success = false;
			error = e.toString();
			mssg = "CreateTicketCMDB-CARE: Ocurrio un error al crear ticket" + e;
			logger.info("Error: " + e);
		} finally {
			try {
				if (token != null)
					logInValidator.closeToken(token);
			} catch (RemoteException e) {
				logger.info("Error Ticket" + e);
			}
		}

		Period period = new Period(initial, new DateTime());
		if (tickets != null)
			return new CATicketList(success, period, error, mssg, tickets.size(), tickets);
		else
			return new CATicketList(success, period, error, mssg, 0);
	}

}
