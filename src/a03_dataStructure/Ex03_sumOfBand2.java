package a03_dataStructure;

import java.util.Scanner;

public class Ex03_sumOfBand2 {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("2차원 배열의 크기와 질의의 수를 입력하시오");
		int numberOfData = input.nextInt();
		int numberOfQuery = input.nextInt();
		
		System.out.println("구간 합을 구할 배열을 입력하시오");			// 한 칸 크게 선언하면 라인 많이 줄어들음
		int[][] arr = new int[numberOfData+1][numberOfData+1];
		for(int i=1; i<numberOfData+1; i++)
			for(int j=1; j<numberOfData+1; j++)
				arr[i][j]=input.nextInt();
		
		int[][] queries = new int[numberOfQuery][4];
		for (int i=0; i<numberOfQuery; i++) {
			System.out.println((i+1)+"번째 질의를 입력하시오(A(x,y) 좌표부터 B(x,y) 좌표까지의 구간 합)");
			queries[i][0] = input.nextInt();
			queries[i][1] = input.nextInt();
			queries[i][2] = input.nextInt();
			queries[i][3] = input.nextInt();
		}
		
		sumOfBand(arr, queries);		
	}
	
	public static void sumOfBand(int[][] arr, int[][] queries) {
		
		int[][] sumOfBand = new int[arr.length+1][arr.length+1];
		
		// make sumOfBand array
		for(int i=1; i<arr.length; i++) {
			for(int j=1; j<arr.length; j++) {
//				if(i == 0 & j==0)
//					sumOfBand[i] = arr[i];
//				else if(j ==0)
//					sumOfBand[i][j] = sumOfBand[i-1][j]+arr[i][j];
//				else if(i ==0)
//					sumOfBand[i][j] = sumOfBand[i][j-1]+arr[i][j];
//				else
//					sumOfBand[i][j] = sumOfBand[i][j-1]+sumOfBand[i-1][j]-sumOfBand[i-1][j-1]+arr[i][j];
				sumOfBand[i][j] = sumOfBand[i][j-1]+sumOfBand[i-1][j]-sumOfBand[i-1][j-1]+arr[i][j];
				System.out.print(sumOfBand[i][j]+"	");
			} System.out.println();
		} System.out.println();
		
		// print result of queries
		int result=0;
		for(int i = 0; i<queries.length; i++) {
//			if(queries[i][0] == 1 & queries[i][1] == 1) {
//				result = sumOfBand[queries[i][2]-1][queries[i][3]-1];
//			}
//			else if(queries[i][0] == 1) {
//				result = sumOfBand[queries[i][2]-1][queries[i][3]-1] - sumOfBand[queries[i][0]-2][queries[i][3]-1];
//			}
//			else if(queries[i][1] == 1) {
//				result = sumOfBand[queries[i][2]-1][queries[i][3]-1] - sumOfBand[queries[i][2]-1][queries[i][1]-2];
//			}
//			else {
//				result = sumOfBand[ queries[i][2]-1 ][ queries[i][3]-1 ] - sumOfBand[ queries[i][0]-2 ][ queries[i][3]-1 ]  - sumOfBand[ queries[i][2]-1 ][ queries[i][1]-2 ] + sumOfBand[ queries[i][0]-2 ][ queries[i][1]-2 ];
//			}
			result = sumOfBand[ queries[i][2] ][ queries[i][3] ] - sumOfBand[ queries[i][0]-1 ][ queries[i][3] ]  - sumOfBand[ queries[i][2] ][ queries[i][1]-1 ] + sumOfBand[ queries[i][0]-1 ][ queries[i][1]-1 ];
			System.out.println("Q"+(i+1)+" 계산 결과 : "+result);
		}
	}
}
