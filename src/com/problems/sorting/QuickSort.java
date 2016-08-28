package com.problems.sorting;

public class QuickSort {
	
	static int partition(int[] arr, int start, int end) {
		int pivot = arr[end];
		int j = start;
		for(int i = start; i < end; i++) {
			if(arr[i] <= pivot) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j++] = temp;
			}
		}
		int temp = arr[j];
		arr[j] = pivot;
		arr[end] = temp;
		return j;
	}
	
	static void sort(int[] arr, int start, int end) {
		if(start < end) {
			int p = partition(arr, start, end);
			sort(arr, start, p - 1);
			sort(arr, p + 1, end);
		}
	}

	public static void main(String[] args) {
		int arr[] = {12, 11, 13, 5, 6, 7};

		sort(arr, 0, arr.length - 1);

		System.out.println("Sorted array is");
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ", ");
		}


	}
	
}