package com.problems.general;

import java.util.HashSet;
import java.util.Set;

public class SumPairArray {

	public static void main(String[] args) {
		int A[] = {1, 4, 45, 6, 10, 8};
        int n = 16;
        printpairs(A,  n);
	}

	private static void printpairs(int[] a, int n) {
		Set<Integer> s = new HashSet<Integer>();
		for(int i = 0; i < a.length; i++) {
			if(s.contains(n - a[i])) {
				System.out.println((n - a[i]) + " " + a[i] );
				break;
			} else {
				s.add(a[i]);
			}
		}
	}

}
