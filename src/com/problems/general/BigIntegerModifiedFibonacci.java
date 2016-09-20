package com.problems.general;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Fibonacci: Fn = (Fn-1)^2 + Fn-2
public class BigIntegerModifiedFibonacci {
	
	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int t1 = sc.nextInt();
        int t2 = sc.nextInt();
        int n = sc.nextInt();
        List<BigInteger> sequence = new ArrayList<BigInteger>();
        sequence.add(BigInteger.valueOf(t1));
        sequence.add(BigInteger.valueOf(t2));
        int count = 2;
        while(count < n) {
            sequence.add(sequence.get(count - 2).add(sequence.get(count - 1).pow(2)));
            count++;
        }
        System.out.println(sequence.get(count - 1));
    }

}
