package ro.unibuc;

import java.util.List;
import java.util.Scanner;

public class WordCounting {
    public static void main(String[] args) {
        FileWordCounter fileWordCounter = new FileWordCounter();
        //TODO: add code here to read from console and get the length limit


        Scanner scanner =  new Scanner(System.in);
        int nr = scanner.nextInt();
        List<String> result = fileWordCounter.countN("homework/homework3/src/test/resources/poezie1.txt",nr);
        System.out.println(result.size());
    }
}