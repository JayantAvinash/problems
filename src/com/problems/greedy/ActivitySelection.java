package com.problems.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class ActivitySelection {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] start = new int[n];
		int[] finish = new int[n];
		for(int i = 0; i < n; i++) {
			start[i] = sc.nextInt();
		}
		for(int i = 0; i < n; i++) {
			finish[i] = sc.nextInt();
		}
		sc.close();
		getActivitySelection(start, finish, n);
	}

	private static void getActivitySelection(int[] start, int[] finish, int n) {
		int[] sortedFinish = finish;
		Arrays.sort(sortedFinish);
		int[] sortedStart = new int[n];
		int[] indices = new int[n];
		HashSet<Integer> h = new HashSet<Integer>();
		for(int i = 0; i< n; i++) {
			int a = sortedFinish[i];
			int j = 0;
			while(j < n) {
				if(finish[j] == a && !h.contains(j)) {
					h.add(j);
					break;
				}
				j++;
			}
			indices[i] = j;
		}
		for(int i = 0; i < n; i++) {
			sortedStart[i] = start[indices[i]];
		}
		System.out.print(indices[0] + " ");
		for(int i = 1; i < n; i++) {
			int j = i;
			while(j < n) {
				if(sortedStart[j] >= sortedFinish[i - 1]) {
					System.out.print(indices[j] + " ");
					i = j;
					break;
				}
				j++;
			}
		}
	}

}
