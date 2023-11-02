package com.github.zybercik00.hellojava;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class SortedInput {


    public static void main(String [] args) throws IOException {
        SortedInput sortedInput = new SortedInput();
        List<String> input = sortedInput.readFile();
        List<String> output = sortedInput.sortImput(input);
        sortedInput.writeFile(output);
    }


    public void writeFile(List<String> list) throws IOException {
        Path file = Path.of("sortedOutput");
        Files.write(file, list, StandardCharsets.UTF_8);
        System.out.println("linie zapisane: " + list.size());
    }


    public List<String> sortImput(List<String> input) {
        for (int i = 0; i <= input.size() - 2; i++) {
            for (int j = 0; j <= input.size() - 2; j++) {
                if ((input.get(j)).compareTo(input.get(j + 1)) > 0) {
                   String element = input.get(j);
                   input.set(j, input.get(j + 1));
                   input.set(j + 1, element);
                   System.out.println(element.toString());
                } 
            }
        }
        System.out.println("linie posortowane: " + input.size());
        return input;
    }


    public List<String> readFile() throws IOException {
        Path file = Path.of("input.txt");
        List<String> inputFromFile;
        inputFromFile = Files.readAllLines(file, StandardCharsets.UTF_8);
        System.out.println("linie przeczytane: " + inputFromFile.size());
        return inputFromFile;
    }
}