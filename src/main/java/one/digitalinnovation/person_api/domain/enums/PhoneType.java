package one.digitalinnovation.person_api.domain.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum PhoneType {
	HOME("Home"), MOBILE("Mobile"), COMMERCIAL("Commercial");

	private final String description;

	@JsonValue
	public String getDescription() {
		return this.description;
	}
}
