package com.sparta.jh.starwarsapi.framework;

import com.sparta.jh.starwarsapi.framework.connection.APIConnection;
import com.sparta.jh.starwarsapi.framework.connection.APIConnectionController;
import com.sparta.jh.starwarsapi.framework.dtos.PersonDTO;
import com.sparta.jh.starwarsapi.framework.dtos.Resources;
import com.sparta.jh.starwarsapi.framework.injection.Injector;

public class Scratch {
    public static void main(String[] args) {
        APIConnection connection = APIConnectionController.getConnection(Resources.PERSON, 1);
        System.out.println(connection.getURL());
        PersonDTO personDTO = (PersonDTO) Injector.injectDTO(connection);
        System.out.println(personDTO.getName());
    }
}
