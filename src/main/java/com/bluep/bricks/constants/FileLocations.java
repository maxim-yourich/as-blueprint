package com.bluep.bricks.constants;

import java.nio.file.Path;
import java.nio.file.Paths;

public class FileLocations {
    //    FOLDERS
    private static final String PROJECT_DIR = System.getProperty("user.dir");
    public static Path MAIN_RESOURCES = Paths.get(PROJECT_DIR, "src", "main", "resources");
    public static Path TEST_DATA = Paths.get(PROJECT_DIR, "src", "test", "resources", "data");
    public static Path TEST_DATA_API = Paths.get(String.valueOf(TEST_DATA), "api-data");
    public static Path TEST_DATA_COMMON = Paths.get(String.valueOf(TEST_DATA), "common");

    //    DATA FILES
    public static Path POKEMON_LIST_EXPECTED_RESULT_FILE_LOCATION = getFile(TEST_DATA_API, "pokemonListExpectedResult.json");
    public static Path DEV_FEATURE_DATA_FILE_LOCATION = getFile(TEST_DATA_COMMON, "dev-feature-data.csv");

    private static Path getFile(Path folder, String fileName) {
        return Paths.get(String.valueOf(folder), fileName);
    }
}
