package com.enlacetpe.ticketapi.service.apis;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Properties;

import org.apache.commons.codec.binary.Base64;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.primefaces.json.JSONArray;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.stringtemplate.v4.ST;

import com.enlacetpe.ticketapi.request.AdjuntarArchivoRequest;
import com.enlacetpe.ticketapi.request.TransferenciaGrupoRequest;
import com.enlacetpe.ticketapi.response.TAdjuntarArchivoResponse;
import com.enlacetpe.ticketapi.response.TTransferenciaGrupoResponse;

@Service
public class ServiceArchivoSD {

	public TAdjuntarArchivoResponse adjuntarArchivoSD(AdjuntarArchivoRequest requestAdjuntar) throws Exception {

		JSONArray array = null;
		String resp = "";
		JSONParser parser = new JSONParser();
		Properties p = new Properties();
		InputStream input = null;
		TAdjuntarArchivoResponse response = new TAdjuntarArchivoResponse();

		input = getClass().getClassLoader().getResourceAsStream("dataBasesJPA.properties");
		p.load(input);

		String rootUri = p.getProperty("getUrlServicio");

		ST template = new ST(rootUri + "/APIRecibirDocumentos/rest/salesforce/recibir/adjunto");
		String path = template.render();

		JSONObject object = new JSONObject();

		// tipoArchivo
		String comentario = "Nombre del operador quien adjunto el documento: " + requestAdjuntar.getNombreOperador()
				+ " Su numero de empleado: " + requestAdjuntar.getNumeroEmpleadoTPoperador();

		object.put("nombreArchivo", requestAdjuntar.getNombreArchivo());
		object.put("comentario", comentario);
		object.put("ticketSalesForce", requestAdjuntar.getFolioSF());
		object.put("ticketServiceDesk", requestAdjuntar.getTicketSD());
		object.put("usuario", "Integracion SF Dashboard Web");
		object.put("password", "Integracion SF Dashboard Web");
		object.put("archivoBase64", requestAdjuntar.getArchivo());

		HttpEntity<String> request = new HttpEntity<String>(object.toString(), getJsonHeaders());
		RestTemplate rest = getTemplate();
		ResponseEntity<String> responseAPI = rest.exchange(path, HttpMethod.POST, request, String.class);
		JSONObject obj = (JSONObject) parser.parse(responseAPI.getBody());

		if (obj.get("respuestaBoolean").equals("true")) {
			
			boolean respuesta = Boolean.parseBoolean((String) obj.get("respuestaBoolean"));

			response.setFolioDocumento((String) obj.get("folioDocumento"));
			response.setCodigoRespuesta((String) obj.get("codigoRespuesta"));
			response.setDescripcionRespuesta((String) obj.get("descripcionRespuesta"));
			response.setMensajeServicio((String) obj.get("mensajeServicio"));
			response.setFechaSolicitud((String) obj.get("fechaSolicitud"));
			response.setRespuestaBoolean(respuesta);
			System.out.println("ID Id_attm: " + response.getFolioDocumento());

		} else {
			response.setCodigoRespuesta((String) obj.get("codigoRespuesta"));
			response.setDescripcionRespuesta((String) obj.get("descripcionRespuesta"));
			response.setMensajeServicio((String) obj.get("mensajeServicio"));
			response.setFechaSolicitud((String) obj.get("fechaSolicitud"));
		}

		return response;
	}

	public TTransferenciaGrupoResponse transferenciaGrupoSD(TransferenciaGrupoRequest requestTransferencia)
			throws Exception {

		JSONArray array = null;
		String resp = "";
		JSONParser parser = new JSONParser();
		Properties p = new Properties();
		InputStream input = null;
		TTransferenciaGrupoResponse response = new TTransferenciaGrupoResponse();

		input = getClass().getClassLoader().getResourceAsStream("dataBasesJPA.properties");
		p.load(input);

		String rootUri = p.getProperty("getUrlServicio");

		ST template = new ST(rootUri + "/APITransferenciaSFtoSD/rest/ticket/transferir/grupo");
		String path = template.render();

		JSONObject object = new JSONObject();

		// tipoArchivo
		String descripcion = requestTransferencia.getJustificacion() + "\n"
				+ " Nombre del operador quien transfirió el ticket: " + requestTransferencia.getNombreOperador()
				+ " Su número de empleado: " + requestTransferencia.getNumeroEmpleadoTPoperador();

		object.put("usuario", "Integracion SF Dashboard Web");
		object.put("password", "Integracion SF Dashboard Web");
		object.put("responsable", "Integracion SF Dashboard Web");
		object.put("numRefTicket", requestTransferencia.getTicketSD());
		object.put("numTicketSF", requestTransferencia.getFolioSF());
		object.put("descripcion", descripcion);
		object.put("nuevoGrupo", requestTransferencia.getGrupo());

		HttpEntity<String> request = new HttpEntity<String>(object.toString(), getJsonHeaders());
		RestTemplate rest = getTemplate();
		ResponseEntity<String> responseAPI = rest.exchange(path, HttpMethod.POST, request, String.class);
		JSONObject obj = (JSONObject) parser.parse(responseAPI.getBody());

		if (obj.get("respuestaBoolean").equals("true")) {
			
			boolean respuesta = Boolean.parseBoolean((String) obj.get("respuestaBoolean"));

			response.setCodigoRespuesta((String) obj.get("codigoRespuesta"));
			response.setDescripcionRespuesta((String) obj.get("descripcionRespuesta"));
			response.setMensajeServicio((String) obj.get("mensajeServicio"));
			response.setFechaSolicitud((String) obj.get("fechaSolicitud"));
			response.setRespuestaBoolean(respuesta);

		} else {
			response.setCodigoRespuesta((String) obj.get("codigoRespuesta"));
			response.setDescripcionRespuesta((String) obj.get("descripcionRespuesta"));
			response.setMensajeServicio((String) obj.get("mensajeServicio"));
			response.setFechaSolicitud((String) obj.get("fechaSolicitud"));
		}

		return response;
	}

	// Auth Headers
	protected HttpHeaders getAuthHeaders() {
		String credentials = "client:client";
		String base64 = new String(Base64.encodeBase64(credentials.getBytes()));
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Basic " + base64);
		return headers;
	}

	// Rest Template
	protected RestTemplate getTemplate() {
		RestTemplate rest = new RestTemplate();
		rest.getMessageConverters().add(0, new StringHttpMessageConverter(StandardCharsets.UTF_8));
		return rest;
	}

	// Json Headers
	protected HttpHeaders getJsonHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Accept", "application/json;charset=utf-8");
		return headers;
	}

}
