class Solution {
    int nums[];
    int temp[];

    public int reversePairs(int[] nums) {
        int n=nums.length;
        this.nums=nums;
        temp=new int[n];
        return merge(0,n-1);
        
    }
    public int merge(int left,int right){
        if(left>=right){
            return 0;
        }
        int mid=(left+right)/2;
        int ans=(merge(left,mid) +  merge(mid+1,right));
        int i=left;
        int j=mid+1;
       
        while(i<=mid&& j<=right){
            if(nums[i]<=2*nums[j]){
                i++;
            }else{
                j++;
                ans+=(mid-i+1);
            }
        }
        i=left;
        j=mid+1;
        int key=0;
        while(i<=mid && j<=right){
            if(nums[i]<nums[j]){
                temp[key++]=nums[i++];
            }else{
                temp[key++]=nums[j++];
            }
        }
        while(i<=mid){
            temp[key++]=nums[i++];
        }
        while(j<=right){
            temp[key++]=nums[j++];
        }
        for(int a=left;a<=right;a++){
            nums[a]=temp[a-left];
        }
        return ans;
    }
}