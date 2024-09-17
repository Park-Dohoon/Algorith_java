package a03_dataStructure;

import java.util.Scanner;

public class Ex03_sumOfBand {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("데이터의 개수와 질의의 개수를 입력하시오(공백으로 구분)");
		int numberOfData = input.nextInt();
		int numberOfQuery = input.nextInt();
		
		System.out.println("구간 합을 구할 배열을 입력하시오");
		int[] arr = new int[numberOfData];
		for(int i=0; i<numberOfData; i++) 
			arr[i]=input.nextInt();
		
		System.out.println("질의를 입력하시오(i 번째 수부터 j번째 수까지 : i j)");
		int[][] queries = new int[numberOfQuery][2];
		for (int i=0; i<numberOfQuery; i++) {
			queries[i][0] = input.nextInt();
			queries[i][1] = input.nextInt();
		}
		
		sumOfBand(arr, queries);		
	}
	
	public static void sumOfBand(int[] arr, int[][] queries) {
		
		int[] sumOfBand = new int[arr.length];
		
		// make sumOfBand array
		for(int i=0; i<arr.length; i++) {
			if(i == 0)
				sumOfBand[i] = arr[i];
			else
				sumOfBand[i] = sumOfBand[i-1]+arr[i];
		} System.out.println();
		
		// print result of queries
		for(int i = 0; i<queries.length; i++) {
			if(queries[i][0] == 1)
				System.out.println(sumOfBand[queries[i][1]-1]);
			else
				System.out.println(sumOfBand[queries[i][1]-1] - sumOfBand[queries[i][0]-2]);
		}
	}
}
