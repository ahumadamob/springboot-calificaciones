package com.imb2025.calificaciones.exception;

//Esta clase se usa cuando intentás crear un recurso duplicado (por ejemplo, un identificador repetido)
public class DuplicateResourceException extends RuntimeException {

 private static final long serialVersionUID = 1L;

 public DuplicateResourceException(String message) {
     super(message);
 }
}