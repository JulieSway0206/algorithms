// You have an infinite number of stacks arranged in a row and numbered (left to right) from 0, each of the stacks has the same maximum capacity.
// Implement the DinnerPlates class:
// DinnerPlates(int capacity) Initializes the object with the maximum capacity of the stacks capacity.
// void push(int val) Pushes the given integer val into the leftmost stack with a size less than capacity.
// int pop() Returns the value at the top of the rightmost non-empty stack and removes it from that stack, and returns -1 if all the stacks are empty.
// int popAtStack(int index) Returns the value at the top of the stack with the given index index and removes it from that stack or returns -1 if the stack with that given index is empty.
//Exp:
// ["DinnerPlates","push","push","push","popAtStack","pop","pop"]
// [[1],[1],[2],[3],[1],[],[]]

// PS: A TreeSet is a set where the elements are sorted.
// A HashSet is a set where the elements are not sorted or ordered. It is faster than a TreeSet. The HashSet is an implementation of a Set.

// Intuition
// Use ArrayList to store stacks and keep a tab on empty stacks using TreeSet

// Approach
// Maintain an ordered set of indexes to store stack with items less than capacity. Item at the front of set will give the leftmost index of stack with plates less than capacity

//TreeSet in Java, provide O(log(N)) complexity for adding, removing, and searching elements
// Stack is a very useful data structure with many uses. It is an essential part of every program as all the programming languages internally use stack for function calls and many more operations. To summarize , the time and space Complexities of Stack are:
// OPERATION	BEST TIME COMPLEXITY	WORST TIME COMPLEXITY	AVERAGE TIME COMPLEXITY	SPACE COMPLEXITY
// Push	              O(1)	                    O(n)	                 O(1)	              O(1)
// Pop	              O(1)	                    O(1)	                 O(1)	              O(1)
// Peek	              O(1)	                    O(1)	                 O(1)	              O(1)


Read more: https://javarevisited.blogspot.com/2017/04/difference-between-priorityqueue-and-treeset-in-java.html#ixzz7rj9FWqtS
class DinnerPlates {

	List<Stack<Integer>> stacks; // ArrayList of stacks of plates
	int capacity;
	TreeSet<Integer> availableStack; // Track of the ordered indices of stacks with available space to push new
										// elements

	public DinnerPlates(int capacity) {
		this.stacks = new ArrayList<Stack<Integer>>();
		this.capacity = capacity;
		this.availableStack = new TreeSet<Integer>();
	}

	public void push(int val) {
		if (availableStack.isEmpty()) { // No stack with space is available
			stacks.add(new Stack<Integer>()); // Add a new empty stack
			availableStack.add(stacks.size() - 1); // Add the index of the newly added stack
		}

		// Gets the smallest value from the treeset which will be the index
		// of the first stack with space to push a value
		Stack<Integer> firstStackWithSpace = stacks.get(availableStack.first());
		firstStackWithSpace.push(val);

		// If this firstStackWithSpace reaches max capacity, remove the index from
		// treemap
		if (firstStackWithSpace.size() == capacity) {
			availableStack.pollFirst(); // Remove the smallest value (index of stack)
		}
	}

	public int pop() {
		if (stacks.isEmpty()) { // No stack is present
			return -1; // Return -1
		}
		int val = stacks.get(stacks.size() - 1).pop(); // Pop from the last stack in the list of stacks

		// Since we removed at least 1 element from this last stack, let's add its index
		// to availableStack
		availableStack.add(stacks.size() - 1);

		// Once we remove an element from the last stack, we need to check if that stack
		// is empty or not,
		// and if empty, we need to remove the empty stacks
		//why to have while here, check the example above
		while (!stacks.isEmpty() && stacks.get(stacks.size() - 1).isEmpty()) {
			stacks.remove(stacks.size() - 1); // Remove the stack from the list of stacks

			// Since we removed the element from the last index, and that was in
			// availableStack
			// as a stack which has space to push more elements, it would have been the
			// highest
			// value in the TreeSet, since data stays as sorted in TreeSet. So we can use
			// pollLast()
			// to remove the last (or rather highest value) index now, since we also removed
			// that
			// empty stack from the list of stacks
			availableStack.pollLast();
		}

		return val;
	}

	public int popAtStack(int index) {
		if (index >= stacks.size()) {
			return -1; // Invalid stack index
		}
		if (index == stacks.size() - 1) { // Basically the last stack
			return pop();
		}

		// If it's any index other than the last stack, then...
		Stack<Integer> requiredStack = stacks.get(index);
		int val = requiredStack.isEmpty() ? -1 : requiredStack.pop();
		availableStack.add(index); // Since we removed an element, it frees up a space in that stack

		return val;
	}
}
/**
 * Your DinnerPlates object will be instantiated and called as such:
 * DinnerPlates obj = new DinnerPlates(capacity);
 * obj.push(val);
 * int param_2 = obj.pop();
 * int param_3 = obj.popAtStack(index);
 */