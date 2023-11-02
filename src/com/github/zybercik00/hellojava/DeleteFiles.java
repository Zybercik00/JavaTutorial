package com.github.zybercik00.hellojava;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class DeleteFiles extends SimpleFileVisitor<Path> {


    public static void main(String[] args) throws IOException{
        Path path = Path.of("/Users/kamilchmiel/Projects/HelloJava/");
        DeleteFiles deleteFiles = new DeleteFiles();
        BasicFileAttributes attributes = deleteFiles.getAttributes();
        deleteFiles.visitFile(path, attributes);
        Files.walkFileTree(path, deleteFiles);

    }
    


   public FileVisitResult visitFile(Path path, BasicFileAttributes attributes) throws IOException {
        if (attributes.isRegularFile()) {
            String filename = path.getFileName().toString();
            int indexOfDot = filename.lastIndexOf(".");
            if (indexOfDot < 0) {
                return FileVisitResult.CONTINUE; 
            } 
            String fileExtention = filename.substring(indexOfDot + 1);
            if (fileExtention.equals("class")) {
                Files.delete(path);
            }
        }
        return FileVisitResult.CONTINUE;
    }

    public BasicFileAttributes getAttributes() throws IOException {
        Path path = Path.of("/Users/kamilchmiel/Projects/HelloJava/");
        BasicFileAttributes attributes = Files.readAttributes(path, BasicFileAttributes.class);
        return attributes;
    }
   
}

