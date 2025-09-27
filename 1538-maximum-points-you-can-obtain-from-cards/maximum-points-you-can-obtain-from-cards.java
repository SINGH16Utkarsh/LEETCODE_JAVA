class Solution {
    public int maxScore(int[] cardPoints, int k) {
       int n=cardPoints.length;
       int total =0;

       for(int x: cardPoints){
        total += x;
       } 

       if( n==k){
        return total;
       }

       int windowsize = n-k;
       int windowsum =0;

       for(int i=0; i<windowsize; i++){
            windowsum += cardPoints[i];
       }
       int minsum =windowsum;

       for(int i=windowsize; i<n; i++){
        windowsum += cardPoints[i] - cardPoints[i-windowsize];
        minsum =Math.min(minsum , windowsum);
       }
       return total-minsum;
    }
}