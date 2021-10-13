package com.enlacetpe.ticketapi.service.CMDB;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.joda.time.DateTime;
import org.joda.time.Period;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enlacetpe.ticketapi.caManager.serviceDesk.CALogInValidator;
import com.enlacetpe.ticketapi.caManager.serviceDesk.CAQueryValidator;
import com.enlacetpe.ticketapi.caMapper.serviceDesk.CATicketMapper;
import com.enlacetpe.ticketapi.caQueryBuilder.TicketQueryBuilder;
import com.enlacetpe.ticketapi.dictionary.TicketDictionary;
import com.enlacetpe.ticketapi.model.SdmBusmgtModel;
import com.enlacetpe.ticketapi.model.SdmCaOwnedResourceModel;
import com.enlacetpe.ticketapi.model.SdmCaResourceFamilyModel;
import com.enlacetpe.ticketapi.modelTicketApiSD.CatFamiliaClasesModel;
import com.enlacetpe.ticketapi.repository.SdmBusmgtRepository;
import com.enlacetpe.ticketapi.repository.SdmCaOwnedResourceRepository;
import com.enlacetpe.ticketapi.repository.SdmCaResourceFamiliyRepositiory;
import com.enlacetpe.ticketapi.repository.SdmCallReqRepository;
import com.enlacetpe.ticketapi.repositoryTicketApiSD.CatFamiliaClasesRepository;
import com.enlacetpe.ticketapi.request.DeviceAndAlarm;
import com.enlacetpe.ticketapi.request.StatusRequestByRequest;
import com.enlacetpe.ticketapi.request.StatusOrganizationRequest;
import com.enlacetpe.ticketapi.request.TicketGroupRequest;
import com.enlacetpe.ticketapi.request.TicketIpRequest;
import com.enlacetpe.ticketapi.request.TicketOrganizationRequest;
import com.enlacetpe.ticketapi.request.TicketRefNumRequest;
import com.enlacetpe.ticketapi.response.CAStatus;
import com.enlacetpe.ticketapi.response.CATicket;
import com.enlacetpe.ticketapi.response.CATicketByNameCI;
import com.enlacetpe.ticketapi.response.CATicketByNameCIList;
import com.enlacetpe.ticketapi.response.CATicketList;

@Service
public class TicketManager {

	@Autowired
	private SdmCallReqRepository sdmCallReqRepository;

	@Autowired
	private SdmCaOwnedResourceRepository sdmCaOwnedResourceRepository;

	@Autowired
	private SdmBusmgtRepository sdmBusmgtRepository;

	@PersistenceContext
	protected EntityManager entityManager;

	@Autowired
	private CALogInValidator logInValidator;

	@Autowired
	private CAQueryValidator queryValidator;

	@Autowired
	private SdmCaResourceFamiliyRepositiory sdmCaResourceFamiliyRepositiory;

	@Autowired
	private CatFamiliaClasesRepository catFamiliaClasesRepository;

