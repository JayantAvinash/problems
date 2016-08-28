package com.problems.dynamicprog;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    public int getMaxRegion(int[][] arr, int n , int m, int i, int j) {
        if(i < 0 || j < 0 || i >= n || j >= m || arr[i][j] == -1 || arr[i][j] == 1) {
            return 0;
        } else {
            arr[i][j] = 1;
            return 1 + getMaxRegion(arr, n, m, i - 1, j - 1) + getMaxRegion(arr, n, m, i - 1, j) + getMaxRegion(arr, n, m, i - 1, j + 1) + getMaxRegion(arr, n, m, i, j - 1) + getMaxRegion(arr, n, m, i, j + 1) + getMaxRegion(arr, n, m, i + 1, j - 1) + getMaxRegion(arr, n, m, i + 1, j) + getMaxRegion(arr, n, m, i + 1, j + 1);
        }
    }
    
   

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt() - 1;
            }
        }
        Solution s = new Solution();
        int max = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                max = Math.max(max, s.getMaxRegion(arr, n , m, i, j));
            }
        }
        System.out.println(max);
    }
}
