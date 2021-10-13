package com.enlacetpe.ticketapi.comunes;

public final class Comunes {

    // Validación de si una cadena es un número
    public static boolean isNumeric(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

}