	@SuppressWarnings("unused")
	public CATicketList getTicket(String option, Object value) {
		DateTime initial = new DateTime();
		ArrayList<CATicket> tickets = null;
		Boolean success = true;
		String error = "";
		String mssg = "";
		List<Object> listaTickets = null;
		String clase = null;
		try {
			if (option.equalsIgnoreCase("refnum")) {
				TicketRefNumRequest request = (TicketRefNumRequest) value;
				List<Object> refNum = sdmCallReqRepository.getRefNum(request.getRefNum());
				if (refNum != null && !refNum.isEmpty()) {
					tickets = mapper(refNum, "", "");
				} else {
					mssg = "refNum:El Ticket proporcionado no existe";
				}
			} else if (option.equalsIgnoreCase("ActiveCMDB")) {
				TicketOrganizationRequest request = (TicketOrganizationRequest) value;
				List<String> hijos = new ArrayList<String>();

				List<Object> familia = catFamiliaClasesRepository.getFamiliaClase();

				for (Object obj : familia) {
					Object[] objeto = (Object[]) obj;
					clase = String.valueOf(objeto[1]);

					System.out.println("Clase familia: " + clase);
				}

				SdmCaResourceFamilyModel idService = sdmCaResourceFamiliyRepositiory.findByNameAndInactive(clase, 0);
				if (idService != null) {
					System.out.println("ID servicio: " + idService.getId());
					SdmCaOwnedResourceModel padre = sdmCaOwnedResourceRepository
							.findByResourceNameAndResourceFamilyAndInactive(request.getOrganization().trim(),
									idService.getId(), 0);
					System.out.println(padre.getOwnResourceUuid());
					if (padre != null) {
						if (padre.getInactive() != null && padre.getInactive() == 0) {
							List<SdmBusmgtModel> listaHijos = sdmBusmgtRepository
									.findByHierParent(padre.getOwnResourceUuid());
							System.out.println("Tamaño de la lista " + listaHijos.size());
							hijos.add(padre.getOwnResourceUuid());
							if (listaHijos != null && listaHijos.size() > 0) {
								for (SdmBusmgtModel entity : listaHijos) {
									hijos.add(entity.getHierChild());
								}
							}
							listaTickets = sdmCallReqRepository.getTicketsActivos(hijos, clase);
							if (listaTickets.size() > 0) {
								tickets = mapper(listaTickets, request.getOrganization(), padre.getOwnResourceUuid());
								System.out.println("Total de tickets: " + tickets.size());
								mssg = "ActiveCMDB:Exito al conseguir los tickets activos de la organizacion:"
										+ request.getOrganization();
							} else {
								mssg = "ActiveCMDB:No se encontraron tickets para esta organizacion";
							}

						} else {
							mssg = "ActiveCMDB:La organizacion esta inactiva";
						}
					} else {
						mssg = "ActiveCMDB:Organizacion no encontrada";
					}
				} else {
					System.out.println("La clase servicio esta inactiva");
				}
			}
		} catch (Exception ex) {
			success = false;
			error = ex.toString();
		}
		Period period = new Period(initial, new DateTime());
		if (tickets != null) {
			return new CATicketList(success, period, error, mssg, tickets.size(), tickets);
		} else {
			return new CATicketList(success, period, error, mssg, 0);
		}

	}

