package com.omt.learn.algo.allAlgos;

public class RotateArrayByElement {

	public static void main(String[] args) {

		
		int a[] = {1,2,3,4,5};
		int numberOfElementRotation = 3;
		int findIntAtPosition = 3; // Starts with 0 
		
		System.out.println(elementAtAfterRotation(a, numberOfElementRotation, findIntAtPosition));
		
		

	}
	
	
	public static int elementAtAfterRotation(int[] a,int rotation, int position) {
		int size = a.length;
		int pointer = rotation % size;
		int element = a[((pointer+position)%size)];
		return element;
	}
	
	
	

}
