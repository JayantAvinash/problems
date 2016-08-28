package com.problems.sorting;

public class HeapSort {
	
	static void sort(int[] arr) {
		int n = arr.length;
		for(int i = n/2 - 1; i >= 0; i--) {
			heapify(arr, n, i);
		}
		for(int i = n - 1; i >= 0; i--) {
			swap(arr, 0, i);
			heapify(arr, i, 0);
		}
	}

	private static void heapify(int[] arr, int n, int i) {
		int l = 2*i + 1;
		int r = 2*i + 2;
		int largest = i;
		if(l < n && arr[largest] < arr[l]) {
			largest = l;
		}
		if(r < n && arr[largest] < arr[r]) {
			largest = r;
		}
		if(largest != i) {
			swap(arr, i, largest);
			heapify(arr, n, largest);
		}
		
	}
	private static void swap(int[] arr, int i, int largest) {
		int temp = arr[i];
		arr[i] = arr[largest];
		arr[largest] = temp;
		
	}

	public static void main(String[] args) {
		int arr[] = {12, 11, 13, 5, 6, 7};

		sort(arr);

		System.out.println("Sorted array is");
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ", ");
		}

	}

}
