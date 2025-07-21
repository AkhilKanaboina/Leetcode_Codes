class Solution {
    public String makeFancyString(String s) {
        int n = s.length();
        int[] freq = new int[n];
        freq[0] = 0;

        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                freq[i] = freq[i - 1] + 1;  // Fix: use freq[i - 1] here
            } else {
                freq[i] = 0;
            }
        }

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (freq[i] <= 1) {  // allows at most 2 consecutive characters
                ans.append(s.charAt(i));
            }
        }

        return ans.toString();
    }
}
