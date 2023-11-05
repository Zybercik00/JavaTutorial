#!/bin/bash
javac -d build src/com/github/zybercik00/hellojava/JavaCompilerShellApplication.java

echo "Provide class name"
read name
java -cp build com.github.zybercik00.hellojava.JavaCompilerShellApplication $name