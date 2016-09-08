package com.problems.general;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*
 * input: a string
 * output: if any of its anagram can be a palindrome or not
 * */
public class AnagramPalindrome {
	
	   public static void main(String[] args) {
	        Scanner myScan = new Scanner(System.in);
	        String inputString = myScan.nextLine();
	        Set<Character> s = new HashSet<Character>();
	        char[] c = inputString.toCharArray();
	        for(char ch : c){
	            if(!s.add(ch)) {
	                s.remove(ch);
	            }
	        }
	        
	        String ans;
	        if(s.isEmpty() || s.size() == 1) {
	            ans = "YES";
	        } else {
	            ans = "NO";
	        }
	        // Assign ans a value of YES or NO, depending on whether or not inputString satisfies the required condition
	        System.out.println(ans);
	        myScan.close();
	    }

}
