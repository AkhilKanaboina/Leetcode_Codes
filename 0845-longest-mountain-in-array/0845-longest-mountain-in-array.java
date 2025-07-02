class Solution {
    public int longestMountain(int[] arr) {
        int start = -1, mid = -1, end = -1;
        int ans = 0;
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            if (arr[i] < arr[i + 1]) {
                if (start == -1) {
                    start = i;
                }
                // New increasing after a valid mountain
                if (start != -1 && mid != -1 && end != -1) {
                    start = i;
                    mid = -1;
                    end = -1;
                }
            } else if (arr[i] > arr[i + 1]) {
                if (start != -1) {
                    if (mid == -1) {
                        mid = i;
                    }
                    end = i + 1;
                    ans = Math.max(ans, end - start + 1);
                }
            } else {
                // Equal elements — break in the mountain
                start = -1;
                mid = -1;
                end = -1;
            }
        }

        return ans >= 3 ? ans : 0;
    }
}
