// Towers of Hanoi: In the classic problem of the Towers of Hanoi, you have 3 towers and N disks of different sizes which can slide onto any tower. The puzzle starts with disks sorted in ascending order of size from top to bottom (i.e., each disk sits on top of an even larger one).
// You have the following constraints:
// (1) Only one disk can be moved at a time.
// (2) A disk is slid off the top of one tower onto another tower.
// (3) A disk cannot be placed on top of a smaller disk. Write a program to move the disks from the first tower to the
// last using Stacks.
//https://www.youtube.com/watch?v=rf6uf3jNjbo




public class Solution {
	public static void toh(int n, int start, int end) {
		if(n == 1) {
			print(n, start, end);
		}
		else {
			int other = 6 - (start + end);
			toh(n-1, start, other);
			print(n, start, end);
			toh(n-1, other, end);
		}
	}
	public static void print(int n, int start, int end) {
		System.out.println(n+"["+start+"->"+end+"]");
	}
}