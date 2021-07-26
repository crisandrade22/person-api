package one.digitalinnovation.person_api.advice;

import one.digitalinnovation.person_api.exception.CpfAlreadyExistsException;
import one.digitalinnovation.person_api.exception.PersonNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class ControllerAdvices {

	@ResponseBody
	@ExceptionHandler(PersonNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public Map<String, String> personNotFoundHandler(PersonNotFoundException ex) {
		return Map.of("message", ex.getMessage());
	}

	@ResponseBody
	@ExceptionHandler(ConstraintViolationException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Map<String, String> constraintViolationHandler(ConstraintViolationException ex) {
		return Map.of("message", ex.getMessage());
	}

	@ResponseBody
	@ExceptionHandler(CpfAlreadyExistsException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Map<String, String> cpfAlreadyExistsHandler(CpfAlreadyExistsException ex) {
		return Map.of("message", ex.getMessage());
	}

	@ResponseBody
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Map<String, List<String>> methodArgHandler(MethodArgumentNotValidException ex) {
		List<String> errors = new ArrayList<>();
		for (ObjectError fieldError : ex.getBindingResult().getAllErrors()) {
			FieldError error = (FieldError) fieldError;
			errors.add(error.getField() + ":" + fieldError.getDefaultMessage());
		}

		return Map.of("message", errors);
	}

	@ResponseBody
	@ExceptionHandler(HttpMessageNotReadableException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Map<String, String> messageNotReadeableHandler(HttpMessageNotReadableException ex) {
		return Map.of("message", "Request Json is not valid");
	}

}
