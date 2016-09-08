package com.problems.general;

import java.util.Scanner;

public class MakingAnagrams {
	/*
	 * input 2 strings
	 * output: count of characters removed from both to make them anagram of each other
	 * */
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        int[] i1 = new int[26];
        int[] i2 = new int[26];
        for(char c : str1.toCharArray()) {
            i1[c - 97]++;
        }
        for(char c : str2.toCharArray()) {
            i2[c - 97]++;
        }
        int count = 0;
        for(int i = 0; i < 26; i++) {
            count += Math.abs(i1[i] - i2[i]);
        }
        System.out.println(count);
    }
}
