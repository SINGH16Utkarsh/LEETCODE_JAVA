class Solution {
    public String removeKdigits(String num, int k) {
         Stack<Character> st = new Stack<>();

        for (char c : num.toCharArray()) {
            // Pop larger digits if we can still remove
            while (k > 0 && !st.isEmpty() && st.peek() > c) {
                st.pop();
                k--;
            }
            st.push(c);
        }

        // If k is still left, remove from end
        while (k > 0 && !st.isEmpty()) {
            st.pop();
            k--;
        }

        // Build result string
        StringBuilder ans = new StringBuilder();
        for (char c : st) {
            ans.append(c);
        }

        // Remove leading zeros
        int i = 0;
        while (i < ans.length() && ans.charAt(i) == '0') {
            i++;
        }

        String result = (i == ans.length()) ? "0" : ans.substring(i);
        return result;

    }
}