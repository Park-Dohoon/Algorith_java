package b_sort;

public class Ex02_selection {
	public static void main(String[] args) {
		
		int[] arr = {42,32,24,60,15};
		
		selection(arr);
		
		
		for(int i=0; i<arr.length; i++)
			System.out.println(arr[i]);
		
	}
	
	public static void selection(int[] arr) {
		
		for(int i=arr.length-1; i>0; i--) {
			int max_idx = 0;
			
			for(int j=0; j<=i; j++)
				if(arr[max_idx]<arr[j])
					max_idx = j;
			
			int temp = arr[max_idx];
			arr[max_idx] = arr[i];
			arr[i] = temp;
		}
	}
}
