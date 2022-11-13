// In an array of integers, a peak is an element which is greater than or equal or equal to the adjacent integers and a valley is an element which is less than or equal to the adjacent integers. For example, in the array {5, 8, 6, 2, 3, 4, 6}, {8, 6} are peaks and {5, 2} are valleys. Given an array of integers, sort the array into an alternating sequence of peaks and valleys.
// Exmp:
// Input:  {5, 3, 1, 2, 3}
// Output: {5, 1, 3, 2, 3}
//https://www.geeksforgeeks.org/sort-array-wave-form-2/
//Approach 1: Wave Array using sorting
// Time Complexity: O(N*log(N))
// Auxiliary Space: O(1)
//A idea is to use sorting. First sort the input array, then swap all adjacent elements.
// Java implementation of naive method for sorting
// an array in wave form.
import java.util.*;

class SortWave
{
	// A utility method to swap two numbers.
	void swap(int arr[], int a, int b)
	{
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	// This function sorts arr[0..n-1] in wave form, i.e.,
	// arr[0] >= arr[1] <= arr[2] >= arr[3] <= arr[4]..
	void sortInWave(int arr[], int n)
	{
		// Sort the input array
		Arrays.sort(arr);

		// Swap adjacent elements
		for (int i=0; i<n-1; i += 2)
			swap(arr, i, i+1);
	}

	// Driver method
	public static void main(String args[])
	{
		SortWave ob = new SortWave();
		int arr[] = {10, 90, 49, 2, 1, 5, 23};
		int n = arr.length;
		ob.sortInWave(arr, n);
		for (int i : arr)
			System.out.print(i + " ");
	}
}



//Approach 2: Wave Array Optimized Approach
// Time Complexity: O(N)
// Auxiliary Space: O(1)
//the idea is based on the fact that if we make sure that all even positioned (at index 0, 2, 4, ..) elements are greater than their adjacent odd elements, we don’t need to worry about oddly positioned elements. 
// A O(n) Java program to sort an input array in wave form
public class SortWave
{
	// A utility method to swap two numbers.
	void swap(int arr[], int a, int b)
	{
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	// This function sorts arr[0..n-1] in wave form, i.e.,
	// arr[0] >= arr[1] <= arr[2] >= arr[3] <= arr[4]....
	void sortInWave(int arr[], int n)
	{
		// Traverse all even elements
		for(int i = 0; i < n-1; i+=2){
			//swap odd and even positions
			if(i > 0 && arr[i - 1] > arr[i])
				swap(arr, i, i-1);
			if(i < n-1 && arr[i + 1] > arr[i])
				swap(arr, i, i+1);
		}
	}

	// Driver program to test above function
	public static void main(String args[])
	{
		SortWave ob = new SortWave();
		int arr[] = {10, 90, 49, 2, 1, 5, 23};
		int n = arr.length;
		ob.sortInWave(arr, n);
		for (int i : arr)
			System.out.print(i+" ");
	}
};

