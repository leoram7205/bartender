package com.aldeamo.bartender.exception;

import org.springframework.http.HttpStatus;

public class DatosException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	private String codigo;
	private HttpStatus estado;
	
	public DatosException(String codigo, HttpStatus estado, String message) {
		super(message);
		this.codigo = codigo;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public HttpStatus getEstado() {
		return estado;
	}

	public void setEstado(HttpStatus estado) {
		this.estado = estado;
	}
	
}
