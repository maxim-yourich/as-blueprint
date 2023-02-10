package com.bluep.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:pokeAPI.properties"})
public interface Configuration extends Config {

    @Key("api.base.path")
    String basePath();

    @Key("api.base.uri")
    String baseURI();

    @Key("api.pokemon.list")
    String pokemonList();

    @Key("log.all")
    boolean logAll();
}
