package com.problems.general;

public class BinarySearch {
	
	public static int search(int[] arr, int l, int r, int x) {
		if (r > l) {
			if (arr[l] == x) {
				return l;
			} else if (arr[r] == x) {
				return r;
			}
			int mid = (r + l)/2 + 1;
			if (arr[mid] == x) {
				return mid;
			} else if (arr[mid] > x) {
				return search(arr, l, mid - 1, x);
			} else {
				return search(arr, mid + 1, r, x);
			} 
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; 
		System.out.println(search(arr, 0 , 9, -1));
	}

}
