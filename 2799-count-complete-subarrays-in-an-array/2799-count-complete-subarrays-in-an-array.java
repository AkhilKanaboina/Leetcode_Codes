class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int n=nums.length;
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<n;i++){
            set.add(nums[i]);
        }
        return helper(nums,set.size(),n)-helper(nums,set.size()-1,n);
        
    }
    public int helper(int nums[],int k,int n){
        int right=0;
        int left=0;
        int tempUnique=0;
        int ans=0;
        int hash[]=new int[2001];
        for(;right<n;right++){
            if(hash[nums[right]]==0){
                tempUnique++;
            } 
            hash[nums[right]]++;
            while(tempUnique>k && left<=right){
                if(hash[nums[left]]==1){
                    tempUnique--;
                }
                hash[nums[left++]]--;
            }
            ans+=(right-left+1);     
        }
        return ans;
    }
}