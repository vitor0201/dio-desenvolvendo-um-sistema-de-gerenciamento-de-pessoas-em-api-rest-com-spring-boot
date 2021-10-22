package com.rodrigues.nunes.vitor.utils;

import java.time.LocalDate;
import java.util.Collections;

import com.rodrigues.nunes.vitor.dto.PersonDTO;
import com.rodrigues.nunes.vitor.entity.Person;

public class PersonUtils {

	private static final String FIRST_NAME = "Capitu";
	private static final String LAST_NAME = "Rodrigues";
	private static final String CPF_NUMBER = "117.698.031-90";
	private static final Long PERSON_ID = 1L;
	public static final LocalDate BIRTH_DATE = LocalDate.of(2016, 10, 10);

	public static PersonDTO createFakeDTO() {
		return PersonDTO.builder().id(PERSON_ID).firstName(FIRST_NAME).lastName(LAST_NAME).cpf(CPF_NUMBER)
				.birthDate(BIRTH_DATE).phones(Collections.singletonList(PhoneUtils.createFakeDTO())).build();
	}

	public static Person createFakeEntity() {
		return Person.builder().id(PERSON_ID).firstName(FIRST_NAME).lastName(LAST_NAME).cpf(CPF_NUMBER)
				.birthDate(BIRTH_DATE).phones(Collections.singletonList(PhoneUtils.createFakeEntity())).build();
	}
}
