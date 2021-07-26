package one.digitalinnovation.person_api.mapper;

import one.digitalinnovation.person_api.domain.entity.PersonEntity;
import one.digitalinnovation.person_api.domain.dto.PersonDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonMapper {
//	PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

	PersonDTO entityToDto(PersonEntity entity);

	PersonEntity dtoToEntity(PersonDTO response);


}
