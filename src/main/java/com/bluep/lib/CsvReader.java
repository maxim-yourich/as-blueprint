package com.bluep.lib;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

public class CsvReader {
    public static ArrayList<HashMap<String, String>> readToHashMap(String filePath) throws Exception {
        CSVReader reader = new CSVReader(new FileReader(filePath));
        String[] nextLine;
        ArrayList<HashMap<String, String>> data = new ArrayList<>();
        ArrayList<String> header = new ArrayList<>();
        int i = 0;

        while ((nextLine = reader.readNext()) != null) {
            HashMap<String, String> nextLineMap = new HashMap<>();

            for (int j = 0; j < nextLine.length; j++) {
                String cell = nextLine[j];

                if (i == 0) header.add(cell);
                else {
                    nextLineMap.put(header.get(j), cell);
                }
            }

            if (i != 0) data.add(nextLineMap);
            i++;
        }

        return data;
    }
}
