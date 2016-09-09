package com.problems.general;

import java.util.Arrays;

public class MergeKSortedArrays {
	
	static class HeapNode {
		int value;
		int listNo;
		int index;
		
		HeapNode(int value, int listNo, int index) {
			this.value = value;
			this.listNo = listNo;
			this.index = index;
		}
	}

	public static void main(String[] args) {
		int[][] A = new int[5][];
		A[0] = new int[] { 1, 5, 8, 9 };
		A[1] = new int[] { 2, 3, 7, 10 };
		A[2] = new int[] { 4, 6, 11, 15 };
		A[3] = new int[] { 9, 14, 16, 19 };
		A[4] = new int[] { 2, 4, 6, 9 };
		MergeKSortedArrays m = new MergeKSortedArrays();
		System.out.println(Arrays.toString(m.sortArray(A)));
	}

	private int[] sortArray(int[][] a) {
		
		int k = a.length;
		int n = a[0].length;
		int size = n*k;
		int[] sortedArray = new int[size];
		int currIndex = 0;
		HeapNode[] h = new HeapNode[k];
		for(int i = 0; i < k; i++) {
			HeapNode h1 = new HeapNode(a[i][0], i, 0);
			insert(h, i, h1);
		}
		while(currIndex < size) {
			HeapNode h1 = h[0];
			int index = h1.index;
			int lNo = h1.listNo;
			HeapNode h2 = null;
			if(index < n - 1) {
				h2 = new HeapNode(a[lNo][index + 1], lNo, index + 1);
			} else {
				h2 = new HeapNode(Integer.MAX_VALUE, lNo, index + 1);
			}
			h[0] = h2;
			sinkDown(h);
			sortedArray[currIndex++] = h1.value; 
		}
		return sortedArray;
	}

	/*private int extractMin(HeapNode[] h) {
		HeapNode h1 = h[0];
		int index = h1.index;
		return h1.value;
	}*/

	private void sinkDown(HeapNode[] h) {
		sinkDown(h, h.length, 0);
		
	}

	private void sinkDown(HeapNode[] h, int length, int i) {
		int smallest = i;
		if(length > (2*i + 1) && h[2*i + 1].value < h[smallest].value) {
			smallest = 2*i + 1;
		}
		if(length > (2*i + 2) && h[2*i + 2].value < h[smallest].value) {
			smallest = 2*i + 2;
		}
		if(smallest != i) {
			swap(h, smallest, i);
			sinkDown(h, length, smallest);
		}
	}

	private void insert(HeapNode[] h, int i, HeapNode h1) {
		h[i] = h1;
		if(i > 0) {
			bubbleUp(h, i);
		}
	}

	private void bubbleUp(HeapNode[] h, int i) {

		while(i > 0) {
			if(h[(i - 1)/2].value > h[i].value) {
				swap(h, (i - 1)/2, i);
				i = (i - 1)/2;
			} else {
				i = 0;
			}
		}
	}

	private void swap(HeapNode[] h, int i, int i2) {

		HeapNode temp = h[i];
		h[i] = h[i2];
		h[i2] = temp;
	}

}
