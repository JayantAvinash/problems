package com.problems.sorting;

public class SelectionSort {

	public static void main(String[] args) {
		int[] a = {10, 9 , 8, 6, 7, 4, 5, 2, 3, 1};
		int[] b = selectionSort(a);
		for(int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
		
	}
	
	public static int[] selectionSort(int[] arr) {
		for(int i = 0; i < arr.length - 1; i++) {
			int min = i;
			for(int j = i + 1; j < arr.length; j++) {
				if(arr[min] > arr[j]) {
					min = j;
				}
			}
			swap(arr, i, min);
		}
		return arr;
	}
	
	private static void swap(int[] arr, int j, int i) {
		int temp = arr[j];
		arr[j] = arr[i];
		arr[i] = temp;
	}

}
