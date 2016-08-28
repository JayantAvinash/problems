package com.problems.dynamicprog;

public class CommonSubSeqLength {

	public static void main(String[] args) {
		CommonSubSeqLength csl = new CommonSubSeqLength();
		System.out.println(csl.getCommonSubSeqLengthMatrix("AGGTAB", "GXTXAYB"));
	}
	
	public int getCommonSubSeqLength(String a, String b) {
		if(a.equals(null) || b.equals(null) || "".equals(a) || "".equals(b)) {
			return 0;
		} else {
			int lengthOfA = a.length();
			int lengthOfB = b.length();
			if(a.substring(lengthOfA - 1).equals(b.substring(lengthOfB - 1))) {
				return 1 + getCommonSubSeqLength(a.substring(0, lengthOfA - 1), b.substring(0, lengthOfB - 1));
			} else {
				return Math.max(getCommonSubSeqLength(a.substring(0, lengthOfA - 1), b.substring(0, lengthOfB)), getCommonSubSeqLength(a.substring(0, lengthOfA), b.substring(0, lengthOfB - 1)));
			}
		}
	}
	
	public int getCommonSubSeqLengthMatrix(String a, String b) {
		if(a.equals(null) || b.equals(null) || "".equals(a) || "".equals(b)) {
			return 0;
		}
		int lengthOfA = a.length();
		int lengthOfB = b.length();
		int[][] L = new int[lengthOfA + 1][lengthOfB + 1];
		for(int i = 0; i <= lengthOfA; i++) {
			for(int j = 0; j <= lengthOfB; j++) {
				if(i == 0 || j == 0) {
					L[i][j] = 0;
				} else if(a.charAt(i - 1) == b.charAt(j - 1)) {
					L[i][j] = 1 + L[i - 1][j - 1];
				} else {
					L[i][j] = Math.max(L[i - 1][j], L[i][j - 1]);
				}
			}
		}
		return L[lengthOfA][lengthOfB];
	}

}
