class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low=1, high=0;
        for(int i :nums){
            high=Math.max(high,i);
        }
        int ans=0;
        while(low <= high){
            int mid = low +(high-low)/2;
            if(smallerDivisor(mid, nums, threshold)){
               ans=mid;
               high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
    public boolean smallerDivisor(int divisor, int nums[], int threshold){
        int x=0;
        for(int i:nums){
            x +=(int)Math.ceil((double) i/divisor);
        }
        return x <=threshold;
    }
}