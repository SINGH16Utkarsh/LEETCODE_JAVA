class Solution {
    static class Pair implements Comparable<Pair>{
        char ch;
        int count;
        public Pair(char ch, int count){
            this.ch=ch;
            this.count=count;
        }
        @Override
        public int compareTo(Pair p2){
            return Integer.compare(p2.count, this.count);
        }
    }
    public String frequencySort(String s) {
        int arr[] = new int[126];
        for(char ch : s.toCharArray()){
            arr[ch]++;
        } 
        List<Pair> list = new ArrayList<>();
        for(int i=0; i<126; i++){
            if(arr[i]>0){
             
             list.add(new Pair((char)i, arr[i]));
             }
        }
        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        for(Pair p : list){
            for(int i=0; i<p.count; i++){
                sb.append(p.ch);
            }
        }
        return sb.toString();
    }
}