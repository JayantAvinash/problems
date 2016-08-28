package com.problems.sorting;

public class InsertionSort {

	public static void main(String[] args) {
		int[] a = {10, 9 , 8, 6, 7, 4, 5, 2, 3, 1};
		int[] b = insertionSort(a);
		for(int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}

	}
	
	public static int[] insertionSort(int[] arr) {
		for(int i = 1; i < arr.length; i++) {
			int j = i - 1;
			int key = arr[i];
			while(j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = key;
		}
		return arr;
	}

}
