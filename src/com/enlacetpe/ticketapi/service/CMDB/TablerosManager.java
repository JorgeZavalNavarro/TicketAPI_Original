package com.enlacetpe.ticketapi.service.CMDB;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import javax.xml.rpc.holders.StringHolder;

import org.apache.log4j.Logger;
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
import com.enlacetpe.ticketapi.model.SdmCrStatModel;
import com.enlacetpe.ticketapi.model.SdmImpactModel;
import com.enlacetpe.ticketapi.model.SdmUrgncyModel;
import com.enlacetpe.ticketapi.modelTicketApiSD.CatGruposModel;
import com.enlacetpe.ticketapi.modelTicketApiSD.CatRegionesModel;
import com.enlacetpe.ticketapi.modelTicketApiSD.CatZCiudadesModel;
import com.enlacetpe.ticketapi.repository.SdmCaOwnedResourceRepository;
import com.enlacetpe.ticketapi.repository.SdmCrStatRepository;
import com.enlacetpe.ticketapi.repository.SdmImpactRepository;
import com.enlacetpe.ticketapi.repository.SdmUrgncyRepository;
import com.enlacetpe.ticketapi.repositoryTicketApiSD.BitacoraPeticionesRepository;
import com.enlacetpe.ticketapi.repositoryTicketApiSD.CatCategoriasRepository;
import com.enlacetpe.ticketapi.repositoryTicketApiSD.CatRegionesRepository;
import com.enlacetpe.ticketapi.repositoryTicketApiSD.CatZCiudadesRepository;
import com.enlacetpe.ticketapi.repositoryTicketApiSD.CatGruposRepository;
import com.enlacetpe.ticketapi.request.AgregarComentarioRequest;
import com.enlacetpe.ticketapi.request.ConsultarCategoriasRequest;
import com.enlacetpe.ticketapi.request.ConsultarCiudadesRequest;
import com.enlacetpe.ticketapi.request.ConsultarGruposRequest;
import com.enlacetpe.ticketapi.request.CrearSolicitudRequest;
import com.enlacetpe.ticketapi.request.CrearTicketClienteRequest;
import com.enlacetpe.ticketapi.request.CrearTicketMasivoRequest;
import com.enlacetpe.ticketapi.request.TransferenciaGrupoRequest;
import com.enlacetpe.ticketapi.request.ActualizarEstatusRequest;
import com.enlacetpe.ticketapi.request.AdjuntarArchivoRequest;
import com.enlacetpe.ticketapi.response.CATicket;
import com.enlacetpe.ticketapi.response.TAdjuntarArchivoResponse;
import com.enlacetpe.ticketapi.response.TCategorias;
import com.enlacetpe.ticketapi.response.TCategoriasList;
import com.enlacetpe.ticketapi.response.TCiudades;
import com.enlacetpe.ticketapi.response.TCiudadesList;
import com.enlacetpe.ticketapi.response.TGrupos;
import com.enlacetpe.ticketapi.response.TGruposList;
import com.enlacetpe.ticketapi.response.TTransferenciaGrupoResponse;
import com.enlacetpe.ticketapi.response.TablerosResponse;
import com.enlacetpe.ticketapi.response.TablerosTicketList;
import com.enlacetpe.ticketapi.service.apis.ServiceArchivoSD;
import java.util.logging.Level;
import org.primefaces.json.JSONException;

@Service
public class TablerosManager {

    final static Logger logger = Logger.getLogger(TablerosManager.class);
    public TCiudadesList responseCiudad = new TCiudadesList();

    @Autowired
    private CALogInValidator logInValidator;

    @Autowired
    private CAQueryValidator queryValidator;

    @Autowired
    private CAObjectValidator objValidator;

    @Autowired
    private CatCategoriasRepository catCategoriasRepository;

    @Autowired
    private BitacoraPeticionesRepository bitacoraRepository;

    @Autowired
    private CatGruposRepository gruposRepository;

    @Autowired
    private CatRegionesRepository regionesRepository;

    @Autowired
    private SdmCrStatRepository sdmCrStatRepository;

    @Autowired
    private SdmCaOwnedResourceRepository sdmCaOwnedResourceRepository;

    @Autowired
    private SdmImpactRepository sdmImpactRepository;

    @Autowired
    private SdmUrgncyRepository sdmUrgncyRepository;

    @Autowired
    private CatZCiudadesRepository ciudadesRepository;

    @Autowired
    private ServiceArchivoSD serviceArchivoSD;

