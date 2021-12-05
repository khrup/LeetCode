import java.util.Arrays;
import java.util.OptionalInt;

class Solution {
    public int longestPalindrome(String s) {
        
        //s -> abccccdd,
        //dccaccd or dccbccd
        //같은 문자가 2개 이상 이면 palindrome 가능
        //문자개수가 한개인 종류가 여러개가 나올경우 -> 그중 한개를 찝어서 palindrome 가능

        int[] charCnt = new int[52];
        for(int i = 0 ; i < s.length(); i++){
            char ch = s.charAt(i);
            if(Character.isUpperCase(ch)){
                charCnt[ch - 'A' + 26]++;
            }else {
                charCnt[ch - 'a']++;
            }
        }

        int result = Arrays.stream(charCnt).filter(cnt -> {return cnt%2 == 0;}).sum();
        OptionalInt maxInt = Arrays.stream(charCnt).filter(cnt -> {return cnt%2 != 0;}).max();
        if(maxInt.isPresent()){
            result += maxInt.getAsInt();
            result += Arrays.stream(charCnt).filter(cnt -> {return cnt%2 != 0 && cnt > 0;}).map(cnt -> {return cnt - 1;}).sum() - maxInt.getAsInt() + 1;
        }

        return result;
    }
}