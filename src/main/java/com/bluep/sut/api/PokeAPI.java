package com.bluep.sut.api;

import com.bluep.config.ConfigManager;
import com.bluep.config.ConfigPokeAPI;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class PokeAPI {
    ConfigPokeAPI pokeAPI;
    RequestSpecification request;

    public PokeAPI() {
        this.request = given();
        this.pokeAPI = ConfigManager.getPokeApiConfiguration();

        this.request.baseUri(this.pokeAPI.baseURI());
        this.request.basePath(this.pokeAPI.basePath());
    }

    public String getPokes() {
        HashMap<String, String> queryParams = new HashMap<String, String>() {{
            put("limit", "2");
            put("offset", "0");
        }};

        Response response = this.request.queryParams(queryParams).when().get(pokeAPI.pokemonList());

        if (response.getStatusCode() == 200) return response.asString();

        return null;
    }
}
