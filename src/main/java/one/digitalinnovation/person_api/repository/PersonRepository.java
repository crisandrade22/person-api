package one.digitalinnovation.person_api.repository;

import one.digitalinnovation.person_api.domain.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<PersonEntity, Long> {

	boolean existsByCpf(String cpf);
}

