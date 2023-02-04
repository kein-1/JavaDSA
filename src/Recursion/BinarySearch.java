package Recursion;

public class BinarySearch {
	public static void main(String[] args) {

		int[] arr = {1,2,3,4,5,6,7,8,9,10};
		int size = arr.length-1;
		boolean search1 = BinarySearchMethod(arr, 2, 0, size);
		boolean search2 = BinarySearchMethod(arr, -5, 0, size);
		boolean search3 = BinarySearchMethod(arr, 5, 0, size);
		boolean search4 = BinarySearchMethod(arr, 8, 0, size);
		boolean search5 = BinarySearchMethod(arr, 12, 0, size);

		System.out.println("Is 2 in the array? " + search1);
		System.out.println("Is -5 in the array? " + search2);
		System.out.println("Is 5 in the array? " + search3);
		System.out.println("Is 8 in the array? " + search4);
		System.out.println("Is 12 in the array? " + search5);

	}

	public static boolean BinarySearchMethod(int[] arr, int target, int start, int end){
		if (start > end){
			System.out.println("start,end " + start + " " + end);
			return false;
		}
		// preferred method to find the middle 
		int middle = start + (end - start)/2;
		
		System.out.println("start,end,middle " + start + " " + end + " " + middle);
		if (arr[middle] == target){
			return true;
		}
		// Search left half 
		if (arr[middle] > target){
			return BinarySearchMethod(arr, target, start, middle - 1);
		}
		// Search right half
		return BinarySearchMethod(arr, target, middle+1, end);
		
	}

}	
