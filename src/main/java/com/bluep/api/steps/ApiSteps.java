package com.bluep.api.steps;

import com.bluep.api.PokeAPI;

public class ApiSteps {
    private final PokeAPI pokeAPI = new PokeAPI();

    public String getPokes() {
        return pokeAPI.getPokes();
    }
}
