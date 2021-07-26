package one.digitalinnovation.person_api.domain.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Getter
@RequiredArgsConstructor
public class PersonDTO {
    private final Long id;

    @NotNull
    @Size(min = 2)
    private final String firstName;

    @NotNull
    @Size(min = 2)
    private final String surname;

    @NotNull
    @CPF
    private final String cpf;
    
    @NotNull
    @Past
    private final LocalDate birthDate;

    @NotNull
    @Valid

    private final List<PhoneDTO> phones;
}
