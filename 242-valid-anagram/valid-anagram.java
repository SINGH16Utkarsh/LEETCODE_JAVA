class Solution {
    public boolean isAnagram(String s, String t) {
        int n=s.length();
        int m=t.length();

        if(n!=m){
            return false;
        }
        HashMap<Character,Integer> map= new HashMap<>();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for(int i=0;i<m;i++){
            char ch=t.charAt(i);
            if(map.get(ch)!=null){
                if(map.get(ch)==1){
                    map.remove(ch);
                }
                else{
                    map.put(ch,map.get(ch)-1);
                }}
                else{
                    return false;
                }
            
        } return map.isEmpty();
    }
   
}