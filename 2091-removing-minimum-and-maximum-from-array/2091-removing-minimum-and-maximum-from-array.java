class Solution {
    public int minimumDeletions(int[] nums) {
        int minIndex=0;
        int maxIndex=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[minIndex]>nums[i]){
                minIndex=i;
            }
            if(nums[maxIndex]<nums[i]){
                maxIndex=i;
            }
        }
        int ansFront,ansBack,ansBoth;
        ansFront=Math.max(maxIndex,minIndex)+1;
        ansBack=Math.max(n-maxIndex,n-minIndex);
        ansBoth=Math.min(maxIndex+1,n-maxIndex)+Math.min(minIndex+1,n-minIndex);
        return Math.min(ansFront,Math.min(ansBack,ansBoth));
    }
}