package com.problems.dynamicprog;

public class CoinChangeProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1, 2, 3};
		int m = arr.length;
		int n = 4;
		System.out.println(getNoOfSolutions(arr, m, n));

	}
	
	static int getNoOfSolutions(int[] S, int m, int n) {
		int[][] arr = new int[n + 1][m];
		for(int i = 0; i < m - 1; i++) {
			arr[0][i] = 1;
		}
		for(int i = 1; i <= n; i++) {
			for(int j = 0; j < m; j++) {
				int x = (i - S[j]) >= 0 ? arr[i - S[j]][j] : 0;
				int y = (j >= 1) ? arr[i][j - 1] : 0;
				arr[i][j] = x + y;
			}
		}
		return arr[n][m - 1];
	}

}
