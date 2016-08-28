package com.problems.general;

public class PowerOfANumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(power(15, -3));

	}
	
	static double power(long n, long p) {
		if(p == 0) {
			return 1;
		}
		double temp = power(n, p/2);
		if(p % 2 == 0) {
			return temp*temp;
		} else {
			if(p > 0) {
				return n*temp*temp;
			} else {
				return temp*temp/n;
			}
		}
	}

}
