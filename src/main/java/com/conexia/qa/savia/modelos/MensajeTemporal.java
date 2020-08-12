package com.conexia.qa.savia.modelos;

public class MensajeTemporal {

	private static String MENSAJE;
	private static String MENSAJE_TEXTO;

	public static String traerMensaje() {
		return MENSAJE;
	}

	public static void guardarMensaje(String mENSAJE) {
		MENSAJE = mENSAJE;
	}

	public static String traerMensajeTexto() {
		return MENSAJE_TEXTO;
	}

	public static void guardarMensajeTexto(String mensajeTexto) {
		MENSAJE_TEXTO = mensajeTexto;
	}
}
