package com.problems.general;

public class BleakNumbers {
	
	public static String[] output1;
	public static void bleakNumbers(int[] input1) {
		int size = input1[0];
		output1 = new String[size];
		for(int i = 0; i < size; i++ ) {
			int val = input1[i + 1];
			if(val < 0 ) {
				output1[i] = "-999";
			} else if(val == 0) {
				output1[i] = "SUPPORTED";
			} else if(val == 1) {
				output1[i] = "BLEAK";
			} else {
				for (int j = val - 1; j > 0; j--) {
					String bin = Integer.toBinaryString(j);
					int count = 0;
					for (char c : bin.toCharArray()) {
						if (c == '1') {
							count++;
						}
					}
					if (j + count == val) {
						output1[i] = "SUPPORTED";
						break;
					}
				} 
			}
			if(output1[i] == null) {
				output1[i] = "BLEAK";
			}
			
		}
		for(int k = 0; k < size; k++) {
			System.out.print(output1[k] + ",");
		}
		
	}
	
	public static void main(String[] args) {
		
		int[] input = {2, 4, 9};
		bleakNumbers(input);
	}
}
