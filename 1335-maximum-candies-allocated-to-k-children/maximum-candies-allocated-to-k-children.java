class Solution {
    public int maximumCandies(int[] candies, long k) {
        long low=1;
        long high=0;
        for(int pile : candies){
           high += pile;
        }
        long end = high/k;
        int answer=0;

        while(low<=end){
            long mid = low + (end-low)/2;
            if(canDistribute(candies,k,mid)){
            answer=(int)mid;
            low=mid+1;
        }
        else{
            end=mid-1;
        }
        }
        return answer;
    }
    public boolean canDistribute(int candies[],long k, long CandiesPerChildren){
        long count=0;
        for(int pile :candies){
            count+=(pile/CandiesPerChildren);
        }
        return count>=k;
    }
}