package com.enlacetpe.ticketapi.service.serviceDesk;

import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.Period;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enlacetpe.ticketapi.caManager.serviceDesk.CALogInValidator;
import com.enlacetpe.ticketapi.caManager.serviceDesk.CAObjectValidator;
import com.enlacetpe.ticketapi.caManager.serviceDesk.CAQueryValidator;
import com.enlacetpe.ticketapi.caMapper.serviceDesk.CATicketMapper;
import com.enlacetpe.ticketapi.caQueryBuilder.TicketQueryBuilder;
import com.enlacetpe.ticketapi.dictionary.TicketDictionary;
import com.enlacetpe.ticketapi.model.SdmCrStatModel;
import com.enlacetpe.ticketapi.repository.SdmCrStatRepository;
import com.enlacetpe.ticketapi.request.ChangeEstatusRequest;
import com.enlacetpe.ticketapi.response.CAResponse;

@Service
public class EstatusManagerSD {

	final static Logger logger = Logger.getLogger(EstatusManagerSD.class);

	@Autowired
	private CALogInValidator logInValidator;

	@Autowired
	private CAQueryValidator queryValidator;

	@Autowired
	private CAObjectValidator objValidator;

	@Autowired
	private SdmCrStatRepository sdmCrStatRepository;

	@SuppressWarnings("unused")
	public CAResponse updateStatus(ChangeEstatusRequest request) {
		DateTime initial = new DateTime();
		Boolean success = Boolean.valueOf(true);
		Integer token = null;
		String error = null;
		String mssg = null;
		String code = "";
		boolean cerrado = false;
		Period period = null;
		try {
			logger.info("Se recibieron las estatus del usuario: " + request.getEstatus() + "El solicitante:"
					+ request.getSolicitadoPor());
			token = Integer.valueOf(this.logInValidator.getToken());
			String userHandle = this.logInValidator.getUserHandle(token.intValue());
			CATicketMapper mapper = new CATicketMapper();
			String[] estatusArray = request.getEstatus().split(",");
			List<String> listaEstatus = Arrays.asList(estatusArray);
			String requestByCriteriaRequestBy = TicketQueryBuilder.buildQuery(request.getSolicitadoPor(), "userCreate");
			String requestByXmlRequestBy = this.queryValidator.doSelect(token.intValue(), "cnt",
					requestByCriteriaRequestBy, 1, TicketDictionary.persistentIdParam);
			String requestBy = mapper.getValueByAttrName(requestByXmlRequestBy, "id");
			String requestByTicket = TicketQueryBuilder.buildQuery(request.getRefNum(), "refNum");
			String requestByXmlTicket = this.queryValidator.doSelect(token.intValue(), "cr", requestByTicket, 1,
					TicketDictionary.ticketParam);
			String ticket = mapper.getValueByAttrName(requestByXmlTicket, "persistent_id");
			String ticketStatus = mapper.getValueByAttrName(requestByXmlTicket, "status");
			logger.info("El ticket esta en status:" + ticketStatus);
			int i;
			if (ticketStatus.equalsIgnoreCase("CL")) {
				success = Boolean.valueOf(false);
				code = "001";
				error = "No se puede actualizar un ticket inactivo";
				logger.error("No se puede actualizar un ticket inactivo" + request.getRefNum());
			} else {
				int posicion = listaEstatus.indexOf(ticketStatus);
				if (posicion != -1) {
					for (i = posicion + 1; i < listaEstatus.size(); i++) {
						logger.info("El ticket " + request.getRefNum() + " pasara a estatus: "
								+ (String) listaEstatus.get(i));
						SdmCrStatModel esatdoId = this.sdmCrStatRepository.findByCode((String) listaEstatus.get(i));
						if (esatdoId != null) {
							if (((String) listaEstatus.get(i)).equalsIgnoreCase("RE")) {
								Date currentDate = new Date();
								long fechaUnix = currentDate.getTime() / 1000L;
								String[] attributes = new String[0];
								String[] attrVals = { "zDiagnostico_id", request.getDiagnostico(), "zsolucion_id",
										request.getSolucion(), "zfecha_sol", String.valueOf(fechaUnix),
										"zact_realizadas", request.getActividadesRealizadas(), "zTipo_Soporte",
										request.getAreaResultora(), "zNivel_Soporte", request.getNivelSoporte(),
										"zRegCiu_id", request.getRegCiuId() };
								String respuestaUpadte = this.objValidator.updateObject(token.intValue(), ticket,
										attrVals, attributes);
								logger.info("Objeto actualizado");
							}
							String coment = request.getComentario() + ": " + request.getJustificacion();
							logger.info("Se va actualizar el estado");
							boolean updateStatus = this.objValidator.updateStatus(ticket, esatdoId.getPersid(), coment,
									token.intValue(), "cnt:" + requestBy);
							logger.info("Estatus actualizado:  " + updateStatus);
						}
					}
				} else {
					if (listaEstatus.size() >= 3 && ticketStatus.equals("OP")) {
						SdmCrStatModel esatdoId = this.sdmCrStatRepository.findByCode("CL");
						if (esatdoId != null) {
							String coment = request.getComentario() + ": " + request.getJustificacion();
							logger.info("Se va actualizar el estado CL");
							boolean updateStatus = this.objValidator.updateStatus(ticket, esatdoId.getPersid(), coment,
									token.intValue(), "cnt:" + requestBy);
							logger.info("Estatus actualizado:  " + updateStatus);
						}
					} else {
						for (String estatus : listaEstatus) {
							logger.info("El ticket " + request.getRefNum() + " pasara a estatus: " + estatus);
							SdmCrStatModel esatdoId = this.sdmCrStatRepository.findByCode(estatus);
							if (esatdoId != null) {
								if (estatus.equalsIgnoreCase("RE")) {
									Date currentDate = new Date();
									long fechaUnix = currentDate.getTime() / 1000L;
									String[] attributes = new String[0];
									String[] attrVals = { "zDiagnostico_id", request.getDiagnostico(), "zsolucion_id",
											request.getSolucion(), "zfecha_sol", String.valueOf(fechaUnix),
											"zact_realizadas", request.getActividadesRealizadas(), "zTipo_Soporte",
											request.getAreaResultora(), "zNivel_Soporte", request.getNivelSoporte(),
											"zRegCiu_id", request.getRegCiuId() };
									String respuestaUpadte = this.objValidator.updateObject(token.intValue(), ticket,
											attrVals, attributes);
									logger.info("Objeto actualizado");
								}
								String coment = request.getComentario() + ": " + request.getJustificacion();
								logger.info("Se va actualizar el estado");
								boolean updateStatus = this.objValidator.updateStatus(ticket, esatdoId.getPersid(),
										coment, token.intValue(), "cnt:" + requestBy);
								logger.info("Estatus actualizado:  " + updateStatus);
							}
						}
					}
					// }
				}
			}
			cerrado = this.logInValidator.closeToken(token.intValue());
			logger.info("La sesion finalizo de forma: " + cerrado);
			token = null;
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
			period = new Period(initial, new DateTime());
		} catch (Exception e) {
			success = Boolean.valueOf(false);
			error = "Error en UpdateStatus para el ticket" + request.getRefNum() + " :" + e.toString();
			logger.error("Ocurrio un error en UpdateStatus, para el ticket:" + request.getRefNum() + ":" + error);
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
		return new CAResponse(success.booleanValue(), period, error, mssg, code);
	}

	@SuppressWarnings("unused")
	public CAResponse reprocesoUpdateStatus(ChangeEstatusRequest request, String ticket, String requestBy,
			List<String> listaEstatus, Integer token) {

		logger.info("reprocesoUpdateStatus");

		DateTime initial = new DateTime();
		Boolean success = true;
		String error = null;
		String mssg = null;
		String code = "";
		boolean cerrado = false;

		CATicketMapper mapper = new CATicketMapper();
		String[] estatusArray = request.getEstatus().split(",");
		String respuestaUpadte = null;
		boolean updateStatus = false;

		try {

			for (String estatus : listaEstatus) {
				logger.info("El ticket " + request.getRefNum() + " pasara a estatus: " + estatus + " en REPROCESO");
				SdmCrStatModel esatdoId = sdmCrStatRepository.findByCode(estatus);

				if (esatdoId != null) {
					if (estatus.equalsIgnoreCase("RE")) {
						Date currentDate = new Date();
						long fechaUnix = currentDate.getTime() / 1000;

						String[] attributes = new String[] {};
						String[] attrVals = new String[] { "zDiagnostico_id", request.getDiagnostico(), "zsolucion_id",
								request.getSolucion(), "zfecha_sol", String.valueOf(fechaUnix), "zact_realizadas",
								request.getActividadesRealizadas(), "zTipo_Soporte", request.getAreaResultora(),
								"zNivel_Soporte", request.getNivelSoporte(), "zRegCiu_id", request.getRegCiuId(),

						};

						logger.info("Se va actualizar el objeto en REPROCESO");
						respuestaUpadte = objValidator.updateObject(token, ticket, attrVals, attributes);
						logger.info("Objeto actualizado en REPROCESO" + respuestaUpadte);
					}
					String coment = request.getComentario() + ": " + request.getJustificacion();
					logger.info("Se va actualizar el estado en REPROCESO");
					updateStatus = objValidator.updateStatus(ticket, esatdoId.getPersid(), coment, token,
							"cnt:" + requestBy);
					logger.info("Estatus actualizado en REPROCESO:  " + updateStatus);
				}

			}
		} catch (Exception e) {

			success = false;
			error = "Error en REPROCESO-UpdateStatus para el ticket" + request.getRefNum() + " :" + e.toString();
			logger.error(
					"Ocurrio un error en REPROCESO-UpdateStatus, para el ticket:" + request.getRefNum() + ":" + error);

		} finally {
			try {
				logger.info("Entro a finally...");
				if (token != null) {
					cerrado = logInValidator.closeToken(token);
					logger.info("La sesion finalizo de forma (Finally): " + cerrado);
				}
			} catch (RemoteException e) {
				logger.error(e.toString());
				error = "Error al actualizar el estatus: " + e.toString();
			}
		}

		Period period = new Period(initial, new DateTime());
		return new CAResponse(success, period, error, mssg, code);

	}

	/*
	 * @SuppressWarnings("unused") public CAResponse
	 * updateStatus(ChangeEstatusRequest request) { DateTime initial = new
	 * DateTime(); Boolean success = true; Integer token = null; String error =
	 * null; String mssg = null; String code = ""; boolean cerrado = false;
	 * 
	 * String requestBy = null; String ticket = null; List<String> listaEstatus
	 * = null;
	 * 
	 * try { logger.info("Se recibieron las estatus del usuario: " +
	 * request.getEstatus() + "El solicitante:" + request.getSolicitadoPor());
	 * token = logInValidator.getToken(); String userHandle =
	 * logInValidator.getUserHandle(token);
	 * 
	 * CATicketMapper mapper = new CATicketMapper(); String[] estatusArray =
	 * request.getEstatus().split(","); listaEstatus =
	 * Arrays.asList(estatusArray); String respuestaUpadte = null; boolean
	 * updateStatus = false;
	 * 
	 * 
	 * String requestByCriteriaRequestBy =
	 * TicketQueryBuilder.buildQuery(request.getSolicitadoPor(), "userCreate");
	 * //Busco por id del creador String requestByXmlRequestBy =
	 * queryValidator.doSelect(token, "cnt", requestByCriteriaRequestBy,
	 * 1,TicketDictionary.persistentIdParam); requestBy =
	 * mapper.getValueByAttrName(requestByXmlRequestBy, TicketDictionary.id);
	 * 
	 * String requestByTicket =
	 * TicketQueryBuilder.buildQuery(request.getRefNum(), "refNum"); //Busco por
	 * ref num del ticket String requestByXmlTicket =
	 * queryValidator.doSelect(token, "cr", requestByTicket,
	 * 1,TicketDictionary.ticketParam); ticket =
	 * mapper.getValueByAttrName(requestByXmlTicket,
	 * TicketDictionary.persistentId); String ticketStatus =
	 * mapper.getValueByAttrName(requestByXmlTicket,
	 * TicketDictionary.statusTicket); logger.info("El ticket esta en status:" +
	 * ticketStatus);
	 * 
	 * if(ticketStatus.equalsIgnoreCase("CL")) { success = false; code = "001";
	 * error = "No se puede actualizar un ticket inactivo";
	 * logger.error("No se puede actualizar un ticket inactivo" +
	 * request.getRefNum()); }else { int posicion =
	 * listaEstatus.indexOf(ticketStatus); if(posicion != -1) { for(int i =
	 * posicion+1; i<listaEstatus.size() ; i++) { logger.info("El ticket " +
	 * request.getRefNum() + " pasara a estatus: " + listaEstatus.get(i));
	 * SdmCrStatModel esatdoId =
	 * sdmCrStatRepository.findByCode(listaEstatus.get(i)); if(esatdoId!= null)
	 * { if(listaEstatus.get(i).equalsIgnoreCase("RE")) { Date currentDate = new
	 * Date(); long fechaUnix = currentDate.getTime() / 1000;
	 * 
	 * 
	 * String[] attributes = new String[] {}; String[] attrVals = new String[] {
	 * "zDiagnostico_id",request.getDiagnostico(), "zsolucion_id",
	 * request.getSolucion(), "zfecha_sol", String.valueOf(fechaUnix),
	 * "zact_realizadas",request.getActividadesRealizadas(),
	 * "zTipo_Soporte",request.getAreaResultora(),
	 * "zNivel_Soporte",request.getNivelSoporte(),
	 * "zRegCiu_id",request.getRegCiuId(),
	 * 
	 * }; logger.info("Se va actualizar el objeto"); respuestaUpadte =
	 * objValidator.updateObject(token,ticket, attrVals, attributes);
	 * logger.info("Objeto actualizado"); }
	 * 
	 * String coment = request.getComentario() +": "+
	 * request.getJustificacion(); logger.info("Se va actualizar el estado");
	 * updateStatus = objValidator.updateStatus(ticket,
	 * esatdoId.getPersid(),coment , token, "cnt:"+requestBy);
	 * logger.info("Estatus actualizado:  " + updateStatus); } } }else {
	 * for(String estatus: listaEstatus) { logger.info("El ticket " +
	 * request.getRefNum() + " pasara a estatus: " + estatus); SdmCrStatModel
	 * esatdoId = sdmCrStatRepository.findByCode(estatus);
	 * 
	 * if(esatdoId!= null) { if(estatus.equalsIgnoreCase("RE")) { Date
	 * currentDate = new Date(); long fechaUnix = currentDate.getTime() / 1000;
	 * 
	 * String[] attributes = new String[] {}; String[] attrVals = new String[] {
	 * "zDiagnostico_id",request.getDiagnostico(), //diagnostico final
	 * "zsolucion_id", request.getSolucion(), // solucion "zfecha_sol",
	 * String.valueOf(fechaUnix), //Fecha/Hora de Solución
	 * "zact_realizadas",request.getActividadesRealizadas(), //Fecha/hora –
	 * Actividades Realizadas "zTipo_Soporte",request.getAreaResultora(), //Área
	 * Resolutora "zNivel_Soporte",request.getNivelSoporte(),
	 * "zRegCiu_id",request.getRegCiuId(), //REgion
	 * 
	 * };
	 * 
	 * logger.info("Se va actualizar el objeto"); respuestaUpadte =
	 * objValidator.updateObject(token,ticket, attrVals, attributes);
	 * logger.info("Objeto actualizado"+respuestaUpadte); } String coment =
	 * request.getComentario() +": "+ request.getJustificacion();
	 * logger.info("Se va actualizar el estado"); updateStatus =
	 * objValidator.updateStatus(ticket, esatdoId.getPersid(), coment, token,
	 * "cnt:"+requestBy); logger.info("Estatus actualizado:  " + updateStatus);
	 * }
	 * 
	 * } } }
	 * 
	 * logger.info("****respuestaUpadte****"+respuestaUpadte); cerrado =
	 * logInValidator.closeToken(token);
	 * logger.info("La sesion finalizo de forma: " + cerrado); token = null; }
	 * catch(Exception e) {
	 * 
	 * 
	 * logger.info("**ERROR*** " + e.toString());
	 * 
	 * if(e.toString().equals("AHD05208:Registro bloqueado.")) {
	 * reprocesoUpdateStatus(request,ticket,requestBy,listaEstatus,token); }
	 * 
	 * success = false;
	 * 
	 * error = "Error en UpdateStatus para el ticket" + request.getRefNum()
	 * +" :"+ e.toString();
	 * logger.error("Ocurrio un error en UpdateStatus, para el ticket:"
	 * +request.getRefNum() + ":"+ error); }finally { try {
	 * logger.info("Entro a finally..." ); if(token != null) { cerrado=
	 * logInValidator.closeToken(token);
	 * logger.info("La sesion finalizo de forma (Finally): " + cerrado); } }
	 * catch (RemoteException e) { logger.error(e.toString()); error =
	 * "Error al actualizar el estatus: "+ e.toString(); } } Period period = new
	 * Period(initial, new DateTime()); return new CAResponse(success, period,
	 * error,mssg,code); }
	 */

	@SuppressWarnings("unused")
	public CAResponse consultaRegion(ChangeEstatusRequest request) {
		DateTime initial = new DateTime();
		Boolean success = Boolean.valueOf(true);
		Integer token = null;
		String error = null;
		String mssg = null;
		String code = "";
		boolean cerrado = false;
		Period period = null;
		try {
			logger.info("Se recibieron las estatus del usuario: " + request.getEstatus() + "El solicitante:"
					+ request.getSolicitadoPor());
			token = Integer.valueOf(this.logInValidator.getToken());
			String userHandle = this.logInValidator.getUserHandle(token.intValue());

			CATicketMapper mapper = new CATicketMapper();

			String requestByTicket = TicketQueryBuilder.buildQuery("", "refNum");
			String requestByXmlTicket = this.queryValidator.doSelect(token.intValue(), "cr", requestByTicket, 1,
					TicketDictionary.ticketParamText);
			String ticket = mapper.getValueByAttrName(requestByXmlTicket, "persistent_id");
			String ticketStatus = mapper.getValueByAttrName(requestByXmlTicket, "status");

			String region = mapper.getValueByAttrName(requestByXmlTicket, "zRegCiu_id");

			String CI = mapper.getValueByAttrName(requestByXmlTicket, "affected_resource");

			logger.info("El ticket esta en status:" + ticketStatus);

			logger.info("Region de ticket: " + region);

			logger.info("CI de ticket: " + CI);

			cerrado = this.logInValidator.closeToken(token.intValue());
			logger.info("La sesion finalizo de forma: " + cerrado);
			token = null;
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
			period = new Period(initial, new DateTime());
		} catch (Exception e) {
			success = Boolean.valueOf(false);
			error = "Error en UpdateStatus para el ticket" + request.getRefNum() + " :" + e.toString();
			logger.error("Ocurrio un error en UpdateStatus, para el ticket:" + request.getRefNum() + ":" + error);
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

		return new CAResponse(success.booleanValue(), period, error, mssg, code);
	}
}
