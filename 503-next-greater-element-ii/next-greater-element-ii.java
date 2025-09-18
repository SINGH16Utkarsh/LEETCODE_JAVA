class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> s = new Stack<>();
        int n = nums.length;
        int result[] = new int[n];
        Arrays.fill(result,-1);

        for(int i=0; i<2*n; i++){
            int num = nums[i%n];

            while(!s.isEmpty() && nums[s.peek()] <num){
                result[s.pop()]=num;
            }
        
        if(i<n){
            s.push(i);
        }}
        return result;
    }

}