package br.edu.ifpe.paulista.sample.project.ui.exceptions;

public class BusinessException extends Exception {

	public BusinessException(String message, Throwable cause) {
		super(message, cause);
	}

	public BusinessException(String message) {
		super(message);
	}
	
}
