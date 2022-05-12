// A magic index in an arrayA[l…n-l]is defined to be an index such thatA[i] = i. 
// Given a sorted array of distinct integers, write a method to find a magic index, if one exists, in array A.
//https://codesolutiony.wordpress.com/2014/12/31/9-3-magic-index/
//The time complexity of the binary search algorithm is O(log n). 
// The space complexity of the binary search algorithm depends on the implementation of the algorithm. 
// There are two ways of implementing it:
// 1.Iterative method
// 2.Recursive method
// In the iterative method, the space complexity would be O(1). 
// While in the recursive method, the space complexity would be O(log n). 
public int findMagicIndex(int[] num) {
    int start = 0, end = num.length - 1;
    while (start <= end) {
        int mid = (start + end) / 2;
        if (num[mid] == mid) {
            return mid;
        }
        if (num[mid] > mid) {
            end = mid - 1;
        } else {
            start = mid + 1;
        }
    }
    return -1;
}

class Solution {
	public int findMagicIndex(int[] num) {
		return helper(num, 0, num.length -1);
	}

	private int helper(int[] num, int start, int end) {
		if (start > end){
			return -1;
		}
		int mid = (start + end) / 2;
		if (num[mid] == mid) {
			return mid;
		}
		if (num[mid] > mid) {
			return helper(num, start, mid - 1);
		}
		else {
			return helper(num, mid + 1, end);
		}

	}
}	


// FOLLOW UP
// What if the values are not distinct?
class Solution {
	public int findMagicIndex(int[] num) {
		return subFind(num, 0, num.length - 1);
	}

	private int subFind(int[] num, int start, int end) {
		int result = -1;
		if(start > end) {
			return -1;
		}

		int mid = (start + end) / 2;
		if(num[mid] == mid) {
			return mid;
		}
		if(num[mid] > mid) {
			result = subFind(num, start, mid - 1);
			retsult = result == -1 ? subFind(num, num[mid], end) : result;
		} else {
			result = subFind(num, mid + 1, end);
			result = result == -1 ? subFind(num, start, num[mid]);
		}
		return result;
	}
}