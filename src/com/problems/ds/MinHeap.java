package com.problems.ds;

public class MinHeap {
	
	int position;
	int[] heapArray;
	int size;
	
	public MinHeap(int size) {
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
		while(pos > 0 && heapArray[pos/2] > heapArray[pos]) {
			swap(pos/2, pos);
			pos /= 2;
		}
	}
	
	public int extractMin() {
		int min = heapArray[1];
		heapArray[1] = heapArray[position];
		heapArray[position--] = 0;
		sinkDown(1);
		return min;
	}
	
	private void sinkDown(int i) {
		int a = heapArray[i];
		int smallest = i;
		if(position >= 2*i &&  heapArray[smallest] > heapArray[2*i]) {
			smallest = 2*i;
		}
		if(position >= 2*i + 1 &&  heapArray[smallest] > heapArray[2*i + 1]) {
			smallest = 2*i + 1;
		}
		if(smallest != i) {
			swap(i, smallest);
			sinkDown(smallest);
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
		// TODO Auto-generated method stub
		int arrA [] = {3,2,1,7,8,4,10,16,12};
		System.out.print("Original Array : ");
		for(int i=0;i<arrA.length;i++){
			System.out.print("  " + arrA[i]);
		}
		MinHeap mh = new MinHeap(arrA.length);
		System.out.print("\nMin-Heap : ");
		mh.createHeap(arrA);		
		mh.display();
		System.out.print("Extract Min :");
		for(int i=0;i<arrA.length;i++){
			System.out.print("  " + mh.extractMin());
		}
	}

}
