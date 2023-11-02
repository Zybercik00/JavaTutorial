package com.github.zybercik00.hellojava;


import java.util.*;

public class PrintReversedStringList {   


    public static void main(String[] args) {
        PrintReversedStringList newList = new PrintReversedStringList();
        List<String> listToReverse = newList.listToRevers();
        List<String> reversedList = newList.reversedList(listToReverse);
        newList.printElements(reversedList);
    
    }
    
    public List<String> listToRevers() {
        List<String> listToRevers = new ArrayList<>();
        listToRevers.add("a");
        listToRevers.add("b");
        listToRevers.add("c");
        return listToRevers;
    }

    public List<String> reversedList(List<String> list) {
        List<String> reversedList = new ArrayList<>();
        for (int i = list.size()-1; i >= 0; i--) {
            reversedList.add(list.get(i));
        }
        return reversedList;
    }

    public void printElements(List<String> list) {
        for (String element : list) {
            System.out.println(element);
        }
    }

}
