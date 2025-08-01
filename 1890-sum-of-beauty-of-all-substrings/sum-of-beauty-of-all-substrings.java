class Solution {
    public int beautySum(String s) {
         int total = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            int[] freq = new int[26]; // frequency of characters in current substring

            for (int j = i; j < n; j++) {
                freq[s.charAt(j) - 'a']++;

                int max = 0, min = Integer.MAX_VALUE;
                for (int f : freq) {
                    if (f > 0) {
                        max = Math.max(max, f);
                        min = Math.min(min, f);
                    }
                }

                total += (max - min); // beauty of current substring
            }
        }

        return total;
    }
}