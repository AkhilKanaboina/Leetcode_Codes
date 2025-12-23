class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long ans=0;
        long slideSum=0;
        int n=nums.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        int counter=0;
        for(int i=0;i<k-1;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            if(map.get(nums[i])>1){
                counter++;
            }
            slideSum=(long)slideSum+nums[i];
        }
        int left=0;
        for(int i=k-1;i<n;i++){
            slideSum=(long)slideSum+nums[i];
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);

            if(map.get(nums[i])>1){
                counter++;
            }
            if(counter==0){
                ans=Math.max(ans,slideSum);
            }
            if(map.get(nums[left])>1){
                counter--;
            }
            map.put(nums[left],map.get(nums[left])-1);
            slideSum=slideSum-nums[left++];
        }
        return ans;
    }
}