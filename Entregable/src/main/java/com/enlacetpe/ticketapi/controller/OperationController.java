package com.enlacetpe.ticketapi.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.Period;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.enlacetpe.ticketapi.comunes.Comunes;
import com.enlacetpe.ticketapi.request.ActualizaIPRequest;
import com.enlacetpe.ticketapi.request.ActualizaTiemposImputablesRequest;
import com.enlacetpe.ticketapi.request.ActualizarEstatusOperationRequest;
import com.enlacetpe.ticketapi.request.ActualizarEstatusRequest;
import com.enlacetpe.ticketapi.request.ActualizarPuntaRequest;
import com.enlacetpe.ticketapi.request.AdjuntarLigaArchivoRequest;
import com.enlacetpe.ticketapi.request.AgregarComentarioOperationRequest;
import com.enlacetpe.ticketapi.request.ChangeEstatusRequest;
import com.enlacetpe.ticketapi.request.CommentRequest;
import com.enlacetpe.ticketapi.request.ConsultarCiudadesRequest;
import com.enlacetpe.ticketapi.request.CreateTicketRequest;
import com.enlacetpe.ticketapi.request.ExternalSystemTicketRequest;
import com.enlacetpe.ticketapi.request.NumSerieRequest;
import com.enlacetpe.ticketapi.request.ONTRequest;
import com.enlacetpe.ticketapi.request.OperationTicketAutomatico;
import com.enlacetpe.ticketapi.request.OperationTicketNocRequest;
import com.enlacetpe.ticketapi.request.OperationTicketRequest;
import com.enlacetpe.ticketapi.request.OrganizationRequest;
import com.enlacetpe.ticketapi.request.PruebasRequest;
import com.enlacetpe.ticketapi.request.RfcRequest;
import com.enlacetpe.ticketapi.request.TransferenciaGrupoOperationRequest;
import com.enlacetpe.ticketapi.request.TransferenciaGrupoRequest;
import com.enlacetpe.ticketapi.request.UpdateRequest;
import com.enlacetpe.ticketapi.response.ActualizarEstatusOperationResponse;
import com.enlacetpe.ticketapi.response.ActualizarPuntaResponse;
import com.enlacetpe.ticketapi.response.AgregarComentarioResponse;
import com.enlacetpe.ticketapi.response.CAOrganizationList;
import com.enlacetpe.ticketapi.response.CAResponse;
import com.enlacetpe.ticketapi.response.CARfcList;
import com.enlacetpe.ticketapi.response.CATicketList;
import com.enlacetpe.ticketapi.response.CAuuid;
import com.enlacetpe.ticketapi.response.TAdjuntarLigaArchivoResponse;
import com.enlacetpe.ticketapi.response.TCiudadesList;
import com.enlacetpe.ticketapi.response.TablerosResponse;
import com.enlacetpe.ticketapi.response.TransferenciaGrupoResponse;
import com.enlacetpe.ticketapi.service.CMDB.CreateTicketManager;
import com.enlacetpe.ticketapi.service.CMDB.OperationManager;
import com.enlacetpe.ticketapi.service.CMDB.OrganizationManager;
import com.enlacetpe.ticketapi.service.CMDB.TicketsAutomatico;
import com.enlacetpe.ticketapi.service.serviceDesk.ChangeTicketManager;
import com.enlacetpe.ticketapi.service.serviceDesk.CommentTicketManager;
import com.enlacetpe.ticketapi.service.serviceDesk.EstatusManagerSD;
import com.enlacetpe.ticketapi.util.ActivityLogger;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/operation")
@Api(value = "operation")
public class OperationController {

	public ActualizarPuntaResponse responsePunta = new ActualizarPuntaResponse();
	public TransferenciaGrupoResponse responseTransferencia = new TransferenciaGrupoResponse();
	public AgregarComentarioResponse responseComentario = new AgregarComentarioResponse();
	public ActualizarEstatusOperationResponse responseActualizarEstatus = new ActualizarEstatusOperationResponse();

	final static Logger logger = Logger.getLogger(OperationController.class);

	@Autowired
	private OperationManager operationManager;

	@Autowired
	private OrganizationManager organizationManager;

	@Autowired
	private TicketsAutomatico ticketsAutomatico;

	@Autowired
	private CreateTicketManager createTicketManager;

	@Autowired
	private EstatusManagerSD estatusManagerSD;

	@Autowired
	private CommentTicketManager commentTicketManager;

	@Autowired
	private ChangeTicketManager changeTicketManager;

	// public AdjuntarArchivoResponse adjuntarArchivoResponse = new
	// AdjuntarArchivoResponse();
	public TAdjuntarLigaArchivoResponse adjuntarLigaArchivoResponse = new TAdjuntarLigaArchivoResponse();

	@RequestMapping(value = "/ticketCMDB-CARE", method = RequestMethod.POST)
	@ApiOperation(value = "Genera un nuevo ticket", notes = "Se genera un nuevo ticket")
	public ResponseEntity<CATicketList> createTicketCMDBCARE(@Valid @RequestBody OperationTicketRequest request) {
		ActivityLogger.logMethod("createTicketCMDB-CARE");
		CATicketList tickets = operationManager.createTicketCMDBCARE(request);
		return new ResponseEntity<CATicketList>(tickets, HttpStatus.OK);
	}

