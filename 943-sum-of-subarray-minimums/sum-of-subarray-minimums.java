class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n= arr.length;
        long mod =1000000007;

        
        int[] left = new int[n];   // distance to previous strictly less
        int[] right = new int[n];

        Stack<Integer> stack = new Stack<>();

         for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? (i + 1) : (i - stack.peek());
            stack.push(i);
        }

        stack.clear();
        // next less or equal
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? (n - i) : (stack.peek() - i);
            stack.push(i);
        }  
         long result = 0;
        for (int i = 0; i < n; i++) {
            result = (result + (long) arr[i] * left[i] * right[i]) % mod;
        }
        return (int) result;

    }
}