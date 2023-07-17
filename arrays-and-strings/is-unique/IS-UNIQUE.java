//Given a string, determine if the string has all unique characters. What if you can't use additional data structures?

//https://www.geeksforgeeks.org/determine-string-unique-characters/
//Approach 1 – Sorting:
//Time Complexity: O(nlogn)  
//Auxiliary Space: O(1)
public class IS-UNIQUE
{

boolean uniqueCharacters(String str)
    {
        char[] chArray = str.toCharArray();
 
        // Using sorting
        // Arrays.sort() uses binarySort in the background
        // for non-primitives which is of O(nlogn) time complexity
        Arrays.sort(chArray);
 
        for (int i = 0; i < chArray.length - 1; i++) {
            // if the adjacent elements are not
            // equal, move to next element
            if (chArray[i] != chArray[i + 1])
                continue;
 
            // if at any time, 2 adjacent elements
            // become equal, return false
            else
                return false;
        }
        return true;
    }

}

	// Approach 2 - Using sets() function:
	// Time Complexity: O(nlogn)

	// Auxiliary Space: O(n)

	static boolean uniqueCharacters(String str) {
		HashSet<Character> char_set = new HashSet<>();

		// Inserting character of String into set
		for (int c = 0; c < str.length(); c++) {
			char_set.add(str.charAt(c));
		}

		// If length of set is equal to len of String
		// then it will have unique characters
		return char_set.size() == str.length();
	}

	// Approach 3 – Without Extra Data Structure: The approach is valid for strings
	// having alphabet as a-z. This approach is a little tricky.
	// Instead of maintaining a boolean array, we maintain an integer value called
	// checker(32 bits). As we iterate over the string,
	// we find the int value of the character with respect to ‘a’ with the statement
	// int bitAtIndex = str.charAt(i)-‘a’;
	// Then the bit at that int value is set to 1 with the statement 1 << bitAtIndex
	// .
	// Now, if this bit is already set in the checker, the bit AND operation would
	// make the checker > 0. Return false in this case.
	// Else Update checker to make the bit 1 at that index with the statement
	// checker = checker | (1 <<bitAtIndex);

	// Time Complexity: O(n)
	// Auxiliary Space: O(1)
	boolean uniqueCharacters(String str) {
		// Assuming string can have characters a-z
		// this has 32 bits set to 0
		int checker = 0;

		for (int i = 0; i < str.length(); i++) {
			int bitAtIndex = str.charAt(i) - 'a';

			// if that bit is already set in checker,
			// return false
			if ((checker & (1 << bitAtIndex)) > 0)
				return false;

			// otherwise update and continue by
			// setting that bit in the checker
			checker = checker | (1 << bitAtIndex);
		}

		// no duplicates encountered, return true
		return true;
}
