package com.enlacetpe.ticketapi.util;

public class ReturnValor {
	
	public static String returnValor(String cadenaRecivida) {
		if(cadenaRecivida != null) {
			return cadenaRecivida;
		}else {
			return " ";
		}
	}

}
