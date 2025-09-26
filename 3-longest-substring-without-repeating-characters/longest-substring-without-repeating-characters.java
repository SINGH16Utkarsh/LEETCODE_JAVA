class Solution {
    public int lengthOfLongestSubstring(String s) {
         Set<Character> window = new HashSet<>();

         int left =0; int maxLen =0;

         for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);

            while(window.contains(ch)){
                window.remove(s.charAt(left));
                left ++;
            }
            window.add(ch);
            maxLen = Math.max(maxLen, i - left +1);
         }
           return maxLen;
    }
}