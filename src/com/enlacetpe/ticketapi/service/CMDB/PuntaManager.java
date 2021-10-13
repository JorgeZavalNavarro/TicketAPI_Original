package com.enlacetpe.ticketapi.service.CMDB;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.Period;
import org.primefaces.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enlacetpe.ticketapi.caManager.serviceDesk.CALogInValidator;
import com.enlacetpe.ticketapi.caManager.serviceDesk.CAObjectValidator;
import com.enlacetpe.ticketapi.caManager.serviceDesk.CAQueryValidator;
import com.enlacetpe.ticketapi.caMapper.serviceDesk.CATicketMapper;
import com.enlacetpe.ticketapi.caQueryBuilder.TicketQueryBuilder;
import com.enlacetpe.ticketapi.dictionary.TicketDictionary;
import com.enlacetpe.ticketapi.model.SdmCaOwnedResourceModel;
import com.enlacetpe.ticketapi.model.SdmCrStatModel;
import com.enlacetpe.ticketapi.modelTicketApiSD.CatRegionesModel;
import com.enlacetpe.ticketapi.repository.SdmCaOwnedResourceRepository;
import com.enlacetpe.ticketapi.request.ActualizarEstatusRequest;
import com.enlacetpe.ticketapi.request.ActualizarPuntaRequest;
import com.enlacetpe.ticketapi.request.ConsultarCiudadesRequest;
import com.enlacetpe.ticketapi.request.PuntaRequest;
import com.enlacetpe.ticketapi.request.ipRequest;
import com.enlacetpe.ticketapi.response.ActualizarPuntaResponse;
import com.enlacetpe.ticketapi.response.CAInformacionIp;
import com.enlacetpe.ticketapi.response.CAInformacionIpResponse;
import com.enlacetpe.ticketapi.response.CAInformacionPunta;
import com.enlacetpe.ticketapi.response.CAResponse;
import com.enlacetpe.ticketapi.response.CATicket;
import com.enlacetpe.ticketapi.response.CATicketByNameCI;
import com.enlacetpe.ticketapi.response.TCiudades;
import com.enlacetpe.ticketapi.response.TCiudadesList;
import com.enlacetpe.ticketapi.response.TablerosResponse;

@Service
public class PuntaManager {

	final static Logger logger = Logger.getLogger(PuntaManager.class);

	@Autowired
	private CAQueryValidator queryValidator;

	@Autowired
	private CALogInValidator logInValidator;
	
	@Autowired
	private CAObjectValidator objValidator;

	@Autowired
	private SdmCaOwnedResourceRepository sdmCaOwnedResourceRepository;

	public CAResponse tieneTicketActivos(PuntaRequest request) {
		boolean success = false;
		String error = "";
		Integer token = null;
		try {
			token = logInValidator.getToken();
			CATicketMapper mapper = new CATicketMapper();

			String id = request.getPunta().replace("0x", "");
			String existetActivos = TicketQueryBuilder.buildQuery(id, "ticketsActivos");
			String existetActivosXml = queryValidator.doSelect(token, "cr", existetActivos, 1,
					TicketDictionary.refNumParam);
			String ticket = mapper.getValueByAttrName(existetActivosXml, TicketDictionary.refNum);
			if (ticket != null || !ticket.isEmpty()) {
				success = true;
			}
			boolean cerrado = logInValidator.closeToken(token);
			System.out.println("Se cierra sesion: " + cerrado);
		} catch (Exception ex) {

			logger.info("Error: " + ex);
		} finally {
			try {
				if (token != null)
					logInValidator.closeToken(token);
			} catch (RemoteException e) {
				logger.info("Error Ticket" + e);
			}
		}
		return new CAResponse(success, error);

	}

	public CAInformacionPunta getInformation(ipRequest request) {
		DateTime initial = new DateTime();
		boolean success = false;
		String error = "";
		String uuid = "";
		String name = "";
		String host = "";
		String ip = "";
		Integer inactive = null;

		try {
			SdmCaOwnedResourceModel entity = sdmCaOwnedResourceRepository.findByIpAddress(request.getIp());
			if (entity != null) {
				uuid = entity.getOwnResourceUuid();
				name = entity.getResourceName();
				host = entity.getHostName();
				ip = entity.getIpAddress();
				inactive = entity.getInactive();
				success = true;
			} else {
				error = "No se encontro informacion para la ip " + request.getIp();
			}
		} catch (Exception ex) {
			error = "Se encontro una excepcion al consultar la informacion del servidor:  " + ex;
			logger.info("Se encontro una excepcion al consultar la informacion del servidor:  " + ex);
		}
		Period period = new Period(initial, new DateTime());
		return new CAInformacionPunta(success, period, error, uuid, host, name, ip, inactive);

	}

	public CAInformacionIp getInformationIP(ipRequest request) {
		DateTime initial = new DateTime();
		boolean success = false;
		String error = "";
		String punta = "";
		String nombreOrganizacion = "";

		try {
			Object info = sdmCaOwnedResourceRepository.getInformationIP(request.getIp());

			/*
			 * if (!((List)tickets).isEmpty()) for (Object objecto :
			 * (List)tickets) { String refNum = null; CATicketByNameCI
			 * objRespuesta = new CATicketByNameCI(); Object[] obj =
			 * (Object[])objecto; String dispositivo = String.valueOf(obj[0]);
			 * String alarma = String.valueOf(obj[1]); if (obj[2] != null) {
			 * refNum = String.valueOf(obj[2]); } else { refNum = new
			 * String(""); }
			 * 
			 * List<CATicket> listTickets = new ArrayList(); CATicket ticket =
			 * new CATicket(); ticket.setRefNum(refNum);
			 * listTickets.add(ticket);
			 * objRespuesta.setNombreDispositivo(dispositivo);
			 * objRespuesta.setAlarma(alarma);
			 * objRespuesta.setTickets(listTickets);
			 * respuestaList.add(objRespuesta); }
			 */

			/*
			 * if (resp != null) {
			 * 
			 * punta = resp.getPunta(); nombreOrganizacion =
			 * resp.getNombreOrganizacion(); success = true; } else { error =
			 * "No se encontro informacion para la ip " + request.getIp(); }
			 */
		} catch (Exception ex) {
			error = "Se encontro una excepcion al consultar la informacion del servidor:  " + ex;
			logger.info("Se encontro una excepcion al consultar la informacion del servidor:  " + ex);
		}
		Period period = new Period(initial, new DateTime());
		return new CAInformacionIp(success, period, error, punta, nombreOrganizacion);

	}

	
}
