class Solution {
    int target;
    int size;
    Map<String,Integer> memo=new HashMap<>();
    public int findTargetSumWays(int[] nums, int val) {
        target=val;
        size=nums.length;
        return dp(nums,0,0);
    }
    public int dp(int nums[],int n,int val){
        if (n == size) {
             return (val == target) ? 1 : 0;
        }
        if(memo.containsKey(n+","+val)){
            return memo.get(n+","+val);
        }
        int neg=dp(nums,n+1,val-nums[n]);
        int pos=dp(nums,n+1,val+nums[n]);
        memo.put(n+","+val,neg+pos);
        return neg+pos;
    }
}