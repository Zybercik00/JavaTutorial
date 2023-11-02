package com.github.zybercik00.hellojava;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.stream.Stream;

public class JavaCompilerShellApplication extends SimpleFileVisitor<Path>{

    private static Path projectPath = Path.of("/Users/kamilchmiel/Projects/HelloJava/");
    private final String className;
   

    JavaCompilerShellApplication(String className) {
        this.className = className;
    }

    public static void main(String[] args) throws IOException {
        for (String argument : args) {
            JavaCompilerShellApplication javaCompilerShellApplication = new JavaCompilerShellApplication(argument);
            Files.walkFileTree(projectPath, javaCompilerShellApplication);
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
        if ( !className.equals(basename) ) {
            return FileVisitResult.CONTINUE;
        }

        Path relativePath = projectPath.relativize(path);
        String stringRelativePath = relativePath.toString();
        int lastIndexOf = stringRelativePath.lastIndexOf(".");
        String stringBuildPath = stringRelativePath.substring(4, lastIndexOf);
        String fullClassName = stringBuildPath.replace("/", ".");
        System.out.println("Full class name: " + fullClassName);

        try {
            Process compileProcess = new ProcessBuilder("javac", "-d", "build", stringRelativePath)
                .inheritIO()
                .start();
            int compilerExitcode = compileProcess.waitFor();
            
            if (compilerExitcode == 0) {
                System.out.println("Compiler exit code: " + compilerExitcode);
                Process javaProcess = new ProcessBuilder("java", "-cp", "build", fullClassName)
                    .inheritIO()
                    .start();
                int javaExitCode = javaProcess.waitFor();
                System.out.println("Java exit code: " + javaExitCode);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return FileVisitResult.TERMINATE;
    }
}