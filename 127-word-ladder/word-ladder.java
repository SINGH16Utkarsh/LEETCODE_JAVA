class Solution {
    public int ladderLength(String beginword, String endword, List<String> wordlist) {
        if( !wordlist.contains(endword))  return 0;
        HashMap<String,Boolean> Vmap = new HashMap<String,Boolean>();
        for(int i=0; i<wordlist.size(); i++){
            Vmap.put(wordlist.get(i),false);
        }
            Queue<String> q = new LinkedList<>();
            int length=1;
            q.add(beginword);
            Vmap.put(beginword, true);
            while(!q.isEmpty()){
                int size=q.size();
                for(int i=0; i<size; i++){
                    String w =q.poll();
                    if(w.equals(endword)){
                        return length;
                    }
                    wordwatch(w,Vmap,q);
                }
                length++;
            }
            return 0;
        
    }
    public void wordwatch(String w, HashMap<String , Boolean> Vmap, Queue<String> q){
        for(int i=0; i<w.length(); i++){
            char[] word =w.toCharArray();
            for(int j=0; j<26; j++){
                char c = (char) ('a'+j);
                 word[i]=c;
                 String s = String.valueOf(word);
                 if(Vmap.containsKey(s) && Vmap.get(s)==false){
                    q.add(s);
                    Vmap.put(s,true);
                 }

            }
        }
    }
}