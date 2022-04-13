package ro.unibuc;

import java.util.Collections;
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.io.FileNotFoundException;


public class FileWordCounter {
    public List<String> countN (String fileName, int n) {
        List<String> lista = new ArrayList<String>();
        try {
            Scanner fileReader = new Scanner(new File(fileName));
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                String[] wordsOnLine = line.split(" ");
                for (String s : wordsOnLine) {
                    if(s.length() < n) {
                        lista.add(s);
                    }

                }
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
        }
        return lista;
    }


    public List<String> word (String fileName, String word) {
        List<String> lista = new ArrayList<String>();
        try {

            Scanner fileReader = new Scanner(new File(fileName));
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                String[] wordsOnLine = line.split(" ");
                for (String s : wordsOnLine) {
                    if(s.replace("!", "").equals(word)){
                        lista.add(s);
                    }
                }
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
        }
        return lista;
    }

    public List<String> getSizeOne(String fileName) {

        return this.countN(fileName,2);
    }

    public List<String> getSizeLessThan3(String fileName) {

        return this.countN(fileName,3);
    }

    public List<String> countWordAppearances(String fileName, String word) {
        return this.word(fileName,word);
    }
}