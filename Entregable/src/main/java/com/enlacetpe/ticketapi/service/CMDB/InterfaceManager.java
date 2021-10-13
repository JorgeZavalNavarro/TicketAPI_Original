package com.enlacetpe.ticketapi.service.CMDB;

import org.springframework.stereotype.Service;

@Service
public class InterfaceManager {
	
//	final static Logger logger = Logger.getLogger(InterfaceManager.class);
//	
//	@Autowired
//	private SmcPuntaInterfaceVwRepository smcPuntaInterfaceVwRepository;
//	
//	public CAInterfaceList getInterface(Interfaces request) {
//		DateTime initial = new DateTime();
//		Boolean success = true;
//		String error = null;
//		List<CAInterfaces> listInterfaces = new ArrayList<CAInterfaces>();
//		try {
//			List<SmcPuntaInterfaceVwModel> interfaces =smcPuntaInterfaceVwRepository.findByPuntaName(request.getNamePeack());
//			if(!interfaces.isEmpty()) {
//				for(SmcPuntaInterfaceVwModel entity: interfaces) {
//					CAInterfaces interfacesName = new CAInterfaces();
////					if(entity.getInterfaceName() != null) {
////						interfacesName.setName(entity.getInterfaceName());
////					}else {
////						interfacesName.setName("");
////					}
////					if(entity.getIpAddress() != null) {
////						interfacesName.setIp(entity.getIpAddress());
////					}else {
////						interfacesName.setIp("");
////					}
//					
//					listInterfaces.add(interfacesName);
//				}
//			}else {
//				success = false;
//				error ="No se encontro interface para el elemento de configuración proporcionado";
//			}
//		}catch(Exception e) {
//			success = false;
//			error = e.toString();		
//			logger.info("Error al conseguir las interfaces: " + e);
//		}
//		Period period = new Period(initial, new DateTime());
//		return new CAInterfaceList(success, period, error,listInterfaces); 
//	}

}
