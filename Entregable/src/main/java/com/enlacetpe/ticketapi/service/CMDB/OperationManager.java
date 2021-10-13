package com.enlacetpe.ticketapi.service.CMDB;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.xml.rpc.holders.StringHolder;

import org.apache.axis.client.Call;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.Period;
import org.primefaces.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ca.www.UnicenterServicePlus.ServiceDesk.ListResult;
import com.ca.www.UnicenterServicePlus.ServiceDesk.USD_WebServiceLocator;
import com.ca.www.UnicenterServicePlus.ServiceDesk.USD_WebServiceSoap;
import com.enlacetpe.ticketapi.caManager.serviceDesk.CALogInValidator;
import com.enlacetpe.ticketapi.caManager.serviceDesk.CAObjectValidator;
import com.enlacetpe.ticketapi.caManager.serviceDesk.CAObjectValidatorSFB64;
import com.enlacetpe.ticketapi.caManager.serviceDesk.CAQueryValidator;
import com.enlacetpe.ticketapi.caMapper.serviceDesk.CAMapper;
import com.enlacetpe.ticketapi.caMapper.serviceDesk.CATicketMapper;
import com.enlacetpe.ticketapi.caQueryBuilder.QueryBuilder;
import com.enlacetpe.ticketapi.caQueryBuilder.TicketQueryBuilder;
import com.enlacetpe.ticketapi.dictionary.TicketDictionary;
import com.enlacetpe.ticketapi.model.SdmCaOrganizationModel;
import com.enlacetpe.ticketapi.model.SdmCaOwnedResourceModel;
import com.enlacetpe.ticketapi.model.SdmCallReqModel;
import com.enlacetpe.ticketapi.model.SdmChgModel;
import com.enlacetpe.ticketapi.model.SdmCrStatModel;
import com.enlacetpe.ticketapi.model.SdmProbCtgModel;
import com.enlacetpe.ticketapi.repository.SdmCaOrganizationRepository;
import com.enlacetpe.ticketapi.repository.SdmCaOwnedResourceRepository;
import com.enlacetpe.ticketapi.repository.SdmCallReqRepository;
import com.enlacetpe.ticketapi.repository.SdmChgRepository;
import com.enlacetpe.ticketapi.repository.SdmCrStatRepository;
import com.enlacetpe.ticketapi.repository.SdmProbCtgRepository;
import com.enlacetpe.ticketapi.repositoryTicketApiSD.BitacoraPeticionesRepository;
import com.enlacetpe.ticketapi.request.ActualizaIPRequest;
import com.enlacetpe.ticketapi.request.ActualizaTiemposImputablesRequest;
import com.enlacetpe.ticketapi.request.ActualizarEstatusOperationRequest;
import com.enlacetpe.ticketapi.request.ActualizarEstatusRequest;
import com.enlacetpe.ticketapi.request.ActualizarPuntaRequest;
import com.enlacetpe.ticketapi.request.AdjuntarArchivoRequest;
import com.enlacetpe.ticketapi.request.AdjuntarLigaArchivoRequest;
import com.enlacetpe.ticketapi.request.AgregarComentarioOperationRequest;
import com.enlacetpe.ticketapi.request.NumSerieRequest;
import com.enlacetpe.ticketapi.request.ONTRequest;
import com.enlacetpe.ticketapi.request.OperationPreTicketCare;
import com.enlacetpe.ticketapi.request.OperationPreTicketNoc;
import com.enlacetpe.ticketapi.request.OperationTicketNocRequest;
import com.enlacetpe.ticketapi.request.OperationTicketRequest;
import com.enlacetpe.ticketapi.request.PruebasRequest;
import com.enlacetpe.ticketapi.request.RfcRequest;
import com.enlacetpe.ticketapi.request.TransferenciaGrupoOperationRequest;
import com.enlacetpe.ticketapi.request.TransferenciaGrupoRequest;
import com.enlacetpe.ticketapi.request.UpdateRequest;
import com.enlacetpe.ticketapi.response.ActualizarEstatusOperationResponse;
import com.enlacetpe.ticketapi.response.ActualizarPuntaResponse;
import com.enlacetpe.ticketapi.response.AgregarComentarioResponse;
import com.enlacetpe.ticketapi.response.CAResponse;
import com.enlacetpe.ticketapi.response.CARfc;
import com.enlacetpe.ticketapi.response.CARfcList;
import com.enlacetpe.ticketapi.response.CATicket;
import com.enlacetpe.ticketapi.response.CATicketList;
import com.enlacetpe.ticketapi.response.CAuuid;
import com.enlacetpe.ticketapi.response.TAdjuntarLigaArchivoResponse;
import com.enlacetpe.ticketapi.response.TablerosResponse;
import com.enlacetpe.ticketapi.response.TransferenciaGrupoResponse;
import com.enlacetpe.ticketapi.service.apis.ServiceArchivoSD;
import com.enlacetpe.ticketapi.util.ActivityLogger;

import Integracion_TPE_SF_B64_pkg.ResponseWS;
import io.swagger.annotations.ApiOperation;

@Service
public class OperationManager {

	final static Logger logger = Logger.getLogger(OperationManager.class);

	@Autowired
	private CALogInValidator logInValidator;

	@Autowired
	private CAQueryValidator queryValidator;

	@Autowired
	private CAObjectValidator objValidator;

	@Autowired
	private SdmProbCtgRepository sdmProbCtgRepository;

	@Autowired
	private SdmCaOrganizationRepository sdmCaOrganizationRepository;

	@Autowired
	private SdmCaOwnedResourceRepository sdmCaOwnedResourceRepository;

	@Autowired
	private SdmChgRepository sdmChgRepository;

	@Autowired
	private SdmCallReqRepository sdmCallReqRepository;

	@Autowired
	private CAObjectValidatorSFB64 integracionSFB64;

	@Autowired
	private ServiceArchivoSD serviceArchivoSD;

	@Autowired
	private SdmCrStatRepository sdmCrStatRepository;

	// @Autowired
	// private BitacoraPeticionesRepository bitacoraRepository;

