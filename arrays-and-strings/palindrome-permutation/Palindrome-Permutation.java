//Given a string s, return true if a permutation of the string could form a palindrome and false otherwise.

//Approach #1 Using HashMap
// Time complexity : O(n). We traverse over the given string sss with n characters once. We also traverse over the map which can grow up to a size of n in case all characters in s are distinct.

// Space complexity : O(1). The map can grow up to a maximum number of all distinct elements. However, the number of distinct characters are bounded, so as the space complexity.
public class Solution {
 public boolean canPermutePalindrome(String s) {
     HashMap < Character, Integer > map = new HashMap < > ();
     for (int i = 0; i < s.length(); i++) {
         map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
     }
     int count = 0;
     for (char key: map.keySet()) {
         count += map.get(key) % 2;
     }
     return count <= 1;
 }
}

//Approach #2 Using Set (single pass):
// Time complexity : O(n). 
// Space complexity : O(1).
public class Solution {
    public boolean canPermutePalindrome(String s) {
        Set < Character > set = new HashSet < > ();
        for (int i = 0; i < s.length(); i++) {
            if (!set.add(s.charAt(i)))
                set.remove(s.charAt(i));
        }
        return set.size() <= 1;
    }
}

