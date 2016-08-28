package com.problems.dynamicprog;

import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {

		int[] arr = { 10, 22, 9, 33, 21, 50, 41, 60, 80 };
		System.out.println(getLongestSubSequence(arr, 9));
	}

	public static int getLongestSubSequence(int[] arr, int n) {
		List<List<Integer>> subSequence = new ArrayList<List<Integer>>(n);
		for(int i = 0; i < n; i++) {
			int max = -1;
			for(int j = 0; j < i; j++) {
				if(arr[j] <= arr[i]) {
					if (max == -1) {
						max = 0;
					}
					if(subSequence.get(max).size() < subSequence.get(j).size()) {
						max = j;
					}
				}
			}
			if(max == -1) {
				List<Integer> currentIndexList = new ArrayList<Integer>();
				currentIndexList.add(arr[i]);
				subSequence.add(currentIndexList);
			} else {
				List<Integer> currentIndexList = new ArrayList<Integer>(subSequence.get(max));
				currentIndexList.add(arr[i]);
				subSequence.add(currentIndexList);
			}
		}
		int maxLength = 0;
		for(int i = 0; i < n; i++) {
			maxLength = (subSequence.get(i).size() > maxLength ? subSequence.get(i).size() : maxLength);
		}
		return maxLength;
	}

}
