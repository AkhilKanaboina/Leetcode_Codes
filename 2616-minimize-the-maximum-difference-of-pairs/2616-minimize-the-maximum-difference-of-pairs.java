class Solution {
    public int minimizeMax(int[] nums, int p) {
        if(p==0) return 0;
        int n=nums.length;
        Arrays.sort(nums);
        int min=0;
        int max=nums[n-1]-nums[0];
        return searchAnswer(min,max,nums,p);
    }
    public int searchAnswer(int min,int max,int[] nums,int p){
        while(min<=max){
            int mid=min+(max-min)/2;
            if(isPossiblePairs(nums,p,mid)){
                max=mid-1;
            }else{
                min=mid+1;
            }
        }
        return min;
    }
    public boolean isPossiblePairs(int nums[],int p,int maxDifference){
        int n=nums.length;
        int count=0;
        for(int i=1;i<n;i++){
            if(Math.abs(nums[i]-nums[i-1])<=maxDifference){
                count++;
                i++;
            }
        }
        if(count>=p) return true;

        return false;
    }
}