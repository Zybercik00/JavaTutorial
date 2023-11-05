package com.github.zybercik00.hellojava;

// Given a string s consisting of words and spaces, return the length of the last word in the string.

// A word is a maximal 
// substring
//  consisting of non-space characters only.

 

// Example 1:

// Input: s = "Hello World"
// Output: 5
// Explanation: The last word is "World" with length 5.
// Example 2:

// Input: s = "   fly me   to   the moon  "
// Output: 4
// Explanation: The last word is "moon" with length 4.
// Example 3:

// Input: s = "luffy is still joyboy"
// Output: 6
// Explanation: The last word is "joyboy" with length 6.


public class LeetcodeLenghtoFLastWord {
    

    public static void main(String[] args) {
        LeetcodeLenghtoFLastWord leetcode = new LeetcodeLenghtoFLastWord();
        leetcode.lengthOfLastWord("   fly me   to   the moon  ");
    }


    public int lengthOfLastWord(String s) {

       String[] splited = s.split(" ");
       
       int count = 1;
       int size = 0;
       String[] newStringArray = new String[count];
       for (int elementIndex = 0; elementIndex <= splited.length -1; elementIndex++) {
        char[] charArrayOfElement = splited[elementIndex].toCharArray();
        for (int charIndex = 0; charIndex < charArrayOfElement.length; charIndex++) {
            if (charArrayOfElement[charIndex] != ' ') {
               
                count++;
                for (int j = 0; j < newStringArray.length; j++) {
                    newStringArray[j] = splited[elementIndex];
                   
                }
                break;
            }
        }
        
       }
       
       for (int i = 0; i <= newStringArray.length -1; i++) {
        if (newStringArray[i] == newStringArray[newStringArray.length - 1]) {
            size = newStringArray[i].length();
        }
       }
        System.out.println(size);
        return size;
    }
}
