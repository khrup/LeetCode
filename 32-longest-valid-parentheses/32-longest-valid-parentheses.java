class Solution {
    public int longestValidParentheses(String s) {

        Stack<Character> stack = new Stack<>();
        List<Integer> cntList  = new ArrayList<>();
        for (char c : s.toCharArray()) {

            if (c == '(') {
                stack.push(c);
                cntList.add(0);
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                    int index = cntList.size() - 1;
                    for(int i = index ;i >= 0 ; i--){
                        if(cntList.get(i) == 0){
                            index = i;
                            break;
                        }
                    }
                    cntList.remove(index);
                    cntList.add(index, 2);
                }else {
                    cntList.add(0);
                }
            }
        }
        System.out.println(cntList);
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (Integer i : cntList) {
            if (i == 0) {
                if (sum > max) {
                    max = sum;
                }
                sum = 0;
            } else {
                sum += i;
            }
        }
        if (sum > max) {
            max = sum;
        }
        return max;
    }
}