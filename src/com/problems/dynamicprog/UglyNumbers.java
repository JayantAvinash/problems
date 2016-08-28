package com.problems.dynamicprog;

public class UglyNumbers {

	public static void main(String[] args) {
		System.out.println(getUglyNumber(150));
	}
	
	public static int getUglyNumber(int n) {
		int[] arr = new int[n];
		arr[0] = 1;
		int i2 = 0, i3 = 0, i5 = 0;
		int nxtMulOf2 = 2;
		int nxtMulOf3 = 3;
		int nxtMulOf5 = 5;
		for(int i = 1; i < n; i++) {
			int nxtNo = Math.min(Math.min(nxtMulOf2, nxtMulOf3), nxtMulOf5);
			arr[i] = nxtNo;
			if(nxtNo == nxtMulOf2) {
				
				nxtMulOf2 = arr[++i2]*2;
			} if (nxtNo == nxtMulOf3) {
				nxtMulOf3 = arr[++i3]*3;
			} if(nxtNo == nxtMulOf5) {
				nxtMulOf5 = arr[++i5]*5;
			}
		}
		return arr[n - 1];
	}

}
