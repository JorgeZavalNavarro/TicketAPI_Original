package com.enlacetpe.ticketapi.service.serviceDesk;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
import com.enlacetpe.ticketapi.model.SdmCallReqModel;
import com.enlacetpe.ticketapi.repository.SdmActLogRepository;
import com.enlacetpe.ticketapi.repository.SdmCallReqRepository;
import com.enlacetpe.ticketapi.request.CommentRequest;
import com.enlacetpe.ticketapi.request.TicketRefNumRequest;
import com.enlacetpe.ticketapi.response.CAComment;
import com.enlacetpe.ticketapi.response.CACommentList;
import com.enlacetpe.ticketapi.response.CAResponse;

@Service
public class CommentTicketManager {
	
	final static Logger logger = Logger.getLogger(CommentTicketManager.class);

	@Autowired
	private SdmActLogRepository sdmActLogRepository;
	
	@Autowired
	private SdmCallReqRepository sdmCallReqRepository;	
		
	@Autowired
	private CALogInValidator logInValidator;
		
	@Autowired
	private CAObjectValidator objValidator;	  
	
	@Autowired
	private CAQueryValidator queryValidator;
	
	
	public CACommentList consultComment(TicketRefNumRequest request) {
		DateTime initial = new DateTime();
		Boolean success = true;
		String error = null;
		String mssg = "Tickets: Exito al encontrar los Tickets";
		List<CAComment> commentarios = null;
		try {
			List<SdmCallReqModel> ticket = sdmCallReqRepository.findByRefNum(request.getRefNum());
			if(ticket != null && ticket.size()==1) {
				String persid = ticket.get(0).getPersid();
				List<Object> comentarios = sdmActLogRepository.getComentariosLog(persid);
				if(!comentarios.isEmpty()) {
					commentarios = mapperComment(comentarios);
				}else {
					success = false;
					mssg = "AddComment: No se encontraron comentarios para este ticket " + request.getRefNum();
				}
			}else {
				success = false;
				mssg = "AddComment: Ticket no encontrado" + request.getRefNum();
			}
		}catch(Exception ex) {
			error = "AddComment: Ocurrio un error al insertar el comentario" +ex;
			success = false;
		}
		Period period = new Period(initial, new DateTime());
		return new CACommentList(success, period,error, mssg,commentarios);
	} 
	
	
	private List<CAComment> mapperComment(List<Object> comentarios) {
		List<CAComment> lista = new ArrayList<CAComment>();
		for(Object comen: comentarios) {
			CAComment entity = new CAComment();
			Object[] obj = (Object[]) comen;
			   String callReqId = String.valueOf(obj[0]); 
			   String descripcion = String.valueOf(obj[1]); 
			   String fechaInsercion = String.valueOf(obj[2]);
			   String tipo = String.valueOf(obj[3]);
			   entity.setCallReqId(callReqId);
			   entity.setDescription(descripcion);
			   entity.setDateInsert(fechaInsercion);
			   entity.setTipo(tipo);
			   lista.add(entity);
		}
		
		if (lista != null && !lista.isEmpty()) {
			Collections.sort(lista, new Comparator<CAComment>() {
				@Override
				public int compare(CAComment arg0, CAComment arg1) {
					return arg1.getDateInsert().compareTo(arg0.getDateInsert());
				}
			});
		}
		return lista;
	}
	
	
	public CAResponse addComent(CommentRequest request) {
		DateTime initial = new DateTime();		
		Boolean success = true;
		String error = null;
		Integer token = null;
		String mssg = null;
		CATicketMapper mapper = new CATicketMapper();
		try {			
			token = logInValidator.getToken();	
			if(request.getRefNum() !=  null) {
				List<SdmCallReqModel> ticket = sdmCallReqRepository.findByRefNum(request.getRefNum());
				if(ticket != null) {
					
					String requestByCriteria = TicketQueryBuilder.buildQuery(request.getCreatorUUID(),"userCreate");
					String requestByXml = queryValidator.doSelect(token, "cnt", requestByCriteria, 1, TicketDictionary.persistentIdParam);
					String creator = mapper.getValueByAttrName(requestByXml, TicketDictionary.persistentId);
					
					String objectHandle =ticket.get(0).getPersid();
					String description = request.getComment(); 
					String logType = "LOG";
					int timeSpent = 0;
					boolean internal = false;
					String respuestaWS = objValidator.addComment(token, creator, objectHandle, description, logType, timeSpent, internal);
					String idComment = mapper.maperComment(respuestaWS);
					mssg = "Create comment: Se agrego comentario al ticket " + request.getRefNum() + "El id del comentario: " + idComment;
					logger.info("Create comment: Se agrego comentario al ticket " + request.getRefNum() + "El id del comentario: " + idComment);

				}else {
				success = false;
				error = "Create Comment:Ticket no encontrado.. ";
				}
			}
			logInValidator.closeToken(token);
		} catch(Exception e) {
			error = "Create comment error: " + e.toString();
			success = false;
		} finally {
			try {
				if(token != null)
					logInValidator.closeToken(token);
			} catch (RemoteException e) {
				logger.info("ocurrio un error en add commnet");
			}
		}
		Period period = new Period(initial, new DateTime());
		return new CAResponse(success, period, error,mssg);
	}
	
	
	
}
