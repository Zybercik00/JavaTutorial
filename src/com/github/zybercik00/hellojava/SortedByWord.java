package com.github.zybercik00.hellojava;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;


public class SortedByWord {


    public static void main(String[] args) throws IOException {
        SortedByWord sortedByWord = new SortedByWord();
        List<String> input = sortedByWord.readFile();
        List<String> sortedInput = sortedByWord.sortInput(input);
        sortedByWord.writeFile(sortedInput);
        
    }

    public void writeFile(List<String> list) throws IOException {
        Path file = Path.of("sortedOutputByWord");
        Files.write(file, list, StandardCharsets.UTF_8);
        System.out.println("linie zapisane: " + list.size());
    }

    public List<String> sortInput(List<String> input) {
        for (int outerIndex = 0; outerIndex <= input.size() - 2; outerIndex++) {
            for (int innerIndex = 0; innerIndex <= input.size() - 2; innerIndex++) {
                String current = input.get(innerIndex);
                String next = input.get(innerIndex + 1);
                if (compareTo(current, next) > 0) {
                    input.set(innerIndex, next);
                    input.set(innerIndex + 1, current);
                }
            }
        }
        return input;
    }

    private int compareTo(String left, String right) {
       String [] leftStrings = left.split(" ");
       String [] righStrings = right.split(" ");
       if(leftStrings.length < 3) {
        System.out.println("minej niz trzy slowa: " + left);
       }
       if(righStrings.length < 3) {
        System.out.println("minej niz trzy slowa: " + right);
       }
       String leftWord = leftStrings[2];
       String rightWord = righStrings[2];
       
        return leftWord.compareTo(rightWord);
    }

    public List<String> readFile() throws IOException {
        Path file = Path.of("input.txt");
        List<String> inputFromFile;
        inputFromFile = Files.readAllLines(file, StandardCharsets.UTF_8);
        System.out.println("linie przeczytane: " + inputFromFile.size());
        return inputFromFile;
    }
    
}
