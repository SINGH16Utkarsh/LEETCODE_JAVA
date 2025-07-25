class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0  || strs== null){
            return "";
        }
       String match = strs[0];
       for(int i=0; i<strs.length; i++){
        while(!strs[i].startsWith(match)){
            match = match.substring(0,match.length()-1);
            if(match.isEmpty()){
                return "";
            }
        }
       }
      
       
        return match;
    }
}