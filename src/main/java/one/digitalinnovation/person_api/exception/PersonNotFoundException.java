package one.digitalinnovation.person_api.exception;

public class PersonNotFoundException extends RuntimeException{

	public PersonNotFoundException(Long id) {
		super("Could not find person with the id " + id);
	}
}
