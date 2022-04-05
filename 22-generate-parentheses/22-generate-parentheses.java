import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
       List<String> answer = new ArrayList<>();
    public List<String> generateParenthesis(int n) {

        recusive("", n);
        return answer;
    }

    public void recusive(String s, int n) {
        if (s.length() == (n * 2)) {
            if(valid(s)){
                answer.add(s);
            }
        }else {
            recusive(s + "(", n);
            recusive(s + ")", n);
        }
    }

    public boolean valid(String s){
        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()){
            if(!stack.isEmpty()){
                if(c == ')' && stack.peek() == '('){
                    stack.pop();
                }else{
                    stack.push(c);
                }
            }else{
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }
}