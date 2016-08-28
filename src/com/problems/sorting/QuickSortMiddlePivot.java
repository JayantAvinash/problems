package com.problems.sorting;

public class QuickSortMiddlePivot {

	public static void main(String[] args) {
		int arr[] = {12, 11, 13, 5, 6, 7};

		sort(arr, 0, arr.length - 1);

		System.out.println("Sorted array is");
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ", ");
		}
	}
	
	static void sort(int[] arr, int start, int end) {
		int pivot = arr[(start + end)/2];
		int i = start;
		int j = end;
		while(i <= j) {
			while(arr[i] < pivot) {
				i++;
			}
			while(arr[j] > pivot) {
				j--;
			}
			if(i <= j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
		}
		if(j > start) {
			sort(arr, start, j);
		}
		if(i < end) {
			sort(arr, i, end);
		}
	}

}
