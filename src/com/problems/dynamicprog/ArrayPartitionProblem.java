package com.problems.dynamicprog;

import java.util.Scanner;

public class ArrayPartitionProblem {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = i + 1;
		}
		System.out.println(checkPossibility(arr, n));
		sc.close();
	}

	private static String checkPossibility(int[] arr, int n) {
		int sum = n*(n + 1)/2;
		if(sum % 2 != 0) {
			return "No";
		} else {
			boolean[][] ifValid = new boolean[sum/2 + 1][n + 1];
			for(int i = 0; i <= n; i++) {
				ifValid[0][i] = true; 
			}
			for(int i = 1; i <= sum/2; i++) {
				ifValid[i][0] = false; 
			}
			for(int i = 1; i <= sum/2; i++) {
				for(int j = 1; j <=n ; j++) {
					ifValid[i][j] = ifValid[i][j - 1];
					if(i >= arr[j - 1]) {
						ifValid[i][j] = ifValid[i][j] || ifValid[i - arr[j - 1]][j - 1];
					}
				}
			}
			if(ifValid[sum/2][n]) {
				return "Yes";
			} else {
				return "No";
			}
		}
	}

}
