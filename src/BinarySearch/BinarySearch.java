package BinarySearch;

public class BinarySearch {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8,9,10};
		// int val = BsearchFirstBad(9, arr);
		// int val2 = BsearchFirstBad(10, arr);
		int val3 = BsearchFirstBad(20, arr);
		// int val4 = BsearchFirstBad(-1, arr);
		// System.out.println(val);
		// System.out.println(val2);
		System.out.println(val3);
		// System.out.println(val4);
	}

	/**
	 * 
	 * @param target 
	 * @param arr
	 * @return The first bad integer
	 */

	static int BsearchFirstBad(int target, int[] arr){
		if (arr == null || arr.length == 0){
			return -1;
		}

		int start = 0; 
		int end = arr.length - 1;
		
		while (start <= end){
			// preferred method to find the middle 
			int middle = start + (end - start)/2;
			if (arr[middle] == target){
				return target;
			}
			if (arr[middle] > target){
				end = middle - 1;
			} else{
				start = middle + 1;
			}
			System.out.println(start + " " + end + " " + middle);

		}
		return start;
	}
}
