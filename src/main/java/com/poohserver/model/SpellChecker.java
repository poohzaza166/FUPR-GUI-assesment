package com.poohserver.model;

import javax.xml.stream.FactoryConfigurationError;
import java.util.ArrayList;
import java.util.Random;

public class SpellChecker {
    private ArrayList data;
    private int randomSelect;
    public SpellChecker(String fileName){
        this.data = FileIO.readDataFromFile(fileName);

    }

    public int getRandomSelect() {
        return randomSelect;
    }

    public void setRandomSelect(){
        Random random = new Random();
        this.randomSelect = random.nextInt(data.size());
    }
    public boolean run(String input){
        int i = NumberToWords.wordsToNumber(input);
        if (i != randomSelect){
            return false;
        }
        if (data.indexOf(i) > -1){

            return true;
        }
        System.out.println("Error: incorrect spelling or number not existed in dict");
        return false;
    }
}
