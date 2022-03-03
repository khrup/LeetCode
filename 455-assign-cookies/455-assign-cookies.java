class Solution {
    public int findContentChildren(int[] g, int[] s) {
        g = Arrays.stream(g).sorted().toArray();
        s = Arrays.stream(s).sorted().toArray();

        int content = 0;
        int gIndex = 0;
        int sIndex = 0;
        
        while(true && s.length > 0){
            if(g[gIndex] <= s[sIndex]){
                content++;
                gIndex++;
                sIndex++;
            }else if(g[gIndex] > s[sIndex]){
                sIndex++;
            }

            if(gIndex == g.length || sIndex == s.length) break;
        }

        return content;
    }
}