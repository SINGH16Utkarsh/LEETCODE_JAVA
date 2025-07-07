class Solution {
    public int splitArray(int[] nums, int k) {
        int start = Integer.MIN_VALUE;
        int end = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>start){
                start = nums[i];
            }
            end += nums[i];
        }

        while(start<=end){
            int mid = start+(end-start)/2;
            if(canSplit(nums,k,mid)){
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }

        return start;
    }
    private boolean canSplit(int[] arr, int k,int maxSum){
        int noOfSubArrs = 1;
        int sum=0;
        for(int i=0;i<arr.length;i++){
            if(sum+arr[i]<=maxSum){
                sum+=arr[i];
            }
            else{
                sum=arr[i];
                noOfSubArrs++;
            }
        }
        return noOfSubArrs <= k;
    }
}