package one.digitalinnovation.person_api.domain.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import one.digitalinnovation.person_api.domain.enums.PhoneType;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@RequiredArgsConstructor
public class PhoneDTO {

	private final Long id;

	@NotNull
	private final PhoneType type;

	@NotEmpty
	@Size(min = 10, max = 16)
	private final String phoneNumber;

}
