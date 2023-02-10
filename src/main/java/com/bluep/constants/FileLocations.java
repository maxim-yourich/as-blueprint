package com.bluep.constants;

public class FileLocations {
    private static final String PROJECT_DIR = System.getProperty("user.dir");
    public static String MAIN_RESOURCES = PROJECT_DIR + "\\src\\main\\resources";
    public static String TEST_RESOURCES = PROJECT_DIR + "\\src\\test\\resources";
    public static String POKEMON_LIST_EXPECTED_RESULT_FILE = TEST_RESOURCES + "\\pokemonListExpectedResult.json";
}
