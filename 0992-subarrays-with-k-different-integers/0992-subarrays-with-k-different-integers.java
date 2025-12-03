class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
       return helper(nums,k)-helper(nums,k-1);
    }
    public int helper(int nums[],int k){
        int n=nums.length;
        int left=0;
        int right=0;
        int ans=0;
        int hash[]=new int[n+1];
        int total=0;
        for(;right<n;right++){  
            if(hash[nums[right]]==0){
                total++;
            }
            hash[nums[right]]++;
            while(total>k && left<=right){
                if(hash[nums[left]]==1){
                    total--;
                }
                hash[nums[left]]--;
                left++;
            }
            ans=ans+(right-left+1);
        }
        return ans;
    }

    // public int total(int hash[]){
    //     int n=hash.length;
    //     int counter=0;
    //     for(int i=1;i<n;i++){
    //         if(hash[i]>0){
    //             counter++;
    //         }
    //     }
    //     return counter;
    // }
}