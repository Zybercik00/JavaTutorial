package com.github.zybercik00.hellojava;

public class Letcode {

    public static void main(String[] args) {
        Letcode letcode = new Letcode();
        letcode.strStr("mississippi", "issip");
        
    }
    
    public int strStr(String haystack, String needle) {
        int value = -1;
        if (haystack.contains(needle)) {
            value = haystack.indexOf(needle);
        }
        return value;
    }
}
