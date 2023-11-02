package com.github.zybercik00.hellojava;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class ReversTextFromFile {

    public static void main(String[] args) throws IOException {
        ReversTextFromFile reversTextFromFile = new ReversTextFromFile();
        List<String> txtToRevers = reversTextFromFile.readFile();
        List<String> reversedTxt = reversTextFromFile.reversImput(txtToRevers);
        reversTextFromFile.writeFile(reversedTxt);

    }

    public void writeFile(List<String> list) throws IOException {
        Path file = Path.of("output.txt");
        Files.write(file, list, StandardCharsets.UTF_8);
        System.out.println("How many lines was written: " + list.size());
    }


    public List<String> reversImput(List<String> input) {
        List<String> newList = new ArrayList<>();
        for (int i = input.size()-1; i >= 0; i--) {
            newList.add(input.get(i));
        }
        return newList;
    }


    public List<String> readFile() throws IOException {
        Path file = Path.of("input.txt");
        List<String> readedFile;
        readedFile = Files.readAllLines(file, StandardCharsets.UTF_8);
        System.out.println("How many lines was readed: " + readedFile.size());
        return readedFile;
    }
    
}
