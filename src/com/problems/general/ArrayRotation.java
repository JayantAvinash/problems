package com.problems.general;

import java.util.Scanner;

public class ArrayRotation {
	static void printIndexes(int[] arr, int[] queries, int k) {
		 
        int arrSize = arr.length;
        k = k % arrSize;;
        int[] temp = new int[k];
        for(int i = 0; i < k; i++) {
        	temp[i] = arr[arrSize - i - 1];
        }
            for(int j = arrSize - 1; j > k - 1; j--) {
     
                arr[j] = arr[j - k];
        }
        for(int i = 0; i < k; i++) {
            arr[i] = temp[k- i - 1];
        }
        for(int i = 0; i < queries.length; i++) {
             int index = queries[i];
             if(index < arrSize)
                System.out.println(arr[index]);
        }
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        int k = sc.nextInt();
        int q = sc.nextInt();
        for(int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        int[] queries = new int[q];
        for(int i = 0; i < q; i++) {
            queries[i] = sc.nextInt();
        }
        printIndexes(arr, queries, k);
        sc.close();
        /*#input:
        	3 2 3
        	1 2 3
        	0
        	1
        	2*/

    }
}
