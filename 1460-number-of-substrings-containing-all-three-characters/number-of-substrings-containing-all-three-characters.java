class Solution {
    public int numberOfSubstrings(String s) {
        int last[] = {-1,-1,-1};
        int n =s.length();
        int res=0;


        for(int i=0; i<n; i++){
            char ch =s.charAt(i);
            last[ch-'a'] = i;

            if(last[0] != -1 && last[1] != -1 && last[2] != -1){
                res += 1 + Math.min(last[0] , Math.min(last[1], last[2]));
            }
        }
        return res;
    }
}