	@RequestMapping(value = "/ticketCMDB-NOC", method = RequestMethod.POST)
	@ApiOperation(value = "Genera un nuevo ticket", notes = "Se genera un nuevo ticket")
	public ResponseEntity<CATicketList> createTicketCMDBNOC(@Valid @RequestBody OperationTicketNocRequest request) {
		ActivityLogger.logMethod("createTicketCMDB-NOC");
		CATicketList tickets = operationManager.createTicketCMDBNOC(request);
		return new ResponseEntity<CATicketList>(tickets, HttpStatus.OK);
	}

	// @RequestMapping(value = "/preticket-NOC", method = RequestMethod.POST)
	// @ApiOperation(value = "Genera un nuevo ticket", notes = "Se genera un
	// nuevo ticket")
	// public ResponseEntity<CATicketList> createPreTicketNoc(@Valid
	// @RequestBody OperationPreTicketNoc request) {
	// ActivityLogger.logMethod("createPreTicketNoc");
	// CATicketList tickets = operationManager.createPreeTicketNOC(request);
	// return new ResponseEntity<CATicketList>(tickets, HttpStatus.OK);
	// }

	// @RequestMapping(value = "/preticket-CARE", method = RequestMethod.POST)
	// @ApiOperation(value = "Genera un nuevo ticket", notes = "Se genera un
	// nuevo ticket")
	// public ResponseEntity<CATicketList> createPreTicketCare(@Valid
	// @RequestBody OperationPreTicketCare request) {
	// ActivityLogger.logMethod("createPreTicketCare");
	// CATicketList tickets = operationManager.createPreeTicketCARE(request);
	// return new ResponseEntity<CATicketList>(tickets, HttpStatus.OK);
	// }

	@RequestMapping(value = "/comment", method = RequestMethod.POST)
	@ApiOperation(value = "Agrega comentario a un ticket", notes = "Agrega comentario a un ticket")
	public ResponseEntity<CAResponse> addComent(@Valid @RequestBody CommentRequest request) {
		ActivityLogger.logMethod("addComent");
		CAResponse responseManager = commentTicketManager.addComent(request);
		return new ResponseEntity<CAResponse>(responseManager, HttpStatus.OK);
	}

	@RequestMapping(value = "/status", method = RequestMethod.POST)
	@ApiOperation(value = "Cambia el status a un ticket", notes = "Cambia el status a un ticket")
	public ResponseEntity<CAResponse> status(@Valid @RequestBody ChangeEstatusRequest request, BindingResult result,
			HttpServletResponse httpResponse) {
		ActivityLogger.logMethod("status");
		CAResponse responseManager = estatusManagerSD.updateStatus(request);

		DateTime initial = new DateTime();
		Period period = new Period(initial, new DateTime());

		responseManager.setMssg(responseManager.getError());
		responseManager.setCode("01");
		responseManager.setTimeRes(period);

		return new ResponseEntity<CAResponse>(responseManager, HttpStatus.OK);
	}

	@RequestMapping(value = "/ticketONT", method = RequestMethod.POST)
	@ApiOperation(value = "Genera un nuevo ticket para ONT", notes = "Se genera un nuevo ticket para ONT")
	public ResponseEntity<CATicketList> createTicketONT(@Valid @RequestBody ONTRequest request) {
		ActivityLogger.logMethod("createTicketONT");
		CATicketList tickets = operationManager.createTicketONT(request);
		return new ResponseEntity<CATicketList>(tickets, HttpStatus.OK);
	}

	@RequestMapping(value = "/organization", method = RequestMethod.POST)
	@ApiOperation(value = "Muestra las coincidencias de un cliente", notes = "Muestra las coincidencias de un cliente")
	public ResponseEntity<CAOrganizationList> coincidenciasCliete(@Valid @RequestBody OrganizationRequest request) {
		ActivityLogger.logMethod("createTicketONT");
		CAOrganizationList clientes = organizationManager.findOrganization(request);
		return new ResponseEntity<CAOrganizationList>(clientes, HttpStatus.OK);
	}

	@RequestMapping(value = "/automatico", method = RequestMethod.POST)
	@ApiOperation(value = "Genera un nuevo ticket", notes = "Se genera un nuevo ticket")
	public ResponseEntity<CATicketList> createTicketAutomatico(@Valid @RequestBody OperationTicketAutomatico request) {
		ActivityLogger.logMethod("createTicketAutomatico");
		CATicketList tickets = ticketsAutomatico.createTicketAutomatico(request);
		return new ResponseEntity<CATicketList>(tickets, HttpStatus.OK);
	}

	// @RequestMapping(value = "/solicitud/automatico", method =
	// RequestMethod.POST)
	// @ApiOperation(value = "Genera un nueva solicitud", notes = "Se genera una
	// nueva solicitud")
	// public ResponseEntity<CATicketList> createSolicitudAutomatico(@Valid
	// @RequestBody SolicitudRequest request) {
	// ActivityLogger.logMethod("createSolicitudAutomatico");
	// CATicketList tickets =
	// ticketsAutomatico.createSolicitudAutomatico(request);
	// return new ResponseEntity<CATicketList>(tickets, HttpStatus.OK);
	// }

