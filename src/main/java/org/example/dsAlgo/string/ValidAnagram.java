package org.example.dsAlgo.string;

public class ValidAnagram {

    // s and t are in lower cases
    // length of Strings s and t should be equal
    // populate character count in int[] charCount using String s
    // Start traversing String t and decrease all charCounts by 1 if value > 0
    // If value for a particular char = 0, then the given string is not an anagram
    public boolean isAnagram(String s, String t) {
        int[] charCount = new int[26];

        if (s.length() != t.length()) {
            return false;
        }

        for (int i = 0; i < s.length(); ++i) {
            charCount[s.charAt(i) - 'a'] += 1;
        }

        for (int i = 0; i < t.length(); ++i) {
            int index = t.charAt(i) - 'a';
            if (charCount[index] == 0) {
                return false;
            } else {
                charCount[index] -= 1;
            }
        }
        return true;
    }
}