	private ArrayList<CATicket> mapper(List<Object> ticketsR, String nombreOrganizacion, String idOrganizacion) {
		ArrayList<CATicket> tickets = new ArrayList<CATicket>();
		for (Object titulo : ticketsR) {
			CATicket ticket = new CATicket();
			Object[] obj = (Object[]) titulo;
			String refNum = String.valueOf(obj[0]);
			String tfe = String.valueOf(obj[1]);
			String tenant = String.valueOf(obj[2]);
			String resumen = String.valueOf(obj[3]);
			String prioridad = String.valueOf(obj[4]);
			String categoria = String.valueOf(obj[5]);
			String estado = String.valueOf(obj[6]);
			String asignado = String.valueOf(obj[7]);
			String asignadoPrimerNombre = String.valueOf(obj[8]);
			String asignadoSegundoNombre = String.valueOf(obj[9]);
			String asignadoApellido = String.valueOf(obj[10]);
			String customer = String.valueOf(obj[11]);
			String customerPrimerNombre = String.valueOf(obj[12]);
			String customerSegundoNombre = String.valueOf(obj[13]);
			String customerApellido = String.valueOf(obj[14]);
			String descripcion = String.valueOf(obj[15]);
			String solicitante = String.valueOf(obj[16]);
			String grupo = String.valueOf(obj[17]);
			String urgencia = String.valueOf(obj[18]);
			String impacto = String.valueOf(obj[19]);
			String diagInicial = String.valueOf(obj[20]);
			String diagFinal = String.valueOf(obj[21]);
			String solucion = String.valueOf(obj[22]);
			String fechaHoraSolucion = String.valueOf(obj[23]);
			String fechaApertura = String.valueOf(obj[24]);
			String ultimaModificacion = String.valueOf(obj[25]);
			String fechaResultora = String.valueOf(obj[26]);
			String fechaCierre = String.valueOf(obj[27]);
			String tiempoFallaEnlace = String.valueOf(obj[28]);
			String tiempoFallaCliente = String.valueOf(obj[29]);
			String ci = String.valueOf(obj[30]);
			String proactivoReactivo = String.valueOf(obj[31]);
			String tiempoFallaProveedor = String.valueOf(obj[32]);
			String tiempoFallaTerceros = String.valueOf(obj[33]);
			String slaViolation = String.valueOf(obj[34]);
			String macroPredictViol = String.valueOf(obj[35]);
			String externalSystemTicket = String.valueOf(obj[36]);
			String ip = String.valueOf(obj[37]);
			String organization = String.valueOf(obj[38]);

			if (refNum != null) {
				ticket.setRefNum(refNum);
			} else {
				ticket.setRefNum("");
			}
			if (tfe != null) {
				ticket.setTfe(tfe);
			} else {
				ticket.setTfe("");
			}
			if (tenant != null) {
				ticket.setTenant(tenant);
			} else {
				ticket.setTenant("");
			}
			if (resumen != null) {
				ticket.setSummary(resumen);
			} else {
				ticket.setSummary("");
			}
			if (prioridad != null) {
				ticket.setPriority(prioridad);
			} else {
				ticket.setPriority("");
			}
			if (categoria != null) {
				ticket.setCategory(categoria);
			} else {
				ticket.setCategory("");
			}
			if (estado != null) {
				ticket.setStatus(estado);
			} else {
				ticket.setStatus("");
			}
			if (asignado != null) {
				if (!asignado.equalsIgnoreCase("null")) {
					ticket.setAssignee(asignado);
				} else {
					ticket.setAssignee("");
				}

			} else {
				ticket.setAssignee("");
			}

			if (asignadoPrimerNombre != null) {
				ticket.setAssigneeFirstName(asignadoPrimerNombre);
			} else {
				ticket.setAssigneeFirstName("");
			}
			if (asignadoSegundoNombre != null) {
				ticket.setAsigneeMiddleName(asignadoSegundoNombre);
			} else {
				ticket.setAsigneeMiddleName("");
			}
			if (asignadoApellido != null) {
				ticket.setAssigneeLastName(asignadoApellido);
			} else {
				ticket.setAssigneeLastName("");
			}
			if (customer != null) {
				ticket.setCustomer(customer);
			} else {
				ticket.setCustomer("");
			}
			if (customerPrimerNombre != null) {
				ticket.setCustomerFirstName(customerPrimerNombre);
			} else {
				ticket.setCustomerFirstName("");
			}
			if (customerSegundoNombre != null) {
				ticket.setCustomerMiddleName(customerSegundoNombre);
			} else {
				ticket.setCustomerMiddleName("");
			}
			if (customerApellido != null) {
				ticket.setCustomerLastName(customerApellido);
			} else {
				ticket.setCustomerLastName("");
			}
			if (descripcion != null) {
				ticket.setDescription(descripcion);
			} else {
				ticket.setDescription("");
			}
			if (solicitante != null && solicitante.equalsIgnoreCase("null")) {
				ticket.setRequestedBy(solicitante);
			} else {
				ticket.setRequestedBy("");
			}

			if (grupo != null) {
				ticket.setGroup(grupo);
			} else {
				ticket.setGroup("");
			}
			if (urgencia != null) {
				ticket.setUrgency(urgencia);
			} else {
				ticket.setUrgency("");
			}
			if (impacto != null) {
				ticket.setImpact(impacto);
			} else {
				ticket.setImpact("");
			}
			if (diagInicial != null) {
				ticket.setInitialDiagnose(diagInicial);
			} else {
				ticket.setInitialDiagnose("");
			}

			if (diagFinal != null && !diagFinal.equalsIgnoreCase("null")) {
				ticket.setFinalDiagnose(diagFinal);
			} else {
				ticket.setFinalDiagnose("");
			}

			if (solucion != null && solucion.equalsIgnoreCase("null")) {
				ticket.setSolution(solucion);
			} else {
				ticket.setSolution("");
			}

			if (fechaHoraSolucion != null && !fechaHoraSolucion.equalsIgnoreCase("null")) {
				ticket.setSolutionTime(fechaHoraSolucion);
			} else {
				ticket.setSolutionTime("");
			}

			if (fechaApertura != null) {
				ticket.setOpenTime(fechaApertura);
			} else {
				ticket.setOpenTime("");
			}
			if (ultimaModificacion != null && !ultimaModificacion.equalsIgnoreCase("null")) {
				ticket.setLastModTime(ultimaModificacion);
			} else {
				ticket.setLastModTime("");
			}

			if (fechaResultora != null) {
				ticket.setResolveTime(fechaResultora);
			} else {
				ticket.setResolveTime("");
			}
			if (fechaCierre != null && !fechaCierre.equalsIgnoreCase("null")) {
				ticket.setCloseTime(fechaCierre);
			} else {
				ticket.setCloseTime("");
			}

			if (tiempoFallaEnlace != null) {
				ticket.setTiempoEnlace(tiempoFallaEnlace);
			} else {
				ticket.setTiempoEnlace("");
			}
			if (tiempoFallaCliente != null) {
				ticket.setTiempoCliente(tiempoFallaCliente);
			} else {
				ticket.setTiempoCliente("");
			}
			if (ci != null) {
				ticket.setCi(ci);
			} else {
				ticket.setCi("");
			}

			if (proactivoReactivo != null && !proactivoReactivo.equalsIgnoreCase("null")) {
				ticket.setProactivoReactivo(proactivoReactivo);
			} else {
				ticket.setProactivoReactivo("");
			}

			if (tiempoFallaProveedor != null && !tiempoFallaProveedor.equalsIgnoreCase("null")) {
				ticket.setZtiempoFallaProv(tiempoFallaProveedor);
			} else {
				ticket.setZtiempoFallaProv("");
			}

			if (tiempoFallaTerceros != null) {
				if (!tiempoFallaTerceros.equalsIgnoreCase("null")) {
					ticket.setZtiempoFallaTerceros(tiempoFallaTerceros);
				} else {
					ticket.setZtiempoFallaTerceros("");
				}

			} else {
				ticket.setZtiempoFallaTerceros("");
			}

			if (slaViolation != null) {
				ticket.setSlaViolation(slaViolation);
			}
			if (macroPredictViol != null) {
				ticket.setMacroPredictViol(macroPredictViol);
			}
			if (externalSystemTicket != null) {
				if (externalSystemTicket.equalsIgnoreCase("null")
						|| externalSystemTicket.equalsIgnoreCase("undefined")) {
					ticket.setExternalSystemTicket("");
				} else {
					ticket.setExternalSystemTicket(externalSystemTicket);
				}
			} else {
				ticket.setExternalSystemTicket("");
			}

			if (ip != null) {
				if (ip.equalsIgnoreCase("null")) {
					ticket.setIp("");
				} else {
					ticket.setIp(ip);
				}
			} else {
				ticket.setIp("");
			}

			// insertar el cliente
			if (organization != null) {
				ticket.setOrganization(organization);
			} else {
				ticket.setOrganization("");
			}

			tickets.add(ticket);
		}
		return tickets;
	}

