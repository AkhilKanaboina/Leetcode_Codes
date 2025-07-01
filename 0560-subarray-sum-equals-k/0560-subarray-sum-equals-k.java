class Solution {
    public int subarraySum(int[] nums, int k) {
        int count=0,temp=0;
        for(int i=0;i<nums.length;i++){
            temp=0;
            for(int j=i;j<nums.length;j++){
                temp=temp+nums[j];
                if(temp==k)
                count++;
            }
        }

        return count;
    }
}