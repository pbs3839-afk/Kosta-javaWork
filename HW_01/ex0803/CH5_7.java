package ex0803;

public class CH5_7 {
	int iarr [] = new int [5];
	public static void main(String[] args) {
		int [] arr = {1,5,3,8,2};
		for (int i=0 ; i < arr.length -1; i++) {
		    for (int j=0; j < arr.length -1 - i; j++) {
		        if (arr[j] > arr[j +1]) {
		            int temp = arr[j];
		            arr[j] = arr[j +1];
		            arr[j +1] = temp;
		        }
		    }
		}	System.out.println(arr[4]);
		int [] array = {1,5,3,8,2};
		int maxValue = Integer.MIN_VALUE;
		
		for (int i=0;i <arr.length;i++) {
			if (maxValue<array[i]) {
				maxValue = array[i];
			}
		}
		System.out.println(maxValue);
	
	
	
	}	

}
