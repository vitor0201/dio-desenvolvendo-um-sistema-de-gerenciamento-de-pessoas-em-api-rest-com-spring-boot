package com.rodrigues.nunes.vitor.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.rodrigues.nunes.vitor.dto.PersonDTO;
import com.rodrigues.nunes.vitor.entity.Person;

@Mapper
public interface PersonMapper {

	PersonMapper INSTACE = Mappers.getMapper(PersonMapper.class);

	@Mapping(target = "birthDate", source= "birthDate", dateFormat = "dd-MM-yyyy")
	Person toModel(PersonDTO personDTO);

	PersonDTO toDTO(Person person);
}
