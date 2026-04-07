class Solution {
    public int sumOfPower(int[] nums) {
        Arrays.sort(nums);
        
        int n = nums.length;
        long mod = 1_000_000_007;

        long prefix = 0;  // stores sum of previous contributions
        long res = 0;

        for (int i = 0; i < n; i++) {
            long x = nums[i];

            // current contribution
            long curr = (x * x) % mod;
            curr = (curr * ((x + prefix) % mod)) % mod;

            res = (res + curr) % mod;

            // update prefix
            prefix = (prefix * 2 + x) % mod;
        }

        return (int) res;
    }
}