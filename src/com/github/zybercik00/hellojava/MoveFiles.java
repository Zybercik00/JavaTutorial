package com.github.zybercik00.hellojava;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;

public class MoveFiles extends SimpleFileVisitor<Path> {

    private Path targetPath = Path.of("/Users/kamilchmiel/Projects/HelloJava/src/com/");
    private Path sourcePath = Path.of("/Users/kamilchmiel/Projects/HelloJava/com");
    private Path path = Path.of("/Users/kamilchmiel/Projects/HelloJava/");


    public static void main(String[] args) throws IOException {
    
        MoveFiles moveFiles = new MoveFiles();
        Files.walkFileTree(moveFiles.path, moveFiles);

    }

    
    public FileVisitResult visitFile(Path path, BasicFileAttributes attributes) throws IOException {
        if (attributes.isRegularFile()) {
           String fileName = path.getFileName().toString();
           int indexOfDot = fileName.lastIndexOf(".");
           if (indexOfDot < 0) {
            return FileVisitResult.CONTINUE;
           }
           String sufixString = fileName.substring(indexOfDot + 1);
           if (sufixString.equals("java")) {
            Path relativPath = sourcePath.relativize(path);
            System.out.println("relative: " + relativPath);
            System.out.println("source: " + sourcePath);
            Path newPath = targetPath.resolve(relativPath);
            System.out.println("new: " + newPath);
            Path parrentPath = newPath.getParent();
            // Files.createDirectories(parrentPath);
            // Files.move(path, newPath, StandardCopyOption.REPLACE_EXISTING);
           }
        }
        return FileVisitResult.CONTINUE;
    }
}
    
