package com.imb2025.calificaciones.exception;

public class EntidadNoEncontradaException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public EntidadNoEncontradaException(String mensaje) {
        super(mensaje);
    }
    
    public class DuplicateResourceException extends RuntimeException {
        private static final long serialVersionUID = 1L;
        public DuplicateResourceException(String message) {
            super(message);
        }
    }  
    
}
