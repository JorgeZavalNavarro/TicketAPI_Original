package com.enlacetpe.ticketapi.service.serviceDesk;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.Base64;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;

import org.apache.axis.client.Call;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.Period;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ca.www.UnicenterServicePlus.ServiceDesk.USD_WebServiceLocator;
import com.ca.www.UnicenterServicePlus.ServiceDesk.USD_WebServiceSoap;
import com.enlacetpe.ticketapi.caManager.serviceDesk.CALogInValidator;
import com.enlacetpe.ticketapi.caManager.serviceDesk.CAQueryValidator;
import com.enlacetpe.ticketapi.caMapper.serviceDesk.CATicketMapper;
import com.enlacetpe.ticketapi.caQueryBuilder.TicketQueryBuilder;
import com.enlacetpe.ticketapi.dictionary.TicketDictionary;
import com.enlacetpe.ticketapi.request.DecodeBase64Request;
import com.enlacetpe.ticketapi.request.EncodeBase64Request;
import com.enlacetpe.ticketapi.request.LoadFileRequest;
import com.enlacetpe.ticketapi.response.CAResponse;

@Service
public class FileManager {
	
	final static Logger logger = Logger.getLogger(FileManager.class);

	@Autowired
	private CALogInValidator logInValidator;
	
	@Autowired
	private CAQueryValidator queryValidator;
	
	@SuppressWarnings("unused")
	public CAResponse loadFile(LoadFileRequest request) {
		DateTime initial = new DateTime();
		Integer token = null;
		Boolean success = true;
		String mssg ="";
		try {
			CATicketMapper mapper = new CATicketMapper();
			token = logInValidator.getToken();
	
			String requestByTicket = TicketQueryBuilder.buildQuery(request.getRefNum(), "refNum"); //Busco por ref num y que el ticket este activo
			String requestByXmlTicket = queryValidator.doSelect(token, "cr", requestByTicket, 1,TicketDictionary.ticketParam);
			String ticket = mapper.getValueByAttrName(requestByXmlTicket, TicketDictionary.persistentId);
			
			DecodeBase64Request objectDecode = new DecodeBase64Request();
			objectDecode.setBase64(request.getBase64());
			objectDecode.setNombre(request.getNombre());
			objectDecode.setExtension(request.getExtension());
			boolean fileCreate = decoder(objectDecode);
			
			if(fileCreate) {
				if (!ticket.isEmpty()) {
					String ServiceDeskDocumentRepository = "doc_rep:1002";
					USD_WebServiceLocator ws = new USD_WebServiceLocator();
					java.net.URL url = new java.net.URL(ws.getUSD_WebServiceSoapAddress());
					USD_WebServiceSoap usd = ws.getUSD_WebServiceSoap(url);
					
					FileDataSource fds = new FileDataSource("/home/implementacion/base64/"+request.getNombre()+request.getExtension()); // -> "C:\\base64\\"+request.getNombre()+request.getExtension()
					//FileDataSource fds = new FileDataSource("C:\\base64\\"+request.getNombre()+request.getExtension());
					DataHandler dhandler = new DataHandler(fds);
					((org.apache.axis.client.Stub) usd)._setProperty(
					Call.ATTACHMENT_ENCAPSULATION_FORMAT,
					Call.ATTACHMENT_ENCAPSULATION_FORMAT_DIME);
					((org.apache.axis.client.Stub) usd).addAttachment(dhandler);

					String attmntHandle = usd.createAttachment(token, ServiceDeskDocumentRepository,
							ticket, "Archivo creado", "C:\\base64\\"+request.getNombre()+request.getExtension());
					System.out.println("Respuesta del servicio: " + attmntHandle);
					if (attmntHandle.length() > 0)
							mssg = "File: Se cargo el archivo correctamente";
				}
			}
			logInValidator.closeToken(token);				
		} catch (Exception e) {
			success = false;
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
		return new CAResponse(success, period);
	}
	
	public static String encoder(EncodeBase64Request request) {
		String base64Image = "";
		File file = new File(request.getUrl()+"\\"+request.getNombre()+request.getExtension());
		try(FileInputStream imageInFile = new FileInputStream(file)) {
			//Reading a image file from file system
			byte imageData[] = new byte[(int)file.length()];
			imageInFile.read(imageData);
			base64Image = Base64.getEncoder().encodeToString(imageData);
		}catch(FileNotFoundException e) {
			logger.info("Image not found" + e);
		}catch(IOException ioe) {
			logger.info("Excepcion mientras se leia el archivo:" + ioe);
		}
		return base64Image;
	}
	
	public static boolean  decoder(DecodeBase64Request request) {
		boolean exito = false;
		try(FileOutputStream imageOutFile = new FileOutputStream("/home/implementacion/base64/"+request.getNombre()+request.getExtension())){
//		try(FileOutputStream imageOutFile = new FileOutputStream("C:\\base64\\"+request.getNombre()+request.getExtension())){
			//Converting a base64 String into Image byte array
			byte[] imageByteArray = Base64.getDecoder().decode(request.getBase64());
			imageOutFile.write(imageByteArray);
			exito = true;
		}catch(FileNotFoundException e) {
			logger.info("Image not found" + e);
			exito = false;
		}catch(IOException ioe) {
			logger.info("Exception while reading the image " + ioe);
			exito = false;
		}catch(Exception ex) {
			logger.info("Exception while reading the image " + ex);
			exito = false;
		}
		
		return exito;
	}


	
	

}
