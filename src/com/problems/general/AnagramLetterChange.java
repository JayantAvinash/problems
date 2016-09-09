package com.problems.general;

import java.util.Scanner;

/*
 * two concatenated strings: no of letters to change in 1st to make them anagram of each other
 * */
public class AnagramLetterChange {

	  public static void main(String[] args) {
	        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
	        Scanner sc = new Scanner(System.in);
	        int t = sc.nextInt();
	        for(int j = 0; j < t; j++) {
	            String str1 = sc.next();
	            int length = str1.length();
	            if(length % 2 != 0) {
	                System.out.println(-1);
	            } else {
	               int[] i1 = new int[26];
	                for(int i = 0; i < length/2; i++) {
	                    i1[str1.charAt(i) - 97]++;
	                }
	                //int[] i2 = new int[26];
	                for(int i = length/2; i < length; i++) {
	                    i1[str1.charAt(i) - 97]--;
	                }
	                int count = 0;
	                for(int i = 0; i < 26; i++) {
	                    count += Math.abs(i1[i]);
	                }
	                System.out.println(count/2);
	            }
	        }
	    }
}
