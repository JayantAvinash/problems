package com.problems.ds;

public class MaxHeap {
	
	int position;
	int[] heapArray;
	int size;
	
	public MaxHeap(int size) {
		this.size = size;
		position = 0;
		heapArray = new int[size + 1];
	}
	
	public void createHeap(int[] a) {
		if(a.length > 0) {
			for(int i = 0; i < a.length; i++) {
				insert(a[i]);
			}
		}
	}
	
	public void insert(int a) {
		heapArray[++position] = a;
		if(position > 1) {
			bubbleUp();
		}
	}

	private void bubbleUp() {
		int pos = position;
		while(pos > 0 && heapArray[pos] > heapArray[pos/2]) {
			swap(pos, pos/2);
			pos /= 2;
		}
	}
	
	public int extractMax() {
		int max = heapArray[1];
		heapArray[1] = heapArray[position];
		heapArray[position] = 0;
		position--;
		sinkdown(1);
		return max;
	}
	
	private void sinkdown(int i) {
		int largest = i;
		if(position >= 2*i && heapArray[largest] < heapArray[2*i]) {
			largest = 2*i;
		}
		if(position >= 2*i + 1 && heapArray[largest] < heapArray[2*i + 1]) {
			largest = 2*i + 1;;
		}
		if(largest != i) {
			swap(i, largest);
			sinkdown(largest);
		}
	}

	public void swap(int a, int b) {
		int temp = heapArray[a];
		heapArray[a] = heapArray[b];
		heapArray[b] = temp;
	}
	
	public void display() {
		if(position > 0) {
			for(int i = 1; i < heapArray.length; i++) {
				System.out.print(heapArray[i] + "\t");
			}
		}
	}

	public static void main(String[] args) {
		int arrA [] = {3,2,1,7,8,4,10,16,12};
		System.out.print("Original Array : ");
		for(int i=0;i<arrA.length;i++){
			System.out.print("  " + arrA[i]);
		}
		MaxHeap mh = new MaxHeap(arrA.length);
		System.out.print("\nMax-Heap : ");
		mh.createHeap(arrA);		
		mh.display();
		System.out.print("Extract Min :");
		for(int i=0;i<arrA.length;i++){
			System.out.print("  " + mh.extractMax());
		}
	}
}
