class Solution {
    public int countPrimes(int n) {
         if (n <= 2) return 0;  // No primes less than 2
        
        // Step 1: Initialize boolean array
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);  // Assume all numbers are prime initially
        
        isPrime[0] = false;  // 0 is not prime
        isPrime[1] = false;  // 1 is not prime
        
        // Step 2: Sieve algorithm
        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;  // Mark multiples of i as not prime
                }
            }
        }
        
        // Step 3: Count primes
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) count++;
        }
        
        return count;
    }
}