	public CATicketList createTicketCMDBCARE(OperationTicketRequest request) {
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

				String id = request.getPeack().replace("0x", "");
				String existetActivos = TicketQueryBuilder.buildQuery(id, "ticketsActivos"); // Busco
																								// si
																								// hay
																								// tickets
																								// activos
				String existetActivosXml = queryValidator.doSelect(token, "cr", existetActivos, 1,
						TicketDictionary.refNumParam);
				String ticket = mapper.getValueByAttrName(existetActivosXml, TicketDictionary.refNum);

				if (ticket.isEmpty()) {
					if (!request.getGroup().isEmpty()) {
						StringHolder newRequestHandle = new StringHolder();
						StringHolder newRequestNumber = new StringHolder();
						String requestByCriteria = TicketQueryBuilder.buildQuery(request.getRequestBy(), "userCreate"); // Busco
																														// por
																														// id
																														// del
																														// creador
						String requestByXml = queryValidator.doSelect(token, "cnt", requestByCriteria, 1,
								TicketDictionary.persistentIdParam);
						String requestBy = mapper.getValueByAttrName(requestByXml, TicketDictionary.id);

						String requestByCriteriaGrupo = TicketQueryBuilder.buildQuery(request.getGroup(), "group"); // Busco
																													// por
																													// nombre
						String requestByXmlGrupo = queryValidator.doSelect(token, "cnt", requestByCriteriaGrupo, 1,
								TicketDictionary.persistentIdParam);
						String grupoId = mapper.getValueByAttrName(requestByXmlGrupo, TicketDictionary.id);

						String type = TicketQueryBuilder.validateTicketType(request.getType());

						SdmProbCtgModel categoria = sdmProbCtgRepository
								.findById(Integer.valueOf(request.getCategoryId()));// buscar
																					// Id
																					// de
																					// categoria

						if (categoria != null) {
							String category = categoria.getPersid();
							if (category != null && !category.equals("") && type != null) {
								String[] array = request.getDesc();
								String[] argsCreate = new String[] { "requested_by", requestBy, "customer", requestBy,
										"category", category, "created_via", "3556", "summary", request.getSummary(),
										"description", array[0], "type", type, "affected_resource",
										request.getPeack().replace("0x", "nr:"), "zdiag_inicial",
										request.getDiagInitial(), "ztipo_red", request.getNetworkType(), "zRegCiu_id",
										request.getRegCiuId(), "log_agent", requestBy, "zorg_id", uuidOrganization,
										"group", grupoId, };
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

	public CATicketList createTicketCMDBNOC(OperationTicketNocRequest request) {
		DateTime initial = new DateTime();
		ArrayList<CATicket> tickets = new ArrayList<CATicket>();
		Integer token = null;
		Boolean success = true;
		String error = null;
		String mssg = "CeateTicketCMDB-NOC: Exito al crear Ticket";
		try {

			SdmCaOwnedResourceModel idPunta = sdmCaOwnedResourceRepository.findByResourceName(request.getPeackName());
			if (idPunta != null && idPunta.getOwnResourceUuid() != null) {
				CATicketMapper mapper = new CATicketMapper();
				token = logInValidator.getToken();
				String userHandle = logInValidator.getUserHandle(token);
				String[] propertyValues = {};
				String[] attributes = {};

				String id = idPunta.getOwnResourceUuid().replace("0x", "");
				String existetActivos = TicketQueryBuilder.buildQuery(id, "ticketsActivos"); // Busco
																								// si
																								// hay
																								// tickets
																								// activos
				String existetActivosXml = queryValidator.doSelect(token, "cr", existetActivos, 1,
						TicketDictionary.refNumParam);
				String ticket = mapper.getValueByAttrName(existetActivosXml, TicketDictionary.refNum);

				if (ticket.isEmpty()) {
					StringHolder newRequestHandle = new StringHolder();
					StringHolder newRequestNumber = new StringHolder();
					String requestByCriteria = TicketQueryBuilder.buildQuery(request.getRequestBy(), "userCreate"); // Busco
																													// por
																													// nombre
					String requestByXml = queryValidator.doSelect(token, "cnt", requestByCriteria, 1,
							TicketDictionary.persistentIdParam);
					String requestBy = mapper.getValueByAttrName(requestByXml, TicketDictionary.id);

					String requestByCriteriaCI = TicketQueryBuilder.buildQuery(request.getPeackName(), "CIName"); // Busco
																													// por
																													// nombre
					String requestByXmlCI = queryValidator.doSelect(token, "nr", requestByCriteriaCI, 1,
							TicketDictionary.persistentIdParam);
					String CI = mapper.getValueByAttrName(requestByXmlCI, TicketDictionary.id);

					String type = TicketQueryBuilder.validateTicketType(request.getType());
					SdmProbCtgModel categoria = sdmProbCtgRepository.findById(Integer.valueOf(request.getCategoryId()));// buscar
																														// Id
																														// de
																														// categoria

					if (CI != null) {
						String category = categoria.getPersid();
						if (category != null && !category.equals("") && type != null) {
							String[] array = request.getDescription();
							String[] argsCreate = new String[] { "requested_by", requestBy, "customer", requestBy,
									"category", category, "description", array[0], "type", type, "affected_resource",
									CI, "zdiag_inicial", request.getDiagInitial(), "zRegCiu_id", request.getRegCiuId(),
									"log_agent", requestBy, "created_via", "3556", };

							String xml = objValidator.createTicket(token, userHandle, argsCreate, propertyValues,
									attributes, newRequestHandle, newRequestNumber);
							tickets = mapper.mapUnique(xml);

							// se crea archivo
							if (!request.getUrl().isEmpty() || request.getUrl() != "") {
								String ServiceDeskDocumentRepository = "doc_rep:1002";
								USD_WebServiceLocator ws = new USD_WebServiceLocator();
								java.net.URL url = new java.net.URL(ws.getUSD_WebServiceSoapAddress());
								USD_WebServiceSoap usd = ws.getUSD_WebServiceSoap(url);
								FileDataSource fds = new FileDataSource(request.getUrl());
								DataHandler dhandler = new DataHandler(fds);
								((org.apache.axis.client.Stub) usd)._setProperty(Call.ATTACHMENT_ENCAPSULATION_FORMAT,
										Call.ATTACHMENT_ENCAPSULATION_FORMAT_DIME);
								((org.apache.axis.client.Stub) usd).addAttachment(dhandler);

								String attmntHandle = usd.createAttachment(token, ServiceDeskDocumentRepository,
										newRequestHandle.value, "Archivo creado desde el SMC", request.getUrl());
								if (attmntHandle.length() > 0)
									mssg = "CreateTicket-NOC: El ticket y el archivo fueron creados";
							}

						} else {
							success = false;
							error = "CrearTicketCMDB-NOC: Parametros no validos para crear ticket";
							mssg = "CreateTicketCMDB-NOC: Ocurrio un error al crear ticket";

						}
					} else {
						success = false;
						error = "CrearTicketCMDB-NOC: Dispositivo no encontrado";
						mssg = "CreateTicketCMDB-NOC: Ocurrio un error al crear ticket";
					}
				} else {
					success = false;
					error = "CrearTicketCMDB-NOC: El elemento de configuración ya tiene un ticket activo";
					mssg = "CreateTicketCMDB-NOC: El elemento de configuración ya tiene un ticket activo";
				}
			} else {
				success = false;
				error = "CrearTicketCMDB-NOC: Elemento de configuración no encontrado";
				mssg = "CreateTicketCMDB-NOC: Elemento de configuración no encontrado";
			}
			logInValidator.closeToken(token);
		} catch (Exception e) {
			success = false;
			error = e.toString();
			mssg = "CreateTicketCMDB-NOC: Ocurrio un error al crear ticket";
		} finally {
			try {
				if (token != null)
					logInValidator.closeToken(token);
			} catch (RemoteException e) {
				System.out.println("Error ticket NOC");
			}
		}

		Period period = new Period(initial, new DateTime());
		if (tickets != null)
			return new CATicketList(success, period, error, mssg, tickets.size(), tickets);
		else
			return new CATicketList(success, period, error, mssg, 0);
	}

	public CATicketList createTicketNOC(OperationTicketNocRequest request) {
		DateTime initial = new DateTime();
		ArrayList<CATicket> tickets = new ArrayList<CATicket>();
		Integer token = null;
		Boolean success = true;
		String error = null;
		String mssg = "CeateTicketCMDB-NOC: Exito al crear Ticket";
		try {

			SdmCaOwnedResourceModel idPunta = sdmCaOwnedResourceRepository.findByResourceName(request.getPeackName());
			if (idPunta != null && idPunta.getOwnResourceUuid() != null) {
				CATicketMapper mapper = new CATicketMapper();
				token = logInValidator.getToken();
				String userHandle = logInValidator.getUserHandle(token);
				String[] propertyValues = {};
				String[] attributes = {};

				String id = idPunta.getOwnResourceUuid().replace("0x", "");
				String existetActivos = TicketQueryBuilder.buildQuery(id, "ticketsActivos"); // Busco
																								// si
																								// hay
																								// tickets
																								// activos
				String existetActivosXml = queryValidator.doSelect(token, "cr", existetActivos, 1,
						TicketDictionary.refNumParam);
				String ticket = mapper.getValueByAttrName(existetActivosXml, TicketDictionary.refNum);

				if (ticket.isEmpty()) {
					StringHolder newRequestHandle = new StringHolder();
					StringHolder newRequestNumber = new StringHolder();
					String requestByCriteria = TicketQueryBuilder.buildQuery(request.getRequestBy(), "userCreate"); // Busco
																													// por
																													// nombre
					String requestByXml = queryValidator.doSelect(token, "cnt", requestByCriteria, 1,
							TicketDictionary.persistentIdParam);
					String requestBy = mapper.getValueByAttrName(requestByXml, TicketDictionary.id);

					String requestByCriteriaCI = TicketQueryBuilder.buildQuery(request.getPeackName(), "CIName"); // Busco
																													// por
																													// nombre
					String requestByXmlCI = queryValidator.doSelect(token, "nr", requestByCriteriaCI, 1,
							TicketDictionary.persistentIdParam);
					String CI = mapper.getValueByAttrName(requestByXmlCI, TicketDictionary.id);

					String type = TicketQueryBuilder.validateTicketType(request.getType());
					SdmProbCtgModel categoria = sdmProbCtgRepository.findById(Integer.valueOf(request.getCategoryId()));// buscar
																														// Id
																														// de
																														// categoria
					String requestByCriteriaGrupo = TicketQueryBuilder.buildQuery(request.getGroup(), "group"); // Busco
																												// grupo
																												// por
																												// nombre
					String requestByXmlGrupo = queryValidator.doSelect(token, "cnt", requestByCriteriaGrupo, 1,
							TicketDictionary.persistentIdParam);
					String grupoId = mapper.getValueByAttrName(requestByXmlGrupo, TicketDictionary.id);

					if (CI != null) {
						String category = categoria.getPersid();
						if (category != null && !category.equals("") && type != null) {
							String[] array = request.getDescription();
							String[] argsCreate = new String[] { "requested_by", requestBy, "customer", requestBy,
									"category", category, "description", array[0], "type", type, "affected_resource",
									CI, "zdiag_inicial", request.getDiagInitial(), "zRegCiu_id", request.getRegCiuId(),
									"group", grupoId, "log_agent", requestBy, "created_via", "3556", };

							String xml = objValidator.createTicket(token, userHandle, argsCreate, propertyValues,
									attributes, newRequestHandle, newRequestNumber);
							tickets = mapper.mapUnique(xml);

							// se crea archivo
							if (!request.getUrl().isEmpty() || request.getUrl() != "") {
								String ServiceDeskDocumentRepository = "doc_rep:1002";
								USD_WebServiceLocator ws = new USD_WebServiceLocator();
								java.net.URL url = new java.net.URL(ws.getUSD_WebServiceSoapAddress());
								USD_WebServiceSoap usd = ws.getUSD_WebServiceSoap(url);
								FileDataSource fds = new FileDataSource(request.getUrl());
								DataHandler dhandler = new DataHandler(fds);
								((org.apache.axis.client.Stub) usd)._setProperty(Call.ATTACHMENT_ENCAPSULATION_FORMAT,
										Call.ATTACHMENT_ENCAPSULATION_FORMAT_DIME);
								((org.apache.axis.client.Stub) usd).addAttachment(dhandler);

								String attmntHandle = usd.createAttachment(token, ServiceDeskDocumentRepository,
										newRequestHandle.value, "Archivo creado desde el SMC", request.getUrl());
								if (attmntHandle.length() > 0)
									mssg = "CreateTicket-NOC: El ticket y el archivo fueron creados";
							}

						} else {
							success = false;
							error = "CrearTicketCMDB-NOC: Parametros no validos para crear ticket";
							mssg = "CreateTicketCMDB-NOC: Ocurrio un error al crear ticket";

						}
					} else {
						success = false;
						error = "CrearTicketCMDB-NOC: Dispositivo no encontrado";
						mssg = "CreateTicketCMDB-NOC: Ocurrio un error al crear ticket";
					}
				} else {
					success = false;
					error = "CrearTicketCMDB-NOC: El elemento de configuración ya tiene un ticket activo";
					mssg = "CreateTicketCMDB-NOC: El elemento de configuración ya tiene un ticket activo";
				}
			} else {
				success = false;
				error = "CrearTicketCMDB-NOC: Elemento de configuración no encontrado";
				mssg = "CreateTicketCMDB-NOC: Elemento de configuración no encontrado";
			}
			logInValidator.closeToken(token);
		} catch (Exception e) {
			success = false;
			error = e.toString();
		} finally {
			try {
				if (token != null)
					logInValidator.closeToken(token);
			} catch (RemoteException e) {
				System.out.println("Error ticket NOC");
			}
		}

		Period period = new Period(initial, new DateTime());
		if (tickets != null)
			return new CATicketList(success, period, error, mssg, tickets.size(), tickets);
		else
			return new CATicketList(success, period, error, mssg, 0);
	}

	public CATicketList createPreeTicketNOC(OperationPreTicketNoc request) {
		DateTime initial = new DateTime();
		ArrayList<CATicket> tickets = new ArrayList<CATicket>();
		Integer token = null;
		Boolean success = true;
		String error = null;
		String mssg = "PreTicket-NOC: Exito al crear el Pre-Ticket -NOC";
		try {
			CATicketMapper mapper = new CATicketMapper();
			token = logInValidator.getToken();
			String userHandle = logInValidator.getUserHandle(token);
			String[] propertyValues = {};
			String[] attributes = {};

			SdmCaOwnedResourceModel idPunta = sdmCaOwnedResourceRepository.findByResourceName(request.getPeackName());
			if (idPunta != null && idPunta.getOwnResourceUuid() != null) {
				String id = idPunta.getOwnResourceUuid().replace("0x", "");
				String existetActivos = TicketQueryBuilder.buildQuery(id, "ticketsActivos"); // Busco
																								// si
																								// hay
																								// tickets
																								// activos
				String existetActivosXml = queryValidator.doSelect(token, "cr", existetActivos, 1,
						TicketDictionary.refNumParam);
				String ticket = mapper.getValueByAttrName(existetActivosXml, TicketDictionary.refNum);

				if (ticket.isEmpty()) {
					StringHolder newRequestHandle = new StringHolder();
					StringHolder newRequestNumber = new StringHolder();
					String requestByCriteria = TicketQueryBuilder.buildQuery(request.getRequestBy(), "userCreate"); // Busco
																													// por
																													// nombre
					String requestByXml = queryValidator.doSelect(token, "cnt", requestByCriteria, 1,
							TicketDictionary.persistentIdParam);
					String requestBy = mapper.getValueByAttrName(requestByXml, TicketDictionary.id);

					String requestByCriteriaCI = TicketQueryBuilder.buildQuery(request.getPeackName(), "CIName"); // Busco
																													// por
																													// nombre
					String requestByXmlCI = queryValidator.doSelect(token, "nr", requestByCriteriaCI, 1,
							TicketDictionary.persistentIdParam);
					String CI = mapper.getValueByAttrName(requestByXmlCI, TicketDictionary.id);

					String requestByCriteriaEstatus = TicketQueryBuilder.buildQuery("Pre-Ticket", "CodeStatus"); // Busco
																													// por
																													// nombre
					String requestByXmlEstatus = queryValidator.doSelect(token, "crs", requestByCriteriaEstatus, 1,
							TicketDictionary.statusParam);
					String codeStatus = mapper.getValueByAttrName(requestByXmlEstatus, TicketDictionary.code);

					String requestByCriteriaGrupo = TicketQueryBuilder.buildQuery("Pre-Ticket", "group"); // Busco
																											// por
																											// nombre
					String requestByXmlGrupo = queryValidator.doSelect(token, "cnt", requestByCriteriaGrupo, 1,
							TicketDictionary.persistentIdParam);
					String grupoId = mapper.getValueByAttrName(requestByXmlGrupo, TicketDictionary.id);

					String type = TicketQueryBuilder.validateTicketType(request.getType());
					SdmProbCtgModel categoria = sdmProbCtgRepository.findById(Integer.valueOf(request.getCategoryId()));// buscar
																														// Id
																														// de
																														// categoria

					if (CI != null) {
						String category = categoria.getPersid();
						if (category != null && !category.equals("") && type != null) {
							String[] argsCreate = new String[] { "requested_by", requestBy, "customer", requestBy,
									"category", category, "created_via", request.getCreatedVia(), "description",
									request.getDescription(), "type", type, "affected_resource", CI, "zdiag_inicial",
									request.getDiagInitial(), "zRegCiu_id", request.getRegCiuId(), "log_agent",
									requestBy, "status", codeStatus, "group", grupoId };

							String xml = objValidator.createTicket(token, userHandle, argsCreate, propertyValues,
									attributes, newRequestHandle, newRequestNumber);
							tickets = mapper.mapUnique(xml);

							// se crea archivo
							if (!request.getUrl().isEmpty() || request.getUrl() != "") {
								String ServiceDeskDocumentRepository = "doc_rep:1002";
								USD_WebServiceLocator ws = new USD_WebServiceLocator();
								java.net.URL url = new java.net.URL(ws.getUSD_WebServiceSoapAddress());
								USD_WebServiceSoap usd = ws.getUSD_WebServiceSoap(url);
								FileDataSource fds = new FileDataSource(request.getUrl());
								DataHandler dhandler = new DataHandler(fds);
								((org.apache.axis.client.Stub) usd)._setProperty(Call.ATTACHMENT_ENCAPSULATION_FORMAT,
										Call.ATTACHMENT_ENCAPSULATION_FORMAT_DIME);
								((org.apache.axis.client.Stub) usd).addAttachment(dhandler);

								String attmntHandle = usd.createAttachment(token, ServiceDeskDocumentRepository,
										newRequestHandle.value, "Archivo creado desde el SMC", request.getUrl());
								if (attmntHandle.length() > 0)
									mssg = "CreateTicket: El ticket y el archivo fueron creados";
							}

						} else {
							success = false;
							error = "PreTicket-NOC: Parametros no validos para crear ticket";
							mssg = "PreTicket-NOC: Ocurrio un error al crear ticket";

						}
					} else {
						success = false;
						error = "PreTicket-NOC: Dispositivo no encontrado";
						mssg = "PreTicket-NOC: Ocurrio un error al crear el pre-ticket";
					}
				} else {
					success = false;
					error = "PreTicket-NOC: El elemento de configuración ya cuenta con un ticket en curso";
					mssg = "PreTicket-NOC: El elemento de configuración ya cuenta con un ticket en curso";
				}
			} else {
				success = false;
				error = "PreTicket-NOC: Elemento de configuración no encontrado";
				mssg = "PreTicket-NOC: Elemento de configuración no encontrado";
			}
			logInValidator.closeToken(token);
		} catch (Exception e) {
			success = false;
			error = e.toString();
			mssg = "PreTicket-NOC: Ocurrio un error al crear el pre-ticket";
		} finally {
			try {
				if (token != null)
					logInValidator.closeToken(token);
			} catch (RemoteException e) {
				System.out.println("Error pre-ticket");
			}
		}

		Period period = new Period(initial, new DateTime());
		if (tickets != null)
			return new CATicketList(success, period, error, mssg, tickets.size(), tickets);
		else
			return new CATicketList(success, period, error, mssg, 0);
	}

	public CATicketList createPreeTicketCARE(OperationPreTicketCare request) {
		DateTime initial = new DateTime();
		ArrayList<CATicket> tickets = new ArrayList<CATicket>();
		Integer token = null;
		Boolean success = true;
		String error = null;
		String mssg = "PreTicket-CARE: Exito al crear el Pre-Ticket -CARE";
		try {
			CATicketMapper mapper = new CATicketMapper();
			token = logInValidator.getToken();
			String userHandle = logInValidator.getUserHandle(token);
			String[] propertyValues = {};
			String[] attributes = {};

			String id = request.getPeackId().replace("0x", "");
			String existetActivos = TicketQueryBuilder.buildQuery(id, "ticketsActivos"); // Busco
																							// si
																							// hay
																							// tickets
																							// activos
			String existetActivosXml = queryValidator.doSelect(token, "cr", existetActivos, 1,
					TicketDictionary.refNumParam);
			String ticket = mapper.getValueByAttrName(existetActivosXml, TicketDictionary.refNum);

			if (ticket.isEmpty()) {
				String uuidOrganization = null;
				SdmCaOrganizationModel org = sdmCaOrganizationRepository.findByOrgName(request.getOrganization());
				if (org != null && org.getInactive() == 0) {
					uuidOrganization = org.getOrganizationUuid().replace("0x", "org:");
				}

				StringHolder newRequestHandle = new StringHolder();
				StringHolder newRequestNumber = new StringHolder();
				String requestByCriteria = TicketQueryBuilder.buildQuery(request.getRequestBy(), "userCreate"); // Busco
																												// por
																												// nombre
				String requestByXml = queryValidator.doSelect(token, "cnt", requestByCriteria, 1,
						TicketDictionary.persistentIdParam);
				String requestBy = mapper.getValueByAttrName(requestByXml, TicketDictionary.id);

				String requestByCriteriaEstatus = TicketQueryBuilder.buildQuery("Pre-Ticket", "CodeStatus"); // Busco
																												// por
																												// nombre
				String requestByXmlEstatus = queryValidator.doSelect(token, "crs", requestByCriteriaEstatus, 1,
						TicketDictionary.statusParam);
				String codeStatus = mapper.getValueByAttrName(requestByXmlEstatus, TicketDictionary.code);

				String requestByCriteriaGrupo = TicketQueryBuilder.buildQuery("Pre-Ticket", "group"); // Busco
																										// por
																										// nombre
				String requestByXmlGrupo = queryValidator.doSelect(token, "cnt", requestByCriteriaGrupo, 1,
						TicketDictionary.persistentIdParam);
				String grupoId = mapper.getValueByAttrName(requestByXmlGrupo, TicketDictionary.id);

				String type = TicketQueryBuilder.validateTicketType(request.getType());
				SdmProbCtgModel categoria = sdmProbCtgRepository.findById(Integer.valueOf(request.getCategoryId()));// buscar
																													// Id
																													// de
																													// categoria

				String CI = request.getPeackId().replace("0x", "nr:");

				if (CI != null) {
					String category = categoria.getPersid();
					if (category != null && !category.equals("") && type != null) {
						String[] array = request.getDescription();
						String[] argsCreate = new String[] { "requested_by", requestBy, "customer", requestBy,
								"category", category, "created_via", "3556", "summary", request.getSummary(),
								"description", array[0], "type", type, "affected_resource", CI, "zdiag_inicial",
								request.getDiagInitial(), "ztipo_red", request.getNetworkType(), "zRegCiu_id",
								request.getRegCiuId(), "log_agent", requestBy, "status", codeStatus, "zorg_id",
								uuidOrganization, "group", grupoId };

						String xml = objValidator.createTicket(token, userHandle, argsCreate, propertyValues,
								attributes, newRequestHandle, newRequestNumber);
						tickets = mapper.mapUnique(xml);

						// se crea archivo
						if (!request.getUrl().isEmpty() || request.getUrl() != "") {
							String ServiceDeskDocumentRepository = "doc_rep:1002";
							USD_WebServiceLocator ws = new USD_WebServiceLocator();
							java.net.URL url = new java.net.URL(ws.getUSD_WebServiceSoapAddress());
							USD_WebServiceSoap usd = ws.getUSD_WebServiceSoap(url);
							FileDataSource fds = new FileDataSource(request.getUrl());
							DataHandler dhandler = new DataHandler(fds);
							((org.apache.axis.client.Stub) usd)._setProperty(Call.ATTACHMENT_ENCAPSULATION_FORMAT,
									Call.ATTACHMENT_ENCAPSULATION_FORMAT_DIME);
							((org.apache.axis.client.Stub) usd).addAttachment(dhandler);

							String attmntHandle = usd.createAttachment(token, ServiceDeskDocumentRepository,
									newRequestHandle.value, "Archivo creado desde el SMC", request.getUrl());
							if (attmntHandle.length() > 0)
								mssg = "CreateTicket-NOC: El ticket y el archivo fueron creados";
						}

					} else {
						success = false;
						error = "PreTicket-CARE: Parametros no validos para crear ticket";
						mssg = "PreTicket-CARE: Ocurrio un error al crear ticket";

					}
				} else {
					success = false;
					error = "PreTicket-CARE: Dispositivo no encontrado";
					mssg = "PreTicket-CARE: Ocurrio un error al crear el pre-ticket";
				}
			} else {
				success = false;
				error = "PreTicket-CARE: El elemento de configuración ya tiene un tickets en curso";
				mssg = "PreTicket-CARE:  El elemento de configuración ya tiene un tickets en curso";
			}

		} catch (Exception e) {
			success = false;
			error = e.toString();
			mssg = "PreTicket-CARE: Ocurrio un error al crear el pre-ticket";
		} finally {
			try {
				if (token != null)
					logInValidator.closeToken(token);
			} catch (RemoteException e) {
				System.out.println("Error pre-ticket");
			}
		}

		Period period = new Period(initial, new DateTime());
		if (tickets != null)
			return new CATicketList(success, period, error, mssg, tickets.size(), tickets);
		else
			return new CATicketList(success, period, error, mssg, 0);
	}

	public CATicketList createTicketONT(ONTRequest request) { // falta modificar
																// para que no
																// cree tickets
																// a la misma
																// punta
		DateTime initial = new DateTime();
		ArrayList<CATicket> tickets = new ArrayList<CATicket>();
		Integer token = null;
		Boolean success = true;
		String error = null;
		String mssg = "CreateTicket-ONT: Exito al crear ticket";
		try {
			CATicketMapper mapper = new CATicketMapper();
			token = logInValidator.getToken();

			String requestByCriteria = TicketQueryBuilder.buildQuery(request.getRequestBy(), "userCreate"); // Busco
																											// el
																											// nombre
			String requestByXml = queryValidator.doSelect(token, "cnt", requestByCriteria, 1,
					TicketDictionary.persistentIdParam);
			String requestBy = mapper.getValueByAttrName(requestByXml, TicketDictionary.persistentId);

			SdmProbCtgModel categoria = sdmProbCtgRepository.findById(Integer.valueOf(request.getCategoryId()));// buscar
																												// ide
																												// de
																												// la
																												// categoria
			String category = categoria.getPersid();
			String ont = null;

			if (request.getNumSerie().isEmpty() && request.getNameONT().isEmpty()) {
				success = false;
				mssg = "CreateTicket-ONT: El numero de serie o el nombre de la ont deben estar llenos";
			} else {

				if (!request.getNumSerie().isEmpty()) {
					System.out.println("Buscara por numero de serie");
					String ontCriteria = TicketQueryBuilder.buildQuery(request.getNumSerie(), "numeroSerie"); // Busco
																												// por
																												// numero
																												// de
																												// serie
					String ontXml = queryValidator.doSelect(token, "nr", ontCriteria, 1,
							TicketDictionary.persistentIdParam);
					ont = mapper.getValueByAttrName(ontXml, TicketDictionary.id);
					System.out.println("ont: " + ont);
					if (ont.isEmpty()) {
						success = false;
						mssg = "CreateTicket-ONT: ONT no encontrada";
						if (!request.getNameONT().isEmpty()) {
							ontCriteria = TicketQueryBuilder.buildQuery(request.getNameONT(), "CIName"); // Busco
																											// por
																											// nombre
																											// de
																											// la
																											// ont
							ontXml = queryValidator.doSelect(token, "nr", ontCriteria, 1,
									TicketDictionary.persistentIdParam);
							ont = mapper.getValueByAttrName(ontXml, TicketDictionary.id);
							if (ont.isEmpty()) {
								String existetActivos = TicketQueryBuilder.buildQuery(ont, "ticketsActivos"); // Busco
																												// si
																												// hay
																												// tickets
																												// activos
								String existetActivosXml = queryValidator.doSelect(token, "cr", existetActivos, 1,
										TicketDictionary.refNumParam);
								String ticket = mapper.getValueByAttrName(existetActivosXml, TicketDictionary.refNum);
								System.out.println(existetActivosXml);
								if (ticket.isEmpty()) {
									String xml = insertaTicket(request, category, requestBy, ont, token);
									tickets = mapper.mapUnique(xml);
								} else {
									success = false;
									mssg = "CreateTicket-ONT: La ont ya tiene ticket activo";
								}
							} else {
								success = false;
								mssg = "CreateTicket-ONT: No se encontro la ont";
							}
						}
					} else {
						String xml = insertaTicket(request, category, requestBy, ont, token);
						tickets = mapper.mapUnique(xml);
					}

				} else {
					String ontCriteria = TicketQueryBuilder.buildQuery(request.getNameONT(), "CIName"); // Busco
																										// por
																										// nombre
																										// de
																										// la
																										// ont
					String ontXml = queryValidator.doSelect(token, "nr", ontCriteria, 1,
							TicketDictionary.persistentIdParam);
					ont = mapper.getValueByAttrName(ontXml, TicketDictionary.id);
					if (ont != null) {
						String existetActivos = TicketQueryBuilder.buildQuery(ont, "ticketsActivos"); // Busco
																										// si
																										// hay
																										// tickets
																										// activos
						String existetActivosXml = queryValidator.doSelect(token, "cr", existetActivos, 1,
								TicketDictionary.refNumParam);
						String ticket = mapper.getValueByAttrName(existetActivosXml, TicketDictionary.refNum);
						if (ticket.isEmpty()) {
							String xml = insertaTicket(request, category, requestBy, ont, token);
							tickets = mapper.mapUnique(xml);
						} else {
							success = false;
							mssg = "CreateTicket-ONT: La ont ya tiene ticket activo";
						}
					} else {
						success = false;
						mssg = "CreateTicket-ONT: No se encontro la ont";
					}
				}
			}
		} catch (Exception e) {
			success = false;
			error = e.toString();
			mssg = "CreateTicket-ONT: Error al crear ticket";
		} finally {
			try {
				if (token != null)
					logInValidator.closeToken(token);
			} catch (RemoteException e) {
				System.out.println("Error creando ticket ont " + e);
			}
		}

		Period period = new Period(initial, new DateTime());
		if (tickets != null)
			return new CATicketList(success, period, error, mssg, tickets.size(), tickets);
		else
			return new CATicketList(success, period, error, mssg, 0);

	}

	private String insertaTicket(ONTRequest request, String category, String requestBy, String ont, Integer token)
			throws RemoteException {
		String xml = null;
		if (category != null && !category.equals("") && request.getType() != null) {
			String[] array = request.getDescription();
			String[] attributes = {};
			String userHandle = logInValidator.getUserHandle(token);
			String[] propertyValues = {};
			StringHolder newRequestHandle = new StringHolder();
			StringHolder newRequestNumber = new StringHolder();
			String[] argsCreate = new String[] { "requested_by", requestBy, "customer", requestBy, "category", category,
					"description", array[0], "type", request.getType(), "affected_resource", ont, "zdiag_inicial",
					request.getInitialDiagnostic(), "zRegCiu_id", request.getRegCiuId(), "log_agent", requestBy,
					"created_via", "3556", };

			xml = objValidator.createTicket(token, userHandle, argsCreate, propertyValues, attributes, newRequestHandle,
					newRequestNumber);
		}
		return xml;
	}

	public CAResponse updateObject(UpdateRequest request) {
		DateTime initial = new DateTime();
		Boolean success = true;
		Integer token = null;
		String mssg = "";
		CATicketMapper mapper = new CATicketMapper();
		try {
			System.out.println("request: " + request.toString());

			token = logInValidator.getToken();
			String criteriaCreador = TicketQueryBuilder.buildQuery(request.getUsuario(), "customerCreate");
			String criteriaCreadorXml = queryValidator.doSelect(token, "cnt", criteriaCreador, 1,
					TicketDictionary.persistentIdParam);
			String creator = mapper.getValueByAttrName(criteriaCreadorXml, TicketDictionary.persistentId);

			String criteriaTicket = TicketQueryBuilder.buildQuery(request.getRefNum(), "refNumAndActive");
			String criteriaTicketXml = queryValidator.doSelect(token, "cr", criteriaTicket, 1,
					TicketDictionary.ticketParam);
			String objectHandle = mapper.getValueByAttrName(criteriaTicketXml, TicketDictionary.persistentId);

			String tipoTicket = mapper.getValueByAttrName(criteriaTicketXml, TicketDictionary.typeTicket);

			if (!creator.isEmpty() && !creator.equals("")) {
				if (!objectHandle.isEmpty() && !objectHandle.equals("")) {
					if (tipoTicket.equalsIgnoreCase("I")) {
						mssg = request.getUsuario() + " LoginId: " + request.getUsuarioBot();
						String logType = "LOG";
						int timeSpent = 0;
						boolean internal = false;
						String respuestaWS = null;
						String idComment = "";
						String[] attributes = new String[] {};

						List<String> lista = new ArrayList<String>();
						if (!request.getEta().isEmpty()) {
							lista.add("zETA");
							lista.add(request.getEta() + ":00");
							mssg = mssg + " Se actualizo el ETA= " + request.getEta();
							System.out.println("Se agrego el ETA");
						}

						if (!request.getEtr().isEmpty()) {
							lista.add("zETR");
							lista.add(request.getEtr() + ":00");
							mssg = mssg + " Se actualizo el ETR= " + request.getEtr();
							System.out.println("Se agrego el ETR");
						}
						if (!request.getLatitud().isEmpty()) {
							lista.add("zpoi_latitud");
							lista.add(request.getLatitud());
							mssg = mssg + " Se actualizo la Latitud= " + request.getLatitud();
							System.out.println("Se agrego el Latitud");
						}
						if (!request.getLongitud().isEmpty()) {
							lista.add("zpoi_longitud");
							lista.add(request.getLongitud());
							mssg = mssg + " Se actualizo la Longitud= " + request.getLongitud();
							System.out.println("Se agrego el Longitud");
						}

						System.out.println("Mensaje para Log " + mssg);
						String[] attrVals = new String[lista.size()];
						attrVals = lista.toArray(attrVals);
						if (attrVals.length > 0) {
							objValidator.updateObject(token, objectHandle, attrVals, attributes);
						} else {
							System.out.println("No hay objetos que actualizar");
						}

						if (!request.getComment().isEmpty()) {
							System.out.println("Hay comentario");
							String desc = request.getComment();
							respuestaWS = objValidator.addComment(token, creator, objectHandle, desc, logType,
									timeSpent, internal);
							idComment = mapper.maperComment(respuestaWS);
							mssg = mssg + " El id del comentario: " + idComment;
							System.out.println("Respuesta de service para comentario: " + idComment);
						} else {
							System.out.println("No hubo comentario para mandar");
						}
					} else {
						success = false;
						mssg = mssg + "El ticket proporcionado no es un incidente";
					}
				} else {
					success = false;
					mssg = mssg + "No se encontro el ticket o esta inactivo ";
					System.out.println("No se encontro el ticket o esta inactivo");
				}
			} else {
				success = false;
				mssg = mssg + "No se encontro el usuario";
				System.out.println("No se encontro el usuario");
			}
			logInValidator.closeToken(token);
		} catch (Exception e) {
			mssg = mssg + "Se genero un error al insertar comentario:  " + e.toString();
			success = false;
			System.out.println("Error al actualizar el objeto:" + e);
		} finally {
			try {
				if (token != null)
					logInValidator.closeToken(token);
			} catch (RemoteException e) {
				mssg = mssg + "Se genero un error al insertar comentario:  " + e.toString();
				success = false;
				System.out.println("Se genero un error al insertar comentario:  " + e.toString());
			}
		}
		Period period = new Period(initial, new DateTime());
		return new CAResponse(success, period, mssg);
	}

	/*
	 * @descripcion: Metodo de Consulta de RFC
	 * 
	 * @autor: Christian J.de los Santos (Neta Systems)
	 * 
	 * @fecha: 26/11/2019
	 */
	@SuppressWarnings("unused")
	public CARfcList consultaRfc(RfcRequest request) {
		DateTime initial = new DateTime();
		List<CARfc> rfclist = new ArrayList<CARfc>();
		Boolean success = true;
		String mssg = "";
		String error = "";
		String refNum = request.getRfc();

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		int hours;
		int min;
		int segun;
		String hora;

		try {
			if (!request.getRfc().isEmpty()) {

				List<SdmChgModel> r = sdmChgRepository.findByChgRefNum(request.getRfc());
				if (r.size() > 0) {

					CARfc det = new CARfc();

					for (SdmChgModel detalle : r) {
						det.setEdo(detalle.getStatus());
						String fechaTexto = formatter.format(detalle.getSchedStartDate());
						det.setFchaInicio(fechaTexto);

						hours = (detalle.getSchedDuration() / 3600);
						min = ((detalle.getSchedDuration() - hours * 3600) / 60);
						segun = detalle.getSchedDuration() - (hours * 3600 + min * 60);
						System.out.println(hora = hours + ":" + min + ":" + segun);

						det.setDuracion(hora);
						String fechaTexto2 = formatter.format(detalle.getSchedEndDate());
						det.setFchaTermino(fechaTexto2);
						det.setAfectacionClientes(detalle.getJustificacion());
						rfclist.add(det);
					}
					mssg = "Se realizo la consulta con exito y se presenta el resultado";
					success = true;
				} else {
					mssg = "El RFC que se intenta consultar no existe en la BD";
					success = false;
				}
			} else {
				mssg = "Se requiere un RFC para poder realizar la consulta";
			}
		} catch (Exception ex) {
			success = false;
			error = "Se presento una excepcion" + ex;
		}
		Period period = new Period(initial, new DateTime());

		return new CARfcList(success, period, error, mssg, refNum, rfclist.size(), (ArrayList<CARfc>) rfclist);
	}

	public CAResponse actualizaCI(ActualizaIPRequest request) {
		DateTime initial = new DateTime();
		Boolean success = true;
		Integer token = null;
		String mssg = "";
		// CATicketMapper mapper = new CATicketMapper();
		try {
			CAMapper mapper = new CAMapper();
			String[] paramRetunr = { "persistent_id" };

			token = logInValidator.getToken();
			System.out.println("Token: " + token);

			String criteriaIp = QueryBuilder.buildQuery(request.getIpActualizar(), "ipNetwork");
			String xmlIp = queryValidator.doSelect(token, "nr", criteriaIp, 1, paramRetunr);
			String idIp = mapper.getValueByAttrName(xmlIp, "persistent_id");

			if (!idIp.isEmpty()) {
				String[] attributes = new String[0];
				String[] attrVals = { // "name", request.getIpNueva(), //
										// Resource_name
										// "system_name", request.getIpNueva(),
										// // hostname
						"alarm_id", request.getIpNueva() };

				objValidator.updateObject(token, idIp, attrVals, attributes);
			}

			logInValidator.closeToken(token);
		} catch (Exception e) {
			mssg = mssg + "Se genero un error al actualizar la ip:  " + e.toString();
			success = false;
			System.out.println("Error al actualizar el objeto:" + e.getMessage());
		} finally {
			try {
				if (token != null)
					logInValidator.closeToken(token);
			} catch (RemoteException e) {
				mssg = mssg + "Se genero un error al actualizar la ip:  " + e.toString();
				success = false;
				System.out.println("Se genero un error al actualizar la ip:  " + e.getMessage());
			}
		}
		Period period = new Period(initial, new DateTime());
		return new CAResponse(success, period, mssg);
	}

	public CAuuid getUuidByNumSerie(NumSerieRequest request) {
		DateTime initial = new DateTime();

		Boolean success = true;
		String error = "";

		String uuid = null;
		Integer token = null;
		String uuidSbtr = null;
		try {

			if (request.getNumeroSerie().isEmpty()) {

				success = false;
				error = "El numero de serie es requerido.";

			} else {

				System.out.print(" entre getUuidByNumSerie ");
				CATicketMapper mapper = new CATicketMapper();
				String[] paramRetunr = { "persistent_id" };

				token = Integer.valueOf(logInValidator.getToken());

				String criteria = TicketQueryBuilder.buildQuery(request.getNumeroSerie(), "numeroSerie");

				String xml = queryValidator.doSelect(token.intValue(), "nr", criteria, 1, paramRetunr);

				uuid = mapper.getValueByAttrName(xml, "persistent_id");

				uuidSbtr = uuid.substring(3);

				System.out.print(" Criteria [" + criteria + "]" + " UUID [" + uuidSbtr + "]");

				logInValidator.closeToken(token.intValue());
			}

		} catch (Exception ex) {

			success = false;
			error = ex.getMessage();

			System.out.println("Se encontro una exception en getUuidByNumSerie: " + ex + "/" + error);
		}
		Period period = new Period(initial, new DateTime());

		return new CAuuid(success, period, error, uuidSbtr);

	}

	public CAResponse actualizaTiemposImputables(ActualizaTiemposImputablesRequest request) {
		DateTime initial = new DateTime();
		Boolean success = true;
		Integer token = null;
		String mssg = "";
		ArrayList<CATicket> tickets = new ArrayList<CATicket>();

		try {
			CAMapper mapper = new CAMapper();
			CATicketMapper mapperVal = new CATicketMapper();

			token = logInValidator.getToken();
			System.out.println("Token: " + token);

			String requestByTicket = TicketQueryBuilder.buildQuery(request.getRefNum(), "refNum");
			String requestByXmlTicket = this.queryValidator.doSelect(token.intValue(), "cr", requestByTicket, 1,
					TicketDictionary.ticketParam);
			String ticket = mapper.getValueByAttrName(requestByXmlTicket, "persistent_id");
			String ticketStatus = mapper.getValueByAttrName(requestByXmlTicket, "status");

			logger.info("El ticket esta en status:" + ticketStatus);
			logger.info("Tiempos a actualizar: " + "ztiempo_falla_cte: " + request.getZtiempoFallaCte()
					+ "ztiempo_falla_prov: " + request.getZtiempoFallaProv() + "ztiempo_falla_terceros: "
					+ request.getZtiempoFallaTerceros() + "ztiempo_falla_tpe: " + request.getZtiempoFallaTpe()
					+ "zTime_Perform: " + request.getZtiempoPerformance());

			if (ticket != null && !ticket.isEmpty()) {
				String[] attributes = new String[0];
				String[] attrVals = { "ztiempo_falla_cte", request.getZtiempoFallaCte(), "ztiempo_falla_prov",
						request.getZtiempoFallaProv(), "ztiempo_falla_terceros", request.getZtiempoFallaTerceros(),
						"ztiempo_falla_tpe", request.getZtiempoFallaTpe(), "zTime_Perform",
						request.getZtiempoPerformance() };

				String xml = objValidator.updateObject(token, ticket, attrVals, attributes);

				tickets = mapperVal.mapUnique(xml);
				logger.info("Se actualizaron tiempos imputables sobre el ticket: " + tickets.get(0).getRefNum());

			}

			logInValidator.closeToken(token);
		} catch (Exception e) {
			mssg = mssg + "Se genero un error al actualizar los tiempos:  " + e.toString();
			success = false;
			System.out.println("Error al actualizar el objeto:" + e.getMessage());
		} finally {
			try {
				if (token != null)
					logInValidator.closeToken(token);
			} catch (RemoteException e) {
				mssg = mssg + "Se genero un error al actualizar los tiempos:  " + e.toString();
				success = false;
				System.out.println("Se genero un error al actualizar los tiempos:  " + e.getMessage());
			}
		}
		Period period = new Period(initial, new DateTime());
		return new CAResponse(success, period, mssg);
	}

	public CAResponse test(PruebasRequest request) {
		DateTime initial = new DateTime();
		Boolean success = true;
		Integer token = null;
		String mssg = "";
		// ArrayList<CATicket> tickets = new ArrayList<CATicket>();

		try {
			CAMapper mapper = new CAMapper();
			CATicketMapper mapperVal = new CATicketMapper();
			token = logInValidator.getToken();

			logger.info("TOKEN:" + token);

			// String requestByCriteriaCI =
			// TicketQueryBuilder.buildQuery(request.getNombrePunta(),
			// "CIName"); // Busco
			// String requestByXmlCI = queryValidator.doSelect(token, "nr",
			// requestByCriteriaCI, 1,
			// TicketDictionary.persistentIdParam);
			// String CI = mapper.getValueByAttrName(requestByXmlCI,
			// TicketDictionary.id);

			// logger.info("PUNTA:" + CI);

			// String requestByCriteriaCI2 =
			// TicketQueryBuilder.buildQuery(request.getNumeroCuenta(),
			// "CIName"); // Busco
			// ListResult requestByXmlCI2 = queryValidator.doQuery(token, "nr",
			// TicketDictionary.ciName);
			// String CI2 = mapper.getValueByAttrName(requestByXmlCI2,
			// TicketDictionary.id);

			// logger.info("Dispositivos :" + requestByXmlCI2.getListLength());

			logInValidator.closeToken(token);
		} catch (Exception e) {
			mssg = mssg + "Se genero un error al actualizar los tiempos:  " + e.toString();
			success = false;
			System.out.println("Error al actualizar el objeto:" + e.getMessage());
		} finally {
			try {
				if (token != null)
					logInValidator.closeToken(token);
			} catch (RemoteException e) {
				mssg = mssg + "Se genero un error al actualizar los tiempos:  " + e.toString();
				success = false;
				System.out.println("Se genero un error al actualizar los tiempos:  " + e.getMessage());
			}
		}
		Period period = new Period(initial, new DateTime());
		return new CAResponse(success, period, mssg);
	}

	public TAdjuntarLigaArchivoResponse adjuntarLigaArchivo(AdjuntarLigaArchivoRequest request) {

		TAdjuntarLigaArchivoResponse response = new TAdjuntarLigaArchivoResponse();

		/*
		 * SimpleDateFormat formatter = new
		 * SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 * 
		 * boolean respuesta = true; String codigoRespuesta = null; String
		 * descripcionRespuesta = null; String mensajeServicio = null; String
		 * fechaSolicitud = formatter.format(new Date()); String fechaRespuesta
		 * = null;
		 * 
		 * Integer token = null;
		 * 
		 * ResponseWS response = new ResponseWS(); AdjuntarLigaArchivoResponse
		 * resp = new AdjuntarLigaArchivoResponse();
		 * 
		 * try {
		 * 
		 * List<SdmCallReqModel> ticket =
		 * sdmCallReqRepository.findByRefNum(request.getTicketSD()); if (ticket
		 * != null && !ticket.isEmpty()) {
		 * 
		 * if ((ticket.get(0).getExternalSystemTicket() != null)) {
		 * 
		 * if
		 * (ticket.get(0).getExternalSystemTicket().equals(request.getFolioSF())
		 * ) {
		 * 
		 * JSONObject myObject = new JSONObject();
		 * 
		 * myObject.put("nombreOperador", request.getNombreOperador());
		 * myObject.put("numeroEmpleadoTPoperador",
		 * request.getNumeroEmpleadoTPoperador()); myObject.put("ticketSD",
		 * request.getTicketSD()); myObject.put("folioSF",
		 * request.getFolioSF()); myObject.put("nombreArchivo",
		 * request.getNombreArchivo()); myObject.put("urlArchivo",
		 * request.getUrlArchivo());
		 * 
		 * System.out.print("JSON REQUEST adjuntarLigaArchivo: " + myObject);
		 * 
		 * String entradaOriginal = myObject.toString(); String cadenaCodificada
		 * = Base64.getEncoder().encodeToString(entradaOriginal.getBytes());
		 * 
		 * System.out.println("codificado adjuntarLigaArchivo: " +
		 * cadenaCodificada);
		 * 
		 * bitacoraRepository.insertarBitacora(request.getNombreOperador(),
		 * request.getNumeroEmpleadoTPoperador(), fechaSolicitud,
		 * "Peticion adjuntarLigaArchivo", cadenaCodificada, "");
		 * 
		 * //resp =
		 * serviceArchivoSD.adjuntarLigaArchivoSD(request.getUrlArchivo(),
		 * request.getTicketSD(), // request.getNombreArchivo());
		 * 
		 * if (resp.getIdAttm() != null && !resp.getIdAttm().isEmpty()) {
		 * 
		 * JSONObject myObjectResponse = new JSONObject();
		 * 
		 * myObjectResponse.put("respuesta", respuesta);
		 * myObjectResponse.put("codigoRespuesta", codigoRespuesta);
		 * myObjectResponse.put("descripcionRespuesta", descripcionRespuesta);
		 * myObjectResponse.put("mensajeServicio", mensajeServicio);
		 * myObjectResponse.put("fechaSolicitud", fechaSolicitud);
		 * myObjectResponse.put("fechaRespuesta", fechaRespuesta);
		 * myObjectResponse.put("folioLiga", resp.getIdAttm());
		 * 
		 * System.out.print("JSON RESPONSE  adjuntarLigaArchivo: " +
		 * myObjectResponse);
		 * 
		 * String entradaOriginalResponse = myObjectResponse.toString(); String
		 * cadenaCodificadaResponse = Base64.getEncoder()
		 * .encodeToString(entradaOriginalResponse.getBytes());
		 * 
		 * System.out.println("codificado adjuntarLigaArchivo: " +
		 * cadenaCodificadaResponse);
		 * 
		 * bitacoraRepository.insertarBitacora(request.getNombreOperador(),
		 * request.getNumeroEmpleadoTPoperador(), fechaSolicitud,
		 * "Respuesta de peticion adjuntarLigaArchivo", "",
		 * cadenaCodificadaResponse);
		 * 
		 * respuesta = true; codigoRespuesta = "000"; descripcionRespuesta =
		 * "AdjuntarLigaArchivo: Exito al adjuntar la liga del archivo en ticketSD: "
		 * + request.getTicketSD(); mensajeServicio =
		 * "AdjuntarLigaArchivo: Exito al adjuntar la liga del archivo en ticketSD: "
		 * + request.getTicketSD(); fechaRespuesta = formatter.format(new
		 * Date());
		 * 
		 * } else { respuesta = false; codigoRespuesta = "300";
		 * descripcionRespuesta =
		 * "300 - AdjuntarLigaArchivo: Ocurrio un error al adjuntar la liga del archivo: "
		 * + resp.getDescripcionRespuesta(); mensajeServicio =
		 * "300 - AdjuntarLigaArchivo: Ocurrio un error al adjuntar la liga del archivo: "
		 * + resp.getMensajeServicio(); fechaRespuesta = formatter.format(new
		 * Date()); logger.
		 * info("AdjuntarLigaArchivo: Ocurrio un error al adjuntar la liga del archivo"
		 * ); } } else { respuesta = false; fechaRespuesta =
		 * formatter.format(new Date()); codigoRespuesta = "300";
		 * descripcionRespuesta =
		 * "AdjuntarLigaArchivo: El folio Sales Force no coincide con el registrado en el ticket de Service Desk."
		 * ; mensajeServicio = response.getMensajeServicio(); } } else {
		 * respuesta = false; fechaRespuesta = formatter.format(new Date());
		 * codigoRespuesta = "300"; descripcionRespuesta =
		 * "AdjuntarLigaArchivo: El folio Sales Force no coincide con el registrado en el ticket de Service Desk."
		 * ; mensajeServicio = response.getMensajeServicio(); } } else {
		 * respuesta = false; fechaRespuesta = formatter.format(new Date());
		 * codigoRespuesta = "300"; descripcionRespuesta =
		 * "AdjuntarLigaArchivo: Ticket SD no encontrado."; mensajeServicio =
		 * "AdjuntarLigaArchivo: Ticket SD no encontrado."; } } catch (Exception
		 * e) { respuesta = false; fechaRespuesta = formatter.format(new
		 * Date()); codigoRespuesta = "102"; descripcionRespuesta =
		 * "AdjuntarLigaArchivo: Ocurrio un error al adjuntar la liga del archivo."
		 * ; mensajeServicio = e.toString();
		 * 
		 * JSONObject myObjectResponse = new JSONObject();
		 * 
		 * myObjectResponse.put("respuesta", respuesta);
		 * myObjectResponse.put("codigoRespuesta", codigoRespuesta);
		 * myObjectResponse.put("descripcionRespuesta", descripcionRespuesta);
		 * myObjectResponse.put("mensajeServicio", mensajeServicio);
		 * myObjectResponse.put("fechaSolicitud", fechaSolicitud);
		 * myObjectResponse.put("fechaRespuesta", fechaRespuesta);
		 * System.out.print("JSON RESPONSE adjuntarLigaArchivo: " +
		 * myObjectResponse);
		 * 
		 * String entradaOriginalResponse = myObjectResponse.toString(); String
		 * cadenaCodificadaResponse =
		 * Base64.getEncoder().encodeToString(entradaOriginalResponse.getBytes()
		 * ); System.out.println("codificado adjuntarLigaArchivo: " +
		 * cadenaCodificadaResponse);
		 * 
		 * bitacoraRepository.insertarBitacora(request.getNombreOperador(),
		 * request.getNumeroEmpleadoTPoperador(), fechaSolicitud,
		 * "Respuesta de peticion adjuntarLigaArchivo", "",
		 * cadenaCodificadaResponse); } finally { try { if (token != null)
		 * logInValidator.closeToken(token); } catch (RemoteException x) {
		 * logger.
		 * info("AdjuntarLigaArchivo: Ocurrio un error al adjuntar la liga del archivo"
		 * + x); } }
		 * 
		 * if (resp.getIdAttm() != null && !resp.getIdAttm().isEmpty()) { return
		 * new TAdjuntarLigaArchivoResponse(respuesta, codigoRespuesta,
		 * descripcionRespuesta, mensajeServicio, fechaSolicitud,
		 * fechaRespuesta, resp.getIdAttm()); } else { return new
		 * TAdjuntarLigaArchivoResponse(respuesta, codigoRespuesta,
		 * descripcionRespuesta, mensajeServicio, fechaSolicitud,
		 * fechaRespuesta, null); }
		 */

		return response;
	}

	public ActualizarPuntaResponse actualizarPunta(ActualizarPuntaRequest request) {

		Integer token = null;
		String error = null;
		boolean cerrado = false;
		Period period = null;

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		boolean respuesta = true;
		String codigoRespuesta = null;
		String descripcionRespuesta = null;
		String mensajeServicio = null;
		String fechaSolicitud = formatter.format(new Date());
		String fechaRespuesta = null;

		ArrayList<CATicket> tickets = new ArrayList<CATicket>();

		try {

			logger.info("actualizarPunta: " + request.getNombrePunta());

			token = logInValidator.getToken();
			String userHandle = logInValidator.getUserHandle(token);

			CATicketMapper mapper = new CATicketMapper();

			// String requestByCriteriaCI =
			// TicketQueryBuilder.buildQuery("5.55244_TFE-D-IS9129_3TM_SERVICIOS_CORPORATIVOS_SPECTRUM",
			// "CIName");
			// String requestByXmlCI = queryValidator.doSelect(token, "nr",
			// requestByCriteriaCI, 1,
			// TicketDictionary.persistentIdParam);
			// String CI = mapper.getValueByAttrName(requestByXmlCI,
			// "persistent_id");
			// logger.info("UUID Punta: "+CI);

			String CI = "nr:" + request.getNombrePunta().toUpperCase();
			logger.info("UUID Punta: " + CI);

			String[] attributes = new String[0];

			logger.info("PuntaTipo: " + request.getPuntaTipo());
			if (request.getPuntaTipo().equals("ONT")) {
				logger.info("Es ONT");

				String[] attrVals = { "zip_interface", request.getZipInterface(), "zlongitud",
						String.valueOf(request.getzLongitud()), "zlatitud", String.valueOf(request.getzLatitud()),
						"zes_interface", request.getZesInterface(), "zsitio", request.getzSitio() };

				String respuestaUpadte = this.objValidator.updateObject(token.intValue(), CI, attrVals, attributes);
				logger.info("Objeto actualizado de ONT");

				tickets = mapper.mapUnique(respuestaUpadte);
				logger.info("Se actualizó punta: " + tickets.get(0).getCi());

				if (respuestaUpadte != null) {

					JSONObject myObject = new JSONObject();

					/*
					 * myObject.put("nombrePunta", request.getNombrePunta());
					 * myObject.put("zsec_id_interface",
					 * request.getIdInterface());
					 * myObject.put("zsec_nombre_interface",
					 * request.getNombreInterface());
					 * myObject.put("zsec_alias_interface",
					 * request.getAliasInterface());
					 * myObject.put("zsec_leyenda_interface",
					 * request.getLeyendaInterface());
					 * myObject.put("zsec_id_device",
					 * request.getIdPuntaDetalle());
					 * myObject.put("zsec_ip_device",
					 * request.getNombrePuntaDetalle());
					 * myObject.put("zsec_nombre_nodo",
					 * request.getNombreAgrupador());
					 * myObject.put("zsec_posicion_nodo",
					 * request.getPosicionPunta());
					 * myObject.put("zsec_posicion_interface",
					 * request.getPosicionInterface());
					 * myObject.put("zsec_es_nodo_central",
					 * request.getNodoCentral()); myObject.put("zsitio",
					 * request.getSitio()); myObject.put("zip_interface",
					 * request.getAgrupacion()); myObject.put("zlongitud",
					 * request.getLongitud()); myObject.put("zlatitud",
					 * request.getLatitud()); myObject.put("zes_interface",
					 * request.getTipo());
					 */

					System.out.print("JSON REQUEST actualizarPunta: " + myObject);

					String entradaOriginal = myObject.toString();
					String cadenaCodificada = Base64.getEncoder().encodeToString(entradaOriginal.getBytes());
					System.out.println("codificado actualizarPunta: " + cadenaCodificada);

					// bitacoraRepository.insertarBitacora(request.getNombreOperador(),
					// request.getNumeroEmpleadoTPoperador(), fechaSolicitud,
					// "Peticion agregar comentario",
					// cadenaCodificada, "");

					fechaRespuesta = formatter.format(new Date());
					codigoRespuesta = "000";
					descripcionRespuesta = "ActualizarPunta: Se actualizo punta: " + request.getNombrePunta();
					mensajeServicio = "ActualizarPunta:  " + tickets;
					logger.info("ActualizarPunta: Se actualizo punta: " + request.getNombrePunta());
				}

			} else if (!request.getPuntaTipo().equals("ONT")) {
				logger.info("Diferente de ONT");

				String[] attrVals = { "zip_interface", request.getZipInterface(), "zlongitud",
						String.valueOf(request.getzLongitud()), "zlatitud", String.valueOf(request.getzLatitud()),
						"zes_interface", request.getZesInterface(), "zsitio", request.getzSitio(), "zsec_ip_device",
						request.getZsecIpDevice(), "zsec_id_interface", request.getZsecIdInterface(),
						"zsec_es_nodo_central", request.getZsecEsNodoCentral(), "zsec_id_device",
						request.getZsecIdDevice(), "zsec_posicion_nodo", request.getZsecPosicionNodo(),
						"zsec_nombre_interface", request.getZsecNombreInterface(), "zsec_nombre_nodo",
						request.getZsecNombreNodo(), "zsec_leyenda_interface", request.getZsecLeyendaInterface(),
						"zsec_alias_interface", request.getZsecAliasInterface(), "zsec_posicion_interface",
						request.getZsecPosicionInterface() };

				String respuestaUpadte = this.objValidator.updateObject(token.intValue(), CI, attrVals, attributes);
				logger.info("Objeto actualizado");

				tickets = mapper.mapUnique(respuestaUpadte);
				logger.info("Se actualizó punta: " + tickets.get(0).getCi());

				if (respuestaUpadte != null) {

					JSONObject myObject = new JSONObject();

					/*
					 * myObject.put("nombrePunta", request.getNombrePunta());
					 * myObject.put("zsec_id_interface",
					 * request.getIdInterface());
					 * myObject.put("zsec_nombre_interface",
					 * request.getNombreInterface());
					 * myObject.put("zsec_alias_interface",
					 * request.getAliasInterface());
					 * myObject.put("zsec_leyenda_interface",
					 * request.getLeyendaInterface());
					 * myObject.put("zsec_id_device",
					 * request.getIdPuntaDetalle());
					 * myObject.put("zsec_ip_device",
					 * request.getNombrePuntaDetalle());
					 * myObject.put("zsec_nombre_nodo",
					 * request.getNombreAgrupador());
					 * myObject.put("zsec_posicion_nodo",
					 * request.getPosicionPunta());
					 * myObject.put("zsec_posicion_interface",
					 * request.getPosicionInterface());
					 * myObject.put("zsec_es_nodo_central",
					 * request.getNodoCentral()); myObject.put("zsitio",
					 * request.getSitio()); myObject.put("zip_interface",
					 * request.getAgrupacion()); myObject.put("zlongitud",
					 * request.getLongitud()); myObject.put("zlatitud",
					 * request.getLatitud()); myObject.put("zes_interface",
					 * request.getTipo());
					 */

					System.out.print("JSON REQUEST actualizarPunta: " + myObject);

					String entradaOriginal = myObject.toString();
					String cadenaCodificada = Base64.getEncoder().encodeToString(entradaOriginal.getBytes());
					System.out.println("codificado actualizarPunta: " + cadenaCodificada);

					// bitacoraRepository.insertarBitacora(request.getNombreOperador(),
					// request.getNumeroEmpleadoTPoperador(), fechaSolicitud,
					// "Peticion agregar comentario",
					// cadenaCodificada, "");

					fechaRespuesta = formatter.format(new Date());
					codigoRespuesta = "000";
					descripcionRespuesta = "ActualizarPunta: Se actualizo punta: " + request.getNombrePunta();
					mensajeServicio = "ActualizarPunta:  " + tickets;
					logger.info("ActualizarPunta: Se actualizo punta: " + request.getNombrePunta());
				}
			}
		} catch (Exception e) {

			respuesta = false;
			fechaRespuesta = formatter.format(new Date());
			codigoRespuesta = "102";
			descripcionRespuesta = e.toString();
			mensajeServicio = "ActualizarPunta: Ocurrio un error en ActualizarPunta, para la punta: "
					+ request.getNombrePunta() + ".";
			JSONObject myObjectResponse = new JSONObject();

			myObjectResponse.put("respuesta", respuesta);
			myObjectResponse.put("codigoRespuesta", codigoRespuesta);
			myObjectResponse.put("descripcionRespuesta", descripcionRespuesta);
			myObjectResponse.put("mensajeServicio", mensajeServicio);
			myObjectResponse.put("fechaSolicitud", fechaSolicitud);
			myObjectResponse.put("fechaRespuesta", fechaRespuesta);
			System.out.print("JSON RESPONSE ActualizarPunta: " + myObjectResponse);

			String entradaOriginalResponse = myObjectResponse.toString();
			String cadenaCodificadaResponse = Base64.getEncoder().encodeToString(entradaOriginalResponse.getBytes());
			System.out.println("codificado ActualizarPunta: " + cadenaCodificadaResponse);

			// bitacoraRepository.insertarBitacora(request.getNombreOperador(),
			// request.getNumeroEmpleadoTPoperador(),
			// fechaSolicitud, "Respuesta de peticion actualizar estatus", "",
			// cadenaCodificadaResponse);

		} finally {
			try {
				logger.info("Entro a finally...");
				if (token != null) {
					cerrado = this.logInValidator.closeToken(token.intValue());
					logger.info("La sesion finalizo de forma (Finally): " + cerrado);
				}
			} catch (RemoteException e) {
				logger.error(e.toString());
				error = "Error al actualizar el estatus: " + e.toString();
			}
		}
		return new ActualizarPuntaResponse(respuesta, codigoRespuesta, descripcionRespuesta, mensajeServicio,
				fechaSolicitud, fechaRespuesta, null);
	}

	public TransferenciaGrupoResponse transferenciaGrupo(TransferenciaGrupoOperationRequest request) {

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		boolean respuesta = true;
		String codigoRespuesta = null;
		String descripcionRespuesta = null;
		String mensajeServicio = null;
		String fechaSolicitud = formatter.format(new Date());
		String fechaRespuesta = null;
		Integer token = null;

		try {

			token = logInValidator.getToken();
			CATicketMapper mapper = new CATicketMapper();

			String requestByCriteriaRequestBy = TicketQueryBuilder.buildQuery(request.getUsuarioSD(), "userCreate");
			String requestByXmlRequestBy = this.queryValidator.doSelect(token, "cnt", requestByCriteriaRequestBy, 1,
					TicketDictionary.persistentIdParam);
			String requestBy = mapper.getValueByAttrName(requestByXmlRequestBy, "persistent_id");

			String requestByTicket = TicketQueryBuilder.buildQuery(request.getTicketSD(), "refNum");
			String requestByXmlTicket = this.queryValidator.doSelect(token, "cr", requestByTicket, 1,
					TicketDictionary.ticketParam);
			String ticket = mapper.getValueByAttrName(requestByXmlTicket, "persistent_id");

			String requestByCriteriaGrupo = TicketQueryBuilder.buildQuery(request.getGrupo(), "group");
			String requestByXmlGrupo = queryValidator.doSelect(token, "cnt", requestByCriteriaGrupo, 1,
					TicketDictionary.persistentIdParam);
			String grupoId = mapper.getValueByAttrName(requestByXmlGrupo, "persistent_id");

			String justificacion = request.getJustificacion() + "\n" + " Nombre del operador quien actualizo el grupo: "
					+ request.getNombreOperador() + " Su numero de empleado: " + request.getNumeroEmpleadoTPoperador();

			if (ticket != null && !ticket.isEmpty()) {
				if (!grupoId.equals("null") && !grupoId.isEmpty() && grupoId != null) {
					if (!requestBy.isEmpty()) {

						logger.info("TOKEN: " + token.intValue());
						logger.info("El ticket: " + ticket);
						logger.info("Usuario: " + requestBy);
						logger.info("El nuevo grupo: " + grupoId);
						logger.info("Justificacion: " + justificacion);

						JSONObject myObject = new JSONObject();
						myObject.put("nombreOperador", request.getNombreOperador());
						myObject.put("numeroEmpleadoTPoperador", request.getNumeroEmpleadoTPoperador());
						myObject.put("ticketSD", request.getTicketSD());
						myObject.put("grupo", request.getGrupo());
						myObject.put("justificacion", request.getJustificacion());
						myObject.put("usuarioSD", request.getUsuarioSD());
						System.out.print("JSON REQUEST transfereciaGrupo: " + myObject);

						String respuestaUpadte = this.objValidator.transfer(token.intValue(), requestBy, ticket,
								justificacion, false, "", true, grupoId, false, "");
						String idTransferenciaGrupo = mapper.maperTransfer(respuestaUpadte);
						logger.info("Objeto actualizado: " + idTransferenciaGrupo);

						if (!idTransferenciaGrupo.isEmpty()) {
							respuesta = true;
							codigoRespuesta = "000";
							descripcionRespuesta = "TransfereciaGrupo: Exito al transferir el grupo a ticket:"
									+ request.getTicketSD();
							mensajeServicio = "TransfereciaGrupo: El idTransferenciaGrupo : " + idTransferenciaGrupo;
							fechaRespuesta = formatter.format(new Date());
						}
					} else {
						respuesta = false;
						codigoRespuesta = "102";
						descripcionRespuesta = "102 - TransfereciaGrupo: UsuarioSD no encontrado";
						mensajeServicio = "102 - TransfereciaGrupo: UsuarioSD no encontrado";
						fechaRespuesta = formatter.format(new Date());
						logger.info("UsuarioSD no encontrado");
					}
				} else {
					respuesta = false;
					codigoRespuesta = "102";
					descripcionRespuesta = "102 - TransfereciaGrupo: No se encontro grupo: " + request.getGrupo();
					mensajeServicio = "102 - TransfereciaGrupo: No se encontro grupo: " + request.getGrupo();
					fechaRespuesta = formatter.format(new Date());
					logger.info("Grupo invalido");
				}
			} else {
				respuesta = false;
				codigoRespuesta = "102";
				descripcionRespuesta = "102 - TransfereciaGrupo: Ticket no encontrado." + request.getTicketSD();
				mensajeServicio = "102 - TransfereciaGrupo: Ticket no encontrado." + request.getTicketSD();
				fechaRespuesta = formatter.format(new Date());
				logger.info("Ticket invalido");
			}
		} catch (Exception e) {
			respuesta = false;
			fechaRespuesta = formatter.format(new Date());
			codigoRespuesta = "102";
			descripcionRespuesta = e.toString();
			mensajeServicio = e.toString();

			JSONObject myObjectResponse = new JSONObject();
			myObjectResponse.put("respuesta", respuesta);
			myObjectResponse.put("codigoRespuesta", codigoRespuesta);
			myObjectResponse.put("descripcionRespuesta", descripcionRespuesta);
			myObjectResponse.put("mensajeServicio", mensajeServicio);
			myObjectResponse.put("fechaSolicitud", fechaSolicitud);
			myObjectResponse.put("fechaRespuesta", fechaRespuesta);
			System.out.print("JSON RESPONSE transfereciaGrupo: " + myObjectResponse);
		} finally {
			try {
				if (token != null)
					logInValidator.closeToken(token);
			} catch (RemoteException x) {
				logger.info("Error transfer" + x);
			}
		}
		return new TransferenciaGrupoResponse(respuesta, codigoRespuesta, descripcionRespuesta, mensajeServicio,
				fechaSolicitud, fechaRespuesta, null);
	}

	public AgregarComentarioResponse agregarComentario(AgregarComentarioOperationRequest request) {

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		boolean respuesta = true;
		String codigoRespuesta = null;
		String descripcionRespuesta = null;
		String mensajeServicio = null;
		String fechaSolicitud = formatter.format(new Date());
		String fechaRespuesta = null;

		Integer token = null;
		CATicketMapper mapper = new CATicketMapper();

		try {
			token = logInValidator.getToken();

			String requestByCriteriaRequestBy = TicketQueryBuilder.buildQuery(request.getUsuarioSD(), "userCreate");
			String requestByXmlRequestBy = this.queryValidator.doSelect(token, "cnt", requestByCriteriaRequestBy, 1,
					TicketDictionary.persistentIdParam);
			String requestBy = mapper.getValueByAttrName(requestByXmlRequestBy, "persistent_id");

			String requestByTicket = TicketQueryBuilder.buildQuery(request.getTicketSD(), "refNum");
			String requestByXmlTicket = queryValidator.doSelect(token, "cr", requestByTicket, 1,
					TicketDictionary.ticketParam);
			String ticket = mapper.getValueByAttrName(requestByXmlTicket, TicketDictionary.persistentId);
			logger.info("ticket Persid:" + ticket);

			if (ticket != null && !ticket.isEmpty()) {
				if (!requestBy.isEmpty()) {
					String requestByCriteria = TicketQueryBuilder.buildQuery(request.getUsuarioSD(), "userCreate");
					String requestByXml = queryValidator.doSelect(token, "cnt", requestByCriteria, 1,
							TicketDictionary.persistentIdParam);
					String creator = mapper.getValueByAttrName(requestByXml, TicketDictionary.persistentId);

					String description = request.getComentario() + "\n"
							+ " Nombre del operador quien agrego comentario: " + request.getNombreOperador()
							+ " Su numero de empleado: " + request.getNumeroEmpleadoTPoperador();
					String logType = "LOG";
					int timeSpent = 0;
					boolean internal = false;

					JSONObject myObject = new JSONObject();
					myObject.put("nombreOperador", request.getNombreOperador());
					myObject.put("numeroEmpleadoTPoperador", request.getNumeroEmpleadoTPoperador());
					myObject.put("ticketSD", request.getTicketSD());
					myObject.put("comentario", request.getComentario());
					myObject.put("usuarioSD", request.getUsuarioSD());
					System.out.print("JSON REQUEST agregarComentario: " + myObject);

					String respuestaWS = objValidator.addComment(token, creator, ticket, description, logType,
							timeSpent, internal);
					String idComment = mapper.maperComment(respuestaWS);

					if (!idComment.isEmpty()) {
						respuesta = true;
						fechaRespuesta = formatter.format(new Date());
						codigoRespuesta = "000";
						descripcionRespuesta = "AgregarComentario: Se agrego comentario al ticket: "
								+ request.getTicketSD() + " ,el id del comentario: " + idComment;
						mensajeServicio = "AgregarComentario: El idComentario : " + idComment;
						logger.info("AgregarComentario: Se agrego comentario al ticket " + request.getTicketSD()
								+ "El id del comentario: " + idComment);
					}
				} else {
					respuesta = false;
					codigoRespuesta = "102";
					descripcionRespuesta = "102 - AgregarComentario: UsuarioSD no encontrado";
					mensajeServicio = "102 - AgregarComentario: UsuarioSD no encontrado";
					fechaRespuesta = formatter.format(new Date());
					logger.info("UsuarioSD no encontrado");
				}
			} else {
				respuesta = false;
				fechaRespuesta = formatter.format(new Date());
				codigoRespuesta = "300";
				descripcionRespuesta = "AgregarComentario: Ticket no encontrado.";
				mensajeServicio = descripcionRespuesta;
			}
		} catch (Exception e) {
			respuesta = false;
			fechaRespuesta = formatter.format(new Date());
			codigoRespuesta = "102";
			descripcionRespuesta = "AgregarComentario: Ocurrio un error al agregar comentario.";
			mensajeServicio = e.toString();

			JSONObject myObjectResponse = new JSONObject();
			myObjectResponse.put("respuesta", respuesta);
			myObjectResponse.put("codigoRespuesta", codigoRespuesta);
			myObjectResponse.put("descripcionRespuesta", descripcionRespuesta);
			myObjectResponse.put("mensajeServicio", mensajeServicio);
			myObjectResponse.put("fechaSolicitud", fechaSolicitud);
			myObjectResponse.put("fechaRespuesta", fechaRespuesta);
			System.out.print("JSON RESPONSE agregarComentario: " + myObjectResponse);

		} finally {
			try {
				if (token != null)
					logInValidator.closeToken(token);
			} catch (RemoteException x) {
				logger.info("Error addComment" + x);
			}
		}
		return new AgregarComentarioResponse(respuesta, codigoRespuesta, descripcionRespuesta, mensajeServicio,
				fechaSolicitud, fechaRespuesta, null);
	}

	public ActualizarEstatusOperationResponse actualizaEstatus(ActualizarEstatusOperationRequest request) {

		Integer token = null;
		String error = null;
		boolean cerrado = false;

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		boolean respuesta = true;
		String codigoRespuesta = null;
		String descripcionRespuesta = null;
		String mensajeServicio = null;
		String fechaSolicitud = formatter.format(new Date());
		String fechaRespuesta = null;

		try {
			logger.info("Se recibio el estatus: " + request.getNuevoEstatus() + ". El solicitante:"
					+ request.getNombreOperador());

			token = logInValidator.getToken();
			CATicketMapper mapper = new CATicketMapper();

			String requestByCriteriaRequestBy = TicketQueryBuilder.buildQuery(request.getUsuarioSD(),
					"userCreate");
			String requestByXmlRequestBy = this.queryValidator.doSelect(token, "cnt", requestByCriteriaRequestBy, 1,
					TicketDictionary.persistentIdParam);

			String requestBy = mapper.getValueByAttrName(requestByXmlRequestBy, "id");
			String requestByTicket = TicketQueryBuilder.buildQuery(request.getTicketSD(), "refNum");
			String requestByXmlTicket = this.queryValidator.doSelect(token, "cr", requestByTicket, 1,
					TicketDictionary.ticketParam);
			String ticket = mapper.getValueByAttrName(requestByXmlTicket, "persistent_id");
			String ticketStatus = mapper.getValueByAttrName(requestByXmlTicket, "status");
			logger.info("El ticket esta en status:" + ticketStatus);

			if (ticketStatus.equalsIgnoreCase("CL")) {

				respuesta = false;
				fechaRespuesta = formatter.format(new Date());
				codigoRespuesta = "300";
				descripcionRespuesta = "Actualizar estatus: No se puede actualizar un ticket inactivo :"
						+ request.getTicketSD();

				JSONObject myObjectResponse = new JSONObject();

				myObjectResponse.put("respuesta", respuesta);
				myObjectResponse.put("codigoRespuesta", codigoRespuesta);
				myObjectResponse.put("descripcionRespuesta", descripcionRespuesta);
				myObjectResponse.put("mensajeServicio", mensajeServicio);
				myObjectResponse.put("fechaSolicitud", fechaSolicitud);
				myObjectResponse.put("fechaRespuesta", fechaRespuesta);
				System.out.print("JSON RESPONSE actualizaEstatus: " + myObjectResponse);

			} else {
				SdmCrStatModel estadoId = this.sdmCrStatRepository.findByCode(request.getNuevoEstatus());
				if (estadoId != null) {
					String coment = request.getJustificacion();
					logger.info("Se va actualizar el estado " + request.getNuevoEstatus());
					boolean updateStatus = this.objValidator.updateStatus(ticket, estadoId.getPersid(), coment,
							token.intValue(), "cnt:" + requestBy);
					logger.info("Estatus actualizado:  " + updateStatus);

					if (updateStatus) {

						JSONObject myObject = new JSONObject();

						myObject.put("nombreOperador", request.getNombreOperador());
						myObject.put("numeroEmpleadoTPoperador", request.getNumeroEmpleadoTPoperador());
						myObject.put("ticketSD", request.getTicketSD());
						myObject.put("comentario", "");
						System.out.print("JSON REQUEST actualizaEstatus: " + myObject);

						fechaRespuesta = formatter.format(new Date());
						codigoRespuesta = "000";
						descripcionRespuesta = "Actualizar estatus: Se actualizo estatus al ticket: "
								+ request.getTicketSD();
						mensajeServicio = "Estatus actualizado:  " + updateStatus;
						logger.info("Actualizar estatust: Se actualizo estatus al ticket: " + request.getTicketSD());
					}
				}
			}
		} catch (Exception e) {
			respuesta = false;
			fechaRespuesta = formatter.format(new Date());
			codigoRespuesta = "102";
			descripcionRespuesta = e.toString();
			mensajeServicio = "Actualizar estatus: Ocurrio un error en UpdateStatus, para el ticket: "
					+ request.getTicketSD() + ".";
			JSONObject myObjectResponse = new JSONObject();

			myObjectResponse.put("respuesta", respuesta);
			myObjectResponse.put("codigoRespuesta", codigoRespuesta);
			myObjectResponse.put("descripcionRespuesta", descripcionRespuesta);
			myObjectResponse.put("mensajeServicio", mensajeServicio);
			myObjectResponse.put("fechaSolicitud", fechaSolicitud);
			myObjectResponse.put("fechaRespuesta", fechaRespuesta);
			System.out.print("JSON RESPONSE actualizaEstatus: " + myObjectResponse);

		} finally {
			try {
				logger.info("Entro a finally...");
				if (token != null) {
					cerrado = this.logInValidator.closeToken(token.intValue());
					logger.info("La sesion finalizo de forma (Finally): " + cerrado);
				}
			} catch (RemoteException e) {
				logger.error(e.toString());
				error = "Error al actualizar el estatus: " + e.toString();
			}
		}
		return new ActualizarEstatusOperationResponse(respuesta, codigoRespuesta, descripcionRespuesta, mensajeServicio, fechaSolicitud,
				fechaRespuesta, null);
	}

}
