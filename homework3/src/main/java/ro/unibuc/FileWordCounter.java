package ro.unibuc;

import java.util.Collections;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class FileWordCounter {

    //HINT: you could make one generic method to reuse for all three methods above
    //HINT2: think about functional interfaces, one that verifies things in particular
    public List<String> getWordsWithLengthGreaterThanN(String fileName, int n, String word) {
        List<String> returnList = new ArrayList<String>();
        try {
            File itemsFile = new File(fileName);
            Scanner fileReader = new Scanner(itemsFile);
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                String[] wordsOnLine = line.split(" ");
                for (String s : wordsOnLine) {
                    if(s.length() < n) {
                        returnList.add(s);
                    }
                    if(n==0) {
                        if((s.charAt(s.length()-1) == '!' && s.substring(0,s.length()-1).equals(word)) || s.equals(word)){
                            returnList.add(s);
                        }
                    }
                }
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return returnList;
    }

    public List<String> getSizeOne(String fileName) {
        //TODO: add code here
        //return Collections.emptyList();
        return this.getWordsWithLengthGreaterThanN(fileName,2,"");
    }

    public List<String> getSizeLessThan3(String fileName) {
        //TODO: add code here
        //return Collections.emptyList();
        return this.getWordsWithLengthGreaterThanN(fileName,3,"");
    }

    public List<String> countWordAppearances(String fileName, String word) {
        //TODO: add code here
        //return Collections.emptyList();
        return this.getWordsWithLengthGreaterThanN(fileName,0,word);
    }
}