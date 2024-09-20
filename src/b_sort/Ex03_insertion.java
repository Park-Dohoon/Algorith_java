package b_sort;

public class Ex03_insertion {
	public static void main(String[] args) {
		
		int[] arr = {3,1,4,3,2};
		
		insertion(arr);
		
		for(int i=0; i<arr.length; i++)
			System.out.print(arr[i]+" ");
	}
	
	public static void insertion(int[] arr) {
		
		for (int i=1; i<arr.length; i++) {
			
			int insertion_point =i;
			int insertion_value =arr[i];
			
			for (int j = i-1; j>=0; j--) {
				
				if(arr[j]<arr[i]) {
					insertion_point = j+1;
					break;
				}
				if(j==0)
					insertion_point =0;
			}
			
			
			for(int j=i; j>insertion_point; j--)
				arr[j] = arr[j-1];
			
			arr[insertion_point] = insertion_value;
		}
		
	}
}