	private ArrayList<CATicket> mapperNew(List<Object> ticketsR, String nombreOrganizacion, String idOrganizacion) {
		ArrayList<CATicket> tickets = new ArrayList<CATicket>();
		for (Object titulo : ticketsR) {
			CATicket ticket = new CATicket();
			Object[] obj = (Object[]) titulo;
			String refNum = String.valueOf(obj[0]);
			String tfe = String.valueOf(obj[1]);
			String tenant = String.valueOf(obj[2]);
			String resumen = String.valueOf(obj[3]);
			String prioridad = String.valueOf(obj[4]);
			String categoria = String.valueOf(obj[5]);
			String estado = String.valueOf(obj[6]);
			String asignado = String.valueOf(obj[7]);
			String asignadoPrimerNombre = String.valueOf(obj[8]);
			String asignadoSegundoNombre = String.valueOf(obj[9]);
			String asignadoApellido = String.valueOf(obj[10]);
			String customer = String.valueOf(obj[11]);
			String customerPrimerNombre = String.valueOf(obj[12]);
			String customerSegundoNombre = String.valueOf(obj[13]);
			String customerApellido = String.valueOf(obj[14]);
			String descripcion = String.valueOf(obj[15]);
			String solicitante = String.valueOf(obj[16]);
			String grupo = String.valueOf(obj[17]);
			String urgencia = String.valueOf(obj[18]);
			String impacto = String.valueOf(obj[19]);
			String diagInicial = String.valueOf(obj[20]);
			String diagFinal = String.valueOf(obj[21]);
			String solucion = String.valueOf(obj[22]);
			String fechaHoraSolucion = String.valueOf(obj[23]);
			String fechaApertura = String.valueOf(obj[24]);
			String ultimaModificacion = String.valueOf(obj[25]);
			String fechaResultora = String.valueOf(obj[26]);
			String fechaCierre = String.valueOf(obj[27]);
			String tiempoFallaEnlace = String.valueOf(obj[28]);
			String tiempoFallaCliente = String.valueOf(obj[29]);
			String ci = String.valueOf(obj[30]);
			String proactivoReactivo = String.valueOf(obj[31]);
			String tiempoFallaProveedor = String.valueOf(obj[32]);
			String tiempoFallaTerceros = String.valueOf(obj[33]);
			String slaViolation = String.valueOf(obj[34]);
			String macroPredictViol = String.valueOf(obj[35]);
			String externalSystemTicket = String.valueOf(obj[36]);
			String ip = String.valueOf(obj[37]);
			String organization = String.valueOf(obj[38]);

			String numeroSerie = String.valueOf(obj[39]);
			String tipoDispositivo = String.valueOf(obj[40]);

			if (refNum != null) {
				ticket.setRefNum(refNum);
			} else {
				ticket.setRefNum("");
			}
			if (tfe != null) {
				ticket.setTfe(tfe);
			} else {
				ticket.setTfe("");
			}
			if (tenant != null) {
				ticket.setTenant(tenant);
			} else {
				ticket.setTenant("");
			}
			if (resumen != null) {
				ticket.setSummary(resumen);
			} else {
				ticket.setSummary("");
			}
			if (prioridad != null) {
				ticket.setPriority(prioridad);
			} else {
				ticket.setPriority("");
			}
			if (categoria != null) {
				ticket.setCategory(categoria);
			} else {
				ticket.setCategory("");
			}
			if (estado != null) {
				ticket.setStatus(estado);
			} else {
				ticket.setStatus("");
			}
			if (asignado != null) {
				if (!asignado.equalsIgnoreCase("null")) {
					ticket.setAssignee(asignado);
				} else {
					ticket.setAssignee("");
				}

			} else {
				ticket.setAssignee("");
			}

			if (asignadoPrimerNombre != null) {
				ticket.setAssigneeFirstName(asignadoPrimerNombre);
			} else {
				ticket.setAssigneeFirstName("");
			}
			if (asignadoSegundoNombre != null) {
				ticket.setAsigneeMiddleName(asignadoSegundoNombre);
			} else {
				ticket.setAsigneeMiddleName("");
			}
			if (asignadoApellido != null) {
				ticket.setAssigneeLastName(asignadoApellido);
			} else {
				ticket.setAssigneeLastName("");
			}
			if (customer != null) {
				ticket.setCustomer(customer);
			} else {
				ticket.setCustomer("");
			}
			if (customerPrimerNombre != null) {
				ticket.setCustomerFirstName(customerPrimerNombre);
			} else {
				ticket.setCustomerFirstName("");
			}
			if (customerSegundoNombre != null) {
				ticket.setCustomerMiddleName(customerSegundoNombre);
			} else {
				ticket.setCustomerMiddleName("");
			}
			if (customerApellido != null) {
				ticket.setCustomerLastName(customerApellido);
			} else {
				ticket.setCustomerLastName("");
			}
			if (descripcion != null) {
				ticket.setDescription(descripcion);
			} else {
				ticket.setDescription("");
			}
			if (solicitante != null && solicitante.equalsIgnoreCase("null")) {
				ticket.setRequestedBy(solicitante);
			} else {
				ticket.setRequestedBy("");
			}

			if (grupo != null) {
				ticket.setGroup(grupo);
			} else {
				ticket.setGroup("");
			}
			if (urgencia != null) {
				ticket.setUrgency(urgencia);
			} else {
				ticket.setUrgency("");
			}
			if (impacto != null) {
				ticket.setImpact(impacto);
			} else {
				ticket.setImpact("");
			}
			if (diagInicial != null) {
				ticket.setInitialDiagnose(diagInicial);
			} else {
				ticket.setInitialDiagnose("");
			}

			if (diagFinal != null && !diagFinal.equalsIgnoreCase("null")) {
				ticket.setFinalDiagnose(diagFinal);
			} else {
				ticket.setFinalDiagnose("");
			}

			if (solucion != null && solucion.equalsIgnoreCase("null")) {
				ticket.setSolution(solucion);
			} else {
				ticket.setSolution("");
			}

			if (fechaHoraSolucion != null && !fechaHoraSolucion.equalsIgnoreCase("null")) {
				ticket.setSolutionTime(fechaHoraSolucion);
			} else {
				ticket.setSolutionTime("");
			}

			if (fechaApertura != null) {
				ticket.setOpenTime(fechaApertura);
			} else {
				ticket.setOpenTime("");
			}
			if (ultimaModificacion != null && !ultimaModificacion.equalsIgnoreCase("null")) {
				ticket.setLastModTime(ultimaModificacion);
			} else {
				ticket.setLastModTime("");
			}

			if (fechaResultora != null) {
				ticket.setResolveTime(fechaResultora);
			} else {
				ticket.setResolveTime("");
			}
			if (fechaCierre != null && !fechaCierre.equalsIgnoreCase("null")) {
				ticket.setCloseTime(fechaCierre);
			} else {
				ticket.setCloseTime("");
			}

			if (tiempoFallaEnlace != null) {
				ticket.setTiempoEnlace(tiempoFallaEnlace);
			} else {
				ticket.setTiempoEnlace("");
			}
			if (tiempoFallaCliente != null) {
				ticket.setTiempoCliente(tiempoFallaCliente);
			} else {
				ticket.setTiempoCliente("");
			}
			if (ci != null) {
				ticket.setCi(ci);
			} else {
				ticket.setCi("");
			}

			if (proactivoReactivo != null && !proactivoReactivo.equalsIgnoreCase("null")) {
				ticket.setProactivoReactivo(proactivoReactivo);
			} else {
				ticket.setProactivoReactivo("");
			}

			if (tiempoFallaProveedor != null && !tiempoFallaProveedor.equalsIgnoreCase("null")) {
				ticket.setZtiempoFallaProv(tiempoFallaProveedor);
			} else {
				ticket.setZtiempoFallaProv("");
			}

			if (tiempoFallaTerceros != null) {
				if (!tiempoFallaTerceros.equalsIgnoreCase("null")) {
					ticket.setZtiempoFallaTerceros(tiempoFallaTerceros);
				} else {
					ticket.setZtiempoFallaTerceros("");
				}

			} else {
				ticket.setZtiempoFallaTerceros("");
			}

			if (slaViolation != null) {
				ticket.setSlaViolation(slaViolation);
			}
			if (macroPredictViol != null) {
				ticket.setMacroPredictViol(macroPredictViol);
			}
			if (externalSystemTicket != null) {
				if (externalSystemTicket.equalsIgnoreCase("null")
						|| externalSystemTicket.equalsIgnoreCase("undefined")) {
					ticket.setExternalSystemTicket("");
				} else {
					ticket.setExternalSystemTicket(externalSystemTicket);
				}
			} else {
				ticket.setExternalSystemTicket("");
			}

			if (ip != null) {
				if (ip.equalsIgnoreCase("null")) {
					ticket.setIp("");
				} else {
					ticket.setIp(ip);
				}
			} else {
				ticket.setIp("");
			}

			// insertar el cliente
			if (organization != null) {
				ticket.setOrganization(organization);
			} else {
				ticket.setOrganization("");
			}

			if (numeroSerie != null) {
				if (!numeroSerie.equalsIgnoreCase("null")) {
					ticket.setNumeroSerie(numeroSerie);
				} else {
					ticket.setNumeroSerie("");
				}

			} else {
				ticket.setNumeroSerie("");
			}

			if (tipoDispositivo != null) {
				if (!tipoDispositivo.equalsIgnoreCase("null")) {
					ticket.setTipoDispositivo(tipoDispositivo);
				} else {
					ticket.setTipoDispositivo("");
				}

			} else {
				ticket.setTipoDispositivo("");
			}

			tickets.add(ticket);
		}
		return tickets;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public CATicketByNameCIList getTicketsByNameCi(List<DeviceAndAlarm> request) {
		DateTime initial = new DateTime();
		Boolean success = Boolean.valueOf(true);
		List<CATicketByNameCI> respuestaList = new ArrayList();
		try {
			List<String> dispositivos = new ArrayList();
			List<String> alarmas = new ArrayList();
			for (DeviceAndAlarm obj : request) {
				dispositivos.add(obj.getDispositivo());
				alarmas.add(obj.getAlarma());
			}

			Object tickets = sdmCaOwnedResourceRepository.getTickets(dispositivos, alarmas);
			if (!((List) tickets).isEmpty())
				for (Object objecto : (List) tickets) {
					String refNum = null;
					CATicketByNameCI objRespuesta = new CATicketByNameCI();
					Object[] obj = (Object[]) objecto;
					String dispositivo = String.valueOf(obj[0]);
					String alarma = String.valueOf(obj[1]);
					if (obj[2] != null) {
						refNum = String.valueOf(obj[2]);
					} else {
						refNum = new String("");
					}

					List<CATicket> listTickets = new ArrayList();
					CATicket ticket = new CATicket();
					ticket.setRefNum(refNum);
					listTickets.add(ticket);
					objRespuesta.setNombreDispositivo(dispositivo);
					objRespuesta.setAlarma(alarma);
					objRespuesta.setTickets(listTickets);
					respuestaList.add(objRespuesta);
				}
		} catch (Exception ex) {
			success = Boolean.valueOf(false);
		}
		Period period = new Period(initial, new DateTime());

		return new CATicketByNameCIList(success.booleanValue(), period, respuestaList);
	}

	public CAStatus getStatusByTicket(TicketRefNumRequest request) {
		DateTime initial = new DateTime();
		Boolean success = true;
		Integer token = null;
		String error = new String("");
		CATicketMapper mapper = new CATicketMapper();
		String estatus = new String("");
		try {
			token = logInValidator.getToken();
			String refNumCriteria = TicketQueryBuilder.buildQuery(request.getRefNum(), "refNum");
			String refNumByXml = queryValidator.doSelect(token, "cr", refNumCriteria, 1, TicketDictionary.statusParam);
			String statusTicket = mapper.getValueByAttrName(refNumByXml, TicketDictionary.statusTicket);
			estatus = statusTicket;

			logInValidator.closeToken(token);
		} catch (Exception e) {
			error = "Estatus ticket: " + e.toString();
			success = false;
		} finally {
			try {
				if (token != null)
					logInValidator.closeToken(token);
			} catch (RemoteException e) {
				error = "ocurrio un error al consultar el estatus del ticket";
			}
		}
		Period period = new Period(initial, new DateTime());
		return new CAStatus(success, period, error, estatus);
	}

	public CATicketList getTicketByGroup(TicketGroupRequest request) {
		DateTime initial = new DateTime();
		ArrayList<CATicket> tickets = null;
		Boolean success = true;
		String error = "";
		String mssg = "";
		Integer token = null;
		try {
			System.out.println("Grupos" + request.getGroup());
			String[] grupos = request.getGroup().split(",");
			List<String> lista = Arrays.asList(grupos);
			System.out.println("Grupos" + lista.size());
			List<Object> ticketsList = sdmCallReqRepository.getTicketByGroup(lista);

			System.out.println("Se encontraron " + ticketsList.size() + "tickets");
			if (!ticketsList.isEmpty()) {
				tickets = mapper(ticketsList, "", "");
			} else {
				error = "No se encontraron tickets";
			}
		} catch (Exception ex) {
			success = false;
			error = ex.toString();
			System.out.println("Se encontro una exception en tickets por grupos: " + ex);
		}
		Period period = new Period(initial, new DateTime());
		if (tickets != null) {
			System.out.println("Se entregaron datos " + tickets.size());
			return new CATicketList(success, period, error, mssg, tickets.size(), tickets);

		} else {
			return new CATicketList(success, period, error, mssg, 0);
		}
	}

	public CATicketList getTicketsByStatusAndRequestBy(StatusRequestByRequest request) {

		DateTime initial = new DateTime();
		Boolean success = true;
		String error = new String("");
		Integer token = null;
		String mssg = "";
		ArrayList<CATicket> tickets = null;
		String clase = null;
		try {

			System.out.println("Estatus" + request.getStatus());

			List<Object> listaTickets = null;
			String[] estatus = request.getStatus().split(",");
			List<String> listaEstaus = Arrays.asList(estatus);

			System.out.println("listaEstaus" + listaEstaus.size());

			token = logInValidator.getToken();
			CATicketMapper mapper = new CATicketMapper();
			String requestByCriteria = TicketQueryBuilder.buildQuery(request.getRequestBy(), "userCreate"); // Busco
																											// solicitante
			String requestByXml = queryValidator.doSelect(token, "cnt", requestByCriteria, 1,
					TicketDictionary.persistentIdParam);
			String requestBy = mapper.getValueByAttrName(requestByXml, TicketDictionary.id);

			System.out.println("El solicitante:  " + requestBy);

			if (requestBy != null || !requestBy.isEmpty()) {
				System.out.println("Buscara los tickets " + estatus);

				List<Object> familia = catFamiliaClasesRepository.getFamiliaClase();

				for (Object obj : familia) {
					Object[] objeto = (Object[]) obj;
					clase = String.valueOf(objeto[1]);

					System.out.println("Clase familia: " + clase);
				}

				listaTickets = sdmCallReqRepository.getTicketsStatusAndRequestBys(listaEstaus, "0x" + requestBy, clase);
				System.out.println("Tiene tickets " + listaTickets.size());
				if (listaTickets.size() > 0) {
					System.out.println("Encontro tickets");
					tickets = mapper(listaTickets, "", "");
					mssg = "Exito al conseguir los tickets por estatus y solicitante";
				} else {
					mssg = "No se encontraron tickets con los datos proporcionados";
				}
			} else {
				error = "No se encontro el solicitante";
				success = false;
			}

		} catch (Exception e) {

			error = "ocurrio un error al consultar tickets por estatus y requestBy: " + e;
			success = false;
		}
		Period period = new Period(initial, new DateTime());
		return new CATicketList(success, period, error, mssg, tickets.size(), tickets);
	}

	public CATicketList getTicketByIp(TicketIpRequest request) {
		DateTime initial = new DateTime();
		ArrayList<CATicket> tickets = null;
		Boolean success = true;
		String error = "";
		String mssg = "";
		// Integer token = null;
		List<Object> ticketsList = null;
		try {

			Pattern patron = Pattern.compile(
					"^(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])$");
			Matcher mat = patron.matcher(request.getIp());

			if (request.getNumeroSerie().isEmpty() && request.getIp().isEmpty()) {

				success = false;
				error = "Enviar la ip o numero de serie";

			} else if (!request.getIp().isEmpty() && !request.getNumeroSerie().isEmpty()) {

				success = false;
				error = "Enviar la ip o numero de serie no los dos";

			}

			else {

				if (!request.getIp().isEmpty()) {

					if (!mat.matches()) {
						success = false;
						error = "El formato de la ip es incorrecto";
					} else {

						ticketsList = sdmCallReqRepository.getTicketByIP(request.getIp());

					}

				} else if (!request.getNumeroSerie().isEmpty()) {

					ticketsList = sdmCallReqRepository.getTicketByNumSerial(request.getNumeroSerie());

				}

				System.out.println("Se encontraron " + ticketsList.size() + " tickets");
				if (!ticketsList.isEmpty()) {
					tickets = mapperByIP(ticketsList);
				} else {
					success = false;
					error = "No se encontraron tickets";
				}

			}

		} catch (Exception ex) {

			Pattern patron = Pattern.compile(
					"^(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])$");
			Matcher mat = patron.matcher(request.getIp());

			if (request.getNumeroSerie().isEmpty() && request.getIp().isEmpty()) {

				success = false;
				error = "Enviar la ip o numero de serie";

			} else if (!request.getIp().isEmpty() && !request.getNumeroSerie().isEmpty()) {

				success = false;
				error = "Enviar la ip o numero de serie no los dos";

			}
			if (!mat.matches()) {

				success = false;
				error = "El formato de la ip es incorrecto";

			} else {
				success = false;
				error = ex.toString();
			}

			System.out.println("Se encontro una exception en tickets activos: " + ex + "/" + error);
		}
		Period period = new Period(initial, new DateTime());
		if (tickets != null) {
			System.out.println("Se entregaron datos " + tickets.size());
			return new CATicketList(success, period, error, mssg, tickets.size(), tickets);

		} else {
			return new CATicketList(success, period, error, mssg, 0);
		}
	}

	private ArrayList<CATicket> mapperByIP(List<Object> ticketsR) {
		ArrayList<CATicket> tickets = new ArrayList<CATicket>();
		for (Object titulo : ticketsR) {
			CATicket ticket = new CATicket();
			Object[] obj = (Object[]) titulo;
			String refNum = String.valueOf(obj[0]);
			String status = String.valueOf(obj[1]);
			String summary = String.valueOf(obj[2]);

			if (refNum != null) {
				ticket.setRefNum(refNum);
			} else {
				ticket.setRefNum("");
			}

			if (status != null) {
				ticket.setStatus(status);
			} else {
				ticket.setStatus("");
			}

			if (summary != null) {
				ticket.setSummary(summary);
			} else {
				ticket.setSummary("");
			}

			tickets.add(ticket);
		}
		return tickets;
	}

	public CATicketList getTicketsByStatusAndOrganization(StatusOrganizationRequest request) {

		DateTime initial = new DateTime();
		Boolean success = true;
		String error = new String("");
		Integer token = null;
		String mssg = "";
		ArrayList<CATicket> tickets = null;
		List<Object> listaTickets = null;
		String clase = null;
		try {

			System.out.println("Estatus: " + request.getStatus());

			String[] estatus = request.getStatus().split(",");
			List<String> listaEstaus = Arrays.asList(estatus);

			token = logInValidator.getToken();

			List<Object> familia = catFamiliaClasesRepository.getFamiliaClase();

			for (Object obj : familia) {
				Object[] objeto = (Object[]) obj;
				clase = String.valueOf(objeto[1]);

				System.out.println("Clase familia: " + clase);
			}

			System.out.println("Buscara los tickets TicketsByStatusAndOrganization" + estatus);
			listaTickets = sdmCallReqRepository.getTicketsStatusAndResourceName(listaEstaus, request.getOrganization(),
					clase);
			System.out.println("Tiene tickets - TicketsByStatusAndOrganization " + listaTickets.size());
			if (listaTickets.size() > 0) {
				tickets = mapperNew(listaTickets, "", "");
				mssg = "Exito al conseguir los tickets por estatus y organizacion";
			} else {
				mssg = "No se encontraron tickets con los datos proporcionados";
				success = false;
			}

		} catch (Exception e) {

			error = "ocurrio un error al consultar tickets por estatus y organizacion: " + e;
			success = false;
		}

		Period period = new Period(initial, new DateTime());

		if (tickets != null)
			return new CATicketList(success, period, error, mssg, tickets.size(), tickets);
		else
			return new CATicketList(success, period, error, mssg, 0);

	}
}
