class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        int[] need = new int[128]; // frequency of t
        int[] window = new int[128]; // frequency of current window

        // fill need[]
        for (char c : t.toCharArray()) {
            need[c]++;
        }

        int have = 0;                  // how many chars satisfied
        int needCount = t.length();    // total chars needed (including duplicates)

        int left = 0, minLen = Integer.MAX_VALUE, start = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            if (need[c] > 0) { // only track chars in t
                window[c]++;
                if (window[c] <= need[c]) {
                    have++;
                }
            }

            // when all needed chars are matched
            while (have == needCount) {
                // update min window
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                char leftChar = s.charAt(left);
                if (need[leftChar] > 0) {
                    window[leftChar]--;
                    if (window[leftChar] < need[leftChar]) {
                        have--;
                    }
                }
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}