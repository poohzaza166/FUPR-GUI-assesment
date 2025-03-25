package com.poohserver.model;

import javax.xml.stream.FactoryConfigurationError;
import java.util.ArrayList;
import java.util.Random;

public class SpellChecker {
    private ArrayList data;
    private int randomSelect;

    /**
     * constructor method
     * @param fileName file path to open
     */
    public SpellChecker(String fileName){
        this.data = FileIO.readDataFromFile(fileName);

    }

    /**
     * getter method to get the currently selected random Number
     * @return intger
     */
    public int getRandomSelect() {
        return randomSelect;
    }

    /**
     * Randomly select the number
     */
    public void setRandomSelect(){
        Random random = new Random();
        this.randomSelect = random.nextInt(data.size());
    }

    /**
     * this is a main run method to validate if the number is spelled correctly
     * @param input String type
     * @return is it correct or wrong
     */
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
