package com.quarkus.mapper;

import com.quarkus.dto.PersonDto;
import com.quarkus.model.Person;

public class PersonMapper {

    public static PersonDto toDto(Person person) {
        PersonDto dto = new PersonDto();
        dto.id = person.getId();
        dto.name = person.getName();
        return dto;
    }

    public static Person toEntity(PersonDto dto) {
        return new Person(dto.name);
    }
}
