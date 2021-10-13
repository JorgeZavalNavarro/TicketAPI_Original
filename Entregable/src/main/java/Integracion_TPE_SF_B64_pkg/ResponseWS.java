/**
 * ResponseWS.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Integracion_TPE_SF_B64_pkg;

public class ResponseWS  implements java.io.Serializable {
    private java.lang.String codigoRespuesta;

    private java.lang.String descripcionRespuesta;

    private java.lang.String fechaRespuesta;

    private java.lang.String fechaSolicitud;

    private java.lang.String folioDocumento;

    private java.lang.String id_attm;

    private java.lang.String mensajeServicio;

    private java.lang.String message;

    private java.lang.String respuestaBoolean;

    public ResponseWS() {
    }

    public ResponseWS(
           java.lang.String codigoRespuesta,
           java.lang.String descripcionRespuesta,
           java.lang.String fechaRespuesta,
           java.lang.String fechaSolicitud,
           java.lang.String folioDocumento,
           java.lang.String id_attm,
           java.lang.String mensajeServicio,
           java.lang.String message,
           java.lang.String respuestaBoolean) {
           this.codigoRespuesta = codigoRespuesta;
           this.descripcionRespuesta = descripcionRespuesta;
           this.fechaRespuesta = fechaRespuesta;
           this.fechaSolicitud = fechaSolicitud;
           this.folioDocumento = folioDocumento;
           this.id_attm = id_attm;
           this.mensajeServicio = mensajeServicio;
           this.message = message;
           this.respuestaBoolean = respuestaBoolean;
    }


    /**
     * Gets the codigoRespuesta value for this ResponseWS.
     * 
     * @return codigoRespuesta
     */
    public java.lang.String getCodigoRespuesta() {
        return codigoRespuesta;
    }


    /**
     * Sets the codigoRespuesta value for this ResponseWS.
     * 
     * @param codigoRespuesta
     */
    public void setCodigoRespuesta(java.lang.String codigoRespuesta) {
        this.codigoRespuesta = codigoRespuesta;
    }


    /**
     * Gets the descripcionRespuesta value for this ResponseWS.
     * 
     * @return descripcionRespuesta
     */
    public java.lang.String getDescripcionRespuesta() {
        return descripcionRespuesta;
    }


    /**
     * Sets the descripcionRespuesta value for this ResponseWS.
     * 
     * @param descripcionRespuesta
     */
    public void setDescripcionRespuesta(java.lang.String descripcionRespuesta) {
        this.descripcionRespuesta = descripcionRespuesta;
    }


    /**
     * Gets the fechaRespuesta value for this ResponseWS.
     * 
     * @return fechaRespuesta
     */
    public java.lang.String getFechaRespuesta() {
        return fechaRespuesta;
    }


    /**
     * Sets the fechaRespuesta value for this ResponseWS.
     * 
     * @param fechaRespuesta
     */
    public void setFechaRespuesta(java.lang.String fechaRespuesta) {
        this.fechaRespuesta = fechaRespuesta;
    }


    /**
     * Gets the fechaSolicitud value for this ResponseWS.
     * 
     * @return fechaSolicitud
     */
    public java.lang.String getFechaSolicitud() {
        return fechaSolicitud;
    }


    /**
     * Sets the fechaSolicitud value for this ResponseWS.
     * 
     * @param fechaSolicitud
     */
    public void setFechaSolicitud(java.lang.String fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }


    /**
     * Gets the folioDocumento value for this ResponseWS.
     * 
     * @return folioDocumento
     */
    public java.lang.String getFolioDocumento() {
        return folioDocumento;
    }


    /**
     * Sets the folioDocumento value for this ResponseWS.
     * 
     * @param folioDocumento
     */
    public void setFolioDocumento(java.lang.String folioDocumento) {
        this.folioDocumento = folioDocumento;
    }


    /**
     * Gets the id_attm value for this ResponseWS.
     * 
     * @return id_attm
     */
    public java.lang.String getId_attm() {
        return id_attm;
    }


    /**
     * Sets the id_attm value for this ResponseWS.
     * 
     * @param id_attm
     */
    public void setId_attm(java.lang.String id_attm) {
        this.id_attm = id_attm;
    }


    /**
     * Gets the mensajeServicio value for this ResponseWS.
     * 
     * @return mensajeServicio
     */
    public java.lang.String getMensajeServicio() {
        return mensajeServicio;
    }


    /**
     * Sets the mensajeServicio value for this ResponseWS.
     * 
     * @param mensajeServicio
     */
    public void setMensajeServicio(java.lang.String mensajeServicio) {
        this.mensajeServicio = mensajeServicio;
    }


    /**
     * Gets the message value for this ResponseWS.
     * 
     * @return message
     */
    public java.lang.String getMessage() {
        return message;
    }


    /**
     * Sets the message value for this ResponseWS.
     * 
     * @param message
     */
    public void setMessage(java.lang.String message) {
        this.message = message;
    }


    /**
     * Gets the respuestaBoolean value for this ResponseWS.
     * 
     * @return respuestaBoolean
     */
    public java.lang.String getRespuestaBoolean() {
        return respuestaBoolean;
    }


    /**
     * Sets the respuestaBoolean value for this ResponseWS.
     * 
     * @param respuestaBoolean
     */
    public void setRespuestaBoolean(java.lang.String respuestaBoolean) {
        this.respuestaBoolean = respuestaBoolean;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ResponseWS)) return false;
        ResponseWS other = (ResponseWS) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.codigoRespuesta==null && other.getCodigoRespuesta()==null) || 
             (this.codigoRespuesta!=null &&
              this.codigoRespuesta.equals(other.getCodigoRespuesta()))) &&
            ((this.descripcionRespuesta==null && other.getDescripcionRespuesta()==null) || 
             (this.descripcionRespuesta!=null &&
              this.descripcionRespuesta.equals(other.getDescripcionRespuesta()))) &&
            ((this.fechaRespuesta==null && other.getFechaRespuesta()==null) || 
             (this.fechaRespuesta!=null &&
              this.fechaRespuesta.equals(other.getFechaRespuesta()))) &&
            ((this.fechaSolicitud==null && other.getFechaSolicitud()==null) || 
             (this.fechaSolicitud!=null &&
              this.fechaSolicitud.equals(other.getFechaSolicitud()))) &&
            ((this.folioDocumento==null && other.getFolioDocumento()==null) || 
             (this.folioDocumento!=null &&
              this.folioDocumento.equals(other.getFolioDocumento()))) &&
            ((this.id_attm==null && other.getId_attm()==null) || 
             (this.id_attm!=null &&
              this.id_attm.equals(other.getId_attm()))) &&
            ((this.mensajeServicio==null && other.getMensajeServicio()==null) || 
             (this.mensajeServicio!=null &&
              this.mensajeServicio.equals(other.getMensajeServicio()))) &&
            ((this.message==null && other.getMessage()==null) || 
             (this.message!=null &&
              this.message.equals(other.getMessage()))) &&
            ((this.respuestaBoolean==null && other.getRespuestaBoolean()==null) || 
             (this.respuestaBoolean!=null &&
              this.respuestaBoolean.equals(other.getRespuestaBoolean())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getCodigoRespuesta() != null) {
            _hashCode += getCodigoRespuesta().hashCode();
        }
        if (getDescripcionRespuesta() != null) {
            _hashCode += getDescripcionRespuesta().hashCode();
        }
        if (getFechaRespuesta() != null) {
            _hashCode += getFechaRespuesta().hashCode();
        }
        if (getFechaSolicitud() != null) {
            _hashCode += getFechaSolicitud().hashCode();
        }
        if (getFolioDocumento() != null) {
            _hashCode += getFolioDocumento().hashCode();
        }
        if (getId_attm() != null) {
            _hashCode += getId_attm().hashCode();
        }
        if (getMensajeServicio() != null) {
            _hashCode += getMensajeServicio().hashCode();
        }
        if (getMessage() != null) {
            _hashCode += getMessage().hashCode();
        }
        if (getRespuestaBoolean() != null) {
            _hashCode += getRespuestaBoolean().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ResponseWS.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Integracion_TPE_SF_B64/", "responseWS"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codigoRespuesta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "codigoRespuesta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descripcionRespuesta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "descripcionRespuesta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaRespuesta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fechaRespuesta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaSolicitud");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fechaSolicitud"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("folioDocumento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "folioDocumento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id_attm");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id_attm"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mensajeServicio");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mensajeServicio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("message");
        elemField.setXmlName(new javax.xml.namespace.QName("", "message"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("respuestaBoolean");
        elemField.setXmlName(new javax.xml.namespace.QName("", "respuestaBoolean"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
