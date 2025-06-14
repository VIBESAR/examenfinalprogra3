package com.quarkus.service;

import com.quarkus.dto.PersonDto;
import com.quarkus.mapper.PersonMapper;
import com.quarkus.model.Person;
import com.quarkus.repository.PersonRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class PersonService {

    @Inject
    PersonRepository repository;

    @Transactional
    public Person create(Person person) {
        repository.persist(person);
        return person;
    }

    public List<PersonDto> listAll() {
        return repository.listAll().stream()
                .map(PersonMapper::toDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public void create(PersonDto dto) {
        Person person = PersonMapper.toEntity(dto);
        repository.persist(person);
    }
}
