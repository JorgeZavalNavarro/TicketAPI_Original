package com.enlacetpe.ticketapi.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.enlacetpe.ticketapi.request.AgregarComentarioRequest;
import com.enlacetpe.ticketapi.request.ActualizarEstatusRequest;
import com.enlacetpe.ticketapi.request.AdjuntarArchivoRequest;
import com.enlacetpe.ticketapi.request.ConsultarCategoriasRequest;
import com.enlacetpe.ticketapi.request.ConsultarCiudadesRequest;
import com.enlacetpe.ticketapi.request.ConsultarGruposRequest;
import com.enlacetpe.ticketapi.request.CrearSolicitudRequest;
import com.enlacetpe.ticketapi.request.CrearTicketClienteRequest;
import com.enlacetpe.ticketapi.request.CrearTicketMasivoRequest;
import com.enlacetpe.ticketapi.request.TransferenciaGrupoRequest;
import com.enlacetpe.ticketapi.response.TAdjuntarArchivoResponse;
import com.enlacetpe.ticketapi.response.TCategoriasList;
import com.enlacetpe.ticketapi.response.TCiudadesList;
import com.enlacetpe.ticketapi.response.TGruposList;
import com.enlacetpe.ticketapi.response.TTransferenciaGrupoResponse;
import com.enlacetpe.ticketapi.response.TablerosResponse;
import com.enlacetpe.ticketapi.response.TablerosTicketList;
import com.enlacetpe.ticketapi.service.CMDB.TablerosManager;
import com.enlacetpe.ticketapi.util.ActivityLogger;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/tableros")
@Api(value = "tableros")
public class TablerosController {

	public TablerosTicketList response = new TablerosTicketList();
	public TablerosResponse responseTablero = new TablerosResponse();
	public TCategoriasList responseCat = new TCategoriasList();
	public TGruposList responseGpo = new TGruposList();
	public TCiudadesList responseCiudad = new TCiudadesList();
	public TAdjuntarArchivoResponse adjuntarArchivoResponse = new TAdjuntarArchivoResponse();
	public TTransferenciaGrupoResponse responseTransferencia = new TTransferenciaGrupoResponse();

	@Autowired
	private TablerosManager tablerosManager;

