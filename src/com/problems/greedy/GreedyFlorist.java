package com.problems.greedy;

import java.util.Arrays;
import java.util.Scanner;
//problem: N flowers, K people, if a person buys flower more than 1 time price becomes (x + 1)*cost; 
//find most optimized price of whole group
class GreedyFlorist{
	   public static void main( String args[] ){
	      
	// helpers for input/output      
		   /* Input:
		    * 3 3
		   2 5 6
		   Output: 13
		   Input:
		   3 2
			2 5 6
			Output: 15
		   */
	      Scanner in = new Scanner(System.in);
	      
	      int N, K;
	      N = in.nextInt();
	      K = in.nextInt();
	      
	      int C[] = new int[N];
	      for(int i=0; i<N; i++){
	         C[i] = in.nextInt();
	      }
	      Arrays.sort(C);
	      
	      int result = 0;
	       if(N <= K) {
	        for(int i = 0; i < N; i++) {
	            result += C[i];
	        }   
	      } else {
	           int count = 0;
	           int x = 0;
	           for(int j = N - 1; j >= 0; j--) {
	               result += (x + 1) *C[j];
	               if(++count == K) {
	                count = 0;
	                x++;
	                }
	           }
	       }
	      System.out.println( result );
	      
	   }
	}
