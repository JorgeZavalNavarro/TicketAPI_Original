/**
 * Integracion_TPE_SF_B64ServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Integracion_TPE_SF_B64_pkg;

public class Integracion_TPE_SF_B64ServiceLocator extends org.apache.axis.client.Service implements Integracion_TPE_SF_B64_pkg.Integracion_TPE_SF_B64Service {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Integracion_TPE_SF_B64ServiceLocator() {
    }


    public Integracion_TPE_SF_B64ServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public Integracion_TPE_SF_B64ServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for Integracion_TPE_SF_B64Port
    private java.lang.String Integracion_TPE_SF_B64Port_address = "http://10.180.251.70:8080/Integracion_TPE_SF_B64/Integracion_TPE_SF_B64";

    public java.lang.String getIntegracion_TPE_SF_B64PortAddress() {
        return Integracion_TPE_SF_B64Port_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String Integracion_TPE_SF_B64PortWSDDServiceName = "Integracion_TPE_SF_B64Port";

    public java.lang.String getIntegracion_TPE_SF_B64PortWSDDServiceName() {
        return Integracion_TPE_SF_B64PortWSDDServiceName;
    }

    public void setIntegracion_TPE_SF_B64PortWSDDServiceName(java.lang.String name) {
        Integracion_TPE_SF_B64PortWSDDServiceName = name;
    }

    public Integracion_TPE_SF_B64_pkg.Integracion_TPE_SF_B64 getIntegracion_TPE_SF_B64Port() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(Integracion_TPE_SF_B64Port_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getIntegracion_TPE_SF_B64Port(endpoint);
    }

    public Integracion_TPE_SF_B64_pkg.Integracion_TPE_SF_B64 getIntegracion_TPE_SF_B64Port(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            Integracion_TPE_SF_B64_pkg.Integracion_TPE_SF_B64PortBindingStub _stub = new Integracion_TPE_SF_B64_pkg.Integracion_TPE_SF_B64PortBindingStub(portAddress, this);
            _stub.setPortName(getIntegracion_TPE_SF_B64PortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setIntegracion_TPE_SF_B64PortEndpointAddress(java.lang.String address) {
        Integracion_TPE_SF_B64Port_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (Integracion_TPE_SF_B64_pkg.Integracion_TPE_SF_B64.class.isAssignableFrom(serviceEndpointInterface)) {
                Integracion_TPE_SF_B64_pkg.Integracion_TPE_SF_B64PortBindingStub _stub = new Integracion_TPE_SF_B64_pkg.Integracion_TPE_SF_B64PortBindingStub(new java.net.URL(Integracion_TPE_SF_B64Port_address), this);
                _stub.setPortName(getIntegracion_TPE_SF_B64PortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("Integracion_TPE_SF_B64Port".equals(inputPortName)) {
            return getIntegracion_TPE_SF_B64Port();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://Integracion_TPE_SF_B64/", "Integracion_TPE_SF_B64Service");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://Integracion_TPE_SF_B64/", "Integracion_TPE_SF_B64Port"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("Integracion_TPE_SF_B64Port".equals(portName)) {
            setIntegracion_TPE_SF_B64PortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
