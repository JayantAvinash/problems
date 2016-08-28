package com.problems.sorting;

public class MergeSort {

	public static void main(String[] args) {
		int[] a = {10, 9 , 8, 6, 7, 4, 5, 2, 3, 1};
		sort(a, 0, 9);
		for(int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}

	}
	
	static void sort(int[] arr, int l, int r) {
		if(l < r) {
			int m = (l + r)/2;
			sort(arr, l, m);
			sort(arr, m + 1, r);
			merge(arr, l, m, r);
		}
	}

	private static void merge(int[] arr, int l, int m, int r) {
		// TODO Auto-generated method stub
		int n1 = m - l + 1;
		int n2 = r - m;
		int[] L = new int[n1];
		int[] M = new int[n2];
		for(int i = 0; i < n1; i++) {
			L[i] = arr[l + i];
		}
		for(int j = 0; j < n2; j++) {
			M[j] = arr[m + 1 + j];
		}
		int i = 0, j = 0, k = l;
		while(i < n1 && j < n2){
			if(L[i] < M[j]) {
				arr[k++] = L[i];
				i++;
			} else {
				arr[k++] = M[j];
				j++;
			}
		}
		while(i < n1) {
			arr[k++] = L[i++];
		}
		while(j < n2) {
			arr[k++] = M[j++];
		}
	}
}
