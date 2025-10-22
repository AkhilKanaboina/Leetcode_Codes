class Solution {
    public int longestOnes(int[] nums, int k) {
        int n=nums.length;
        int counter=0;
        int j=0;
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                counter++;
            }
            while(counter>k){
                if(nums[j]==0){
                    counter--;
                }
                j++;
            }
            ans=Math.max(ans,i-j+1);
        }
        return ans;
    }
}