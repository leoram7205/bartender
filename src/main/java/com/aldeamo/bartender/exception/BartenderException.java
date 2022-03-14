package com.aldeamo.bartender.exception;

import org.springframework.http.HttpStatus;

public class BartenderException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String codigo;
	private HttpStatus estado;
	
	public BartenderException(String codigo, HttpStatus estado, String message) {
		super(message);
		this.codigo = codigo;
		this.estado = estado;
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
