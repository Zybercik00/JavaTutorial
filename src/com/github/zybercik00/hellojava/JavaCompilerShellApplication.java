package com.github.zybercik00.hellojava;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Stream;

public class JavaCompilerShellApplication extends SimpleFileVisitor<Path> {

    private static Path path = Path.of("/Users/kamilchmiel/Projects/HelloJava/");
    private final String className;
   

    JavaCompilerShellApplication(String className) {
        this.className = className;
    }

    public static void main(String[] args) throws IOException {
        for (String argument : args) {
            JavaCompilerShellApplication javaCompilerShellApplication = new JavaCompilerShellApplication(argument);
            Files.walkFileTree(path, javaCompilerShellApplication);
        }
    }

    @Override
    public FileVisitResult visitFile(Path path, BasicFileAttributes attributes) throws IOException {
        if ( !attributes.isRegularFile() ) {
        return FileVisitResult.CONTINUE;
        }
        String fileName = path.getFileName().toString();
 
        int indexOfDot = fileName.lastIndexOf(".");
        if (indexOfDot < 0) {
            return FileVisitResult.CONTINUE;
        }
        String fileExtension = fileName.substring(indexOfDot + 1);
        if ( !fileExtension.equals("java") ) {
            return FileVisitResult.CONTINUE;
        }
        String basename = fileName.substring(0, indexOfDot);
        if ( className.equals(basename) ) {
            // TODO compile and run
            
        }
        return FileVisitResult.CONTINUE;
    }
}