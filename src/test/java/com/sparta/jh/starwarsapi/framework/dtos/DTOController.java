package com.sparta.jh.starwarsapi.framework.dtos;

import com.sparta.jh.starwarsapi.framework.connection.APIConnection;
import com.sparta.jh.starwarsapi.framework.connection.APIConnectionController;
import com.sparta.jh.starwarsapi.framework.injection.Injector;

import java.util.ArrayList;

public class DTOController {

    public static ArrayList<PeopleDTO> getAllPeopleDTOs() {
        ArrayList<PeopleDTO> peopleList = new ArrayList<>();
        int count = 1;
        PeopleDTO currentPeople = null;
        do {
            APIConnection connection = APIConnectionController.getConnection(Resources.PERSON, "?page=", count);
            currentPeople = Injector.injectPeopleDTO(connection);
            if (currentPeople != null) {
                peopleList.add(currentPeople);
            }
            count++;
        } while (currentPeople.getNext() != null);
        return peopleList;
    }

    public static ArrayList<PersonDTO> getAllPeople() {
        ArrayList<PersonDTO> people = new ArrayList<>();
        for (PeopleDTO currentPeople : getAllPeopleDTOs()) {
            for (PersonDTO person : currentPeople.getResults()) {
                people.add(person);
            }
        }
        return people;
    }
}
