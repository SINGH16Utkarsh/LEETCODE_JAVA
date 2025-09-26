class Solution {
    public int totalFruit(int[] fruits) {
         Map<Integer, Integer> count = new HashMap<>();
         
         int left =0, maxlen =0;

         for(int right =0; right <fruits.length; right++){
            int fruit = fruits[right];
            count.put(fruits[right] , count.getOrDefault(fruits[right], 0)+1);
         

         while(count.size()>2){
            int leftfruit = fruits[left];
            count.put(leftfruit,count.get(leftfruit) -1);
            if(count.get(leftfruit)==0){
                count.remove(leftfruit);
            }
            left ++;
         }
          maxlen = Math.max(maxlen, right-left+1);

         
         }
         return maxlen;
    }
}