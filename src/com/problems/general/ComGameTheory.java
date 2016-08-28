package com.problems.general;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ComGameTheory {
	
	/*#input:
		2
		3
		5 4
		5 8
		8 2
		6
		7 1
		7 2
		7 3
		7 4
		7 4
		7 4*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i = 0; i < t; i++) {
			int noOfCoins = sc.nextInt();
			int nim = 0;
			for(int j = 0; j < noOfCoins; j++) {
				nim ^= grundy(sc.nextInt(), sc.nextInt());
			}
			System.out.println(nim == 0 ? "Second" : "First");
		}
		sc.close();
	}
	
	static int[] grundys = new int[260];
		static {
			for(int i = 0; i < 260; i++) {
			grundys[i] = -1;
			}
	}

	private static int grundy(int x, int y) {
		int g = 0;
		int id = getId(x, y);
		if(grundys[id] != -1) {
			return grundys[id];
		}
		int curGVal = 0;
		List<Integer> neighbors = new ArrayList<Integer>();
		if(x > 2) {
			if(y > 1) {
				neighbors.add(getId(x - 2, y - 1));
			}
			if(y < 15) {
				neighbors.add(getId(x - 2, y + 1));
			}
		}
		if(y > 2) {
			if(x > 1) {
				neighbors.add(getId(x - 1, y - 2));
			}
			if(x < 15) {
				neighbors.add(getId(x + 1, y - 2));
			}
		}
		for(int i = 0; i < neighbors.size(); i++) {
			int j = neighbors.get(i);
			neighbors.set(i, grundy(getX(j), getY(j)));
		}
		Collections.sort(neighbors);
		for(int i : neighbors) {
			if(curGVal == i) 
				curGVal++;
		}
		grundys[id] = curGVal;
		return curGVal;
	}

	private static int getId(int x, int y) {
		return (x + 16*y);
	}
	
	private static int getX(int id) {
		return id % 16;
	}
	
	private static int getY(int id) {
		return id/16;
	}

}
