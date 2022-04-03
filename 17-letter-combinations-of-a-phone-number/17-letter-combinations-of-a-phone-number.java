import java.util.ArrayList;
import java.util.List;
class Solution {
    
    public List<String> answer = new ArrayList<>();
    
     public List<String> letterCombinations(String digits) {

        if(!"".equals(digits)) {
            dfs("", digits, 0);
        }
        return answer;
    }

    public void dfs(String comb, String digits, int index) {

        if (comb.length() == digits.length()) {
            answer.add(comb);
            return;
        }

        String alphabet = getAlphabet(digits.charAt(index));
        for (char c : alphabet.toCharArray()) {
            dfs(comb+c, digits, index + 1);
        }
    }

    public String getAlphabet(char c) {

        switch (c) {
            case '2':
                return "abc";
            case '3':
                return "def";
            case '4':
                return "ghi";
            case '5':
                return "jkl";
            case '6':
                return "mno";
            case '7':
                return "pqrs";
            case '8':
                return "tuv";
            case '9':
                return "wxyz";
            default:
                return "";
        }
    }
}