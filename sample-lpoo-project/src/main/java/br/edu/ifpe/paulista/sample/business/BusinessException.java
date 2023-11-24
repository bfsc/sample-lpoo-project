package br.edu.ifpe.paulista.sample.business;

public class BusinessException extends RuntimeException {

	public BusinessException() {}

	public BusinessException(String message, Throwable cause) {
		super(message, cause);
	}

	public BusinessException(String message) {
		super(message);
	}

}
