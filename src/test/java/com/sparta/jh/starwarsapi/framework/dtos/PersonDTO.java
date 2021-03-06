package com.sparta.jh.starwarsapi.framework.dtos;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.jh.starwarsapi.framework.connection.APIConnection;
import com.sparta.jh.starwarsapi.framework.connection.APIConnectionController;
import com.sparta.jh.starwarsapi.framework.injection.Injector;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "name",
        "height",
        "mass",
        "hair_color",
        "skin_color",
        "eye_color",
        "birth_year",
        "gender",
        "homeworld",
        "films",
        "species",
        "vehicles",
        "starships",
        "created",
        "edited",
        "URL"
})
public class PersonDTO extends StarWarsDTO {

    @JsonProperty("name")
    private String name;
    @JsonProperty("height")
    private String height;
    @JsonProperty("mass")
    private String mass;
    @JsonProperty("hair_color")
    private String hairColor;
    @JsonProperty("skin_color")
    private String skinColor;
    @JsonProperty("eye_color")
    private String eyeColor;
    @JsonProperty("birth_year")
    private String birthYear;
    @JsonProperty("gender")
    private String gender;
    @JsonProperty("homeworld")
    private String homeworld;
    @JsonProperty("films")
    private List<String> films = null;
    @JsonProperty("species")
    private List<String> species = null;
    @JsonProperty("vehicles")
    private List<String> vehicles = null;
    @JsonProperty("starships")
    private List<String> starships = null;
    @JsonProperty("created")
    private String created;
    @JsonProperty("edited")
    private String edited;
    @JsonProperty("url")
    private String URL;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    public PersonDTO() {
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("height")
    public String getHeight() {
        return height;
    }

    @JsonProperty("height")
    public void setHeight(String height) {
        this.height = height;
    }

    @JsonProperty("mass")
    public String getMass() {
        return mass;
    }

    @JsonProperty("mass")
    public void setMass(String mass) {
        this.mass = mass;
    }

    @JsonProperty("hair_color")
    public String getHairColor() {
        return hairColor;
    }

    @JsonProperty("hair_color")
    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    @JsonProperty("skin_color")
    public String getSkinColor() {
        return skinColor;
    }

    @JsonProperty("skin_color")
    public void setSkinColor(String skinColor) {
        this.skinColor = skinColor;
    }

    @JsonProperty("eye_color")
    public String getEyeColor() {
        return eyeColor;
    }

    @JsonProperty("eye_color")
    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    @JsonProperty("birth_year")
    public String getBirthYear() {
        return birthYear;
    }

    @JsonProperty("birth_year")
    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    @JsonProperty("gender")
    public String getGender() {
        return gender;
    }

    @JsonProperty("gender")
    public void setGender(String gender) {
        this.gender = gender;
    }

    @JsonProperty("homeworld")
    public String getHomeworld() {
        return homeworld;
    }

    @JsonProperty("homeworld")
    public void setHomeworld(String homeworld) {
        this.homeworld = homeworld;
    }

    @JsonProperty("films")
    public List<String> getFilms() {
        return films;
    }

    @JsonProperty("films")
    public void setFilms(List<String> films) {
        this.films = films;
    }

    @JsonProperty("species")
    public List<String> getSpecies() {
        return species;
    }

    @JsonProperty("species")
    public void setSpecies(List<String> species) {
        this.species = species;
    }

    @JsonProperty("vehicles")
    public List<String> getVehicles() {
        return vehicles;
    }

    @JsonProperty("vehicles")
    public void setVehicles(List<String> vehicles) {
        this.vehicles = vehicles;
    }

    @JsonProperty("starships")
    public List<String> getStarships() {
        return starships;
    }

    @JsonProperty("starships")
    public void setStarships(List<String> starships) {
        this.starships = starships;
    }

    @JsonProperty("created")
    public String getCreated() {
        return created;
    }

    @JsonProperty("created")
    public void setCreated(String created) {
        this.created = created;
    }

    @JsonProperty("edited")
    public String getEdited() {
        return edited;
    }

    @JsonProperty("edited")
    public void setEdited(String edited) {
        this.edited = edited;
    }

    @JsonProperty("url")
    public String getURL() {
        return URL;
    }

    @JsonProperty("url")
    public void setURL(String URL) {
        this.URL = URL;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public boolean hasName() {
        return name.getClass() == String.class;
    }

    public boolean hasHeight() {
        return height.getClass() == String.class;
    }

    public boolean hasMass() {
        return mass.getClass() == String.class;
    }

    public boolean hasHairColor() {
        return hairColor.getClass() == String.class;
    }

    public boolean hasSkinColor() {
        return skinColor.getClass() == String.class;
    }

    public boolean hasEyeColor() {
        return eyeColor.getClass() == String.class;
    }

    public boolean hasBirthYear() {
        return birthYear.getClass() == String.class;
    }

    public boolean hasGender() {
        return gender.getClass() == String.class;
    }

    public boolean hasHomeworld() {
        return homeworld.getClass() == String.class;
    }

    public boolean hasCreated() {
        return created.getClass() == String.class;
    }

    public boolean hasEdited() {
        return edited.getClass() == String.class;
    }

    public boolean hasURL() {
        return URL.getClass() == String.class;
    }

    public PlanetDTO getHomeworldAsDTO() {
        String replacedURL = homeworld.replace("http", "https");
        APIConnection connection = APIConnectionController.getConnection(replacedURL);
        return (PlanetDTO) Injector.injectDTO(connection);
    }

    public ArrayList<FilmDTO> getFilmsAsDTOs() {
        ArrayList<FilmDTO> DTOList = new ArrayList<>();
        for (String URL : films) {
            String replacedURL = URL.replace("http", "https");
            APIConnection connection = APIConnectionController.getConnection(replacedURL);
            FilmDTO currentFilm = (FilmDTO) Injector.injectDTO(connection);
            DTOList.add(currentFilm);
        }
        return DTOList;
    }

    public ArrayList<SpeciesDTO> getSpeciesAsDTOs() {
        ArrayList<SpeciesDTO> DTOList = new ArrayList<>();
        for (String URL : species) {
            String replacedURL = URL.replace("http", "https");
            APIConnection connection = APIConnectionController.getConnection(replacedURL);
            SpeciesDTO currentSpecies = (SpeciesDTO) Injector.injectDTO(connection);
            DTOList.add(currentSpecies);
        }
        return DTOList;
    }

    public ArrayList<VehicleDTO> getVehiclesAsDTOs() {
        ArrayList<VehicleDTO> DTOList = new ArrayList<>();
        for (String URL : vehicles) {
            String replacedURL = URL.replace("http", "https");
            APIConnection connection = APIConnectionController.getConnection(replacedURL);
            VehicleDTO currentVehicle = (VehicleDTO) Injector.injectDTO(connection);
            DTOList.add(currentVehicle);
        }
        return DTOList;
    }

    public ArrayList<StarshipDTO> getStarshipsAsDTOs() {
        ArrayList<StarshipDTO> DTOList = new ArrayList<>();
        for (String URL : starships) {
            String replacedURL = URL.replace("http", "https");
            APIConnection connection = APIConnectionController.getConnection(replacedURL);
            StarshipDTO currentStarship = (StarshipDTO) Injector.injectDTO(connection);
            DTOList.add(currentStarship);
        }
        return DTOList;
    }


    public String[] getNames() {
        if (isNullOrEmpty(name)) {
            System.err.println("Name is null or empty. Returning null.");
            return null;
        }
        return name.split(" ");
    }

    public String getFirstName() {
        return getNames()[0];
    }

    public String getLastName() {
        String[] names = getNames();
        return names[names.length-1];
    }

    public boolean isNullOrEmpty(String string) {
        if (string == null || string.equals("")) {
            return true;
        }
        return false;
    }

    public JsonNode getJson() {
        String replacedURL = URL.replace("http", "https");
        APIConnection connection = APIConnectionController.getConnection(replacedURL);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.valueToTree(connection.getHttpResponse().body());
    }

    public String toString() {
        return getJson().asText();
    }

    public ArrayList<String> getNullOrEmptyFields() {
        ArrayList<String> nullOrEmptyFields = new ArrayList<>();
        if (isNullOrEmpty(name)) {
            nullOrEmptyFields.add("name");
        }
        if (isNullOrEmpty(height)) {
            nullOrEmptyFields.add("height");
        }
        if (isNullOrEmpty(mass)) {
            nullOrEmptyFields.add("mass");
        }
        if (isNullOrEmpty(hairColor)) {
            nullOrEmptyFields.add("hairColor");
        }
        if (isNullOrEmpty(skinColor)) {
            nullOrEmptyFields.add("skinColor");
        }
        if (isNullOrEmpty(eyeColor)) {
            nullOrEmptyFields.add("eyeColor");
        }
        if (isNullOrEmpty(birthYear)) {
            nullOrEmptyFields.add("birthYear");
        }
        if (isNullOrEmpty(gender)) {
            nullOrEmptyFields.add("gender");
        }
        if (isNullOrEmpty(homeworld)) {
            nullOrEmptyFields.add("homeworld");
        }
        if (films.size() == 0) {
            nullOrEmptyFields.add("films");
        }
        if (species.size() == 0) {
            nullOrEmptyFields.add("species");
        }
        if (vehicles.size() == 0) {
            nullOrEmptyFields.add("vehicles");
        }
        if (starships.size() == 0) {
            nullOrEmptyFields.add("starships");
        }
        if (isNullOrEmpty(created)) {
            nullOrEmptyFields.add("created");
        }
        if (isNullOrEmpty(edited)) {
            nullOrEmptyFields.add("edited");
        }
        if (isNullOrEmpty(URL)) {
            nullOrEmptyFields.add("URL");
        }
        return nullOrEmptyFields;
    }

    public boolean hasNullOrEmptyFields() {
        return getNullOrEmptyFields().size() > 0;
    }

    public int getHeightAsInt() {
        if (isNullOrEmpty(height)) {
            System.err.println("Height is null or empty. Returning -1..");
            return -1;
        }
        try {
            return Integer.parseInt(height);
        } catch (NumberFormatException e) {
            System.err.println("Height is not in integer format. Returning -1.");
            e.printStackTrace();
            return -1;
        }
    }

    public int getMassAsInt() {
        if (isNullOrEmpty(mass)) {
            System.err.println("Mass is null or empty. Returning -1.");
            return -1;
        }
        try {
            return Integer.parseInt(mass);
        } catch (NumberFormatException e) {
            System.err.println("Mass is not in integer format. Returning -1.");
            e.printStackTrace();
            return -1;
        }
    }

    public boolean isHeightInRange(int min, int max) {
        int height = getHeightAsInt();
        return height >= min && height <= max;
    }

    public boolean isMassInRange(int min, int max) {
        int mass = getMassAsInt();
        return mass >= min && mass <= max;
    }
}