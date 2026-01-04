class Solution {
    public int sumFourDivisors(int[] nums) {
        int n=nums.length;
        int ans=0;
        for(int i=0;i<n;i++){
            ans+=helper(nums[i]);
        }
        return ans;
    }
    private int helper(int num){
        int i=1;
        HashSet<Integer> set=new HashSet<>();
        for(;i*i<=num;i++){
            if(num%i==0){
                set.add(i);
                set.add(num/i);
            }
        }
        int ans=0;
        if(set.size()==4){
            for(int val:set){
                ans+=val;
            }
        }
        return ans;  
    }
}