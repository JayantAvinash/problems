package com.problems.general;

import java.util.Scanner;

/*
 * input:
 * 2 
4 
1 2 3 4
6
2 -1 2 3 4 -5
 * */

/*
 * Output:
 * 10 10
   10 11
 * */

//Maximum contiguous sum in a subarray as well as maximum possible sum
public class MaxContiguousSubArray {
	
	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for(int i = 0; i < t; i++) {
            int maxSum = 0;
            int maxPossibleSum = 0;
            int currentSum = 0;
            int maxVal = 0;
            int n = sc.nextInt();
            for(int j = 0; j < n; j++) {
                int a = sc.nextInt();
                if(j == 0) {
                    maxVal = a;
                } else {
                    maxVal = Math.max(maxVal, a);
                }
                if(a > 0) {
                    maxPossibleSum += a;
                }
                currentSum += a;
                if(currentSum > maxSum) {
                    maxSum = currentSum;
                }
                if(currentSum < 0) {
                    currentSum = 0;
                }
            }
            if(maxVal < 0) {
                maxSum = maxVal;
                maxPossibleSum = maxVal;
            }
            System.out.println(maxSum + " " + maxPossibleSum);
        }
    }

}
