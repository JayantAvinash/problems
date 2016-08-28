package com.problems.general;

import java.util.ArrayList;
import java.util.Scanner;

public class FibonacciSum {
	static int sum1(int m, int n) {
		 long startTime = System.currentTimeMillis();
		ArrayList<Integer> al = new ArrayList<Integer>();
		int result = 0;
		al.add(0);
		al.add(1);
		for(int i = 2; i <= n; i++) {
			al.add(al.get(i - 1) + al.get(i - 2));
		}
       for(int i = 1; i <= n; i++) {
       	for(int j = i; j <= n; j++) {
           	if(i != j && i <= m && j <= m) {
           		result += (n - m + 1)*al.get(i)*al.get(j);
           	} else if(i != j &&  j > m) {
           		result += (n - j + 1)*al.get(i)*al.get(j);
           	}
           }
       }
       long stopTime = System.currentTimeMillis();
       long elapsedTime = stopTime - startTime;
       System.out.println(elapsedTime);
       return result;
   }
  static int sum(int n) {
       int result = 0;

       for (int i = 1; i <= n; i++) {
           int sum = 0;

           for (int j = i + 1; j <= n; j++) {
                   sum = sum + fibonacci(j);
           }

           result = result + (sum * fibonacci(i));
       }

       return result;
   }
   
   	static int sum(int m, int n) {
   		 long startTime = System.currentTimeMillis();
   		int s = 0;
   		for(int i = m; i <= n; i++) {
   			s += sum(i);
   		}
   		long stopTime = System.currentTimeMillis();
           long elapsedTime = stopTime - startTime;
           System.out.println(elapsedTime);
   		return s;
   	}
   
  static int fibonacci(int n) {
       if (n == 0) {
           return 0;
       }

       if (n == 1) {
           return 1;
       }

       return fibonacci(n - 1) + fibonacci(n - 2);
   }
   
   public static void main(String args[] ) throws Exception {
       /*
        Read input from stdin and provide input before running* */

       Scanner sc = new Scanner(System.in);
       int N = Integer.parseInt(sc.nextLine());
       ArrayList<Integer> list = new ArrayList<Integer>();
       for (int i = 0; i < N; i++) {
       	String s = sc.nextLine();
       	int indexSpace = s.indexOf(' ');
      		int l = Integer.parseInt(s.substring(0, indexSpace));
      		int r = Integer.parseInt(s.substring(indexSpace + 1));
      		if(l > r) {
      			list.add(0);
      		} else {
      			//list.add(sum1(l, r));
      			System.out.println("By sum: " + sum(l, r));
      		}
       }
       for(int j = 0; j < list.size(); j++) {
       	System.out.println("By sum1: " +  list.get(j));
       }

   }
}