	@RequestMapping(value = "/TcrearTicketCliente", method = RequestMethod.POST)
	@ApiOperation(value = "Genera un nuevo ticket para cliente desde tableros", notes = "Genera un nuevo ticket para cliente desde tableros")
	public ResponseEntity<TablerosTicketList> crearTicketCliente(@Valid @RequestBody CrearTicketClienteRequest request,
			BindingResult result, HttpServletResponse httpResponse) {
		ActivityLogger.logMethod("TcrearTicketCliente");
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
			setRespuestasTicketList(respuesta, "101",
					"Se requiere(n) lo(s) siguientes parametro(s) de entrada: " + parametros,
					"Se requiere(n) lo(s) siguientes parametro(s) de entrada: " + parametros);
		} else {
			// TablerosTicketList response = new TablerosTicketList();
			// SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd
			// HH:mm:ss");
			// String fechaSolicitud = formatter.format(new Date());

			if (request.getNombreOperador().equals("") || request.getNombreOperador() == null
					|| request.getNombreOperador().equals("null")) {

				respuesta = false;
				setRespuestasTicketList(respuesta, "101", "Nombre operador es requerido",
						"Nombre operador es requerido");
				/*
				 * String fechaRespuesta = formatter.format(new Date()); String
				 * codigoRespuesta = "101"; String descripcionRespuesta =
				 * "Nombre operador es requerido"; String mensajeServicio =
				 * "Nombre operador es requerido";
				 * 
				 * response.setRespuesta(respuesta);
				 * response.setFechaRespuesta(fechaRespuesta);
				 * response.setCodigoRespuesta(codigoRespuesta);
				 * response.setDescripcionRespuesta(descripcionRespuesta);
				 * response.setMensajeServicio(mensajeServicio);
				 * response.setFechaSolicitud(fechaSolicitud);
				 */
			}

			if (request.getNumeroEmpleadoTPoperador().equals("") || request.getNumeroEmpleadoTPoperador() == null
					|| request.getNumeroEmpleadoTPoperador().equals("null")) {

				respuesta = false;
				setRespuestasTicketList(respuesta, "101", "NumeroEmpleadoTPoperador es requerido",
						"NumeroEmpleadoTPoperador es requerido");

			}

			if (request.getNumeroCuentaCliente().equals("") || request.getNumeroCuentaCliente() == null
					|| request.getNumeroCuentaCliente().equals("null")) {

				respuesta = false;
				setRespuestasTicketList(respuesta, "101", "NumeroCuentaCliente es requerido",
						"NumeroCuentaCliente es requerido");

			}

			if (request.getOrganizacionCliente().equals("") || request.getOrganizacionCliente() == null
					|| request.getOrganizacionCliente().equals("null")) {

				respuesta = false;
				setRespuestasTicketList(respuesta, "101", "OrganizacionCliente es requerido",
						"OrganizacionCliente es requerido");

			}

			if (request.getNumeroCuentaSitio().equals("") || request.getNumeroCuentaSitio() == null
					|| request.getNumeroCuentaSitio().equals("null")) {

				respuesta = false;
				setRespuestasTicketList(respuesta, "101", "NumeroCuentaSitio es requerido",
						"NumeroCuentaSitio es requerido");

			}

			if (request.getCotSitio().equals("") || request.getCotSitio() == null
					|| request.getCotSitio().equals("null")) {

				respuesta = false;
				setRespuestasTicketList(respuesta, "101", "CotSitio es requerido", "CotSitio es requerido");

			}

			if (request.getNombreSitioDispositivo().equals("") || request.getNombreSitioDispositivo() == null
					|| request.getNombreSitioDispositivo().equals("null")) {

				respuesta = false;
				setRespuestasTicketList(respuesta, "101", "Nombre Sitio Dispositivo es requerido",
						"Nombre Sitio Dispositivo es requerido");

			}

			if (request.getNumeroCuentaServicio().equals("") || request.getNumeroCuentaServicio() == null
					|| request.getNumeroCuentaServicio().equals("null")) {

				respuesta = false;
				setRespuestasTicketList(respuesta, "101", "NumeroCuentaServicio es requerido",
						"NumeroCuentaServicio es requerido");

			}

			if (request.getCotSitioPlan().equals("") || request.getCotSitioPlan() == null
					|| request.getCotSitioPlan().equals("null")) {

				respuesta = false;
				setRespuestasTicketList(respuesta, "101", "CotSitioPlan es requerido", "CotSitioPlan es requerido");

			}

			if (request.getServicioFalla().equals("") || request.getServicioFalla() == null
					|| request.getServicioFalla().equals("null")) {

				respuesta = false;
				setRespuestasTicketList(respuesta, "101", "Servicio Falla es requerido", "Servicio Falla es requerido");

			}

			if (request.getCategoria().equals("") || request.getCategoria() == null
					|| request.getCategoria().equals("null")) {

				respuesta = false;
				setRespuestasTicketList(respuesta, "101", "Categoria es requerido", "Categoria es requerido");

			}

			if (request.getDiagnosticoInicial().equals("") || request.getDiagnosticoInicial() == null
					|| request.getDiagnosticoInicial().equals("null")) {

				respuesta = false;
				setRespuestasTicketList(respuesta, "101", "DiagnosticoInicial es requerido",
						"DiagnosticoInicial es requerido");

			}

			if (request.getGrupo().equals("") || request.getGrupo() == null || request.getGrupo().equals("null")) {

				respuesta = false;
				setRespuestasTicketList(respuesta, "101", "Grupo es requerido", "Grupo es requerido");

			}

			if (request.getProactivoReactivo().equals("") || request.getProactivoReactivo() == null
					|| request.getProactivoReactivo().equals("null")) {

				respuesta = false;
				setRespuestasTicketList(respuesta, "101", "ProactivoReactivo es requerido",
						"ProactivoReactivo es requerido");

			}

			if (request.getDescripcionFalla().equals("") || request.getDescripcionFalla() == null
					|| request.getDescripcionFalla().equals("null")) {

				respuesta = false;
				setRespuestasTicketList(respuesta, "101", "Descripcion falla es requerido",
						"Descripcion falla es requerido");

			}

			if (request.getFolioSF().equals("") || request.getFolioSF() == null
					|| request.getFolioSF().equals("null")) {

				respuesta = false;
				setRespuestasTicketList(respuesta, "101", "FolioSF es requerido", "FolioSF es requerido");

			}

			if (request.getUrgencia().equals("") || request.getUrgencia() == null
					|| request.getUrgencia().equals("null")) {

				respuesta = false;
				setRespuestasTicketList(respuesta, "101", "Urgencia es requerido", "Urgencia es requerido");

			}

			if (request.getImpacto().equals("") || request.getImpacto() == null
					|| request.getImpacto().equals("null")) {

				respuesta = false;
				setRespuestasTicketList(respuesta, "101", "Impacto es requerido", "Impacto es requerido");

			}
			
			if (request.getBandejaRetornoSF().equals("") || request.getBandejaRetornoSF() == null
					|| request.getBandejaRetornoSF().equals("null")) {

				respuesta = false;
				setRespuestasTicketList(respuesta, "101", "BandejaRetornoSF es requerida", "BandejaRetornoSF es requerida");

			}

			if (respuesta != false) {
				response = tablerosManager.crearTicket(request);
			}
		}
		return new ResponseEntity<TablerosTicketList>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/TcrearTicketMasivo", method = RequestMethod.POST)
	@ApiOperation(value = "Genera un nuevo ticket masivo desde tableros", notes = "Genera un nuevo ticket masivo desde tableros")
	public ResponseEntity<TablerosTicketList> crearTicketMasivo(@Valid @RequestBody CrearTicketMasivoRequest request,
			BindingResult result, HttpServletResponse httpResponse) {
		ActivityLogger.logMethod("TcrearTicketMasivo");
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
			setRespuestasTicketList(respuesta, "101",
					"Se requiere(n) lo(s) siguientes parametro(s) de entrada: " + parametros,
					"Se requiere(n) lo(s) siguientes parametro(s) de entrada: " + parametros);
		} else {
			// TablerosTicketList response = new TablerosTicketList();
			// SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd
			// HH:mm:ss");
			// String fechaSolicitud = formatter.format(new Date());

			if (request.getNombreOperador().equals("") || request.getNombreOperador() == null
					|| request.getNombreOperador().equals("null")) {

				respuesta = false;
				setRespuestasTicketList(respuesta, "101", "Nombre operador es requerido",
						"Nombre operador es requerido");

			}

			if (request.getNumeroEmpleadoTPoperador().equals("") || request.getNumeroEmpleadoTPoperador() == null
					|| request.getNumeroEmpleadoTPoperador().equals("null")) {

				respuesta = false;
				setRespuestasTicketList(respuesta, "101", "NumeroEmpleadoTPoperador es requerido",
						"NumeroEmpleadoTPoperador es requerido");

			}

			if (request.getRegion().equals("") || request.getRegion() == null || request.getRegion().equals("null")) {

				respuesta = false;
				setRespuestasTicketList(respuesta, "101", "Region es requerido", "Region es requerido");

			}

			if (request.getCiudad().equals("") || request.getCiudad() == null || request.getCiudad().equals("null")) {

				respuesta = false;
				setRespuestasTicketList(respuesta, "101", "Ciudad es requerido", "Ciudad es requerido");

			}

			if (request.getCategoria().equals("") || request.getCategoria() == null
					|| request.getCategoria().equals("null")) {

				respuesta = false;
				setRespuestasTicketList(respuesta, "101", "Categoria es requerido", "Categoria es requerido");

			}

			if (request.getDiagnosticoInicial().equals("") || request.getDiagnosticoInicial() == null
					|| request.getDiagnosticoInicial().equals("null")) {

				respuesta = false;
				setRespuestasTicketList(respuesta, "101", "DiagnosticoInicial es requerido",
						"DiagnosticoInicial es requerido");

			}

			if (request.getGrupo().equals("") || request.getGrupo() == null || request.getGrupo().equals("null")) {

				respuesta = false;
				setRespuestasTicketList(respuesta, "101", "Grupo es requerido", "Grupo es requerido");

			}

			if (request.getProactivoReactivo().equals("") || request.getProactivoReactivo() == null
					|| request.getProactivoReactivo().equals("null")) {

				respuesta = false;
				setRespuestasTicketList(respuesta, "101", "ProactivoReactivo es requerido",
						"ProactivoReactivo es requerido");

			}

			if (request.getDescripcion().equals("") || request.getDescripcion() == null
					|| request.getDescripcion().equals("null")) {

				respuesta = false;
				setRespuestasTicketList(respuesta, "101", "Descripcion es requerido", "Descripcion es requerido");

			}

			if (request.getFolioSF().equals("") || request.getFolioSF() == null
					|| request.getFolioSF().equals("null")) {

				respuesta = false;
				setRespuestasTicketList(respuesta, "101", "FolioSF es requerido", "FolioSF es requerido");

			}

			if (request.getDescripcionImpacto().equals("") || request.getDescripcionImpacto() == null
					|| request.getDescripcionImpacto().equals("null")) {

				respuesta = false;
				setRespuestasTicketList(respuesta, "101", "DescripcionImpacto es requerido",
						"DescripcionImpacto es requerido");

			}

			if (respuesta != false) {
				response = tablerosManager.crearTicketMasivo(request);
			}
		}
		return new ResponseEntity<TablerosTicketList>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/TcrearSolicitud", method = RequestMethod.POST)
	@ApiOperation(value = "Genera un nuevo ticket de solicitud desde tableros", notes = "Genera un nuevo ticket de solicitud desde tableros")
	public ResponseEntity<TablerosTicketList> crearSolicitud(@Valid @RequestBody CrearSolicitudRequest request,
			BindingResult result, HttpServletResponse httpResponse) {
		ActivityLogger.logMethod("TcrearSolicitud");
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
			setRespuestasTicketList(respuesta, "101",
					"Se requiere(n) lo(s) siguientes parametro(s) de entrada: " + parametros,
					"Se requiere(n) lo(s) siguientes parametro(s) de entrada: " + parametros);
		} else {
			// TablerosTicketList response = new TablerosTicketList();
			// SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd
			// HH:mm:ss");
			// String fechaSolicitud = formatter.format(new Date());

			if (request.getNombreOperador().equals("") || request.getNombreOperador() == null
					|| request.getNombreOperador().equals("null")) {

				respuesta = false;
				setRespuestasTicketList(respuesta, "101", "Nombre operador es requerido",
						"Nombre operador es requerido");

			}

			if (request.getNumeroEmpleadoTPoperador().equals("") || request.getNumeroEmpleadoTPoperador() == null
					|| request.getNumeroEmpleadoTPoperador().equals("null")) {

				respuesta = false;
				setRespuestasTicketList(respuesta, "101", "NumeroEmpleadoTPoperador es requerido",
						"NumeroEmpleadoTPoperador es requerido");

			}

			if (request.getCategoriaSolicitud().equals("") || request.getCategoriaSolicitud() == null
					|| request.getCategoriaSolicitud().equals("null")) {

				respuesta = false;
				setRespuestasTicketList(respuesta, "101", "CategoriaSolicitud es requerido",
						"CategoriaSolicitud es requerido");

			}

			if (request.getGrupo().equals("") || request.getGrupo() == null || request.getGrupo().equals("null")) {

				respuesta = false;
				setRespuestasTicketList(respuesta, "101", "DiagnosticoInicial es requerido",
						"DiagnosticoInicial es requerido");

			}

			if (request.getDescripcionSolicitud().equals("") || request.getDescripcionSolicitud() == null
					|| request.getDescripcionSolicitud().equals("null")) {

				respuesta = false;
				setRespuestasTicketList(respuesta, "101", "DescripcionSolicitud es requerido",
						"DescripcionSolicitud es requerido");

			}

			if (request.getFolioSF().equals("") || request.getFolioSF() == null
					|| request.getFolioSF().equals("null")) {

				respuesta = false;
				setRespuestasTicketList(respuesta, "101", "FolioSF es requerido", "FolioSF es requerido");

			}

			if (respuesta != false) {
				response = tablerosManager.crearSolicitud(request);
			}
		}
		return new ResponseEntity<TablerosTicketList>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/TagregarComentario", method = RequestMethod.POST)
	@ApiOperation(value = "Agrega comentario a ticket", notes = "Agrega comentario a ticket")
	public ResponseEntity<TablerosResponse> agregarComentario(@Valid @RequestBody AgregarComentarioRequest request,
			BindingResult result, HttpServletResponse httpResponse) {
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
			setRespuestasTablero(respuesta, "101",
					"Se requiere(n) lo(s) siguientes parametro(s) de entrada: " + parametros,
					"Se requiere(n) lo(s) siguientes parametro(s) de entrada: " + parametros);
		} else {
			// TablerosResponse response = new TablerosResponse();
			// SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd
			// HH:mm:ss");
			// String fechaSolicitud = formatter.format(new Date());

			if (request.getNombreOperador().equals("") || request.getNombreOperador() == null
					|| request.getNombreOperador().equals("null")) {

				respuesta = false;
				setRespuestasTablero(respuesta, "101", "Nombre operador es requerido", "Nombre operador es requerido");

			}

			if (request.getNumeroEmpleadoTPoperador().equals("") || request.getNumeroEmpleadoTPoperador() == null
					|| request.getNumeroEmpleadoTPoperador().equals("null")) {

				respuesta = false;
				setRespuestasTablero(respuesta, "101", "NumeroEmpleadoTPoperador es requerido",
						"NumeroEmpleadoTPoperador es requerido");

			}

			if (request.getTicketSD().equals("") || request.getTicketSD() == null
					|| request.getTicketSD().equals("null")) {

				respuesta = false;
				setRespuestasTablero(respuesta, "101", "TicketSD es requerido", "TicketSD es requerido");

			}

			if (request.getComentario().equals("") || request.getComentario() == null
					|| request.getComentario().equals("null")) {

				respuesta = false;
				setRespuestasTablero(respuesta, "101", "Comentario es requerido", "Comentario es requerido");

			}

			if (respuesta != false) {
				responseTablero = tablerosManager.agregarComentario(request);
			}
		}
		return new ResponseEntity<TablerosResponse>(responseTablero, HttpStatus.OK);
	}

	@RequestMapping(value = "/Tcategorias", method = RequestMethod.POST)
	@ApiOperation(value = "Catalogo de categorias", notes = "Catalogo de categorias")
	public ResponseEntity<TCategoriasList> consultarCategorias(@Valid @RequestBody ConsultarCategoriasRequest request,
			BindingResult result, HttpServletResponse httpResponse) {
		ActivityLogger.logMethod("Tcategorias");
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
			setRespuestasCat(respuesta, "101", "Se requiere(n) lo(s) siguientes parametro(s) de entrada: " + parametros,
					"Se requiere(n) lo(s) siguientes parametro(s) de entrada: " + parametros);
		} else {

			// TCategoriasList response = new TCategoriasList();
			// SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd
			// HH:mm:ss");
			// String fechaSolicitud = formatter.format(new Date());

			if (request.getNombreOperador().equals("") && request.getNombreOperador() == null
					&& request.getNombreOperador().equals("null")) {

				respuesta = false;
				setRespuestasCat(respuesta, "101", "Nombre operador es requerido", "Nombre operador es requerido");

			}
			if (request.getNumeroEmpleadoTPoperador().equals("") || request.getNumeroEmpleadoTPoperador() == null
					|| request.getNumeroEmpleadoTPoperador().equals("null")) {

				respuesta = false;
				setRespuestasCat(respuesta, "101", "NumeroEmpleadoTPoperador es requerido",
						"NumeroEmpleadoTPoperador es requerido");

			}
			if (request.getTipoCategoria().equals("") || request.getTipoCategoria() == null
					|| request.getTipoCategoria().equals("null")) {

				respuesta = false;
				setRespuestasCat(respuesta, "101", "TipoCategoria es requerido", "TipoCategoria es requerido");

			}
			if (request.getTextoConsultaCategoria().equals("") || request.getTextoConsultaCategoria() == null
					|| request.getTextoConsultaCategoria().equals("null")) {

				respuesta = false;
				setRespuestasCat(respuesta, "101", "No se porporciono ningun texto de consulta.",
						"No se porporciono ningun texto de consulta.");

			}

			char first = request.getTextoConsultaCategoria().charAt(0);
			char last = request.getTextoConsultaCategoria().charAt(request.getTextoConsultaCategoria().length() - 1);
			String cl = request.getTextoConsultaCategoria();
			String Pos = "";
			if (first == '%') {
				cl = cl.substring(1);
			}
			if (last == '%') {
				cl = cl.substring(0, cl.length() - 1);
			}

			String[] arr = cl.split("%");

			if (arr.length < 5) {
				for (int i = 0; i < arr.length; i++) {
					if (arr[i].length() < 3) {
						respuesta = false;
						setRespuestasCat(respuesta, "101", "Algun parametro de la consulta es menor a 3 caracteres.",
								"N/A");
					}
				}

			} else {
				respuesta = false;
				setRespuestasCat(respuesta, "101", "La consulta contiene mas de 4 parametros.", "N/A");
			}

			if (respuesta) {

				responseCat = tablerosManager.consultarCategorias(request);

			}
		}

		return new ResponseEntity<TCategoriasList>(responseCat, HttpStatus.OK);
	}

	@RequestMapping(value = "/Tgrupos", method = RequestMethod.POST)
	@ApiOperation(value = "Catalogo de grupos", notes = "Catalogo de grupos")
	public ResponseEntity<TGruposList> consultarGrupos(@Valid @RequestBody ConsultarGruposRequest request,
			BindingResult result, HttpServletResponse httpResponse) {
		ActivityLogger.logMethod("Tgrupos");
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
			setRespuestasGpo(respuesta, "101", "Se requiere(n) lo(s) siguientes parametro(s) de entrada: " + parametros,
					"Se requiere(n) lo(s) siguientes parametro(s) de entrada: " + parametros);
		} else {
			// TGruposList response = new TGruposList();
			// SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd
			// HH:mm:ss");
			// String fechaSolicitud = formatter.format(new Date());

			if (request.getNombreSolicitante().equals("") || request.getNombreSolicitante() == null
					|| request.getNombreSolicitante().equals("null")) {

				respuesta = false;
				setRespuestasGpo(respuesta, "101", "NombreSolicitante es requerido", "NombreSolicitante es requerido");

			}
			if (request.getNumeroEmpleadoTPSolicitante().equals("") || request.getNumeroEmpleadoTPSolicitante() == null
					|| request.getNumeroEmpleadoTPSolicitante().equals("null")) {

				respuesta = false;
				setRespuestasGpo(respuesta, "101", "NumeroEmpleadoTPSolicitante es requerido",
						"NumeroEmpleadoTPSolicitante es requerido");

			}

			if (request.getTextoConsultaGrupo().equals("") || request.getTextoConsultaGrupo() == null
					|| request.getTextoConsultaGrupo().equals("null")) {

				respuesta = false;
				setRespuestasGpo(respuesta, "101", "TextoConsultaGrupo es requerido",
						"TextoConsultaGrupo es requerido");

			}

			if (respuesta != false) {
				responseGpo = tablerosManager.consultarGrupos(request);
			}
		}
		return new ResponseEntity<TGruposList>(responseGpo, HttpStatus.OK);
	}

	@RequestMapping(value = "/Tciudades", method = RequestMethod.POST)
	@ApiOperation(value = "Catalogo de ciudades", notes = "Catalogo de ciudades")
	public ResponseEntity<TCiudadesList> consultarCiudades(@Valid @RequestBody ConsultarCiudadesRequest request,
			BindingResult result, HttpServletResponse httpResponse) {
		ActivityLogger.logMethod("Tciudades");
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
			setRespuestasCiudad(respuesta, "101",
					"Se requiere(n) lo(s) siguientes parametro(s) de entrada: " + parametros,
					"Se requiere(n) lo(s) siguientes parametro(s) de entrada: " + parametros);
		} else {
			// TCiudadesList response = new TCiudadesList();
			// SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd
			// HH:mm:ss");
			// String fechaSolicitud = formatter.format(new Date());

			if (request.getNombreSolicitante().equals("") || request.getNombreSolicitante() == null
					|| request.getNombreSolicitante().equals("null")) {

				respuesta = false;
				setRespuestasCiudad(respuesta, "101", "NombreSolicitante es requerido",
						"NombreSolicitante es requerido");

			}
			if (request.getNumeroEmpleadoTPSolicitante().equals("") || request.getNumeroEmpleadoTPSolicitante() == null
					|| request.getNumeroEmpleadoTPSolicitante().equals("null")) {

				respuesta = false;
				setRespuestasCiudad(respuesta, "101", "NumeroEmpleadoTPSolicitante es requerido",
						"NumeroEmpleadoTPSolicitante es requerido");

			}

			if (request.getRegionConsulta().equals("") || request.getRegionConsulta() == null
					|| request.getRegionConsulta().equals("null")) {

				respuesta = false;
				setRespuestasCiudad(respuesta, "101", "RegionConsulta es requerido", "RegionConsulta es requerido");

			}

			if (respuesta != false) {
				responseCiudad = tablerosManager.consultarCiudades(request);
			}
		}
		return new ResponseEntity<TCiudadesList>(responseCiudad, HttpStatus.OK);
	}

	@RequestMapping(value = "/TactualizarEstatus", method = RequestMethod.POST)
	@ApiOperation(value = "Actualizar estatus", notes = "Actualizar estatus")
	public ResponseEntity<TablerosResponse> actualizarEstatus(@Valid @RequestBody ActualizarEstatusRequest request,
			BindingResult result, HttpServletResponse httpResponse) {
		ActivityLogger.logMethod("TactualizarEstatus");
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
			setRespuestasTablero(respuesta, "101",
					"Se requiere(n) lo(s) siguientes parametro(s) de entrada: " + parametros,
					"Se requiere(n) lo(s) siguientes parametro(s) de entrada: " + parametros);
		} else {
			// TablerosResponse response = new TablerosResponse();
			// SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd
			// HH:mm:ss");
			// String fechaSolicitud = formatter.format(new Date());

			if (request.getNombreOperador().equals("") || request.getNombreOperador() == null
					|| request.getNombreOperador().equals("null")) {

				respuesta = false;
				setRespuestasTablero(respuesta, "101", "Nombre operador es requerido", "Nombre operador es requerido");

			}

			if (request.getNumeroEmpleadoTPoperador().equals("") || request.getNumeroEmpleadoTPoperador() == null
					|| request.getNumeroEmpleadoTPoperador().equals("null")) {

				respuesta = false;
				setRespuestasTablero(respuesta, "101", "NumeroEmpleadoTPoperador es requerido",
						"NumeroEmpleadoTPoperador es requerido");

			}

			if (request.getTicketSD().equals("") || request.getTicketSD() == null
					|| request.getTicketSD().equals("null")) {

				respuesta = false;
				setRespuestasTablero(respuesta, "101", "TicketSD es requerido", "TicketSD es requerido");

			}

			if (request.getNuevoEstatus().equals("") || request.getNuevoEstatus() == null) {

				respuesta = false;
				setRespuestasTablero(respuesta, "101", "Nuevo estatus es requerido", "Nuevo estatus es requerido");

			} else if (!request.getNuevoEstatus().equals("WIP") && !request.getNuevoEstatus().equals("CL")
					&& !request.getNuevoEstatus().equals("CNCL")) {

				respuesta = false;
				setRespuestasTablero(respuesta, "101", "El nuevo estatus no es correcto",
						"El nuevo estatus no es correcto");

			} else if ((request.getNuevoEstatus().equals("CL") || request.getNuevoEstatus().equals("CNCL"))
					&& (request.getJustificacion().equals("") || request.getJustificacion() == null)) {

				respuesta = false;
				setRespuestasTablero(respuesta, "101", "La justificación es requerida",
						"La justificación es requerida");

			}

			if (respuesta != false) {
				responseTablero = tablerosManager.actualizaEstatus(request);
			}
		}
		return new ResponseEntity<TablerosResponse>(responseTablero, HttpStatus.OK);
	}

	@RequestMapping(value = "/TadjuntarArchivo", method = RequestMethod.POST)
	@ApiOperation(value = "Adjuntar archivo a ticket", notes = "Adjuntar archivo a ticket")
	public ResponseEntity<TAdjuntarArchivoResponse> adjuntarArchivo(@Valid @RequestBody AdjuntarArchivoRequest request,
			BindingResult result, HttpServletResponse httpResponse) {
		ActivityLogger.logMethod("adjuntarArchivo");
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
			setAdjuntarArchivo(respuesta, "101",
					"Se requiere(n) lo(s) siguientes parametro(s) de entrada: " + parametros,
					"Se requiere(n) lo(s) siguientes parametro(s) de entrada: " + parametros);
		} else {

			if (request.getNombreOperador().equals("") || request.getNombreOperador() == null
					|| request.getNombreOperador().equals("null")) {

				respuesta = false;
				setAdjuntarArchivo(respuesta, "101", "Nombre operador es requerido", "Nombre operador es requerido");

			}

			if (request.getNumeroEmpleadoTPoperador().equals("") || request.getNumeroEmpleadoTPoperador() == null
					|| request.getNumeroEmpleadoTPoperador().equals("null")) {

				respuesta = false;
				setAdjuntarArchivo(respuesta, "101", "NumeroEmpleadoTPoperador es requerido",
						"NumeroEmpleadoTPoperador es requerido");

			}

			if (request.getTicketSD().equals("") || request.getTicketSD() == null
					|| request.getTicketSD().equals("null")) {

				respuesta = false;
				setAdjuntarArchivo(respuesta, "101", "TicketSD es requerido", "TicketSD es requerido");

			}

			if (request.getFolioSF().equals("") || request.getFolioSF() == null
					|| request.getFolioSF().equals("null")) {

				respuesta = false;
				setAdjuntarArchivo(respuesta, "101", "FolioSF es requerido", "FolioSF es requerido");

			}

			if (request.getNombreArchivo().equals("") || request.getNombreArchivo() == null
					|| request.getNombreArchivo().equals("null")) {

				respuesta = false;
				setAdjuntarArchivo(respuesta, "101", "NombreArchivo es requerido", "NombreArchivo es requerido");

			}

			if (request.getArchivo().equals("") || request.getArchivo() == null
					|| request.getArchivo().equals("null")) {

				respuesta = false;
				setAdjuntarArchivo(respuesta, "101", "Archivo es requerido", "Archivo es requerido");

			}

			if (respuesta != false) {
				adjuntarArchivoResponse = tablerosManager.adjuntarArchivo(request);
			}
		}
		return new ResponseEntity<TAdjuntarArchivoResponse>(adjuntarArchivoResponse, HttpStatus.OK);
	}

	@RequestMapping(value = "/TtransferenciaGrupo", method = RequestMethod.POST)
	@ApiOperation(value = "Transferencia de grupo (bandeja)", notes = "Transferencia de grupo (bandeja)")
	public ResponseEntity<TTransferenciaGrupoResponse> transferenciaGrupo(
			@Valid @RequestBody TransferenciaGrupoRequest request, BindingResult result,
			HttpServletResponse httpResponse) {
		ActivityLogger.logMethod("TtransferenciaGrupo");
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
			setTransferirGrupo(respuesta, "101",
					"Se requiere(n) lo(s) siguientes parametro(s) de entrada: " + parametros,
					"Se requiere(n) lo(s) siguientes parametro(s) de entrada: " + parametros);
		} else {

			if (request.getNombreOperador().equals("") || request.getNombreOperador() == null
					|| request.getNombreOperador().equals("null")) {

				respuesta = false;
				setTransferirGrupo(respuesta, "101", "Nombre operador es requerido", "Nombre operador es requerido");

			}

			if (request.getNumeroEmpleadoTPoperador().equals("") || request.getNumeroEmpleadoTPoperador() == null
					|| request.getNumeroEmpleadoTPoperador().equals("null")) {

				respuesta = false;
				setTransferirGrupo(respuesta, "101", "NumeroEmpleadoTPoperador es requerido",
						"NumeroEmpleadoTPoperador es requerido");

			}

			if (request.getTicketSD().equals("") || request.getTicketSD() == null
					|| request.getTicketSD().equals("null")) {

				respuesta = false;
				setTransferirGrupo(respuesta, "101", "TicketSD es requerido", "TicketSD es requerido");

			}

			if (request.getGrupo().equals("") || request.getGrupo() == null || request.getGrupo().equals("null")) {

				respuesta = false;
				setTransferirGrupo(respuesta, "101", "Grupo es requerido", "Grupo es requerido");

			}

			if (request.getJustificacion().equals("") || request.getJustificacion() == null
					|| request.getJustificacion().equals("null")) {

				respuesta = false;
				setTransferirGrupo(respuesta, "101", "Justificacion es requerido", "Justificacion es requerido");

			}

			if (respuesta != false) {
				responseTransferencia = tablerosManager.transferenciaGrupo(request);
			}
		}
		return new ResponseEntity<TTransferenciaGrupoResponse>(responseTransferencia, HttpStatus.OK);
	}

	public void setTransferirGrupo(Boolean respuesta, String codigoRespuesta, String descripcionRespuesta,
			String mensajeServicio) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		responseTransferencia = new TTransferenciaGrupoResponse();
		responseTransferencia.setFechaSolicitud(formatter.format(new Date()));
		responseTransferencia.setRespuestaBoolean(respuesta);
		responseTransferencia.setFechaRespuesta(formatter.format(new Date()));
		responseTransferencia.setCodigoRespuesta(codigoRespuesta);
		responseTransferencia.setDescripcionRespuesta(descripcionRespuesta);
		responseTransferencia.setMensajeServicio(mensajeServicio);

	}

	public void setAdjuntarArchivo(Boolean respuesta, String codigoRespuesta, String descripcionRespuesta,
			String mensajeServicio) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		adjuntarArchivoResponse = new TAdjuntarArchivoResponse();
		adjuntarArchivoResponse.setFechaSolicitud(formatter.format(new Date()));
		adjuntarArchivoResponse.setRespuestaBoolean(respuesta);
		adjuntarArchivoResponse.setFechaRespuesta(formatter.format(new Date()));
		adjuntarArchivoResponse.setCodigoRespuesta(codigoRespuesta);
		adjuntarArchivoResponse.setDescripcionRespuesta(descripcionRespuesta);
		adjuntarArchivoResponse.setMensajeServicio(mensajeServicio);

	}

	public void setRespuestasTicketList(Boolean respuesta, String codigoRespuesta, String descripcionRespuesta,
			String mensajeServicio) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		response = new TablerosTicketList();

		response.setFechaSolicitud(formatter.format(new Date()));
		response.setRespuestaBoolean(respuesta);
		response.setFechaRespuesta(formatter.format(new Date()));
		response.setCodigoRespuesta(codigoRespuesta);
		response.setDescripcionRespuesta(descripcionRespuesta);
		response.setMensajeServicio(mensajeServicio);

	}

	public void setRespuestasTablero(Boolean respuesta, String codigoRespuesta, String descripcionRespuesta,
			String mensajeServicio) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		responseTablero = new TablerosResponse();

		responseTablero.setFechaSolicitud(formatter.format(new Date()));
		responseTablero.setRespuestaBoolean(respuesta);
		responseTablero.setFechaRespuesta(formatter.format(new Date()));
		responseTablero.setCodigoRespuesta(codigoRespuesta);
		responseTablero.setDescripcionRespuesta(descripcionRespuesta);
		responseTablero.setMensajeServicio(mensajeServicio);

	}

	public void setRespuestasCat(Boolean respuesta, String codigoRespuesta, String descripcionRespuesta,
			String mensajeServicio) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		responseCat = new TCategoriasList();

		responseCat.setFechaSolicitud(formatter.format(new Date()));
		responseCat.setRespuestaBoolean(respuesta);
		responseCat.setFechaRespuesta(formatter.format(new Date()));
		responseCat.setCodigoRespuesta(codigoRespuesta);
		responseCat.setDescripcionRespuesta(descripcionRespuesta);
		responseCat.setMensajeServicio(mensajeServicio);

	}

	public void setRespuestasGpo(Boolean respuesta, String codigoRespuesta, String descripcionRespuesta,
			String mensajeServicio) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		responseGpo = new TGruposList();

		responseGpo.setFechaSolicitud(formatter.format(new Date()));
		responseGpo.setRespuestaBoolean(respuesta);
		responseGpo.setFechaRespuesta(formatter.format(new Date()));
		responseGpo.setCodigoRespuesta(codigoRespuesta);
		responseGpo.setDescripcionRespuesta(descripcionRespuesta);
		responseGpo.setMensajeServicio(mensajeServicio);

	}

	public void setRespuestasCiudad(Boolean respuesta, String codigoRespuesta, String descripcionRespuesta,
			String mensajeServicio) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		responseCiudad = new TCiudadesList();

		responseCiudad.setFechaSolicitud(formatter.format(new Date()));
		responseCiudad.setRespuestaBoolean(respuesta);
		responseCiudad.setFechaRespuesta(formatter.format(new Date()));
		responseCiudad.setCodigoRespuesta(codigoRespuesta);
		responseCiudad.setDescripcionRespuesta(descripcionRespuesta);
		responseCiudad.setMensajeServicio(mensajeServicio);

	}
}
