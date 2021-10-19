package com.rodrigues.nunes.vitor.service;

import org.springframework.stereotype.Service;

import com.rodrigues.nunes.vitor.dto.MessageResponseDTO;
import com.rodrigues.nunes.vitor.dto.PersonDTO;
import com.rodrigues.nunes.vitor.entity.Person;
import com.rodrigues.nunes.vitor.mapper.PersonMapper;
import com.rodrigues.nunes.vitor.repository.PersonRepository;

@Service
public class PersonService {

	private PersonRepository personRepository;

	private final PersonMapper personMapper = PersonMapper.INSTACE;

	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	public MessageResponseDTO createPerson(PersonDTO person) {
		Person personToSave = personMapper.toModel(person);
		Person savedPerson = personRepository.save(personToSave);
		return MessageResponseDTO.builder().message("Created person with ID " + savedPerson.getId()).build();
	}
}
