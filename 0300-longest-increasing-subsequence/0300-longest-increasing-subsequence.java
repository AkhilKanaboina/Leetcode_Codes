class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int a[]=new int[n];
        int max=1;
        for(int i=0;i<n;i++){
            a[i]=1;
        }
        for(int i=0;i<n;i++){
               // a[i]=1;
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    a[i]=Math.max(a[i],a[j]+1);
                }
            }
            max=Math.max(max,a[i]);
        }
        return max;
    }
}