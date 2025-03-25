package com.poohserver.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileIO {

    private static Object fileData;

    /**
     * @param fileName
     * this function take in file name input and return a arraylist of Intger
     * @return ArrayList<Integer>
     */
    public static ArrayList<Integer> readDataFromFile(String fileName) {
        ArrayList<Integer> obj = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Path.of(fileName));
            for (String line : lines) {
                obj.add(Integer.parseInt(line.trim()));
            }
        } catch (IOException e) {
            System.out.println("ERROR:");
            System.out.println(e);
            System.exit(1);
        }
        fileData = obj;
        return obj;
    }

}


