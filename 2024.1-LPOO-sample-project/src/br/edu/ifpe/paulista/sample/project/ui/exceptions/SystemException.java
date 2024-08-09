package br.edu.ifpe.paulista.sample.project.ui.exceptions;

public class SystemException extends Exception {

	public SystemException(String message, Throwable cause) {
		super(message, cause);
	}

	public SystemException(String message) {
		super(message);
	}
	
}
