package com.omt.temp.practice;

public class MatrixChainMultiplication {


	public static void main(String args[]) {
		int a[] = { 4, 2, 3, 5, 3 };
	System.out.println(minMaltiplication(a));	
	}
	
	public static int minMaltiplication(int a[]) {
		
		int mx[][] = new int[a.length][a.length];
		
		for(int l = 2 ; l <=a.length;l++) {
			for(int i = 0; i < a.length-(l); i++) {
				int j=i+l;
				mx[i][j] = Integer.MAX_VALUE;
				
				for(int k = i+1; k < j ; k++) {
					int cal = mx[i][k]+mx[k][j]+(a[i]*a[j]*a[k]);
					if(cal < mx[i][j]) {
						mx[i][j] = cal;
					}
				}
			}
		}
		
		return mx[0][a.length-1];
	}
	
}

