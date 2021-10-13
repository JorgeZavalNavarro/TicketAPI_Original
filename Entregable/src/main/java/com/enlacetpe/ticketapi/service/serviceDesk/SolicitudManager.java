package com.enlacetpe.ticketapi.service.serviceDesk;

import java.rmi.RemoteException;
import java.util.ArrayList;

import java.util.List;

import javax.xml.rpc.holders.StringHolder;

import org.joda.time.DateTime;
import org.joda.time.Period;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enlacetpe.ticketapi.caManager.serviceDesk.CALogInValidator;
import com.enlacetpe.ticketapi.caManager.serviceDesk.CAObjectValidator;
import com.enlacetpe.ticketapi.caMapper.serviceDesk.CATicketMapper;
import com.enlacetpe.ticketapi.cargasMasivas.repository.CargasMasivasRepository;
import com.enlacetpe.ticketapi.modelCargas.CargasMasivasModel;
import com.enlacetpe.ticketapi.response.CATicket;
import com.enlacetpe.ticketapi.response.CATicketList;

@Service
public class SolicitudManager {

	@Autowired
	private CALogInValidator logInValidator;

	@Autowired
	private CAObjectValidator objValidator;

	//@Autowired
	//private CargasMasivasRepository cargasMasivasRepository;

	public CATicketList registrarSolicitud() {
		return null;

		/*DateTime initial = new DateTime();
		ArrayList<CATicket> tickets = new ArrayList<CATicket>();
		Integer token = null;
		Boolean success = true;
		String error = null;
		String mssg = "CrearSolicitud-MANTENIMIENTO EMPRESARIAL: Exito al crear Solicitud";
		long TInicio = 0, TFin, tiempo = 0;

		try {

			TInicio = System.currentTimeMillis();

			CATicketMapper mapper = new CATicketMapper();
			token = logInValidator.getToken();
			String userHandle = logInValidator.getUserHandle(token);
			String[] propertyValues = {};
			String[] attributes = {};
			StringHolder newRequestHandle = new StringHolder();
			StringHolder newRequestNumber = new StringHolder();

			List<CargasMasivasModel> regList = cargasMasivasRepository.getRegistros();

			System.out.println("No de registros a procesar: " + regList.size());

			if (!regList.isEmpty()) {
				for (CargasMasivasModel registro : regList) {
					String descripcion = registro.getColumna1() + "\n" + registro.getColumna2() + "\n"
							+ registro.getColumna3() + "\n" + registro.getColumna4() + "\n" + registro.getColumna5()
							+ "\n" + registro.getColumna6() + "\n" + registro.getColumna7();

					String[] argsCreate = new String[] { "requested_by", registro.getColumna8(), // requestBy
														 "customer", registro.getColumna9(), // requestby
														 "category", registro.getColumna10(), 
														 "summary", descripcion, 
														 "description", descripcion,
							                             "type", registro.getColumna11(), 
							                             "group", registro.getColumna12(), 
							                             "status",registro.getColumna13() };

					String xml = objValidator.createTicket(token, userHandle, argsCreate, propertyValues, attributes,
							newRequestHandle, newRequestNumber);
					tickets = mapper.mapUnique(xml);
					System.out.println("Se creo la solicitud " + tickets.get(0).getRefNum() + " con Id Registro: "
							+ registro.getIdNumRegistro());

				}
			}

			TFin = System.currentTimeMillis(); // Tomamos la hora en que
												// finalizó el algoritmo y la
												// almacenamos en la variable T
			tiempo = TFin - TInicio; // Calculamos los milisegundos de
										// diferencia

			System.out.println("Tiempo fin de proceso con exito: " + tiempo);

			logInValidator.closeToken(token);
		} catch (Exception e) {
			TFin = System.currentTimeMillis();
			tiempo = TFin - TInicio;
			System.out.println("Tiempo fin de proceso con ERROR: " + tiempo);
			success = false;
			error = e.toString();
			mssg = "CrearSolicitud-MANTENIMIENTO EMPRESARIAL: Ocurrio un error al crear la solicitud: "
					+ e.getMessage();
		} finally {
			try {
				if (token != null)
					logInValidator.closeToken(token);
			} catch (RemoteException e) {
				TFin = System.currentTimeMillis();
				tiempo = TFin - TInicio;
				System.out.println("Tiempo fin de proceso con ERROR: " + tiempo);
				System.out.println("Error Solcitud MANTENIMIENTO EMPRESARIAL" + e);
			}
		}

		Period period = new Period(initial, new DateTime());
		if (tickets != null) {
			return new CATicketList(success, period, error, mssg, tickets.size(), tickets);
		} else {
			return new CATicketList(success, period, error, mssg, 0);
		}*/

	}

}
