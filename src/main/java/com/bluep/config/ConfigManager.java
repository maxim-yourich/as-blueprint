package com.bluep.config;

import org.aeonbits.owner.ConfigCache;

public class ConfigManager {
    public static ConfigPokeAPI getPokeApiConfiguration() {
        return ConfigCache.getOrCreate(ConfigPokeAPI.class);
    }

    public static ConfigSelenium getSeleniumConfiguration() {
        return ConfigCache.getOrCreate(ConfigSelenium.class);
    }
}
