class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
      Arrays.sort(intervals, (a,b) -> a[1]-b[1]);
      
      int maxAct=0;

      //1st activity selected
      maxAct=1;
      int lastend= intervals[0][1];

      for(int i=1; i<intervals.length; i++){
        if(intervals[i][0] >= lastend){
            maxAct++;
            lastend = intervals[i][1];
        }
      }
      return intervals.length-maxAct;
        
    }
}