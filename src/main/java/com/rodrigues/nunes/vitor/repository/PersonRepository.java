package com.rodrigues.nunes.vitor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rodrigues.nunes.vitor.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
