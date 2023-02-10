package com.bluep.config;

import org.aeonbits.owner.ConfigCache;

public class ConfigManager {
    public static Configuration getConfiguration() {
        return ConfigCache.getOrCreate(Configuration.class);
    }
}
