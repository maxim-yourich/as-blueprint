package com.bluep.constants;

import java.nio.file.Path;
import java.nio.file.Paths;

public class FileLocations {
    private static final String PROJECT_DIR = System.getProperty("user.dir");
    public static Path MAIN_RESOURCES = Paths.get(PROJECT_DIR, "src", "main", "resources");
    public static Path TEST_RESOURCES = Paths.get(PROJECT_DIR, "src", "test", "resources");
    public static String POKEMON_LIST_EXPECTED_RESULT_FILE = String.valueOf(Paths.get(String.valueOf(TEST_RESOURCES), "pokemonListExpectedResult.json"));
}
