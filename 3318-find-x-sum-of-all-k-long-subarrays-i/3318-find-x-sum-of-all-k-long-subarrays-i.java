class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        HashMap<Integer, Integer> freq = new HashMap<>();

        // build first window
        for (int i = 0; i < k; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }
        ans[0] = getXSum(freq, x);

        // slide the window
        for (int i = k; i < n; i++) {
            int remove = nums[i - k];
            int add = nums[i];

            freq.put(remove, freq.get(remove) - 1);
            if (freq.get(remove) == 0) freq.remove(remove);

            freq.put(add, freq.getOrDefault(add, 0) + 1);

            ans[i - k + 1] = getXSum(freq, x);
        }
        return ans;
    }

    private int getXSum(HashMap<Integer, Integer> freq, int x) {
        // sort by freq desc, then value desc
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[1] == b[1]) return b[0] - a[0];
            return b[1] - a[1];
        });

        for (int key : freq.keySet()) {
            pq.offer(new int[]{key, freq.get(key)});
        }

        int sum = 0;
        for (int i = 0; i < x && !pq.isEmpty(); i++) {
            int[] top = pq.poll();
            sum += top[0] * top[1];   // multiply value × frequency ✅
        }
        return sum;
    }
}
