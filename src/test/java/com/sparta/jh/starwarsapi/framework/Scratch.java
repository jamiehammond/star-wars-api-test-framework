package com.sparta.jh.starwarsapi.framework;

import com.sparta.jh.starwarsapi.framework.dtos.PersonDTO;
import com.sparta.jh.starwarsapi.framework.injection.Injector;

public class Scratch {
    public static void main(String[] args) {
        PersonDTO personDTO = (PersonDTO) Injector.injectDTO("https://swapi.dev/api/people/1/");
        System.out.println(personDTO.getName());
    }
}
