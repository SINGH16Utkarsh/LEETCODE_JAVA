class Solution {
     // Trie node
    static class TrieNode {
        TrieNode[] children = new TrieNode[2]; // 0 and 1
    }

    private void insert(TrieNode root, int num) {
        TrieNode node = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (node.children[bit] == null) {
                node.children[bit] = new TrieNode();
            }
            node = node.children[bit];
        }
    }

    private int getMaxXor(TrieNode root, int num) {
        TrieNode node = root;
        int xor = 0;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            int opposite = bit ^ 1;
            if (node.children[opposite] != null) {
                xor |= (1 << i);
                node = node.children[opposite];
            } else {
                node = node.children[bit];
            }
        }
        return xor;
    }

    public int[] maximizeXor(int[] nums, int[][] queries) {
        Arrays.sort(nums); // sort nums ascending

        int n = queries.length;
        int[][] q = new int[n][3];
        for (int i = 0; i < n; i++) {
            q[i][0] = queries[i][0]; // xi
            q[i][1] = queries[i][1]; // mi
            q[i][2] = i;             // original index
        }

        Arrays.sort(q, (a, b) -> Integer.compare(a[1], b[1])); // sort queries by mi

        int[] result = new int[n];
        Arrays.fill(result, -1);

        TrieNode root = new TrieNode();
        int idx = 0;

        for (int[] query : q) {
            int x = query[0], m = query[1], origIdx = query[2];

            // insert all nums <= m into Trie
            while (idx < nums.length && nums[idx] <= m) {
                insert(root, nums[idx]);
                idx++;
            }

            if (idx > 0) {
                result[origIdx] = getMaxXor(root, x);
            }
        }

        return result;
}}