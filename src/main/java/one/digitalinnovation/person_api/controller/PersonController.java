package one.digitalinnovation.person_api.controller;

import lombok.RequiredArgsConstructor;
import one.digitalinnovation.person_api.domain.dto.PersonDTO;
import one.digitalinnovation.person_api.service.PersonService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequestMapping("people")
@Validated
@RequiredArgsConstructor
public class PersonController {
    final PersonService service;

    @GetMapping
    public List<PersonDTO> getAllPeople(Pageable pageable){
        return service.getAllPeople(pageable);
    }
    @GetMapping("{id}")
    public PersonDTO getOnePerson(@Positive @PathVariable Long id){
        return service.getOnePerson(id);
    }

    @DeleteMapping("{id}")
    public Long deleteOnePerson(@PathVariable Long id){
        return service.deleteOnePerson(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PersonDTO createOnePerson(@Valid @RequestBody PersonDTO request){
        return service.createOnePerson(request);
    }

    @PutMapping("{id}")
    public PersonDTO updateOnePerson(@Valid @RequestBody PersonDTO request, @PathVariable Long id){
        return service.updateOnePerson(request, id);
    }
}
