package com.github.zybercik00.hellojava.procesbuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class BaeldungProcesBuilder {

    public static void main(String[] args) throws IOException,  InterruptedException {
        BaeldungProcesBuilder baeldungProcesBuilder = new BaeldungProcesBuilder();
        baeldungProcesBuilder.proces();
    }

    public void proces() throws IOException,  InterruptedException {
    ProcessBuilder process = new ProcessBuilder("java", "-version");
    Process p = process.start();

    BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
    String line;
    while ((line = input.readLine()) != null) {
        System.out.println(line);
    }
    p.waitFor();
    System.out.println("ok");
    input.close();
    System.exit(0);
    
    }
}
