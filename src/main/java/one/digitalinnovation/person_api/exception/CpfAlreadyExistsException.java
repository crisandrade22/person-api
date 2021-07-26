package one.digitalinnovation.person_api.exception;

public class CpfAlreadyExistsException extends RuntimeException {
	public CpfAlreadyExistsException(String cpf) {
		super(String.format("This CPF already exists: %s", cpf));
	}

}
