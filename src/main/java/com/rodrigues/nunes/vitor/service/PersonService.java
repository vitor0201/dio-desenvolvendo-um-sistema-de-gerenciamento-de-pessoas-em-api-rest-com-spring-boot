package com.rodrigues.nunes.vitor.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodrigues.nunes.vitor.dto.MessageResponseDTO;
import com.rodrigues.nunes.vitor.dto.PersonDTO;
import com.rodrigues.nunes.vitor.entity.Person;
import com.rodrigues.nunes.vitor.exception.PersonNotFoundException;
import com.rodrigues.nunes.vitor.mapper.PersonMapper;
import com.rodrigues.nunes.vitor.repository.PersonRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonService {

	private PersonRepository personRepository;

	private final PersonMapper personMapper = PersonMapper.INSTANCE;

	public MessageResponseDTO createPerson(PersonDTO person) {
		Person personToSave = personMapper.toModel(person);
		Person savedPerson = personRepository.save(personToSave);
		return createMessageResponse(savedPerson.getId(), "Created person with ID " );
	}

	public List<PersonDTO> listAll() {
		List<Person> persons = personRepository.findAll();
		return persons.stream().map(personMapper::toDTO).collect(Collectors.toList());
	}

	public PersonDTO findById(Long id) throws PersonNotFoundException {
		Person person = verifyIfExists(id);
		return personMapper.toDTO(person);
	}

	public void deleteById(Long id) throws PersonNotFoundException {
		Person person = verifyIfExists(id);
		personRepository.delete(person);
	}

	public MessageResponseDTO updateById(Long id, PersonDTO person) throws PersonNotFoundException {
		verifyIfExists(id);
		Person personToUpdate = personMapper.toModel(person);
		Person updatedPerson = personRepository.save(personToUpdate);
		return createMessageResponse(updatedPerson.getId(), "Edited person with ID ");
	}

	private Person verifyIfExists(Long id) throws PersonNotFoundException {
		Person person = personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
		return person;
	}

	private MessageResponseDTO createMessageResponse(Long id, String message) {
		return MessageResponseDTO.builder().message(message + id).build();
	}

}
