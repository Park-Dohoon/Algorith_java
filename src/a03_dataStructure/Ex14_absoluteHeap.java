package a03_dataStructure;

import java.util.Queue;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;


public class Ex14_absoluteHeap {
	public static void main(String args[]) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("연산의 개수를 입력하시오 : ");
		int number = input.nextInt();
		
		//calculate1(number);
		calculate2(number);
	}
	
	static void calculate1(int number) {
		Scanner input = new Scanner(System.in);
		
		LinkedList<Integer> absHeap = new LinkedList<Integer>();
		LinkedList<Integer> result = new LinkedList<Integer>();
		
		for(int i=0; i < number; i++) {
			int num_in = input.nextInt();
			
			if (num_in == 0) {
				int least = ~0>>>1;
				
				if(absHeap.isEmpty())
					least = 0;
				
				else {
					for(int temp : absHeap) {
						if(Math.abs(least) == Math.abs(temp))
							least = least < temp ? least : temp;
						
						else if(Math.abs(least) > Math.abs(temp))
							least = temp;
						
					}
					absHeap.remove( absHeap.indexOf(least) );
				}
				
				result.add(least);
				//System.out.println(least);
			}
			
			else 
				absHeap.add(num_in);
		}
		
		System.out.print("resutlt is : ");
		while(!result.isEmpty())
			System.out.print(result.poll()+" ");
	}
	
	static void calculate2(int number) {
		Scanner input = new Scanner(System.in);
		
		LinkedList<Integer> result = new LinkedList<Integer>();
		PriorityQueue<Integer> myQueue = new PriorityQueue<>( (o1, o2) -> {
			int first_abs = Math.abs(o1);
			int second_abs = Math.abs(o2);
			
			if (first_abs == second_abs)
				return o1 > o2 ? 1 : -1;
			else
				return first_abs - second_abs;
		} );
		
		for(int i=0; i < number; i++) {
			int request = input.nextInt();
			
			if(request == 0) {
				if(myQueue.isEmpty())
					result.add(0);
				else
					result.add(myQueue.poll());
			}
			else
				myQueue.add(request);
		}
		
		System.out.print("resutlt is : ");
		while(!result.isEmpty())
			System.out.print(result.poll()+" ");
	}
}
