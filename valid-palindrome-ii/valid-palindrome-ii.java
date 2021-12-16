class Solution {
   public static boolean validPalindrome(String s) {


        //1.palindrome 판별 함수 만들기
        //2.한문자씩 빼면서 판별함수 통과
//        if(isPalindrome(s)){
//            return true;
//        }else{
//            for(int i = 0 ; i < s.length(); i++){
//                String tmp = String.valueOf(s.charAt(i));
//                String testPalindrome = s.substring(0,i) + s.substring(i, s.length()).replaceFirst(tmp, "");
//                if(isPalindrome(testPalindrome)){
//                    return true;
//                }
//            }
//        }
        // -> timeout
        if(isPalindrome(s)){
            return true;
        }
        //개선방안
        //1. 목숨한개주고 양옆에서 같은지 확인
        //2. 다르면 앞선 문자와 비교하여 palindrome 확인
        int fAddIndex = 0;
        int bAddIndex = 0;
        for(int i = 0 ; i < s.length() / 2; i++){

            char fchar = s.charAt(i+fAddIndex);
            char bchar = s.charAt(s.length() - (i + 1 + bAddIndex));

            if(fchar != bchar){
                String fPalindrome = s.substring(i+1, s.length()-i);
                String bPalindrome = s.substring(i, s.length()-(i+1));
                if(isPalindrome(fPalindrome) || isPalindrome(bPalindrome)){
                    return true;
                }else{
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean isPalindrome(String s){

        StringBuffer tmp = new StringBuffer(s);

        return s.equals(tmp.reverse().toString());
    }
}