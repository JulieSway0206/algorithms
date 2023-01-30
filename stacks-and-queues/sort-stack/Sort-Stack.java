import java.util.Stack;

//Given a stack of integers, sort it in ascending order 
//https://www.enjoyalgorithms.com/blog/sort-stack-using-temporary-stack
//Appraoch1: Using a temporary stack
//Time complexity:
//Worst-case scenario, the input stack is sorted in descreasing order. Total number of stack operations = n + n - 1 + n - 2 ... + 1 = n ( n + 1) = O(n^2)
//Space complexity:
//O(n) as we are using temporary stack
public class Solution {
	public Stack<Integer> sortStack(Stack<Integer> s) 
	{
		Stack<Integer> tempStack = new Stack<Integer>();
		while(!s.empty()) {
			int topInputStack = s.pop();
			if(!tempStack.isEmpty() && tempStack.peek() > topInputStack) {
				int topTempStack = tempStack.pop();
				s.push(topTempStack);
			}
			tempStack.push(topInputStack);
		}
		return tempStack;
	}
}


//Approach2: Using recursion
public class Solution {
	private void insertTop(Stack<Integer> s, int topElement) {
		if(s.isEmpty() || s.peek() < topElement) {
			s.push(topElement);
			return;
		}
		int temp = s.pop();
		insertTop(s, topElement);
		s.push(temp);
	}
	public void sortStack(Stack<Integer> s) 
	{
		if(!s.empty()) {
			int topElement = s.pop();
			sortStack(s);
			insertTop(s, topElement);
		}
	}
}



