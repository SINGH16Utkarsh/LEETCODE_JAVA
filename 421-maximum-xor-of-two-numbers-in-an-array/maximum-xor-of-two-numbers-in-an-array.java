class Solution {
  private static final int BITS = 31; // since int fits in 32 bits (0-indexed)

    public int findMaximumXOR(int[] nums) {
        int[][] trie = new int[32 * nums.length][2]; 
        int nodeCount = 1; // root is 0

        // Insert into trie
        for (int num : nums) {
            int node = 0;
            for (int i = BITS; i >= 0; i--) {
                int bit = (num >> i) & 1;
                if (trie[node][bit] == 0) {
                    trie[node][bit] = nodeCount++;
                }
                node = trie[node][bit];
            }
        }

        int max = 0;
        // Query maximum XOR
        for (int num : nums) {
            int node = 0, curr = 0;
            for (int i = BITS; i >= 0; i--) {
                int bit = (num >> i) & 1;
                int opposite = bit ^ 1;
                if (trie[node][opposite] != 0) {
                    curr |= (1 << i);
                    node = trie[node][opposite];
                } else {
                    node = trie[node][bit];
                }
            }
            max = Math.max(max, curr);
        }
        return max;
}}
