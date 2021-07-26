package one.digitalinnovation.person_api.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import one.digitalinnovation.person_api.domain.enums.PhoneType;

import javax.persistence.*;

@Entity
@Table(name = "phone")
@Getter
@NoArgsConstructor
@Setter
public class PhoneEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;

	@Column(length = 10, nullable = false)
	private PhoneType type;

	@Column(length = 16, nullable = false)
	private String phoneNumber;


}
