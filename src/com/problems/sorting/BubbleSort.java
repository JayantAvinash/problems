package com.problems.sorting;

public class BubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {10, 9 , 8, 6, 7, 4, 5, 2, 3, 1};
		int[] b = bubbleSort(a);
		for(int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
		
	}
	
	public static int[] bubbleSort(int[] arr) {
		for(int i = 0; i < arr.length - 1; i++) {
			boolean swapped = false;
			for(int j = 0; j < arr.length - 1 - i; j++) {
				if(arr[j] > arr[j + 1]) {
					swap(arr, j, j + 1);
					swapped = true;
				}
			}
			if(!swapped) {
				break;
			}
		}
		return arr;
	}

	private static void swap(int[] arr, int j, int i) {
		int temp = arr[j];
		arr[j] = arr[i];
		arr[i] = temp;
	}

}
