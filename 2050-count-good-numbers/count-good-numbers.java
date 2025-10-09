class Solution {
    private static final long MOD = 1_000_000_007;
    public int countGoodNumbers(long n) {
        long evenCount = (n + 1) / 2;
        long oddCount = n / 2;

        long evenPart = modPow(5, evenCount, MOD); // 5 choices for even indices
        long oddPart = modPow(4, oddCount, MOD);   // 4 choices for odd indices

        return (int) ((evenPart * oddPart) % MOD);
    }

    // Modular exponentiation (fast power)
    private static long modPow(long base, long exp, long mod) {
        long result = 1;
        base %= mod;
        while (exp > 0) {
            if ((exp & 1) == 1)
                result = (result * base) % mod;
            base = (base * base) % mod;
            exp >>= 1;
        }
        return result;
    }

    
}