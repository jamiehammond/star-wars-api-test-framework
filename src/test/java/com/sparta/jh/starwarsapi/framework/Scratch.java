package com.sparta.jh.starwarsapi.framework;

import com.sparta.jh.starwarsapi.framework.dtos.PersonDTO;

public class Scratch {
    public static void main(String[] args) {
        PersonDTO personDTO = Injector.injectDTO("https://swapi.dev/api/people/1/");
        System.out.println(personDTO.getName());
    }
}
