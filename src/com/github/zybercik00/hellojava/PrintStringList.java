package com.github.zybercik00.hellojava;


import java.util.*;

public class PrintStringList {


    public static void main(String[] args) {
        PrintStringList newList = new PrintStringList();
        List<String> listToPrint = newList.setList();
        newList.printList(listToPrint);
        
    }

    public List<String> setList() {
    List<String> staticList = new ArrayList<>();
    staticList.add("first");
    staticList.add("second");
    return staticList;
    }

    public void printList(List<String> list) {
        for (String element : list) {
            System.out.println(element);
        }
    }

}
