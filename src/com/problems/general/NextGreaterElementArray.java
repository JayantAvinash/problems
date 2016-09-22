package com.problems.general;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {4, 2, 3, 9, 7, 6, 8};
		NextGreaterElementArray n = new NextGreaterElementArray();
		n.replaceWithNextGreatest(arr);
	}

	private void replaceWithNextGreatest(int[] arr) {
		Stack<Integer> s = new Stack<Integer>();
		s.push(0);
		for(int i = 1; i < arr.length; i++) {
			boolean flag = true;
			while(!s.isEmpty() && flag) {
				int current = s.pop();
				if(arr[current] < arr[i]) {
					arr[current] = arr[i];
				} else {
					s.push(current);
					flag = false;
				}
			}
			s.push(i);
		}
		s.empty();
		System.out.println(Arrays.toString(arr));
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

}
