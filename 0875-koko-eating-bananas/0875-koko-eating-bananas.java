class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;

        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        int result = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            long totalHours = 0;
            for (int pile : piles) {
                totalHours += (pile + mid - 1) / mid;  // same as ceil
            }

            if (totalHours <= h) {
                result = mid;
                right = mid - 1; // try smaller speed
            } else {
                left = mid + 1;  // speed is too small
            }
        }

        return result;
    }
}
