package Integracion_TPE_SF_B64;

import java.rmi.RemoteException;

import Integracion_TPE_SF_B64_pkg.Integracion_TPE_SF_B64;
import Integracion_TPE_SF_B64_pkg.Integracion_TPE_SF_B64ServiceLocator;
import Integracion_TPE_SF_B64_pkg.ResponseWS;

public class Integracion_TPE_SF_B64Proxy implements Integracion_TPE_SF_B64 {
  private String _endpoint = null;
  private Integracion_TPE_SF_B64 integracion_TPE_SF_B64 = null;
  
  public Integracion_TPE_SF_B64Proxy() {
    _initIntegracion_TPE_SF_B64Proxy();
  }
  
  public Integracion_TPE_SF_B64Proxy(String endpoint) {
    _endpoint = endpoint;
    _initIntegracion_TPE_SF_B64Proxy();
  }
  
  private void _initIntegracion_TPE_SF_B64Proxy() {
    try {
      integracion_TPE_SF_B64 = (new Integracion_TPE_SF_B64ServiceLocator()).getIntegracion_TPE_SF_B64Port();
      if (integracion_TPE_SF_B64 != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)integracion_TPE_SF_B64)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)integracion_TPE_SF_B64)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (integracion_TPE_SF_B64 != null)
      ((javax.xml.rpc.Stub)integracion_TPE_SF_B64)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public Integracion_TPE_SF_B64 getIntegracion_TPE_SF_B64() {
    if (integracion_TPE_SF_B64 == null)
      _initIntegracion_TPE_SF_B64Proxy();
    return integracion_TPE_SF_B64;
  }

@Override
public ResponseWS create_attmnt(String ref_num, String name_file, String b64_code) throws RemoteException {
	ResponseWS response = new ResponseWS();
	_initIntegracion_TPE_SF_B64Proxy();
	response = integracion_TPE_SF_B64.create_attmnt(ref_num, name_file, b64_code);
	return response;
} 
}