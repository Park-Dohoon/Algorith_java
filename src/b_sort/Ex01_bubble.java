package b_sort;

import java.util.Scanner;

public class Ex01_bubble {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int input_len = input.nextInt();
		
		int[] arr = new int[input_len];
		for(int i=0; i<arr.length; i++)
			arr[i] = input.nextInt();
		System.out.println();
		
		bubble(arr);
		
		for(int i=0; i<arr.length; i++)
			System.out.println(arr[i]);
	}
	
	public static void bubble(int[] arr) {
		
		for (int i=arr.length-1; i>0; i--)
			for (int j=0; j<i; j++)
				if (arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
	}
}
