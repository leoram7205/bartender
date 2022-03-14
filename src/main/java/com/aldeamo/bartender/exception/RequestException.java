package com.aldeamo.bartender.exception;

public class RequestException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String codigo;
	
	public RequestException(String codigo, String message) {
		super(message);
		this.codigo = codigo; }

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
}