    public TablerosTicketList crearTicket(CrearTicketClienteRequest request) {

        ArrayList<CATicket> tickets = new ArrayList<CATicket>();
        Integer token = null;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        boolean respuesta = true;
        String codigoRespuesta = null;
        String descripcionRespuesta = null;
        String mensajeServicio = null;
        String fechaSolicitud = formatter.format(new Date());
        String fechaRespuesta = null;
        String errorServicio = null;

        try {

            CATicketMapper mapper = new CATicketMapper();
            token = logInValidator.getToken();
            // String userHandle = logInValidator.getUserHandle(token);
            String[] propertyValues = {};
            String[] attributes = {};
            // String cuentaId = null;
            // String orgId = null;
            StringHolder newRequestHandle = new StringHolder();
            StringHolder newRequestNumber = new StringHolder();

            logger.info("Va a generar ticket");

            // Object cuentas =
            // sdmCaOwnedResourceRepository.getCuenta(request.getNumeroCuentaCliente());

            /*
			 * if (!((List) cuentas).isEmpty()) {
			 * 
			 * for (Object objecto : (List) cuentas) {
			 * 
			 * Object[] obj = (Object[]) objecto;
			 * 
			 * cuentaId = String.valueOf(obj[0]); orgId =
			 * String.valueOf(obj[1]);
			 * 
			 * logger.info("Cuenta:" + cuentaId);
			 * 
			 * logger.info("Organizacion:" + orgId);
			 * 
			 * }
             */
            String requestByCriteria = TicketQueryBuilder.buildQuery("Integracion SF Dashboard Web", "userCreate"); // Busco
            String requestByXml = queryValidator.doSelect(token, "cnt", requestByCriteria, 1,
                    TicketDictionary.persistentIdParam);

            String requestBy = mapper.getValueByAttrName(requestByXml, TicketDictionary.persistentId);

            logger.info("Solicitado por: " + requestBy);

            String requestByCriteriaTenant = TicketQueryBuilder.buildQuery("TOTAL PLAY", "tenant"); // Busco
            // tenant
            String requestByXmlTenant = queryValidator.doSelect(token, "tenant", requestByCriteriaTenant, 1,
                    TicketDictionary.persistentIdParam);
            String tenantId = mapper.getValueByAttrName(requestByXmlTenant, TicketDictionary.id);
            logger.info("Tenant: " + tenantId);

            String type = TicketQueryBuilder.validateTicketType("I");
            logger.info("Tipo: " + type);

            List<Object> listCategoria = null;
            List<Object> listCategoriaIM = null;
            List<Object> listCategoriaS = null;
            listCategoria = catCategoriasRepository.getCategoriesIncidentesSingle(request.getCategoria());
            String Persid = null;

            for (Object obj : listCategoria) {
                Object[] objeto = (Object[]) obj;
                Persid = String.valueOf(objeto[1]);
            }
            // Busco categoría en IM
            listCategoriaIM = catCategoriasRepository.getCategoriesIncidentesMasivosSingle(request.getCategoria());
            String PersidIM = null;

            for (Object obj : listCategoriaIM) {
                Object[] objeto = (Object[]) obj;
                PersidIM = String.valueOf(objeto[1]);
            }
            // Busco categoría en S
            listCategoriaS = catCategoriasRepository.getCategoriesSolicitudesSingle(request.getCategoria());
            String PersidS = null;

            for (Object obj : listCategoriaS) {
                Object[] objeto = (Object[]) obj;
                PersidS = String.valueOf(objeto[1]);
            }

            CatGruposModel grupo = gruposRepository.findByLastName(request.getGrupo());
            String requestByCriteriaGrupo = TicketQueryBuilder.buildQuery(request.getGrupo(), "group"); // Busco
            // Grupo
            String requestByXmlGrupo = queryValidator.doSelect(token, "cnt", requestByCriteriaGrupo, 1,
                    TicketDictionary.persistentIdParam);
            String grupoId = mapper.getValueByAttrName(requestByXmlGrupo, TicketDictionary.id);

            int countImpacto = sdmImpactRepository.countByEnumImpactAndDel(Integer.valueOf(request.getImpacto()), 0);
            int countUrgencia = sdmUrgncyRepository.countByEnumImpactAndDel(Integer.valueOf(request.getUrgencia()), 0);

            if (!requestBy.isEmpty()) {

                if (!tenantId.isEmpty()) {

                    if (!type.isEmpty()) {

                        if (Persid != null) {

                            String category = Persid;
                            logger.info("Categoria: " + category);

                            if (grupo != null) {
                                logger.info("Grupo: " + grupoId);

                                // if (!orgId.equals("null") && !orgId.isEmpty()
                                // && orgId != null) {
                                if (countUrgencia > 0) {
                                    SdmUrgncyModel urgencia = sdmUrgncyRepository
                                            .findByEnumImpactAndDel(Integer.valueOf(request.getUrgencia()), 0);
                                    logger.info("Urgencia: " + urgencia.getEnumImpact());

                                    if (countImpacto > 0) {
                                        SdmImpactModel impacto = sdmImpactRepository
                                                .findByEnumImpactAndDel(Integer.valueOf(request.getImpacto()), 0);
                                        logger.info("Impacto: " + impacto.getEnumImpact());

                                        String[] argsCreate = null;
                                        String[] array = new String[]{
                                            "Numero de cuenta cliente en SF: " + request.getNumeroCuentaCliente()
                                            + "\n" + "Texto de cliente en SF: "
                                            + request.getOrganizacionCliente() + "\n"
                                            + "Folio Dashboard Web-SF: " + request.getFolioSF() + "\n"
                                            + request.getDescripcionFalla() + "\n"
                                            + " Nombre del operador quien creo el ticket: "
                                            + request.getNombreOperador() + "\n"
                                            + " Su numero de empleado: "
                                            + request.getNumeroEmpleadoTPoperador()};

                                        argsCreate = new String[]{"requested_by", requestBy, "customer", requestBy,
                                            "category", category, "created_via", "3556", "summary",
                                            request.getDescripcionFalla(), "description", array[0], "type", type,
                                            /*
												 * "affected_resource",cuentaId.
												 * replace("0x", "nr:"),
												 * "zorg_id",
												 * orgId.replace("0x", "org:"),
                                             */
                                            "group", grupoId, "status", "OP", "log_agent", requestBy,
                                            "zdiag_inicial", request.getDiagnosticoInicial(), "ztipo_red", "Física",
                                            "zes_proactivo_reactivo", request.getProactivoReactivo(),
                                            "zfolio_dbw_sf", request.getFolioSF(), "tenant", tenantId, "urgency",
                                            String.valueOf(urgencia.getEnumImpact()), "impact",
                                            String.valueOf(impacto.getEnumImpact()), "zgrp_origen_sf", request.getBandejaRetornoSF()
                                        };

                                        String xml = objValidator.createTicket(token, requestBy, argsCreate,
                                                propertyValues, attributes, newRequestHandle, newRequestNumber);

                                        System.out.println();
                                        tickets = mapper.mapUniqueTableros(xml);
                                        logger.info("Se creo el ticket - cliente: " + tickets.get(0).getRefNum());

                                        if (!tickets.get(0).getRefNum().isEmpty()) {

                                            JSONObject myObject = new JSONObject();

                                            myObject.put("nombreOperador", request.getNombreOperador());
                                            myObject.put("numeroEmpleadoTPoperador",
                                                    request.getNumeroEmpleadoTPoperador());
                                            myObject.put("numeroCuentaCliente", request.getNumeroCuentaCliente());
                                            myObject.put("organizacionCliente", request.getOrganizacionCliente());
                                            myObject.put("numeroCuentaSitio", request.getNumeroCuentaSitio());
                                            myObject.put("cotSitio", request.getCotSitio());
                                            myObject.put("nombreSitioDispositivo", request.getNombreSitioDispositivo());
                                            myObject.put("numeroCuentaServicio", request.getNumeroCuentaServicio());
                                            myObject.put("cotSitioPlan", request.getCotSitioPlan());
                                            myObject.put("servicioFalla", request.getServicioFalla());
                                            myObject.put("categoria", request.getCategoria());
                                            myObject.put("diagnosticoInicial", request.getDiagnosticoInicial());
                                            myObject.put("grupo", request.getGrupo());
                                            myObject.put("proactivoReactivo", request.getProactivoReactivo());
                                            myObject.put("descripcionFalla", request.getDescripcionFalla());
                                            myObject.put("folioSF", request.getFolioSF());
                                            myObject.put("impacto", request.getImpacto());
                                            myObject.put("urgencia", request.getUrgencia());

                                            System.out.print("JSON REQUEST creacionTicket - cliente: " + myObject);

                                            String entradaOriginal = myObject.toString();
                                            String cadenaCodificada = Base64.getEncoder()
                                                    .encodeToString(entradaOriginal.getBytes());

                                            System.out.println(
                                                    "codificado registro de ticket - cliente: " + cadenaCodificada);

                                            bitacoraRepository.insertarBitacora(request.getNombreOperador(),
                                                    request.getNumeroEmpleadoTPoperador(), fechaSolicitud,
                                                    "Peticion a registro de ticket - cliente", cadenaCodificada, "");

                                            respuesta = true;
                                            codigoRespuesta = "000";
                                            descripcionRespuesta = "CrearTicketCliente: Exito al crear Ticket";
                                            mensajeServicio = "CrearTicketCliente: Exito al crear Ticket";
                                            fechaRespuesta = formatter.format(new Date());

                                        } else {

                                            respuesta = false;
                                            codigoRespuesta = "300";
                                            descripcionRespuesta = "300 - CrearTicketCliente: Ocurrio un error al crear el ticket - cliente";
                                            mensajeServicio = "300 - CrearTicketCliente: Ocurrio un error al crear el ticket - cliente";
                                            fechaRespuesta = formatter.format(new Date());
                                            logger.info("CrearTicket: Ocurrio un error al crear el ticket - cliente");

                                        }

                                    } else {

                                        respuesta = false;
                                        codigoRespuesta = "102";
                                        descripcionRespuesta = "102 - CrearTicketCliente: Impacto invalido: "
                                                + request.getImpacto();
                                        mensajeServicio = "102 - CrearTicketCliente: Impacto invalido: "
                                                + request.getImpacto();
                                        fechaRespuesta = formatter.format(new Date());
                                        logger.info("Impacto invalido");

                                    }

                                } else {

                                    respuesta = false;
                                    codigoRespuesta = "102";
                                    descripcionRespuesta = "102 - CrearTicketCliente: Urgencia invalida: "
                                            + request.getUrgencia();
                                    mensajeServicio = "102 - CrearTicketCliente: Urgencia invalida: "
                                            + request.getUrgencia();
                                    fechaRespuesta = formatter.format(new Date());
                                    logger.info("Urgencia invalida");

                                }

                                /*
								 * } else { respuesta = false; codigoRespuesta =
								 * "102"; descripcionRespuesta =
								 * "102 - CrearTicketCliente: Cuenta no relacionada a una organización en CMDB"
								 * ; mensajeServicio =
								 * "102 - CrearTicketCliente: Cuenta no relacionada a una organización en CMDB"
								 * ; fechaRespuesta = formatter.format(new
								 * Date());
								 * logger.info("Organizacion invalido"); }
                                 */
                            } else {
                                respuesta = false;
                                codigoRespuesta = "102";
                                descripcionRespuesta = "102 - CrearTicketCliente: No se encontro grupo: "
                                        + request.getGrupo();
                                mensajeServicio = "102 - CrearTicketCliente: No se encontro grupo: "
                                        + request.getGrupo();
                                fechaRespuesta = formatter.format(new Date());
                                logger.info("Grupo invalido");
                            }

                        } else {
                            if (PersidIM != null || PersidS != null) {
                                respuesta = false;
                                codigoRespuesta = "102";
                                descripcionRespuesta = "102 - CrearTicketCliente: No se encontro categoria: "
                                        + request.getCategoria();
                                mensajeServicio = "102 - CrearTicketCliente: La categoria indicada no aplica para este metodo.";
                                fechaRespuesta = formatter.format(new Date());
                                logger.info("Categoria invalido");
                            } else {
                                respuesta = false;
                                codigoRespuesta = "102";
                                descripcionRespuesta = "102 - CrearTicketCliente: No se encontro categoria: "
                                        + request.getCategoria();
                                mensajeServicio = "102 - CrearTicketCliente: No se encontro categoria: "
                                        + request.getCategoria();
                                fechaRespuesta = formatter.format(new Date());
                                logger.info("Categoria invalido");
                            }
                        }

                    } else {
                        respuesta = false;
                        codigoRespuesta = "102";
                        descripcionRespuesta = "102 - CrearTicketCliente: Tipo invalido";
                        mensajeServicio = "102 - CrearTicketCliente: Tipo invalido";
                        fechaRespuesta = formatter.format(new Date());
                        logger.info("Tipo invalido");
                    }

                } else {
                    respuesta = false;
                    codigoRespuesta = "102";
                    descripcionRespuesta = "102 - CrearTicketCliente: Tenant no encontrado";
                    mensajeServicio = "102 - CrearTicketCliente: Tenant no encontrado";
                    fechaRespuesta = formatter.format(new Date());
                    logger.info("Tenant no encontrado");
                }

            } else {
                respuesta = false;
                codigoRespuesta = "102";
                descripcionRespuesta = "102 - CrearTicketCliente: Solicitante no encontrado";
                mensajeServicio = "102 - CrearTicketCliente: Solicitante no encontrado";
                fechaRespuesta = formatter.format(new Date());
                logger.info("Solicitante no encontrado");
            }

            /*
			 * } else {
			 * 
			 * respuesta = false; codigoRespuesta = "102"; descripcionRespuesta
			 * = "102 - CrearTicketCliente: Numero de cuenta no encontrado";
			 * mensajeServicio =
			 * "102 - CrearTicketCliente: Numero de cuenta no encontrado";
			 * fechaRespuesta = formatter.format(new Date());
			 * logger.info("Numero de cuenta no encontrado");
			 * 
			 * }
             */
            JSONObject myObjectResponse = new JSONObject();

            myObjectResponse.put("respuestaBoolean", respuesta);
            myObjectResponse.put("codigoRespuesta", codigoRespuesta);
            myObjectResponse.put("descripcionRespuesta", descripcionRespuesta);
            myObjectResponse.put("mensajeServicio", mensajeServicio);
            myObjectResponse.put("fechaSolicitud", fechaSolicitud);
            myObjectResponse.put("fechaRespuesta", fechaRespuesta);
            myObjectResponse.put("tickets", tickets);

            System.out.print("JSON RESPONSE creacionTicket - cliente: " + myObjectResponse);

            String entradaOriginalResponse = myObjectResponse.toString();
            String cadenaCodificadaResponse = Base64.getEncoder().encodeToString(entradaOriginalResponse.getBytes());

            System.out.println("codificado registro de ticket - cliente: " + cadenaCodificadaResponse);

            bitacoraRepository.insertarBitacora(request.getNombreOperador(), request.getNumeroEmpleadoTPoperador(),
                    fechaSolicitud, "Respuesta de peticion a registro de ticket - cliente", "",
                    cadenaCodificadaResponse);

            boolean cerrado = logInValidator.closeToken(token);
            System.out.println("Se cierra sesion: " + cerrado);
            token = null;
        } catch (RemoteException e) {

            try {
                respuesta = false;
                codigoRespuesta = "150";
                descripcionRespuesta = codigoRespuesta + " - ERROR DE DUPLICACIÓN: SF ha solicitado la creación de ticket en SD con el mismo folio SF ya reportado en otro ticket. ";
                logger.info("Simplificando la respuest...");
                logger.info("Error original .......: " + e.getMessage());
                String error = simplificarError(e.getMessage());
                logger.info("Error simplidicado: ...:" + error);
                mensajeServicio = codigoRespuesta + " - " + error;
                fechaRespuesta = formatter.format(new Date());
                logger.info("Error: " + e);

                JSONObject myObjectResponse = new JSONObject();

                myObjectResponse.put("respuestaBoolean", respuesta);
                myObjectResponse.put("codigoRespuesta", codigoRespuesta);
                myObjectResponse.put("descripcionRespuesta", descripcionRespuesta);
                myObjectResponse.put("mensajeServicio", mensajeServicio);
                myObjectResponse.put("fechaSolicitud", fechaSolicitud);
                myObjectResponse.put("fechaRespuesta", fechaRespuesta);
                myObjectResponse.put("tickets", tickets);

                System.out.print("JSON RESPONSE creacionTicket - cliente: " + myObjectResponse);

                String entradaOriginalResponse = myObjectResponse.toString();
                String cadenaCodificadaResponse = Base64.getEncoder().encodeToString(entradaOriginalResponse.getBytes());

                System.out.println("codificado registro de ticket - cliente: " + cadenaCodificadaResponse);

                bitacoraRepository.insertarBitacora(request.getNombreOperador(), request.getNumeroEmpleadoTPoperador(),
                        fechaSolicitud, "Respuesta de peticion a registro de ticket - cliente", "",
                        cadenaCodificadaResponse);
            } catch (JSONException ex) {
                java.util.logging.Logger.getLogger(TablerosManager.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (Exception e) {

            try {
                respuesta = false;
                codigoRespuesta = "102";
                descripcionRespuesta = "Crear Ticket Cliente: Ocurrio un error al crear ticket - cliente. ";
                mensajeServicio = "102 - " + e.toString();
                fechaRespuesta = formatter.format(new Date());
                logger.info("Error: " + e);

                JSONObject myObjectResponse = new JSONObject();

                myObjectResponse.put("respuestaBoolean", respuesta);
                myObjectResponse.put("codigoRespuesta", codigoRespuesta);
                myObjectResponse.put("descripcionRespuesta", descripcionRespuesta);
                myObjectResponse.put("mensajeServicio", mensajeServicio);
                myObjectResponse.put("fechaSolicitud", fechaSolicitud);
                myObjectResponse.put("fechaRespuesta", fechaRespuesta);
                myObjectResponse.put("tickets", tickets);

                System.out.print("JSON RESPONSE creacionTicket - cliente: " + myObjectResponse);

                String entradaOriginalResponse = myObjectResponse.toString();
                String cadenaCodificadaResponse = Base64.getEncoder().encodeToString(entradaOriginalResponse.getBytes());

                System.out.println("codificado registro de ticket - cliente: " + cadenaCodificadaResponse);

                bitacoraRepository.insertarBitacora(request.getNombreOperador(), request.getNumeroEmpleadoTPoperador(),
                        fechaSolicitud, "Respuesta de peticion a registro de ticket - cliente", "",
                        cadenaCodificadaResponse);
            } catch (JSONException ex) {
                java.util.logging.Logger.getLogger(TablerosManager.class.getName()).log(Level.SEVERE, null, ex);
            }

        } finally {
            try {
                if (token != null) {
                    logInValidator.closeToken(token);
                }
            } catch (RemoteException e) {
                logger.info("Error Ticket" + e);
            }
        }

        if (tickets.size() > 0) {
            return new TablerosTicketList(respuesta, codigoRespuesta, descripcionRespuesta, mensajeServicio,
                    fechaSolicitud, fechaRespuesta, tickets.get(0).getRefNum());
        } else {
            return new TablerosTicketList(respuesta, codigoRespuesta, descripcionRespuesta, mensajeServicio,
                    fechaSolicitud, fechaRespuesta, null);
        }
    }

    public TablerosTicketList crearTicketMasivo(CrearTicketMasivoRequest request) {

        ArrayList<CATicket> tickets = new ArrayList<CATicket>();
        Integer token = null;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        boolean respuesta = true;
        String codigoRespuesta = null;
        String descripcionRespuesta = null;
        String mensajeServicio = null;
        String fechaSolicitud = formatter.format(new Date());
        String fechaRespuesta = null;

        try {

            CATicketMapper mapper = new CATicketMapper();
            token = logInValidator.getToken();
            String userHandle = logInValidator.getUserHandle(token);
            String[] propertyValues = {};
            String[] attributes = {};
            CatRegionesModel regionmodel = new CatRegionesModel();
            List<Object> listCiudades = null;
            CatZCiudadesModel ciudadModel = new CatZCiudadesModel();

            logger.info("Va a generar ticket masivo");
            StringHolder newRequestHandle = new StringHolder();
            StringHolder newRequestNumber = new StringHolder();

            String requestByCriteria = TicketQueryBuilder.buildQuery("Integracion SF Dashboard Web", "userCreate"); // Busco
            String requestByXml = queryValidator.doSelect(token, "cnt", requestByCriteria, 1,
                    TicketDictionary.persistentIdParam);
            String requestBy = mapper.getValueByAttrName(requestByXml, TicketDictionary.persistentId);
            logger.info("Solicitado por: " + requestBy);

            String requestByCriteriaTenant = TicketQueryBuilder.buildQuery("TOTAL PLAY", "tenant"); // Busco
            // tenant
            String requestByXmlTenant = queryValidator.doSelect(token, "tenant", requestByCriteriaTenant, 1,
                    TicketDictionary.persistentIdParam);
            String tenantId = mapper.getValueByAttrName(requestByXmlTenant, TicketDictionary.id);
            logger.info("Tenant: " + tenantId);

            String type = TicketQueryBuilder.validateTicketType("I");
            logger.info("Tipo: " + type);

            List<Object> listCategoria = null;
            List<Object> listCategoriaIC = null;
            List<Object> listCategoriaS = null;
            listCategoria = catCategoriasRepository.getCategoriesIncidentesMasivosSingle(request.getCategoria());
            String Persid = null;

            for (Object obj : listCategoria) {
                Object[] objeto = (Object[]) obj;
                Persid = String.valueOf(objeto[1]);
            }

            // Busco categoría en IC
            listCategoriaIC = catCategoriasRepository.getCategoriesIncidentesSingle(request.getCategoria());
            String PersidIC = null;

            for (Object obj : listCategoriaIC) {
                Object[] objeto = (Object[]) obj;
                PersidIC = String.valueOf(objeto[1]);
            }
            // Busco categoría en S
            listCategoriaS = catCategoriasRepository.getCategoriesSolicitudesSingle(request.getCategoria());
            String PersidS = null;

            for (Object obj : listCategoriaS) {
                Object[] objeto = (Object[]) obj;
                PersidS = String.valueOf(objeto[1]);
            }

            CatGruposModel grupo = gruposRepository.findByLastName(request.getGrupo());

            String requestByCriteriaGrupo = TicketQueryBuilder.buildQuery(request.getGrupo(), "group"); // Busco
            // Grupo
            String requestByXmlGrupo = queryValidator.doSelect(token, "cnt", requestByCriteriaGrupo, 1,
                    TicketDictionary.persistentIdParam);
            String grupoId = mapper.getValueByAttrName(requestByXmlGrupo, TicketDictionary.id);

            regionmodel = regionesRepository.findBySymAndDeleteFlag(request.getRegion(), 0);

            int countImpacto = sdmImpactRepository.countByEnumImpactAndDel(Integer.valueOf(request.getImpacto()), 0);
            int countUrgencia = sdmUrgncyRepository.countByEnumImpactAndDel(Integer.valueOf(request.getUrgencia()), 0);

            if (!requestBy.isEmpty()) {

                if (!tenantId.isEmpty()) {

                    if (!type.isEmpty()) {

                        if (Persid != null) {
                            String category = Persid;
                            logger.info("Categoria: " + category);

                            if (grupo != null) {
                                logger.info("Grupo: " + grupoId);

                                if (regionmodel != null && !regionmodel.equals("")) {

                                    ciudadModel = ciudadesRepository.findBySymAndDeleteFlag(request.getCiudad(), 0);

                                    if (ciudadModel != null && !ciudadModel.equals("")) {

                                        if (countUrgencia > 0) {
                                            SdmUrgncyModel urgencia = sdmUrgncyRepository
                                                    .findByEnumImpactAndDel(Integer.valueOf(request.getUrgencia()), 0);
                                            logger.info("Urgencia: " + urgencia.getEnumImpact());

                                            if (countImpacto > 0) {
                                                SdmImpactModel impacto = sdmImpactRepository.findByEnumImpactAndDel(
                                                        Integer.valueOf(request.getImpacto()), 0);
                                                logger.info("Impacto: " + impacto.getEnumImpact());

                                                String[] argsCreate = null;
                                                String[] array = new String[]{request.getDescripcion() + "\n"
                                                    + " Nombre del operador quien creo el ticket: "
                                                    + request.getNombreOperador() + " Su numero de empleado: "
                                                    + request.getNumeroEmpleadoTPoperador()};

                                                argsCreate = new String[]{"requested_by", requestBy, "customer",
                                                    requestBy, "category", category, "created_via", "3556",
                                                    "summary", request.getDescripcion(), "description", array[0],
                                                    "type", type, "group", grupoId, "status", "OP", "log_agent",
                                                    requestBy, "zdiag_inicial", request.getDiagnosticoInicial(),
                                                    "ztipo_red", "Física", "zRegCiu_id",
                                                    String.valueOf(regionmodel.getId()), "zCiuReg_id",
                                                    String.valueOf(ciudadModel.getId()), "zes_proactivo_reactivo",
                                                    request.getProactivoReactivo(), "zfolio_dbw_sf",
                                                    request.getFolioSF(), "tenant", tenantId, "zfalla_masivaTele",
                                                    "1", "zimpacto_Tele", request.getDescripcionImpacto(),
                                                    "urgency", String.valueOf(urgencia.getEnumImpact()), "impact",
                                                    String.valueOf(impacto.getEnumImpact()), "zgrp_origen_sf", request.getBandejaRetornoSF()};

                                                String xml = objValidator.createTicket(token, requestBy, argsCreate,
                                                        propertyValues, attributes, newRequestHandle, newRequestNumber);

                                                System.out.println();
                                                tickets = mapper.mapUniqueTableros(xml);
                                                logger.info("Se creo el ticket: " + tickets.get(0).getRefNum());

                                                if (!tickets.get(0).getRefNum().isEmpty()) {

                                                    JSONObject myObject = new JSONObject();

                                                    myObject.put("nombreOperador", request.getNombreOperador());
                                                    myObject.put("numeroEmpleadoTPoperador",
                                                            request.getNumeroEmpleadoTPoperador());
                                                    myObject.put("region", request.getRegion());
                                                    myObject.put("ciudad", request.getCiudad());
                                                    myObject.put("descripcionImpacto", request.getDescripcionImpacto());
                                                    myObject.put("categoria", request.getCategoria());
                                                    myObject.put("diagnosticoInicial", request.getDiagnosticoInicial());
                                                    myObject.put("grupo", request.getGrupo());
                                                    myObject.put("proactivoReactivo", request.getProactivoReactivo());
                                                    myObject.put("descripcionFalla", request.getDescripcion());
                                                    myObject.put("folioSF", request.getFolioSF());
                                                    myObject.put("impacto", request.getImpacto());
                                                    myObject.put("urgencia", request.getUrgencia());

                                                    System.out
                                                            .print("JSON REQUEST creacionTicket - masivo: " + myObject);

                                                    String entradaOriginal = myObject.toString();
                                                    String cadenaCodificada = Base64.getEncoder()
                                                            .encodeToString(entradaOriginal.getBytes());

                                                    System.out.println("codificado registro de ticket - masivo: "
                                                            + cadenaCodificada);

                                                    bitacoraRepository.insertarBitacora(request.getNombreOperador(),
                                                            request.getNumeroEmpleadoTPoperador(), fechaSolicitud,
                                                            "Peticion a registro de ticket - masivo", cadenaCodificada,
                                                            "");

                                                    respuesta = true;
                                                    codigoRespuesta = "000";
                                                    descripcionRespuesta = "CrearTicketMasivo: Exito al crear Ticket";
                                                    mensajeServicio = "CrearTicketMasivo: Exito al crear Ticket";
                                                    fechaRespuesta = formatter.format(new Date());

                                                } else {

                                                    respuesta = false;
                                                    codigoRespuesta = "300";
                                                    descripcionRespuesta = "CrearTicketMasivo: Ocurrio un error al crear el ticket - masivo";
                                                    mensajeServicio = "CrearTicketMasivo: Ocurrio un error al crear el ticket - masivo";
                                                    fechaRespuesta = formatter.format(new Date());
                                                    logger.info(
                                                            "CrearTicketMasivo: Ocurrio un error al crear el ticket - masivo");

                                                }

                                            } else {

                                                respuesta = false;
                                                codigoRespuesta = "102";
                                                descripcionRespuesta = "102 - CrearTicketMasivo: Impacto invalido: "
                                                        + request.getImpacto();
                                                mensajeServicio = "102 - CrearTicketMasivo: Impacto invalido: "
                                                        + request.getImpacto();
                                                fechaRespuesta = formatter.format(new Date());
                                                logger.info("Impacto invalido");

                                            }
                                        } else {

                                            respuesta = false;
                                            codigoRespuesta = "102";
                                            descripcionRespuesta = "102 - CrearTicketMasivo: Urgencia invalida: "
                                                    + request.getUrgencia();
                                            mensajeServicio = "102 - CrearTicketMasivo: Urgencia invalida: "
                                                    + request.getUrgencia();
                                            fechaRespuesta = formatter.format(new Date());
                                            logger.info("Urgencia invalida");

                                        }

                                    } else {
                                        respuesta = false;
                                        codigoRespuesta = "102";
                                        descripcionRespuesta = "CrearTicketMasivo: Ciudad invalida: "
                                                + request.getCiudad();
                                        mensajeServicio = "CrearTicketMasivo: Ciudad invalida: " + request.getCiudad();
                                        fechaRespuesta = formatter.format(new Date());
                                        logger.info("Region invalida");
                                    }

                                } else {

                                    respuesta = false;
                                    codigoRespuesta = "102";
                                    descripcionRespuesta = "CrearTicketMasivo: Region invalida: " + request.getRegion();
                                    mensajeServicio = "CrearTicketMasivo: Region invalida: " + request.getRegion();
                                    fechaRespuesta = formatter.format(new Date());
                                    logger.info("Region invalida");
                                }

                            } else {
                                respuesta = false;
                                codigoRespuesta = "102";
                                descripcionRespuesta = "CrearTicketMasivo: No se encontro grupo: " + request.getGrupo();
                                mensajeServicio = "CrearTicketMasivo: No se encontro grupo: " + request.getGrupo();
                                fechaRespuesta = formatter.format(new Date());
                                logger.info("Grupo invalido");
                            }

                        } else {
                            if (PersidIC != null || PersidS != null) {
                                respuesta = false;
                                codigoRespuesta = "102";
                                descripcionRespuesta = "CrearTicketCliente: No se encontro categoria: "
                                        + request.getCategoria();
                                mensajeServicio = "CrearTicketCliente: La categoria indicada no aplica para este metodo.";
                                fechaRespuesta = formatter.format(new Date());
                                logger.info("Categoria invalido");
                            } else {
                                respuesta = false;
                                codigoRespuesta = "102";
                                descripcionRespuesta = "CrearTicketMasivo: No se encontro categoria: "
                                        + request.getCategoria();
                                mensajeServicio = "CrearTicketMasivo: No se encontro categoria: "
                                        + request.getCategoria();
                                fechaRespuesta = formatter.format(new Date());
                                logger.info("Categoria invalido");
                            }
                        }

                    } else {
                        respuesta = false;
                        codigoRespuesta = "102";
                        descripcionRespuesta = "CrearTicketMasivo: Tipo invalido";
                        mensajeServicio = "CrearTicketMasivo: Tipo invalido";
                        fechaRespuesta = formatter.format(new Date());
                        logger.info("Tipo invalido");
                    }

                } else {
                    respuesta = false;
                    codigoRespuesta = "102";
                    descripcionRespuesta = "CrearTicketMasivo: Tenant no encontrado";
                    mensajeServicio = "CreateTicket: Tenant no encontrado";
                    fechaRespuesta = formatter.format(new Date());
                    logger.info("Tenant no encontrado");
                }

            } else {
                respuesta = false;
                codigoRespuesta = "102";
                descripcionRespuesta = "CrearTicketMasivo: Solicitante no encontrado";
                mensajeServicio = "CrearTicketMasivo: Solicitante no encontrado";
                fechaRespuesta = formatter.format(new Date());
                logger.info("Solicitante no encontrado");
            }

            JSONObject myObjectResponse = new JSONObject();

            myObjectResponse.put("respuesta", respuesta);
            myObjectResponse.put("codigoRespuesta", codigoRespuesta);
            myObjectResponse.put("descripcionRespuesta", descripcionRespuesta);
            myObjectResponse.put("mensajeServicio", mensajeServicio);
            myObjectResponse.put("fechaSolicitud", fechaSolicitud);
            myObjectResponse.put("fechaRespuesta", fechaRespuesta);
            myObjectResponse.put("tickets", tickets);

            System.out.print("JSON RESPONSE creacionTicket - masivo: " + myObjectResponse);

            String entradaOriginalResponse = myObjectResponse.toString();
            String cadenaCodificadaResponse = Base64.getEncoder().encodeToString(entradaOriginalResponse.getBytes());

            System.out.println("codificado registro de ticket - masivo: " + cadenaCodificadaResponse);

            bitacoraRepository.insertarBitacora(request.getNombreOperador(), request.getNumeroEmpleadoTPoperador(),
                    fechaSolicitud, "Respuesta de peticion a registro de ticket - masivo", "",
                    cadenaCodificadaResponse);

            boolean cerrado = logInValidator.closeToken(token);
            System.out.println("Se cierra sesion: " + cerrado);
            token = null;
        } catch (Exception e) {

            try {
                respuesta = false;
                codigoRespuesta = "102";
                descripcionRespuesta = e.toString();
                mensajeServicio = "Crear Ticket Masivo:: Ocurrio un error al crear ticket masivo. " + e;
                fechaRespuesta = formatter.format(new Date());
                logger.info("Error: " + e);

                JSONObject myObjectResponse = new JSONObject();

                myObjectResponse.put("respuesta", respuesta);
                myObjectResponse.put("codigoRespuesta", codigoRespuesta);
                myObjectResponse.put("descripcionRespuesta", descripcionRespuesta);
                myObjectResponse.put("mensajeServicio", mensajeServicio);
                myObjectResponse.put("fechaSolicitud", fechaSolicitud);
                myObjectResponse.put("fechaRespuesta", fechaRespuesta);
                myObjectResponse.put("tickets", tickets);

                System.out.print("JSON RESPONSE creacionTicket - masivo: " + myObjectResponse);

                String entradaOriginalResponse = myObjectResponse.toString();
                String cadenaCodificadaResponse = Base64.getEncoder().encodeToString(entradaOriginalResponse.getBytes());

                System.out.println("codificado registro de ticket - masivo: " + cadenaCodificadaResponse);

                bitacoraRepository.insertarBitacora(request.getNombreOperador(), request.getNumeroEmpleadoTPoperador(),
                        fechaSolicitud, "Respuesta de peticion a registro de ticket - masivo", "",
                        cadenaCodificadaResponse);
            } catch (JSONException ex) {
                java.util.logging.Logger.getLogger(TablerosManager.class.getName()).log(Level.SEVERE, null, ex);
            }

        } finally {
            try {
                if (token != null) {
                    logInValidator.closeToken(token);
                }
            } catch (RemoteException e) {
                logger.info("Error Ticket" + e);
            }
        }

        if (tickets.size() > 0) {
            return new TablerosTicketList(respuesta, codigoRespuesta, descripcionRespuesta, mensajeServicio,
                    fechaSolicitud, fechaRespuesta, tickets.get(0).getRefNum());
        } else {
            return new TablerosTicketList(respuesta, codigoRespuesta, descripcionRespuesta, mensajeServicio,
                    fechaSolicitud, fechaRespuesta, null);
        }
    }

    public TablerosTicketList crearSolicitud(CrearSolicitudRequest request) {

        ArrayList<CATicket> tickets = new ArrayList<CATicket>();
        Integer token = null;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        boolean respuesta = true;
        String codigoRespuesta = null;
        String descripcionRespuesta = null;
        String mensajeServicio = null;
        String fechaSolicitud = formatter.format(new Date());
        String fechaRespuesta = null;

        try {

            CATicketMapper mapper = new CATicketMapper();
            token = logInValidator.getToken();
            String userHandle = logInValidator.getUserHandle(token);
            String[] propertyValues = {};
            String[] attributes = {};

            logger.info("Va a generar solicitud");
            StringHolder newRequestHandle = new StringHolder();
            StringHolder newRequestNumber = new StringHolder();

            String requestByCriteria = TicketQueryBuilder.buildQuery("Integracion SF Dashboard Web", "userCreate"); // Busco
            String requestByXml = queryValidator.doSelect(token, "cnt", requestByCriteria, 1,
                    TicketDictionary.persistentIdParam);

            String requestBy = mapper.getValueByAttrName(requestByXml, TicketDictionary.persistentId);
            logger.info("Solicitado por: " + requestBy);

            String requestByCriteriaTenant = TicketQueryBuilder.buildQuery("TOTAL PLAY", "tenant"); // Busco
            // tenant
            String requestByXmlTenant = queryValidator.doSelect(token, "tenant", requestByCriteriaTenant, 1,
                    TicketDictionary.persistentIdParam);
            String tenantId = mapper.getValueByAttrName(requestByXmlTenant, TicketDictionary.id);
            logger.info("Tenant: " + tenantId);

            String type = TicketQueryBuilder.validateTicketType("R");
            logger.info("Tipo: " + type);

            List<Object> listCategoria = null;
            List<Object> listCategoriaIM = null;
            List<Object> listCategoriaIC = null;
            listCategoria = catCategoriasRepository.getCategoriesSolicitudesSingle(request.getCategoriaSolicitud());
            String Persid = null;

            for (Object obj : listCategoria) {
                Object[] objeto = (Object[]) obj;
                Persid = String.valueOf(objeto[1]);
            }

            // Busco categoría en IC
            listCategoriaIC = catCategoriasRepository.getCategoriesIncidentesSingle(request.getCategoriaSolicitud());
            String PersidIC = null;

            for (Object obj : listCategoriaIC) {
                Object[] objeto = (Object[]) obj;
                PersidIC = String.valueOf(objeto[1]);
            }
            // Busco categoría en IM
            listCategoriaIM = catCategoriasRepository
                    .getCategoriesIncidentesMasivosSingle(request.getCategoriaSolicitud());
            String PersidIM = null;

            for (Object obj : listCategoriaIM) {
                Object[] objeto = (Object[]) obj;
                PersidIM = String.valueOf(objeto[1]);
            }

            CatGruposModel grupo = gruposRepository.findByLastName(request.getGrupo());

            String requestByCriteriaGrupo = TicketQueryBuilder.buildQuery(request.getGrupo(), "group"); // Busco
            // Grupo
            String requestByXmlGrupo = queryValidator.doSelect(token, "cnt", requestByCriteriaGrupo, 1,
                    TicketDictionary.persistentIdParam);
            String grupoId = mapper.getValueByAttrName(requestByXmlGrupo, TicketDictionary.id);

            if (!requestBy.isEmpty()) {

                if (!tenantId.isEmpty()) {

                    if (!type.isEmpty()) {

                        if (Persid != null) {

                            String category = Persid;
                            logger.info("Categoria: " + category);

                            if (grupo != null) {
                                logger.info("Grupo: " + grupoId);

                                String[] argsCreate = null;
                                String[] array = new String[]{request.getDescripcionSolicitud() + "\n"
                                    + " Nombre del operador quien creo el ticket: " + request.getNombreOperador()
                                    + " Su numero de empleado: " + request.getNumeroEmpleadoTPoperador()};

                                argsCreate = new String[]{"requested_by", requestBy, // requestBy
                                    "customer", requestBy, // requestby
                                    "category", category, "summary", request.getDescripcionSolicitud(),
                                    "description", array[0], "type", type, "group", grupoId, "status", "WIP",
                                    "zfolio_dbw_sf", request.getFolioSF(), "zgrp_origen_sf", request.getBandejaRetornoSF()};

                                String xml = objValidator.createTicket(token, requestBy, argsCreate, propertyValues,
                                        attributes, newRequestHandle, newRequestNumber);

                                System.out.println();
                                tickets = mapper.mapUniqueTableros(xml);
                                logger.info("Se creo el ticket: " + tickets.get(0).getRefNum());

                                if (!tickets.get(0).getRefNum().isEmpty()) {

                                    JSONObject myObject = new JSONObject();

                                    myObject.put("nombreOperador", request.getNombreOperador());
                                    myObject.put("numeroEmpleadoTPoperador", request.getNumeroEmpleadoTPoperador());
                                    myObject.put("categoriaSolicitud", request.getCategoriaSolicitud());
                                    myObject.put("descripcionSolicitud", request.getDescripcionSolicitud());
                                    myObject.put("grupo", request.getGrupo());
                                    myObject.put("folioSF", request.getFolioSF());

                                    System.out.print("JSON REQUEST creacionSolicitud: " + myObject);

                                    String entradaOriginal = myObject.toString();
                                    String cadenaCodificada = Base64.getEncoder()
                                            .encodeToString(entradaOriginal.getBytes());

                                    System.out.println("codificado registro de solicitud: " + cadenaCodificada);

                                    bitacoraRepository.insertarBitacora(request.getNombreOperador(),
                                            request.getNumeroEmpleadoTPoperador(), fechaSolicitud,
                                            "Peticion a registro de solicitud", cadenaCodificada, "");

                                    respuesta = true;
                                    codigoRespuesta = "000";
                                    descripcionRespuesta = "CrearSolicitud: Exito al crear solicitud";
                                    mensajeServicio = "CrearSolicitud: Exito al crear solicitud";
                                    fechaRespuesta = formatter.format(new Date());

                                } else {

                                    respuesta = false;
                                    codigoRespuesta = "099";
                                    descripcionRespuesta = "099 - CrearSolicitud: Ocurrio un error al crear la solicitud";
                                    mensajeServicio = "099 - CrearSolicitud: Ocurrio un error al crear la solicitud";
                                    fechaRespuesta = formatter.format(new Date());
                                    logger.info("CrearSolicitud: Ocurrio un error al crear la solicitud");

                                }

                            } else {
                                respuesta = false;
                                codigoRespuesta = "102";
                                descripcionRespuesta = "102 - CrearSolicitud: No se encontro grupo: "
                                        + request.getGrupo();
                                mensajeServicio = "102 - CrearSolicitud: No se encontro grupo: " + request.getGrupo();
                                fechaRespuesta = formatter.format(new Date());
                                logger.info("Grupo invalido");
                            }

                        } else {
                            if (PersidIM != null || PersidIC != null) {
                                respuesta = false;
                                codigoRespuesta = "102";
                                descripcionRespuesta = "102 - CrearTicketCliente: No se encontro categoria: "
                                        + request.getCategoriaSolicitud();
                                mensajeServicio = "102 - CrearTicketCliente: La categoria indicada no aplica para este metodo.";
                                fechaRespuesta = formatter.format(new Date());
                                logger.info("Categoria invalido");
                            } else {
                                respuesta = false;
                                codigoRespuesta = "102";
                                descripcionRespuesta = "102 - CrearSolicitud: No se encontro categoria: "
                                        + request.getCategoriaSolicitud();
                                mensajeServicio = "102 - CrearSolicitud: No se encontro categoria: "
                                        + request.getCategoriaSolicitud();
                                fechaRespuesta = formatter.format(new Date());
                                logger.info("Categoria invalido");
                            }
                        }

                    } else {
                        respuesta = false;
                        codigoRespuesta = "102";
                        descripcionRespuesta = "102 - CrearSolicitud: Tipo invalido";
                        mensajeServicio = "102 - CrearSolicitud: Tipo invalido";
                        fechaRespuesta = formatter.format(new Date());
                        logger.info("Tipo invalido");
                    }

                } else {
                    respuesta = false;
                    codigoRespuesta = "102";
                    descripcionRespuesta = "102 - CrearSolicitud: Tenant no encontrado";
                    mensajeServicio = "102 - CreateTicket: Tenant no encontrado";
                    fechaRespuesta = formatter.format(new Date());
                    logger.info("Tenant no encontrado");
                }

            } else {
                respuesta = false;
                codigoRespuesta = "102";
                descripcionRespuesta = "102 - Solicitante no encontrado";
                mensajeServicio = "102 - Solicitante no encontrado";
                fechaRespuesta = formatter.format(new Date());
                logger.info("Solicitante no encontrado");
            }

            JSONObject myObjectResponse = new JSONObject();

            myObjectResponse.put("respuesta", respuesta);
            myObjectResponse.put("codigoRespuesta", codigoRespuesta);
            myObjectResponse.put("descripcionRespuesta", descripcionRespuesta);
            myObjectResponse.put("mensajeServicio", mensajeServicio);
            myObjectResponse.put("fechaSolicitud", fechaSolicitud);
            myObjectResponse.put("fechaRespuesta", fechaRespuesta);
            myObjectResponse.put("tickets", tickets);

            System.out.print("JSON RESPONSE creacionSolicitud: " + myObjectResponse);

            String entradaOriginalResponse = myObjectResponse.toString();
            String cadenaCodificadaResponse = Base64.getEncoder().encodeToString(entradaOriginalResponse.getBytes());

            System.out.println("codificado registro de solicitud: " + cadenaCodificadaResponse);

            bitacoraRepository.insertarBitacora(request.getNombreOperador(), request.getNumeroEmpleadoTPoperador(),
                    fechaSolicitud, "Respuesta de peticion a registro de solicitud", "", cadenaCodificadaResponse);

            boolean cerrado = logInValidator.closeToken(token);
            System.out.println("Se cierra sesion: " + cerrado);
            token = null;
        } catch (RemoteException e) {

            try {
                // Modificación 08/10/2021
                respuesta = false;
                codigoRespuesta = "150";
                descripcionRespuesta = "ERROR DE DUPLICACIÓN: SF ha solicitado la creación de ticket en SD con el mismo folio SF ya reportado en otro ticket.";
                logger.info("Simplificando la respuest...");
                logger.info("Error original .......: " + e.getMessage());
                String error = simplificarError(e.getMessage());
                logger.info("Error simplidicado: ...:" + error);
                mensajeServicio = "150 - " + error;
                fechaRespuesta = formatter.format(new Date());
                logger.info("Error: " + e);

                JSONObject myObjectResponse = new JSONObject();

                myObjectResponse.put("respuesta", respuesta);
                myObjectResponse.put("codigoRespuesta", codigoRespuesta);
                myObjectResponse.put("descripcionRespuesta", descripcionRespuesta);
                myObjectResponse.put("mensajeServicio", mensajeServicio);
                myObjectResponse.put("fechaSolicitud", fechaSolicitud);
                myObjectResponse.put("fechaRespuesta", fechaRespuesta);
                myObjectResponse.put("tickets", tickets);

                System.out.print("JSON RESPONSE creacionSolicitud: " + myObjectResponse);

                String entradaOriginalResponse = myObjectResponse.toString();
                String cadenaCodificadaResponse = Base64.getEncoder().encodeToString(entradaOriginalResponse.getBytes());

                System.out.println("codificado registro de solicitud: " + cadenaCodificadaResponse);

                bitacoraRepository.insertarBitacora(request.getNombreOperador(), request.getNumeroEmpleadoTPoperador(),
                        fechaSolicitud, "Respuesta de peticion a registro de solicitud", "", cadenaCodificadaResponse);
            } catch (JSONException ex) {
                java.util.logging.Logger.getLogger(TablerosManager.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (Exception e) {

            try {
                respuesta = false;
                codigoRespuesta = "102";
                descripcionRespuesta = "Crear Solicitud: Ocurrio un error al crear la solicitud.";
                mensajeServicio = "102 - " + e.toString();
                fechaRespuesta = formatter.format(new Date());
                logger.info("Error: " + e);

                JSONObject myObjectResponse = new JSONObject();

                myObjectResponse.put("respuesta", respuesta);
                myObjectResponse.put("codigoRespuesta", codigoRespuesta);
                myObjectResponse.put("descripcionRespuesta", descripcionRespuesta);
                myObjectResponse.put("mensajeServicio", mensajeServicio);
                myObjectResponse.put("fechaSolicitud", fechaSolicitud);
                myObjectResponse.put("fechaRespuesta", fechaRespuesta);
                myObjectResponse.put("tickets", tickets);

                System.out.print("JSON RESPONSE creacionSolicitud: " + myObjectResponse);

                String entradaOriginalResponse = myObjectResponse.toString();
                String cadenaCodificadaResponse = Base64.getEncoder().encodeToString(entradaOriginalResponse.getBytes());

                System.out.println("codificado registro de solicitud: " + cadenaCodificadaResponse);

                bitacoraRepository.insertarBitacora(request.getNombreOperador(), request.getNumeroEmpleadoTPoperador(),
                        fechaSolicitud, "Respuesta de peticion a registro de solicitud", "", cadenaCodificadaResponse);
            } catch (JSONException ex) {
                java.util.logging.Logger.getLogger(TablerosManager.class.getName()).log(Level.SEVERE, null, ex);
            }

        } finally {
            try {
                if (token != null) {
                    logInValidator.closeToken(token);
                }
            } catch (RemoteException e) {
                logger.info("Error solicitud" + e);
            }
        }

        if (tickets.size() > 0) {

            return new TablerosTicketList(respuesta, codigoRespuesta, descripcionRespuesta, mensajeServicio,
                    fechaSolicitud, fechaRespuesta, tickets.get(0).getRefNum());
        } else {
            return new TablerosTicketList(respuesta, codigoRespuesta, descripcionRespuesta, mensajeServicio,
                    fechaSolicitud, fechaRespuesta, null);
        }
    }

    public String simplificarError(String error) {
        String retorno = null;
        if (error != null && !error.isEmpty()) {
            retorno = error;
            // Se espera una cadena como la siguientes
            // NO AHD04199:Se ha producido un error inesperado. Póngase en contacto con su administrador. [Microsoft OLE DB Provider for SQL Server] [ SQL Code=50000 SQL State=42000] Folio de salesforce duplicado. AHD04199:Se ha producido un error inesperado. Póngase en contacto con su administrador. [Microsoft OLE DB Provider for SQL Server] [ SQL Code=50000 SQL State=42000] Folio de salesforce duplicado.
            
            // Buscamos la posición de 'AHD04199:Se ha producido un error inesperado'
            // empezando a buscar desde el indice a partir de la posicióm de 
            int indexFin = error.indexOf("AHD04199:Se ha producido un error inesperado", 10);
            if(indexFin > 10){
                retorno = retorno.substring(0, indexFin - 1);
            }
            
        }
        return retorno;
    }
    
    public static void main(String...params){
        TablerosManager tm = new TablerosManager();
        String error = "NO AHD04199:Se ha producido un error inesperado. Póngase en contacto con su administrador. [Microsoft OLE DB Provider for SQL Server] [ SQL Code=50000 SQL State=42000] Folio de salesforce duplicado. AHD04199:Se ha producido un error inesperado. Póngase en contacto con su administrador. [Microsoft OLE DB Provider for SQL Server] [ SQL Code=50000 SQL State=42000] Folio de salesforce duplicado.";
        System.out.println("Error completo .......: " + error);
        String errorSimplificado = tm.simplificarError(error);
        System.out.println("Error simplificado ...: " + errorSimplificado);
        
    }

    public TablerosResponse agregarComentario(AgregarComentarioRequest request) {

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

            String requestByTicket = TicketQueryBuilder.buildQuery(request.getTicketSD(), "refNum"); // Busco
            // por
            // ref
            // num
            // y
            // que
            // el
            // ticket
            // este
            // activo
            String requestByXmlTicket = queryValidator.doSelect(token, "cr", requestByTicket, 1,
                    TicketDictionary.ticketParam);
            String ticket = mapper.getValueByAttrName(requestByXmlTicket, TicketDictionary.persistentId);
            logger.info("ticket Persid:" + ticket);

            // List<SdmCallReqModel> ticket =
            // sdmCallReqRepository.findByRefNum(request.getTicketSD());
            if (ticket != null && !ticket.isEmpty()) {

                String requestByCriteria = TicketQueryBuilder.buildQuery("Integracion SF Dashboard Web", "userCreate");
                String requestByXml = queryValidator.doSelect(token, "cnt", requestByCriteria, 1,
                        TicketDictionary.persistentIdParam);
                String creator = mapper.getValueByAttrName(requestByXml, TicketDictionary.persistentId);

                // String objectHandle = ticket.get(0).getPersid();
                String description = request.getComentario() + "\n" + " Nombre del operador quien agrego comentario: "
                        + request.getNombreOperador() + " Su numero de empleado: "
                        + request.getNumeroEmpleadoTPoperador();
                String logType = "LOG";
                int timeSpent = 0;
                boolean internal = false;

                String respuestaWS = objValidator.addComment(token, creator, ticket, description, logType, timeSpent,
                        internal);
                String idComment = mapper.maperComment(respuestaWS);

                if (!idComment.isEmpty()) {

                    JSONObject myObject = new JSONObject();

                    myObject.put("nombreOperador", request.getNombreOperador());
                    myObject.put("numeroEmpleadoTPoperador", request.getNumeroEmpleadoTPoperador());
                    myObject.put("ticketSD", request.getTicketSD());
                    myObject.put("comentario", request.getComentario());
                    System.out.print("JSON REQUEST agregarComentario: " + myObject);

                    String entradaOriginal = myObject.toString();
                    String cadenaCodificada = Base64.getEncoder().encodeToString(entradaOriginal.getBytes());
                    System.out.println("codificado agregarComentario: " + cadenaCodificada);

                    bitacoraRepository.insertarBitacora(request.getNombreOperador(),
                            request.getNumeroEmpleadoTPoperador(), fechaSolicitud, "Peticion agregar comentario",
                            cadenaCodificada, "");

                    fechaRespuesta = formatter.format(new Date());
                    codigoRespuesta = "000";
                    descripcionRespuesta = "Agregar comentario: Se agrego comentario al ticket: "
                            + request.getTicketSD() + " ,el id del comentario: " + idComment;
                    mensajeServicio = "Crear comentario: El idComentario : " + idComment;
                    logger.info("Agregar comentario: Se agrego comentario al ticket " + request.getTicketSD()
                            + "El id del comentario: " + idComment);
                }
            } else {

                respuesta = false;
                fechaRespuesta = formatter.format(new Date());
                codigoRespuesta = "300";
                descripcionRespuesta = "Agregar comentario: Ticket no encontrado.";
                mensajeServicio = descripcionRespuesta;
                JSONObject myObjectResponse = new JSONObject();

                myObjectResponse.put("respuesta", respuesta);
                myObjectResponse.put("codigoRespuesta", codigoRespuesta);
                myObjectResponse.put("descripcionRespuesta", descripcionRespuesta);
                myObjectResponse.put("mensajeServicio", mensajeServicio);
                myObjectResponse.put("fechaSolicitud", fechaSolicitud);
                myObjectResponse.put("fechaRespuesta", fechaRespuesta);

                System.out.print("JSON RESPONSE agregarComentario: " + myObjectResponse);

                String entradaOriginalResponse = myObjectResponse.toString();
                String cadenaCodificadaResponse = Base64.getEncoder()
                        .encodeToString(entradaOriginalResponse.getBytes());

                System.out.println("codificado agregarComentario: " + cadenaCodificadaResponse);

                bitacoraRepository.insertarBitacora(request.getNombreOperador(), request.getNumeroEmpleadoTPoperador(),
                        fechaSolicitud, "Respuesta de peticion agregar comentario", "", cadenaCodificadaResponse);

            }

            logInValidator.closeToken(token);
        } catch (Exception e) {
            try {
                respuesta = false;
                fechaRespuesta = formatter.format(new Date());
                codigoRespuesta = "102";
                descripcionRespuesta = "Agregar comentario: Ocurrio un error al agregar comentario.";
                mensajeServicio = e.toString();

                JSONObject myObjectResponse = new JSONObject();

                myObjectResponse.put("respuesta", respuesta);
                myObjectResponse.put("codigoRespuesta", codigoRespuesta);
                myObjectResponse.put("descripcionRespuesta", descripcionRespuesta);
                myObjectResponse.put("mensajeServicio", mensajeServicio);
                myObjectResponse.put("fechaSolicitud", fechaSolicitud);
                myObjectResponse.put("fechaRespuesta", fechaRespuesta);
                System.out.print("JSON RESPONSE agregarComentario: " + myObjectResponse);

                String entradaOriginalResponse = myObjectResponse.toString();
                String cadenaCodificadaResponse = Base64.getEncoder().encodeToString(entradaOriginalResponse.getBytes());
                System.out.println("codificado agregarComentario: " + cadenaCodificadaResponse);

                bitacoraRepository.insertarBitacora(request.getNombreOperador(), request.getNumeroEmpleadoTPoperador(),
                        fechaSolicitud, "Respuesta de peticion agregar comentario", "", cadenaCodificadaResponse);
            } catch (JSONException ex) {
                java.util.logging.Logger.getLogger(TablerosManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                if (token != null) {
                    logInValidator.closeToken(token);
                }
            } catch (RemoteException x) {
                logger.info("Error solicitud" + x);
            }
        }
        return new TablerosResponse(respuesta, codigoRespuesta, descripcionRespuesta, mensajeServicio, fechaSolicitud,
                fechaRespuesta, null);
    }

    public TCategoriasList consultarCategorias(ConsultarCategoriasRequest request) {
        ArrayList<TCategorias> categorias = null;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Boolean respuesta = true;
        String codigoRespuesta = null;
        String descripcionRespuesta = null;
        String descripcionRespuestaServicio = null;
        String fechaSolicitud = formatter.format(new Date());
        String fechaRespuesta = null;

        try {

            categorias = new ArrayList<TCategorias>();
            List<Object> listCategoria = null;
            String datoBusqueda = null;

            if (!request.getTextoConsultaCategoria().equals("")) {
                datoBusqueda = request.getTextoConsultaCategoria();
                System.out.println("<<<<<Dato Busqueda PRIMER NIVEL>>>>>: " + datoBusqueda);
            }

            System.out.println("<<<<<Dato Busqueda>>>>>: " + datoBusqueda);

            if (request.getTipoCategoria().equals("IC")) {
                listCategoria = catCategoriasRepository.getCategoriesIncidentes(datoBusqueda);
                System.out.println("<<<<<LISTA CATEGORIAS DE INCIDENTES>>>>>: " + listCategoria.size());

            } else if (request.getTipoCategoria().equals("IM")) {
                listCategoria = catCategoriasRepository.getCategoriesIncidentesMasivos(datoBusqueda);
                System.out.println("<<<<<LISTA CATEGORIAS DE INCIDENTES MASIVOS>>>>>: " + listCategoria.size());

            } else if (request.getTipoCategoria().equals("S")) {
                listCategoria = catCategoriasRepository.getCategoriesSolicitudes(datoBusqueda);
                System.out.println("<<<<<LISTA CATEGORIAS DE SOLICITUDES>>>>>: " + listCategoria.size());
            }

            if (!listCategoria.isEmpty()) {
                fechaRespuesta = formatter.format(new Date());
                codigoRespuesta = "000";
                descripcionRespuesta = "Categorias encontradas";
                descripcionRespuestaServicio = "Se encontraron las siguientes categorias de acuerdo al criterio de consulta.";
                for (Object obj : listCategoria) {
                    TCategorias tc = new TCategorias();
                    Object[] objeto = (Object[]) obj;

                    String sym = String.valueOf(objeto[2]);

                    tc.setDescripcion(sym);
                    categorias.add(tc);
                }

                JSONObject myObject = new JSONObject();

                myObject.put("nombreOperador", request.getNombreOperador());
                myObject.put("numeroEmpleadoTPoperador", request.getNumeroEmpleadoTPoperador());
                myObject.put("tipoCategoria", request.getTipoCategoria());
                myObject.put("textoPrimerNivel", request.getTextoConsultaCategoria());
                myObject.put("textoSegundoNivel", request.getTextoSegundoNivel());
                myObject.put("textoTercerNivel", request.getTextoTercerNivel());

                System.out.print("JSON REQUEST categorias: " + myObject);

                String entradaOriginal = myObject.toString();
                String cadenaCodificada = Base64.getEncoder().encodeToString(entradaOriginal.getBytes());

                System.out.println("codificado CATEGORIAS: " + cadenaCodificada);

                bitacoraRepository.insertarBitacora(request.getNombreOperador(), request.getNumeroEmpleadoTPoperador(),
                        fechaSolicitud, "Peticion a consulta de categorias", cadenaCodificada, "");

            }

        } catch (Exception e) {
            respuesta = false;
            fechaRespuesta = formatter.format(new Date());
            codigoRespuesta = "102";
            descripcionRespuesta = "Categoria:Ocurrio un error al consultar las categorias. " + e.toString();
            descripcionRespuestaServicio = e.toString();
        }

        if (categorias != null && categorias.size() > 0) {
            return new TCategoriasList(respuesta, codigoRespuesta, descripcionRespuesta, descripcionRespuestaServicio,
                    fechaSolicitud, fechaRespuesta, categorias, categorias.size());
        } else {
            fechaRespuesta = formatter.format(new Date());
            respuesta = false;
            codigoRespuesta = "300";
            descripcionRespuesta = "Categoria: Ocurrio un error al consultar las categorias.";
            descripcionRespuestaServicio = "No se encontraron categorias de acuerdo al criterio de busqueda";
            return new TCategoriasList(respuesta, codigoRespuesta, descripcionRespuesta, descripcionRespuestaServicio,
                    fechaSolicitud, fechaRespuesta, 0);
        }
    }

    public TGruposList consultarGrupos(ConsultarGruposRequest request) {
        ArrayList<TGrupos> grupos = null;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Boolean respuesta = true;
        String codigoRespuesta = null;
        String descripcionRespuesta = null;
        String fechaSolicitud = formatter.format(new Date());
        String fechaRespuesta = null;
        String mensajeServicio = null;

        try {
            grupos = new ArrayList<TGrupos>();
            List<Object> listGrupos = null;

            String datoBusqueda = null;

            datoBusqueda = request.getTextoConsultaGrupo();

            System.out.println("<<<<<datoBusqueda GRUPOS>>>>>: " + datoBusqueda);

            listGrupos = gruposRepository.getGrupos(datoBusqueda);
            System.out.println("<<<<<LISTA GRUPOS>>>>>: " + listGrupos.size());

            if (!listGrupos.isEmpty()) {
                fechaRespuesta = formatter.format(new Date());
                codigoRespuesta = "000";
                descripcionRespuesta = "Grupos encontrados";
                mensajeServicio = descripcionRespuesta;
                for (Object obj : listGrupos) {
                    TGrupos tg = new TGrupos();
                    Object[] objeto = (Object[]) obj;

                    String lastName = String.valueOf(objeto[1]);

                    tg.setDescripcion(lastName);
                    grupos.add(tg);

                }

                JSONObject myObject = new JSONObject();

                myObject.put("nombreSolicitante", request.getNombreSolicitante());
                myObject.put("numeroEmpleadoTPSolicitante", request.getNumeroEmpleadoTPSolicitante());
                myObject.put("textoConsultaGrupo", request.getTextoConsultaGrupo());

                System.out.print("JSON REQUEST grupos: " + myObject);

                String entradaOriginal = myObject.toString();
                String cadenaCodificada = Base64.getEncoder().encodeToString(entradaOriginal.getBytes());

                System.out.println("codificado GRUPOS: " + cadenaCodificada);

                bitacoraRepository.insertarBitacora(request.getNombreSolicitante(),
                        request.getNumeroEmpleadoTPSolicitante(), fechaSolicitud, "Peticion a consulta de grupos",
                        cadenaCodificada, "");
            }
        } catch (Exception e) {
            respuesta = false;
            fechaRespuesta = formatter.format(new Date());
            codigoRespuesta = "102";
            descripcionRespuesta = "Grupos:Ocurrio un error al consultar los grupos.";
            mensajeServicio = e.toString();
        }

        if (grupos != null) {
            return new TGruposList(respuesta, codigoRespuesta, descripcionRespuesta, mensajeServicio, fechaSolicitud,
                    fechaRespuesta, grupos, grupos.size());
        } else {
            fechaRespuesta = formatter.format(new Date());
            respuesta = false;
            codigoRespuesta = "300";
            descripcionRespuesta = "Grupos:Ocurrio un error al consultar los grupos.";
            mensajeServicio = descripcionRespuesta;
            return new TGruposList(respuesta, codigoRespuesta, descripcionRespuesta, mensajeServicio, fechaSolicitud,
                    fechaRespuesta, 0);
        }
    }

    public TCiudadesList consultarCiudades(ConsultarCiudadesRequest request) {
        ArrayList<TCiudades> ciudades = null;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Boolean respuesta = true;
        String codigoRespuesta = null;
        String descripcionRespuesta = null;
        String fechaSolicitud = formatter.format(new Date());
        String fechaRespuesta = null;
        String mensajeServicio = null;
        CatRegionesModel ciudadesmodel = new CatRegionesModel();

        try {
            ciudades = new ArrayList<TCiudades>();
            List<Object> listCiudades = null;
            // String datoBusqueda = null;
            // datoBusqueda = "%" + request.getRegionConsulta() + "%";
            // logger.info("<<<<<datoBusqueda CIUDADES>>>>>: " + datoBusqueda);

            ciudadesmodel = regionesRepository.findBySymAndDeleteFlag(request.getRegionConsulta(), 0);

            if (ciudadesmodel != null && !ciudadesmodel.equals("")) {

                listCiudades = regionesRepository.getCiudades(String.valueOf(ciudadesmodel.getId()));
                logger.info("<<<<<LISTA CIUDADES>>>>>: " + listCiudades.size());

                if (!listCiudades.isEmpty()) {
                    fechaRespuesta = formatter.format(new Date());
                    codigoRespuesta = "000";
                    descripcionRespuesta = "Ciudades encontradas";
                    for (Object obj : listCiudades) {
                        TCiudades tc = new TCiudades();
                        Object[] objeto = (Object[]) obj;

                        String sym = String.valueOf(objeto[1]);
                        logger.info("<<<<<SYM CIUDAD>>>>>: " + sym);

                        tc.setDescripcion(sym);
                        ciudades.add(tc);

                    }

                    JSONObject myObject = new JSONObject();

                    myObject.put("nombreSolicitante", request.getNombreSolicitante());
                    myObject.put("numeroEmpleadoTPSolicitante", request.getNumeroEmpleadoTPSolicitante());
                    myObject.put("regionConsulta", request.getRegionConsulta());

                    System.out.print("JSON REQUEST ciudades: " + myObject);

                    String entradaOriginal = myObject.toString();
                    String cadenaCodificada = Base64.getEncoder().encodeToString(entradaOriginal.getBytes());

                    System.out.println("codificado CIUDADES: " + cadenaCodificada);

                    bitacoraRepository.insertarBitacora(request.getNombreSolicitante(),
                            request.getNumeroEmpleadoTPSolicitante(), fechaSolicitud, "Peticion a consulta de ciudades",
                            cadenaCodificada, "");
                } else {

                    respuesta = false;
                    codigoRespuesta = "102";
                    descripcionRespuesta = "ConsultarCiudades: No se encontraron ciudades para la region: "
                            + request.getRegionConsulta();
                    mensajeServicio = "ConsultarCiudades: No se encontraron ciudades para la region: "
                            + request.getRegionConsulta();
                    fechaRespuesta = formatter.format(new Date());
                    logger.info("Region invalida");
// 
                }

            } else {

                respuesta = false;
                codigoRespuesta = "102";
                descripcionRespuesta = "ConsultarCiudades: Region invalida: " + request.getRegionConsulta();
                mensajeServicio = "ConsultarCiudades: Region invalida: " + request.getRegionConsulta();
                fechaRespuesta = formatter.format(new Date());
                logger.info("Region invalida");

            }

        } catch (Exception e) {
            respuesta = false;
            fechaRespuesta = formatter.format(new Date());
            codigoRespuesta = "102";
            descripcionRespuesta = "Ciudades:Ocurrio un error al consultar las ciudades. " + e.toString();

        }

        if (ciudades != null) {
            mensajeServicio = descripcionRespuesta;
            return new TCiudadesList(respuesta, codigoRespuesta, mensajeServicio, descripcionRespuesta, fechaSolicitud,
                    fechaRespuesta, ciudades, ciudades.size());
        } else {
            fechaRespuesta = formatter.format(new Date());
            respuesta = false;
            codigoRespuesta = "300";
            descripcionRespuesta = "Ciudades:Ocurrio un error al consultar las ciudades.";
            mensajeServicio = descripcionRespuesta;
            return new TCiudadesList(respuesta, codigoRespuesta, descripcionRespuesta, mensajeServicio, fechaSolicitud,
                    fechaRespuesta, 0);
        }
    }

    public TablerosResponse actualizaEstatus(ActualizarEstatusRequest request) {

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

        try {

            logger.info("Se recibio el estatus: " + request.getNuevoEstatus() + ". El solicitante:"
                    + request.getNombreOperador());

            token = logInValidator.getToken();
            String userHandle = logInValidator.getUserHandle(token);

            CATicketMapper mapper = new CATicketMapper();

            String requestByCriteriaRequestBy = TicketQueryBuilder.buildQuery("Integracion SF Dashboard Web",
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

            int i;

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

                String entradaOriginalResponse = myObjectResponse.toString();
                String cadenaCodificadaResponse = Base64.getEncoder()
                        .encodeToString(entradaOriginalResponse.getBytes());
                System.out.println("codificado actualizarEstatus: " + cadenaCodificadaResponse);

                bitacoraRepository.insertarBitacora(request.getNombreOperador(), request.getNumeroEmpleadoTPoperador(),
                        fechaSolicitud, "Respuesta de peticion actualizar estatus", "", cadenaCodificadaResponse);

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

                        String entradaOriginal = myObject.toString();
                        String cadenaCodificada = Base64.getEncoder().encodeToString(entradaOriginal.getBytes());
                        System.out.println("codificado actualizaEstatus: " + cadenaCodificada);

                        bitacoraRepository.insertarBitacora(request.getNombreOperador(),
                                request.getNumeroEmpleadoTPoperador(), fechaSolicitud, "Peticion agregar comentario",
                                cadenaCodificada, "");

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

            try {
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

                String entradaOriginalResponse = myObjectResponse.toString();
                String cadenaCodificadaResponse = Base64.getEncoder().encodeToString(entradaOriginalResponse.getBytes());
                System.out.println("codificado actualizaEstatus: " + cadenaCodificadaResponse);

                bitacoraRepository.insertarBitacora(request.getNombreOperador(), request.getNumeroEmpleadoTPoperador(),
                        fechaSolicitud, "Respuesta de peticion actualizar estatus", "", cadenaCodificadaResponse);
            } catch (JSONException ex) {
                java.util.logging.Logger.getLogger(TablerosManager.class.getName()).log(Level.SEVERE, null, ex);
            }

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
        return new TablerosResponse(respuesta, codigoRespuesta, descripcionRespuesta, mensajeServicio, fechaSolicitud,
                fechaRespuesta, null);
    }

    public TAdjuntarArchivoResponse adjuntarArchivo(AdjuntarArchivoRequest request) {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        boolean respuesta = true;
        String codigoRespuesta = null;
        String descripcionRespuesta = null;
        String mensajeServicio = null;
        String fechaSolicitud = formatter.format(new Date());
        String fechaRespuesta = null;

        TAdjuntarArchivoResponse response = new TAdjuntarArchivoResponse();

        try {

            JSONObject myObject = new JSONObject();

            myObject.put("nombreOperador", request.getNombreOperador());
            myObject.put("numeroEmpleadoTPoperador", request.getNumeroEmpleadoTPoperador());
            myObject.put("ticketSD", request.getTicketSD());
            myObject.put("folioSF", request.getFolioSF());
            myObject.put("nombreArchivo", request.getNombreArchivo());
            myObject.put("archivo", request.getArchivo());

            System.out.print("JSON REQUEST adjuntarArchivo: " + myObject);

            String entradaOriginal = myObject.toString();
            String cadenaCodificada = Base64.getEncoder().encodeToString(entradaOriginal.getBytes());

            System.out.println("codificado adjuntarArchivo: " + cadenaCodificada);

            bitacoraRepository.insertarBitacora(request.getNombreOperador(), request.getNumeroEmpleadoTPoperador(),
                    fechaSolicitud, "Peticion adjuntarArchivo", cadenaCodificada, "");

            response = serviceArchivoSD.adjuntarArchivoSD(request);

            if (response.isRespuestaBoolean() == true) {

                respuesta = true;
                codigoRespuesta = "000";
                descripcionRespuesta = "AdjuntarArchivo: Exito al adjuntar archivo a ticket";
                mensajeServicio = response.getMensajeServicio();
                fechaRespuesta = formatter.format(new Date());

                JSONObject myObjectResponse = new JSONObject();

                myObjectResponse.put("respuesta", respuesta);
                myObjectResponse.put("codigoRespuesta", codigoRespuesta);
                myObjectResponse.put("descripcionRespuesta", descripcionRespuesta);
                myObjectResponse.put("mensajeServicio", response.getMensajeServicio());
                myObjectResponse.put("fechaSolicitud", fechaSolicitud);
                myObjectResponse.put("fechaRespuesta", fechaRespuesta);
                System.out.print("JSON RESPONSE AdjuntarArchivo: " + myObjectResponse);

                String entradaOriginalResponse = myObjectResponse.toString();
                String cadenaCodificadaResponse = Base64.getEncoder()
                        .encodeToString(entradaOriginalResponse.getBytes());

                bitacoraRepository.insertarBitacora(request.getNombreOperador(), request.getNumeroEmpleadoTPoperador(),
                        fechaSolicitud, "Respuesta de peticion de adjuntarArchivo", "", cadenaCodificadaResponse);

            } else {
                respuesta = false;
                codigoRespuesta = "300";
                descripcionRespuesta = "300 - AdjuntarArchivo: Ocurrio un error al adjuntar archivo: "
                        + response.getDescripcionRespuesta();
                mensajeServicio = "300 - AdjuntarArchivo: Ocurrio un error al adjuntar archivo: "
                        + response.getMensajeServicio();
                fechaRespuesta = formatter.format(new Date());
                logger.info("AdjuntarArchivo: Ocurrio un error al adjuntar archivo");
            }

        } catch (Exception e) {
            try {
                respuesta = false;
                fechaRespuesta = formatter.format(new Date());
                codigoRespuesta = "102";
                descripcionRespuesta = "AdjuntarArchivo: Ocurrio un error al adjuntar archivo.";
                mensajeServicio = e.toString();

                JSONObject myObjectResponse = new JSONObject();

                myObjectResponse.put("respuesta", respuesta);
                myObjectResponse.put("codigoRespuesta", codigoRespuesta);
                myObjectResponse.put("descripcionRespuesta", descripcionRespuesta);
                myObjectResponse.put("mensajeServicio", mensajeServicio);
                myObjectResponse.put("fechaSolicitud", fechaSolicitud);
                myObjectResponse.put("fechaRespuesta", fechaRespuesta);
                System.out.print("JSON RESPONSE adjuntarArchivo: " + myObjectResponse);

                String entradaOriginalResponse = myObjectResponse.toString();
                String cadenaCodificadaResponse = Base64.getEncoder().encodeToString(entradaOriginalResponse.getBytes());
                System.out.println("codificado adjuntarArchivo: " + cadenaCodificadaResponse);

                bitacoraRepository.insertarBitacora(request.getNombreOperador(), request.getNumeroEmpleadoTPoperador(),
                        fechaSolicitud, "Respuesta de peticion adjuntarArchivo", "", cadenaCodificadaResponse);
            } catch (JSONException ex) {
                java.util.logging.Logger.getLogger(TablerosManager.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        if (response.getFolioDocumento() != null && !response.getFolioDocumento().isEmpty()) {
            return new TAdjuntarArchivoResponse(respuesta, codigoRespuesta, descripcionRespuesta, mensajeServicio,
                    fechaSolicitud, fechaRespuesta, response.getFolioDocumento());
        } else {
            return new TAdjuntarArchivoResponse(respuesta, codigoRespuesta, descripcionRespuesta, mensajeServicio,
                    fechaSolicitud, fechaRespuesta, null);
        }

    }

    public TTransferenciaGrupoResponse transferenciaGrupo(TransferenciaGrupoRequest request) {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        boolean respuesta = true;
        String codigoRespuesta = null;
        String descripcionRespuesta = null;
        String mensajeServicio = null;
        String fechaSolicitud = formatter.format(new Date());
        String fechaRespuesta = null;

        TTransferenciaGrupoResponse response = new TTransferenciaGrupoResponse();

        try {

            JSONObject myObject = new JSONObject();

            myObject.put("nombreOperador", request.getNombreOperador());
            myObject.put("numeroEmpleadoTPoperador", request.getNumeroEmpleadoTPoperador());
            myObject.put("ticketSD", request.getTicketSD());
            myObject.put("folioSF", request.getFolioSF());
            myObject.put("grupo", request.getGrupo());
            myObject.put("justificacion", request.getJustificacion());

            System.out.print("JSON REQUEST transferenciaGrupo: " + myObject);

            String entradaOriginal = myObject.toString();
            String cadenaCodificada = Base64.getEncoder().encodeToString(entradaOriginal.getBytes());

            System.out.println("codificado transferenciaGrupo: " + cadenaCodificada);

            bitacoraRepository.insertarBitacora(request.getNombreOperador(), request.getNumeroEmpleadoTPoperador(),
                    fechaSolicitud, "Peticion transferencia de grupo a ticketSD", cadenaCodificada, "");

            response = serviceArchivoSD.transferenciaGrupoSD(request);

            if (response.isRespuestaBoolean() == true) {

                respuesta = true;
                codigoRespuesta = "000";
                descripcionRespuesta = "TransferenciaGrupo: Exito al transferir de grupo a ticket";
                mensajeServicio = response.getMensajeServicio();
                fechaRespuesta = formatter.format(new Date());

                JSONObject myObjectResponse = new JSONObject();

                myObjectResponse.put("respuesta", respuesta);
                myObjectResponse.put("codigoRespuesta", codigoRespuesta);
                myObjectResponse.put("descripcionRespuesta", descripcionRespuesta);
                myObjectResponse.put("mensajeServicio", response.getMensajeServicio());
                myObjectResponse.put("fechaSolicitud", fechaSolicitud);
                myObjectResponse.put("fechaRespuesta", fechaRespuesta);
                System.out.print("JSON RESPONSE transfereciaGrupo: " + myObjectResponse);

                String entradaOriginalResponse = myObjectResponse.toString();
                String cadenaCodificadaResponse = Base64.getEncoder()
                        .encodeToString(entradaOriginalResponse.getBytes());

                bitacoraRepository.insertarBitacora(request.getNombreOperador(), request.getNumeroEmpleadoTPoperador(),
                        fechaSolicitud, "Respuesta de peticion a transferencia de grupo", "", cadenaCodificadaResponse);

            } else {
                respuesta = false;
                codigoRespuesta = "300";
                descripcionRespuesta = "300 - TransferenciaGrupo: Ocurrio un error al transferir el ticket: "
                        + response.getDescripcionRespuesta();
                mensajeServicio = "300 - TransferenciaGrupo: Ocurrio un error al transferir el ticket: "
                        + response.getMensajeServicio();
                fechaRespuesta = formatter.format(new Date());
                logger.info("TransferenciaGrupo: Ocurrio un error al transferir el ticket");
            }

        } catch (Exception e) {

            try {
                respuesta = false;
                fechaRespuesta = formatter.format(new Date());
                codigoRespuesta = "102";
                descripcionRespuesta = e.toString();
                mensajeServicio = "TransfereciaGrupo: Ocurrio un error en transfereciaGrupo, para el ticket: "
                        + request.getTicketSD() + ".";
                JSONObject myObjectResponse = new JSONObject();

                myObjectResponse.put("respuesta", respuesta);
                myObjectResponse.put("codigoRespuesta", codigoRespuesta);
                myObjectResponse.put("descripcionRespuesta", descripcionRespuesta);
                myObjectResponse.put("mensajeServicio", mensajeServicio);
                myObjectResponse.put("fechaSolicitud", fechaSolicitud);
                myObjectResponse.put("fechaRespuesta", fechaRespuesta);
                System.out.print("JSON RESPONSE transfereciaGrupo: " + myObjectResponse);

                String entradaOriginalResponse = myObjectResponse.toString();
                String cadenaCodificadaResponse = Base64.getEncoder().encodeToString(entradaOriginalResponse.getBytes());
                System.out.println("codificado transfereciaGrupo: " + cadenaCodificadaResponse);

                bitacoraRepository.insertarBitacora(request.getNombreOperador(), request.getNumeroEmpleadoTPoperador(),
                        fechaSolicitud, "Respuesta de peticion a transferencia de grupo", "", cadenaCodificadaResponse);
            } catch (JSONException ex) {
                java.util.logging.Logger.getLogger(TablerosManager.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        return new TTransferenciaGrupoResponse(respuesta, codigoRespuesta, descripcionRespuesta, mensajeServicio,
                fechaSolicitud, fechaRespuesta);
    }

}
