package com.github.zybercik00.hellojava;

// Given an array of strings words, return the words that can be typed using letters of the alphabet on only one row of American keyboard like the image below.

// In the American keyboard:

// the first row consists of the characters "qwertyuiop",
// the second row consists of the characters "asdfghjkl", and
// the third row consists of the characters "zxcvbnm".

public class LeetcodeKeyboardRow {
    
    public String[] findWords(String[] words) {
        int count = 1;
        String [] newWords = new String[count];
        String firstRow = "qwertyuiop";
        char[] first = firstRow.toCharArray();
        String secondRow = "asdfghjkl";
        char[] second = secondRow.toCharArray();
        String thirdRow = "zxcvbnm";
        char[] third = thirdRow.toCharArray();
        for (int wordIndex = 0; wordIndex <= words.length - 1; wordIndex++) {
            String word = words[wordIndex];
            char[] w = word.toCharArray();
            int length = words[wordIndex].length();
            if (firstRow.contains(w) || second.contains(w) || third.contains(w)) {
                count++;
                for (int newWindex = 0; newWindex <= words.length -1; newWindex++) {
                    newWords[newWindex] = word;
                }
            }
        }
        return newWords;
    }
}
