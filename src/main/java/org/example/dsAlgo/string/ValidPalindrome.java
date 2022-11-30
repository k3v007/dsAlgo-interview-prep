package org.example.dsAlgo.string;

public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        // Given string may contain spaces or integer that must be skipped
        // Also the character can be in upper case also
        int i = 0, j = s.length() - 1;
        boolean isPalindrome = true;
        while (i <= j) {
            char first = s.charAt(i);
            char last = s.charAt(j);
            if (!isAlphaNumeric(first)) {
                ++i;
                continue;
            }
            if (!isAlphaNumeric(last)) {
                --j;
                continue;
            }
            if (Character.toLowerCase(first) != Character.toLowerCase(last)) {
                isPalindrome = false;
                break;
            }
            ++i;
            --j;
        }
        return isPalindrome;
    }

    private boolean isAlphaNumeric(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
    }
}
