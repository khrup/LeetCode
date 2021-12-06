import java.util.Arrays;

class Solution {
    public int findContentChildren(int[] g, int[] s) {

        //1. 각 배열을 sorted
        //2. 작은 배열 기준으로 for
        //3. 인덱스 한개씩 비교하여 카운트 증가
        g = Arrays.stream(g).sorted().toArray();
        s = Arrays.stream(s).sorted().toArray();

        int result = 0;
        int jIndex = 0;
        for(int i = 0 ; i < g.length ; i++){
            for(int j = jIndex ; j < s.length ; j++){
                if(s[j] >= g[i]){
                    result++;
                    jIndex = j + 1;
                    break;
                }
            }
        }

        return result;
    }
}