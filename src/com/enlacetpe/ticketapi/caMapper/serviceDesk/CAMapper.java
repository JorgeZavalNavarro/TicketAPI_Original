package com.enlacetpe.ticketapi.caMapper.serviceDesk;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;	

public class CAMapper {
	
	protected List<Element> getRootList(String xml) throws Exception {
		SAXBuilder saxBuilder = new SAXBuilder();
		InputStream stream = new ByteArrayInputStream(xml.getBytes("UTF-8"));
		Document doc = saxBuilder.build(stream);
		Element root = doc.getRootElement();
		return (List<Element>) root.getChildren("UDSObject");
	}

	protected Element getUniqueRootList(String xml) throws Exception {
		SAXBuilder saxBuilder = new SAXBuilder();
		InputStream stream = new ByteArrayInputStream(xml.getBytes("UTF-8"));
		Document doc = saxBuilder.build(stream);
		Element root = doc.getRootElement();
		return root;
	}	
	
	public String getValueByAttrName(String xml, String attrName) throws Exception {
		List<Element> rootList;
		rootList = getRootList(xml);

		for (Element root : rootList) {
			List<Element> attrs = root.getChild("Attributes").getChildren("Attribute");
			for (Element element : attrs) {
				String prop = element.getChildText("AttrName");
				String val = element.getChildText("AttrValue");
				if (prop.equals(attrName))
					return val;
			}
		}
		return "";
	}	
	
	public String maperTransfer(String xml) {
		String valor = null;
		try{
			Element root = getUniqueRootList(xml);
			valor = root.getChildText("Handle");
		}catch(Exception ex) {
			System.out.println("Transfer: Ocurrio un error cuando se mapeo " + ex);
		}
		return valor;
		
	}
}
