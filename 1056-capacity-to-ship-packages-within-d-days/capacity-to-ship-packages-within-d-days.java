class Solution {
    public int shipWithinDays(int[] weights, int days) {
       int max = Integer.MIN_VALUE, sum = 0;
        for (int i = 0; i < weights.length; i++) {
            sum += weights[i];
            max = Math.max(max, weights[i]);
        }
        int low = max, high = sum;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (daystocomplete(weights, mid) <= days)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return low;
}
         static int daystocomplete(int[] weights, int capacity) {
        int days = 1, load = 0;
        for (int i = 0; i < weights.length; i++) {
            if (load + weights[i] > capacity) {
                days++;
                load = weights[i];
            } else
                load += weights[i];
        }
        return days;
    }
}