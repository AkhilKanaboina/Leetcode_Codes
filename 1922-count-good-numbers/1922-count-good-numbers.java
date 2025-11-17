class Solution {
    static final long mod = 1000000007;

    public int countGoodNumbers(long n) {
        long half = n / 2;
        return (int)((helper(4, half) * helper(5, half + (n % 2))) % mod);
    }

    public long helper(long val, long power) {
        long result = 1;
        while (power > 0) {
            if (power % 2 == 1) {
                result = (result * val) % mod;
                power--;
            } else {
                val = (val * val) % mod;
                power /= 2;
            }
        }
        return result;
    }
}
