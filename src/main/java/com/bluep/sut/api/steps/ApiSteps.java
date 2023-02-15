package com.bluep.sut.api.steps;

import com.bluep.sut.api.PokeAPI;

public class ApiSteps {
    private final PokeAPI pokeAPI = new PokeAPI();

    public String getPokes() {
        return pokeAPI.getPokes();
    }
}