	@RequestMapping(value = "/ticket", method = RequestMethod.POST)
	@ApiOperation(value = "Genera un nuevo ticket", notes = "Se genera un nuevo ticket")
	public ResponseEntity<CATicketList> createTicket(@Valid @RequestBody CreateTicketRequest request,
			BindingResult result, HttpServletResponse httpResponse) {
		ActivityLogger.logMethod("createTicket");
		CATicketList response = createTicketManager.createTicket(request);
		return new ResponseEntity<CATicketList>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/externalTicket", method = RequestMethod.POST)
	@ApiOperation(value = "Cambia el ticket externo de sistema", notes = "Cambia el ticket externo de sistema")
	public ResponseEntity<CAResponse> changeTicketExternal(@RequestBody ExternalSystemTicketRequest request) {
		ActivityLogger.logMethod("changeTicketExternal");
		CAResponse response = changeTicketManager.updateTicket(request);
		return new ResponseEntity<CAResponse>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ApiOperation(value = "Actualiza los valores de ETA ETR Latitud y Longitud", notes = "Actualiza los valores de ETA ETR Latitud y Longitud")
	public ResponseEntity<CAResponse> update(@RequestBody @Valid UpdateRequest request, BindingResult result,
			HttpServletResponse httpResponse) {
		ActivityLogger.logMethod("UpdateRequest");
		CAResponse response = new CAResponse();
		if (result.hasErrors()) {
			System.out.println("Hay error");
			DateTime initial = new DateTime();
			httpResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			response.setSuccess(false);
			List<ObjectError> errors = result.getAllErrors();
			String error = "";
			for (ObjectError oe : errors) {
				error = error + oe.getDefaultMessage() + " ";
				response.setMssg(error);
			}
			Period period = new Period(initial, new DateTime());
			response.setTimeRes(period);
		} else {
			response = operationManager.updateObject(request);
		}

		return new ResponseEntity<CAResponse>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/rfc", method = RequestMethod.POST)
	@ApiOperation(value = "Recupera el detalle del RFC ", notes = "Recupera el detalle del RFC")
	public ResponseEntity<CARfcList> getRfc(@Valid @RequestBody RfcRequest request) {
		ActivityLogger.logMethod("getRfc");
		CARfcList detalle = operationManager.consultaRfc(request);
		return new ResponseEntity<CARfcList>(detalle, HttpStatus.OK);

	}

	@RequestMapping(value = "/actualizarIP", method = RequestMethod.POST)
	@ApiOperation(value = "Actualizar la IP en SD", notes = "Actualizar la IP en SD")
	public ResponseEntity<CAResponse> actualizarIP(@Valid @RequestBody ActualizaIPRequest request) {
		ActivityLogger.logMethod("actualizarIP");

		CAResponse response = new CAResponse();
		StringBuilder error = new StringBuilder("");

		Pattern patron = Pattern.compile(
				"^(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])$");
		Matcher matNueva = patron.matcher(request.getIpNueva());
		Matcher matActualizar = patron.matcher(request.getIpActualizar());

		response.setSuccess(true);

		if (request.getIpActualizar() == null) {
			response.setSuccess(false);
			error.append("La ipActualizar no puede ser nula");
			error.append("\\n ");
			response.setError(error.toString());
		} else if (request.getIpActualizar().equals("")) {
			response.setSuccess(false);
			error.append("La ipActualizar no puede ser vacia");
			error.append("\\n ");
			response.setError(error.toString());
		} else if (!matActualizar.matches()) {
			response.setSuccess(false);
			error.append("El formato de la ipActualizar nueva es incorrecta");
			error.append("\\n ");
			response.setError(error.toString());
		}

		if (request.getIpNueva() == null) {
			response.setSuccess(false);
			error.append("La getIpNueva no puede ser nula");
			error.append("\\n ");
			response.setError(error.toString());
		} else if (request.getIpNueva().equals("")) {
			response.setSuccess(false);
			error.append("La getIpNueva no puede ser vacia");
			error.append("\\n ");
			response.setError(error.toString());
		} else if (!matNueva.matches()) {
			response.setSuccess(false);
			error.append("El formato de la ipActualizar nueva es incorrecta");
			error.append("\\n ");
			response.setError(error.toString());
		}

		if (response.getSuccess() != false) {
			response = operationManager.actualizaCI(request);
		}

		return new ResponseEntity<CAResponse>(response, HttpStatus.OK);

	}

	@RequestMapping(value = "/uuidByNumSerie", method = RequestMethod.POST)
	@ApiOperation(value = "Recupera el UUID por numero de serie", notes = "Recupera el UUID por numero de serie")
	public ResponseEntity<CAuuid> getUuidByNumSerie(@Valid @RequestBody NumSerieRequest request) {
		ActivityLogger.logMethod("getTicketActiveIP");
		CAuuid response = operationManager.getUuidByNumSerie(request);
		return new ResponseEntity<CAuuid>(response, HttpStatus.OK);
	}

	/* Se utiliza en Dashboard de Infraestructura */
	@RequestMapping(value = "/ticketNOC", method = RequestMethod.POST)
	@ApiOperation(value = "Genera un nuevo ticket", notes = "Se genera un nuevo ticket")
	public ResponseEntity<CATicketList> createTicketNOC(@Valid @RequestBody OperationTicketNocRequest request) {
		ActivityLogger.logMethod("createTicketCMDB-NOC");
		CATicketList tickets = operationManager.createTicketNOC(request);
		return new ResponseEntity<CATicketList>(tickets, HttpStatus.OK);
	}

	@RequestMapping(value = "/actualizarTiemposImputables", method = RequestMethod.POST)
	@ApiOperation(value = "Actualizar los tiempos imputables por refNum en SD", notes = "Actualizar los tiempos imputables por refNum en SD")
	public ResponseEntity<CAResponse> actualizarTiemposImputables(
			@Valid @RequestBody ActualizaTiemposImputablesRequest request) {
		ActivityLogger.logMethod("actualizarTiemposImputables");

		CAResponse response = new CAResponse();
		StringBuilder error = new StringBuilder("");
		response.setSuccess(true);
		DateTime initial = new DateTime();
		Period period = new Period(initial, new DateTime());

		if (request.getRefNum() == null) {

			response.setSuccess(false);
			error.append("RefNum no puede ser nula");
			error.append(", ");
			response.setError(error.toString());
			response.setMssg(error.toString());
			response.setCode("01");
			response.setTimeRes(period);
		} else if (request.getRefNum().equals("")) {
			response.setSuccess(false);
			error.append("RefNum no puede ser vacía");
			error.append(", ");
			response.setError(error.toString());
			response.setMssg(error.toString());
			response.setCode("01");
			response.setTimeRes(period);
		} else if (Comunes.isNumeric(request.getRefNum()) == false) {
			response.setSuccess(false);
			error.append("RefNum debe ser numérica");
			error.append(", ");
			response.setError(error.toString());
			response.setMssg(error.toString());
			response.setCode("01");
			response.setTimeRes(period);
		}

		if (request.getZtiempoFallaCte() == null) {
			response.setSuccess(false);
			error.append("ZtiempoFallaCte no puede ser nula");
			error.append(", ");
			response.setError(error.toString());
			response.setMssg(error.toString());
			response.setCode("01");
			response.setTimeRes(period);
		} else if (request.getZtiempoFallaCte().equals("")) {
			response.setSuccess(false);
			error.append("ZtiempoFallaCte no puede ser vacío");
			error.append(", ");
			response.setError(error.toString());
			response.setMssg(error.toString());
			response.setCode("01");
			response.setTimeRes(period);
		} else if (Comunes.isNumeric(request.getZtiempoFallaCte()) == false) {
			response.setSuccess(false);
			error.append("ZtiempoFallaCte debe ser numérico");
			error.append(", ");
			response.setError(error.toString());
			response.setMssg(error.toString());
			response.setCode("01");
			response.setTimeRes(period);
		}

		if (request.getZtiempoFallaProv() == null) {
			response.setSuccess(false);
			error.append("ZtiempoFallaProv no puede ser nula");
			error.append(", ");
			response.setError(error.toString());
			response.setMssg(error.toString());
			response.setCode("01");
			response.setTimeRes(period);
		} else if (request.getZtiempoFallaProv().equals("")) {
			response.setSuccess(false);
			error.append("ZtiempoFallaProv no puede ser vacío");
			error.append(", ");
			response.setError(error.toString());
			response.setMssg(error.toString());
			response.setCode("01");
			response.setTimeRes(period);
		} else if (Comunes.isNumeric(request.getZtiempoFallaProv()) == false) {
			response.setSuccess(false);
			error.append("ZtiempoFallaProv debe ser numérico");
			error.append(", ");
			response.setError(error.toString());
			response.setMssg(error.toString());
			response.setCode("01");
			response.setTimeRes(period);
		}

		if (request.getZtiempoFallaTerceros() == null) {
			response.setSuccess(false);
			error.append("ZtiempoFallaTerceros no puede ser nula");
			error.append(", ");
			response.setError(error.toString());
			response.setMssg(error.toString());
			response.setCode("01");
			response.setTimeRes(period);
		} else if (request.getZtiempoFallaTerceros().equals("")) {
			response.setSuccess(false);
			error.append("ZtiempoFallaTerceros no puede ser vacío");
			error.append(", ");
			response.setError(error.toString());
			response.setMssg(error.toString());
			response.setCode("01");
			response.setTimeRes(period);
		} else if (Comunes.isNumeric(request.getZtiempoFallaTerceros()) == false) {
			response.setSuccess(false);
			error.append("ZtiempoFallaTerceros debe ser numérico");
			error.append(", ");
			response.setError(error.toString());
			response.setMssg(error.toString());
			response.setCode("01");
			response.setTimeRes(period);
		}

		if (request.getZtiempoFallaTpe() == null) {
			response.setSuccess(false);
			error.append("ZtiempoFallaTpe no puede ser nula");
			error.append(", ");
			response.setError(error.toString());
			response.setMssg(error.toString());
			response.setCode("01");
			response.setTimeRes(period);
		} else if (request.getZtiempoFallaTpe().equals("")) {
			response.setSuccess(false);
			error.append("ZtiempoFallaTpe no puede ser vacío");
			error.append(", ");
			response.setError(error.toString());
			response.setMssg(error.toString());
			response.setCode("01");
			response.setTimeRes(period);
		} else if (Comunes.isNumeric(request.getZtiempoFallaTpe()) == false) {
			response.setSuccess(false);
			error.append("ZtiempoFallaTpe debe ser numérico");
			error.append(", ");
			response.setError(error.toString());
			response.setMssg(error.toString());
			response.setCode("01");
			response.setTimeRes(period);
		}

		if (Comunes.isNumeric(request.getZtiempoPerformance()) == false) {
			response.setSuccess(false);
			error.append("ZtiempoPerformance debe ser numérico");
			// error.append("\n");
			response.setError(error.toString());
			response.setMssg(error.toString());
			response.setCode("01");
			response.setTimeRes(period);
		}

		if (response.getSuccess() != false) {
			response = operationManager.actualizaTiemposImputables(request);
		}

		return new ResponseEntity<CAResponse>(response, HttpStatus.OK);

	}

	@RequestMapping(value = "/TadjuntarLigaArchivo", method = RequestMethod.POST)
	@ApiOperation(value = "Adjuntar liga de archivo a ticket", notes = "Adjuntar liga de archivo a ticket")
	public ResponseEntity<TAdjuntarLigaArchivoResponse> adjuntarLigaArchivo(
			@Valid @RequestBody AdjuntarLigaArchivoRequest request, BindingResult result,
			HttpServletResponse httpResponse) {
		ActivityLogger.logMethod("TadjuntarLigaArchivo");
		boolean respuesta = true;
		String parametros = "";
		List<String> listParam = new ArrayList<String>();
		if (result.hasErrors()) {
			httpResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			List<ObjectError> errors = result.getAllErrors();
			for (ObjectError oe : errors) {
				respuesta = false;
				listParam.add(oe.getCodes()[1].substring(oe.getCodes()[1].indexOf(".") + 1));
			}
			parametros = String.join(", ", listParam);
			setAdjuntarLigaArchivo(respuesta, "101",
					"Se requiere(n) lo(s) siguientes parametro(s) de entrada: " + parametros,
					"Se requiere(n) lo(s) siguientes parametro(s) de entrada: " + parametros);
		} else {

			if (request.getNombreOperador().equals("") || request.getNombreOperador() == null
					|| request.getNombreOperador().equals("null")) {

				respuesta = false;
				setAdjuntarLigaArchivo(respuesta, "101", "Nombre operador es requerido",
						"Nombre operador es requerido");

			}

			if (request.getNumeroEmpleadoTPoperador().equals("") || request.getNumeroEmpleadoTPoperador() == null
					|| request.getNumeroEmpleadoTPoperador().equals("null")) {

				respuesta = false;
				setAdjuntarLigaArchivo(respuesta, "101", "NumeroEmpleadoTPoperador es requerido",
						"NumeroEmpleadoTPoperador es requerido");

			}

			if (request.getTicketSD().equals("") || request.getTicketSD() == null
					|| request.getTicketSD().equals("null")) {

				respuesta = false;
				setAdjuntarLigaArchivo(respuesta, "101", "TicketSD es requerido", "TicketSD es requerido");

			}

			if (request.getFolioSF().equals("") || request.getFolioSF() == null
					|| request.getFolioSF().equals("null")) {

				respuesta = false;
				setAdjuntarLigaArchivo(respuesta, "101", "FolioSF es requerido", "FolioSF es requerido");

			}

			if (request.getNombreArchivo().equals("") || request.getNombreArchivo() == null
					|| request.getNombreArchivo().equals("null")) {

				respuesta = false;
				setAdjuntarLigaArchivo(respuesta, "101", "NombreArchivo es requerido", "NombreArchivo es requerido");

			}

			if (request.getUrlArchivo().equals("") || request.getUrlArchivo() == null
					|| request.getUrlArchivo().equals("null")) {

				respuesta = false;
				setAdjuntarLigaArchivo(respuesta, "101", "Url de archivo es requerido", "Url de archivo es requerido");

			}

			if (respuesta != false) {
				adjuntarLigaArchivoResponse = operationManager.adjuntarLigaArchivo(request);
			}
		}
		return new ResponseEntity<TAdjuntarLigaArchivoResponse>(adjuntarLigaArchivoResponse, HttpStatus.OK);
	}

	public void setAdjuntarLigaArchivo(Boolean respuesta, String codigoRespuesta, String descripcionRespuesta,
			String mensajeServicio) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		adjuntarLigaArchivoResponse = new TAdjuntarLigaArchivoResponse();
		adjuntarLigaArchivoResponse.setFechaSolicitud(formatter.format(new Date()));
		adjuntarLigaArchivoResponse.setRespuestaBoolean(respuesta);
		adjuntarLigaArchivoResponse.setFechaRespuesta(formatter.format(new Date()));
		adjuntarLigaArchivoResponse.setCodigoRespuesta(codigoRespuesta);
		adjuntarLigaArchivoResponse.setDescripcionRespuesta(descripcionRespuesta);
		adjuntarLigaArchivoResponse.setMensajeServicio(mensajeServicio);

	}

	@RequestMapping(value = "/pruebas", method = RequestMethod.POST)
	@ApiOperation(value = "", notes = "")
	public ResponseEntity<CAResponse> getPruebas(@Valid @RequestBody PruebasRequest request) {
		ActivityLogger.logMethod("getPruebas");
		CAResponse response = operationManager.test(request);
		return new ResponseEntity<CAResponse>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/actualizarPunta", method = RequestMethod.POST)
	@ApiOperation(value = "Actualizar detalle de punta", notes = "Actualizar detalle de punta")
	public ResponseEntity<ActualizarPuntaResponse> actualizarPunta(@Valid @RequestBody ActualizarPuntaRequest request,
			BindingResult result, HttpServletResponse httpResponse) {
		ActivityLogger.logMethod("actualizarPunta");
		boolean respuesta = true;
		String parametros = "";
		List<String> listParam = new ArrayList<String>();
		if (result.hasErrors()) {
			httpResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			List<ObjectError> errors = result.getAllErrors();
			for (ObjectError oe : errors) {
				respuesta = false;
				listParam.add(oe.getCodes()[1].substring(oe.getCodes()[1].indexOf(".") + 1));
			}
			parametros = String.join(", ", listParam);
			setRespuestasActualizarPunta(respuesta, "101",
					"Se requiere(n) lo(s) siguientes parametro(s) de entrada: " + parametros,
					"Se requiere(n) lo(s) siguientes parametro(s) de entrada: " + parametros);
		} else {

			if (request.getNombreOperador().equals("") || request.getNombreOperador() == null
					|| request.getNombreOperador().equals("null")) {

				respuesta = false;
				setRespuestasActualizarPunta(respuesta, "101", "Nombre operador es requerido",
						"Nombre operador es requerido");

			}

			if (request.getNumeroEmpleadoTPoperador().equals("") || request.getNumeroEmpleadoTPoperador() == null
					|| request.getNumeroEmpleadoTPoperador().equals("null")) {

				respuesta = false;
				setRespuestasActualizarPunta(respuesta, "101", "NumeroEmpleadoTPoperador es requerido",
						"NumeroEmpleadoTPoperador es requerido");

			}

			if (request.getNombrePunta().equals("") || request.getNombrePunta() == null
					|| request.getNombrePunta().equals("null")) {

				respuesta = false;
				setRespuestasActualizarPunta(respuesta, "101", "NombrePunta es requerido", "NombrePunta es requerido");

			}

			if (respuesta != false) {
				responsePunta = operationManager.actualizarPunta(request);
			}
		}
		return new ResponseEntity<ActualizarPuntaResponse>(responsePunta, HttpStatus.OK);
	}

	public void setRespuestasActualizarPunta(Boolean respuesta, String codigoRespuesta, String descripcionRespuesta,
			String mensajeServicio) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		responsePunta = new ActualizarPuntaResponse();

		responsePunta.setFechaSolicitud(formatter.format(new Date()));
		responsePunta.setRespuestaBoolean(respuesta);
		responsePunta.setFechaRespuesta(formatter.format(new Date()));
		responsePunta.setCodigoRespuesta(codigoRespuesta);
		responsePunta.setDescripcionRespuesta(descripcionRespuesta);
		responsePunta.setMensajeServicio(mensajeServicio);

	}
	
	@RequestMapping(value = "/transferenciaGrupo", method = RequestMethod.POST)
	@ApiOperation(value = "Transferencia de grupo (bandeja)", notes = "Transferencia de grupo (bandeja)")
	public ResponseEntity<TransferenciaGrupoResponse> transferenciaGrupo(
			@Valid @RequestBody TransferenciaGrupoOperationRequest request, BindingResult result,
			HttpServletResponse httpResponse) {
		ActivityLogger.logMethod("transferenciaGrupo");
		boolean respuesta = true;
		String parametros = "";
		List<String> listParam = new ArrayList<String>();
		if (result.hasErrors()) {
			httpResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			List<ObjectError> errors = result.getAllErrors();
			for (ObjectError oe : errors) {
				respuesta = false;
				listParam.add(oe.getCodes()[1].substring(oe.getCodes()[1].indexOf(".") + 1));
			}
			parametros = String.join(", ", listParam);
			setRespuestasTransferencia(respuesta, "101",
					"Se requiere(n) lo(s) siguientes parametro(s) de entrada: " + parametros,
					"Se requiere(n) lo(s) siguientes parametro(s) de entrada: " + parametros);
		} else {

			if (request.getNombreOperador().equals("") || request.getNombreOperador() == null
					|| request.getNombreOperador().equals("null")) {

				respuesta = false;
				setRespuestasTransferencia(respuesta, "101", "Nombre operador es requerido",
						"Nombre operador es requerido");

			}

			if (request.getNumeroEmpleadoTPoperador().equals("") || request.getNumeroEmpleadoTPoperador() == null
					|| request.getNumeroEmpleadoTPoperador().equals("null")) {

				respuesta = false;
				setRespuestasTransferencia(respuesta, "101", "NumeroEmpleadoTPoperador es requerido",
						"NumeroEmpleadoTPoperador es requerido");

			}

			if (request.getTicketSD().equals("") || request.getTicketSD() == null
					|| request.getTicketSD().equals("null")) {

				respuesta = false;
				setRespuestasTransferencia(respuesta, "101", "TicketSD es requerido", "TicketSD es requerido");

			}

			if (request.getGrupo().equals("") || request.getGrupo() == null || request.getGrupo().equals("null")) {

				respuesta = false;
				setRespuestasTransferencia(respuesta, "101", "Grupo es requerido", "Grupo es requerido");

			}

			if (request.getJustificacion().equals("") || request.getJustificacion() == null
					|| request.getJustificacion().equals("null")) {

				respuesta = false;
				setRespuestasTransferencia(respuesta, "101", "Justificacion es requerido", "Justificacion es requerido");

			}

			if (request.getUsuarioSD().equals("") || request.getUsuarioSD() == null
					|| request.getUsuarioSD().equals("null")) {

				respuesta = false;
				setRespuestasTransferencia(respuesta, "101", "UsuarioSD es requerido", "UsuarioSD es requerido");

			}

			if (respuesta != false) {
				responseTransferencia = operationManager.transferenciaGrupo(request);
			}
		}
		return new ResponseEntity<TransferenciaGrupoResponse>(responseTransferencia, HttpStatus.OK);
	}

	@RequestMapping(value = "/agregarComentario", method = RequestMethod.POST)
	@ApiOperation(value = "Agrega comentario a ticket", notes = "Agrega comentario a ticket")
	public ResponseEntity<AgregarComentarioResponse> agregarComentario(
			@Valid @RequestBody AgregarComentarioOperationRequest request, BindingResult result,
			HttpServletResponse httpResponse) {
		ActivityLogger.logMethod("TagregarComentario");
		boolean respuesta = true;
		String parametros = "";
		List<String> listParam = new ArrayList<String>();
		if (result.hasErrors()) {
			httpResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			List<ObjectError> errors = result.getAllErrors();
			for (ObjectError oe : errors) {
				respuesta = false;
				listParam.add(oe.getCodes()[1].substring(oe.getCodes()[1].indexOf(".") + 1));
			}
			parametros = String.join(", ", listParam);
			setRespuestasComentario(respuesta, "101",
					"Se requiere(n) lo(s) siguientes parametro(s) de entrada: " + parametros,
					"Se requiere(n) lo(s) siguientes parametro(s) de entrada: " + parametros);
		} else {

			if (request.getNombreOperador().equals("") || request.getNombreOperador() == null
					|| request.getNombreOperador().equals("null")) {

				respuesta = false;
				setRespuestasComentario(respuesta, "101", "Nombre operador es requerido",
						"Nombre operador es requerido");

			}

			if (request.getNumeroEmpleadoTPoperador().equals("") || request.getNumeroEmpleadoTPoperador() == null
					|| request.getNumeroEmpleadoTPoperador().equals("null")) {

				respuesta = false;
				setRespuestasComentario(respuesta, "101", "NumeroEmpleadoTPoperador es requerido",
						"NumeroEmpleadoTPoperador es requerido");

			}

			if (request.getTicketSD().equals("") || request.getTicketSD() == null
					|| request.getTicketSD().equals("null")) {

				respuesta = false;
				setRespuestasComentario(respuesta, "101", "TicketSD es requerido", "TicketSD es requerido");

			}

			if (request.getComentario().equals("") || request.getComentario() == null
					|| request.getComentario().equals("null")) {

				respuesta = false;
				setRespuestasComentario(respuesta, "101", "Comentario es requerido", "Comentario es requerido");

			}
			
			if (request.getUsuarioSD().equals("") || request.getUsuarioSD() == null
					|| request.getUsuarioSD().equals("null")) {

				respuesta = false;
				setRespuestasComentario(respuesta, "101", "UsuarioSD es requerido", "UsuarioSD es requerido");

			}

			if (respuesta != false) {
				responseComentario = operationManager.agregarComentario(request);
			}
		}
		return new ResponseEntity<AgregarComentarioResponse>(responseComentario, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/actualizarEstatus", method = RequestMethod.POST)
	@ApiOperation(value = "Actualizar estatus", notes = "Actualizar estatus")
	public ResponseEntity<ActualizarEstatusOperationResponse> actualizarEstatus(@Valid @RequestBody ActualizarEstatusOperationRequest request,
			BindingResult result, HttpServletResponse httpResponse) {
		ActivityLogger.logMethod("actualizarEstatus");
		boolean respuesta = true;
		String parametros = "";
		List<String> listParam = new ArrayList<String>();
		if (result.hasErrors()) {
			httpResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			List<ObjectError> errors = result.getAllErrors();
			for (ObjectError oe : errors) {
				respuesta = false;
				listParam.add(oe.getCodes()[1].substring(oe.getCodes()[1].indexOf(".") + 1));
			}
			parametros = String.join(", ", listParam);
			setRespuestasActualizarEstatus(respuesta, "101",
					"Se requiere(n) lo(s) siguientes parametro(s) de entrada: " + parametros,
					"Se requiere(n) lo(s) siguientes parametro(s) de entrada: " + parametros);
		} else {

			if (request.getNombreOperador().equals("") || request.getNombreOperador() == null
					|| request.getNombreOperador().equals("null")) {

				respuesta = false;
				setRespuestasActualizarEstatus(respuesta, "101", "Nombre operador es requerido", "Nombre operador es requerido");

			}

			if (request.getNumeroEmpleadoTPoperador().equals("") || request.getNumeroEmpleadoTPoperador() == null
					|| request.getNumeroEmpleadoTPoperador().equals("null")) {

				respuesta = false;
				setRespuestasActualizarEstatus(respuesta, "101", "NumeroEmpleadoTPoperador es requerido",
						"NumeroEmpleadoTPoperador es requerido");

			}

			if (request.getTicketSD().equals("") || request.getTicketSD() == null
					|| request.getTicketSD().equals("null")) {

				respuesta = false;
				setRespuestasActualizarEstatus(respuesta, "101", "TicketSD es requerido", "TicketSD es requerido");

			}

			if (request.getNuevoEstatus().equals("") || request.getNuevoEstatus() == null) {

				respuesta = false;
				setRespuestasActualizarEstatus(respuesta, "101", "Nuevo estatus es requerido", "Nuevo estatus es requerido");

			} else if (!request.getNuevoEstatus().equals("WIP") && !request.getNuevoEstatus().equals("CL")
					&& !request.getNuevoEstatus().equals("CNCL") && !request.getNuevoEstatus().equals("RE")) {

				respuesta = false;
				setRespuestasActualizarEstatus(respuesta, "101", "El nuevo estatus no es correcto",
						"El nuevo estatus no es correcto");

			} else if ((request.getNuevoEstatus().equals("CL") || request.getNuevoEstatus().equals("CNCL") || request.getNuevoEstatus().equals("RE"))
					&& (request.getJustificacion().equals("") || request.getJustificacion() == null)) {

				respuesta = false;
				setRespuestasActualizarEstatus(respuesta, "101", "La justificación es requerida",
						"La justificación es requerida");

			}
			
			if (request.getUsuarioSD().equals("") || request.getUsuarioSD() == null
					|| request.getUsuarioSD().equals("null")) {

				respuesta = false;
				setRespuestasActualizarEstatus(respuesta, "101", "UsuarioSD es requerido", "UsuarioSD es requerido");

			}

			if (respuesta != false) {
				responseActualizarEstatus = operationManager.actualizaEstatus(request);
			}
		}
		return new ResponseEntity<ActualizarEstatusOperationResponse>(responseActualizarEstatus, HttpStatus.OK);
	}

	public void setRespuestasComentario(Boolean respuesta, String codigoRespuesta, String descripcionRespuesta,
			String mensajeServicio) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		responseComentario = new AgregarComentarioResponse();

		responseComentario.setFechaSolicitud(formatter.format(new Date()));
		responseComentario.setRespuestaBoolean(respuesta);
		responseComentario.setFechaRespuesta(formatter.format(new Date()));
		responseComentario.setCodigoRespuesta(codigoRespuesta);
		responseComentario.setDescripcionRespuesta(descripcionRespuesta);
		responseComentario.setMensajeServicio(mensajeServicio);

	}

	public void setRespuestasTransferencia(Boolean respuesta, String codigoRespuesta, String descripcionRespuesta,
			String mensajeServicio) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		responseTransferencia = new TransferenciaGrupoResponse();

		responseTransferencia.setFechaSolicitud(formatter.format(new Date()));
		responseTransferencia.setRespuestaBoolean(respuesta);
		responseTransferencia.setFechaRespuesta(formatter.format(new Date()));
		responseTransferencia.setCodigoRespuesta(codigoRespuesta);
		responseTransferencia.setDescripcionRespuesta(descripcionRespuesta);
		responseTransferencia.setMensajeServicio(mensajeServicio);

	}
	
	public void setRespuestasActualizarEstatus(Boolean respuesta, String codigoRespuesta, String descripcionRespuesta,
			String mensajeServicio) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		responseActualizarEstatus = new ActualizarEstatusOperationResponse();

		responseActualizarEstatus.setFechaSolicitud(formatter.format(new Date()));
		responseActualizarEstatus.setRespuestaBoolean(respuesta);
		responseActualizarEstatus.setFechaRespuesta(formatter.format(new Date()));
		responseActualizarEstatus.setCodigoRespuesta(codigoRespuesta);
		responseActualizarEstatus.setDescripcionRespuesta(descripcionRespuesta);
		responseActualizarEstatus.setMensajeServicio(mensajeServicio);

	}


}
