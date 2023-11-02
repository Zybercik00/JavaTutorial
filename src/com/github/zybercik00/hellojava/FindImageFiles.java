package com.github.zybercik00.hellojava;

import java.util.*;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.lang.Object.*;
// import jakarta.activation.MimetypesFileTypeMap;


public class FindImageFiles extends SimpleFileVisitor<Path> {

    private static Path stringDirectory = Path.of("/Users/kamilchmiel/Desktop/directoryToTest");


    public static void main(String[] args) throws IOException {
        FindImageFiles findImageFiles = new FindImageFiles();
        findImageFiles.visitFile(stringDirectory, findImageFiles.getAttributes());
        Files.walkFileTree(stringDirectory, findImageFiles);
    }

    @Override
    public FileVisitResult visitFile(Path path, BasicFileAttributes attributes) throws IOException {
           if (attributes.isRegularFile()) {
            String filename = path.getFileName().toString();
            int indexOfDot = filename.lastIndexOf(".");
            if (indexOfDot < 0) {
                return FileVisitResult.CONTINUE; 
            } 
            String fileExtention = filename.substring(indexOfDot + 1);
            if (fileExtention.equals("jpeg")) {
                System.out.println(fileExtention);
            }
           } 
        return FileVisitResult.CONTINUE;   
    }

    public BasicFileAttributes getAttributes() throws IOException {
        BasicFileAttributes attributes = Files.readAttributes(stringDirectory, BasicFileAttributes.class);
        return attributes;
    }

    // public void getTypes() {
    //     MimetypesFileTypeMap mimeTypes = new MimetypesFileTypeMap();
    // }
    
}