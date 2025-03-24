package com.poohserver.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileIO {

    private static Object fileData;


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
//    public static void main(String[] args) {
//        String fileName = "/home/pooh/Docrewruments/sussex/furtherprogramming/le-gui-assesmentv2electric-bongaloo/Assets/test.txt"; // Ensure this file exists with integer values
//
//        ArrayList<Integer> numbers = FileIO.readDataFromFile(fileName);
//
//        if (numbers.isEmpty()) {
//            System.out.println("No data read from the file or the file does not exist.");
//        } else {
//            System.out.println("Numbers read from the file:");
//            for (int num : numbers) {
//                System.out.println(num);
//            }
//        }
//    }

}


