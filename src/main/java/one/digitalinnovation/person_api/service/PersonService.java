package one.digitalinnovation.person_api.service;

import lombok.RequiredArgsConstructor;
import one.digitalinnovation.person_api.domain.dto.PersonDTO;
import one.digitalinnovation.person_api.domain.entity.PersonEntity;
import one.digitalinnovation.person_api.exception.CpfAlreadyExistsException;
import one.digitalinnovation.person_api.exception.PersonNotFoundException;
import one.digitalinnovation.person_api.mapper.PersonMapper;
import one.digitalinnovation.person_api.repository.PersonRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PersonService {

    final PersonRepository repo;
    final PersonMapper mapper;

    public List<PersonDTO> getAllPeople(Pageable pageable) {
        Page<PersonEntity> entities = repo.findAll(pageable);
        List<PersonDTO> responses = entities.stream().map(mapper::entityToDto).collect(
                Collectors.toList());
        return responses;

    }

    public Long deleteOnePerson(Long id) {
        if (repo.existsById(id)){
            repo.deleteById(id);
            return id;
        }
        throw new PersonNotFoundException(id);
    }

    public PersonDTO getOnePerson(Long id) {
        Optional<PersonEntity> entity = repo.findById(id);
        return entity.map(mapper::entityToDto).orElseThrow(() -> new PersonNotFoundException(id));
    }

    public PersonDTO createOnePerson(PersonDTO request) {
        boolean cpfExists = repo.existsByCpf(request.getCpf());
        if(cpfExists){
            throw new CpfAlreadyExistsException(request.getCpf());
        }
        PersonEntity entity = mapper.dtoToEntity(request);
        PersonEntity entity1 = repo.save(entity);
        return mapper.entityToDto(entity1);

    }

    public PersonDTO updateOnePerson(PersonDTO request, Long id) {
        PersonEntity entity = mapper.dtoToEntity(request);
        entity.setId(id);
        PersonEntity entity1 = repo.save(entity);
        return mapper.entityToDto(entity1);
    }
}
