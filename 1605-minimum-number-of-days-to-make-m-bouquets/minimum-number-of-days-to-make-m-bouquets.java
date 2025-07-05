class Solution {
   boolean canMakeBouquets(int currentDay, int m, int k, int[] bloomDay) {
        int flowersCount = 0;
        int bouquetsMade = 0;

        for (int day : bloomDay) {
            if (day <= currentDay) {
                flowersCount++;
                if (flowersCount == k) {
                    bouquetsMade++;
                    flowersCount = 0;
                    if (bouquetsMade == m) return true;
                }
            } else {
                flowersCount = 0;
            }
        }
        return false;
    }

    // Main function to find minimum days
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if ((long) m * k > n) return -1; // not enough flowers

        int low = 1;
        int high = 0;

        for (int day : bloomDay) {
            high = Math.max(high, day); // max bloom day
        }

        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canMakeBouquets(mid, m, k, bloomDay)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    } 
}