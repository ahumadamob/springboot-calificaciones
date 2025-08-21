package com.imb2025.calificaciones.exception;

public class EntidadNoEncontradaException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EntidadNoEncontradaException(String mensaje) {
        super(mensaje);
    }
}
