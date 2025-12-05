class Solution {
    public int numberOfSubstrings(String s) {
        int lastSeen[] = new int[3];
        Arrays.fill(lastSeen, -1);
        int n = s.length();
        int index = -1;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            lastSeen[s.charAt(i) - 'a'] = i;
            if (lastSeen[0] != -1 && lastSeen[1] != -1 && lastSeen[2] != -1) {
                index = Math.min(lastSeen[0], Math.min(lastSeen[1], lastSeen[2]));
                ans += (index + 1);
            }
        }
        return ans;
    }
}