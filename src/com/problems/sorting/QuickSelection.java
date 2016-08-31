package com.problems.sorting;

public class QuickSelection {
    
    public static int getKthElement(int[] arr, int l, int r, int k) {
        if(k >= l && k <= r) {
            int pos = randomPartition(arr, l, r);
            if(pos == k) {
                return arr[pos];
            }
            if(pos > k) {
                return getKthElement(arr, l, pos - 1, k);
            }
            return getKthElement(arr, pos + 1, r, k);
        }
        return Integer.MAX_VALUE;
    }
    
    public static int randomPartition(int[] arr, int l, int r) {
        int n = r - l + 1;
        int pivot = ((int)Math.random()) % n;
        swap(arr, l + pivot, r);
        return sort(arr, l, r);
    }
    
    public static int sort(int[] arr, int l, int r) {
        int pivot = arr[r];
        int i = l;
        for(int j = l; j <= r - 1; j++) {
            if(arr[j] < pivot) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, r);
        return i;
    }
    
    public static void swap(int[] arr, int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }
    

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    	int arr[] = {12, 3, 5, 7, 4, 19, 26};
		int n = arr.length,k = 3;
        System.out.print(getKthElement(arr, 0, n - 1, k - 1));
    }
}
