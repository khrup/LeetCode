import java.util.HashSet;
import java.util.Set;

class Solution {
     public String longestPalindrome(String s) {

        String maxSubString = s;

        int max = Integer.MIN_VALUE;
        int maxIdx = 0;
        if (isPalidrome(maxSubString)) {
            return maxSubString;
        } else {
            for (int i = 0; i < s.length(); i++) {
                int len1 = palindromeLength(s, i, i);
                int len2 = palindromeLength(s, i, i + 1);
                int len3 = Integer.max(len1, len2);
                if(len3 > max){
                    max = len3;
                    maxIdx = i;
                }

            }
        }

        int left, right;
        if(max % 2 == 1){
            left = maxIdx - max / 2;
            right = maxIdx + max / 2 + 1;
        }else{
            left = maxIdx - max / 2 + 1;
            right = maxIdx + 1 + max / 2;
        }
        return maxSubString.substring(left, right);
    }

    public boolean isPalidrome(String s) {

        StringBuffer sb = new StringBuffer(s);
        if (s.equals(sb.reverse().toString())) {
            return true;
        }
        return false;
    }

    public int palindromeLength(String s, int left, int right) {

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return right - left - 1;
    }
}