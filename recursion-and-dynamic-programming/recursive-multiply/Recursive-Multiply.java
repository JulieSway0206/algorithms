//Write a recursive function to multiply two positive integers without using the * operator. You can use
//addition, subtraction, and bit shifting, but you should minimize the number of those operations.
//Iterative
//10 * 7
// lastBit = 3
// sum = 56
// a = 2
// lastBit = 1
// sum = 56 + 14
// a = 0
class Solution {
    public int multiply(int a, int b) {
		int lastBit  = (int) (Math.log10(a)/Math.log10(2));
 		int sum  = 0;
    	while (a!=0){
        	sum += (b<<lastBit);  // every shift  multiply number by 2
        	a-=(1<<lastBit); 
        	lastBit  = (int) (Math.log10(a)/Math.log10(2)); // get the last bit location
    	}
    	return sum;
	}
}

//recursive
class Solution {
	public int multiply(int a, int b) {
		if(a == 0 || b == 0) {
			return 0;
		}
		if (a == 1) {
			return b;
		}

		return mutiply(a-1, b) + b;
	}
}