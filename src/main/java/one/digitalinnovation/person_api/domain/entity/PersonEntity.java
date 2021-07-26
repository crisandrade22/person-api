package one.digitalinnovation.person_api.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "people")
@Getter
@NoArgsConstructor
@Setter
public class PersonEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;

	@Column(length = 90, nullable = false)
	private String firstName;

	@Column(length = 110, nullable = false)
	private String surname;

	@Column(unique = true, length = 14, nullable = false)
	private String cpf;

	@Column(nullable = false)
	private LocalDate birthDate;

	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
	private List<PhoneEntity> phones;
}
