package com.github.zybercik00.hellojava;

public class LeetcodeAddBinary {
    
    public String addBinary(String a, String b) {
        byte[] abyte = a.getBytes();
        byte[] bbyte = b.getBytes();

        byte[] cbyte = abyte + bbyte;
    }
}
