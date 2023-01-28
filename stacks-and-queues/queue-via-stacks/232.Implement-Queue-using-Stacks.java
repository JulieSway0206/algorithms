// Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).

// Implement the MyQueue class:

// void push(int x) Pushes element x to the back of the queue.
// int pop() Removes the element from the front of the queue and returns it.
// int peek() Returns the element at the front of the queue.
// boolean empty() Returns true if the queue is empty, false otherwise.
// Notes:

// You must use only standard operations of a stack, which means only push to top, peek/pop from top, size, and is empty operations are valid.


//Approach: two stacks
// Push:
// Time complexity : O(1). Аppending an element to a stack is an O(1) operation.
// Space complexity : O(n). We need additional memory to store the queue elements
//Pop:
// Time complexity: Amortized O(1), Worst-case O(n). In the worst case scenario when stack s2 is empty, the algorithm pops nnn elements from stack s1 and pushes nnn elements to s2, where nnn is the queue size. This gives 2n operations, which is O(n). But when stack s2 is not empty the algorithm has O(1) time complexity.
// Space complexity : O(1)
//Peek:
// Time complexity : O(1). The front element was either previously calculated or returned as a top element of stack s2. Therefore complexity is O(1)
// Space complexity : O(1).
//Empty:
// Time complexity : O(1)
// Space complexity : O(1)



class MyQueue {

    public MyQueue() {
        
    }
    private Stack<Integer> stack1 = new Stack<Integer>();
    private Stack<Integer> stack2 = new Stack<Integer>();
    private int front;
    public void push(int x) {
        if(stack1.isEmpty()) {
            front = x;
        }
        stack1.push(x);
    }
    
    public int pop() {
        if(stack2.isEmpty()) {
            while(!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
    
    public int peek() {
        if(stack2.isEmpty()) {
            return front;
        }
        return stack2.peek();
    }
    
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */