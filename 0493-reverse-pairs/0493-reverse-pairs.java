class Solution {

    int temp[];

    public int reversePairs(int[] nums) {
        temp=new int[nums.length];
       return mergeSort(nums,0,nums.length-1);
    }
    public int mergeSort(int nums[],int left,int right){
        int ans=0;
        if(left>=right){
            return ans;
        }
        int mid=(left+right)/2;
        ans+=mergeSort(nums,left,mid);
        ans+=mergeSort(nums,mid+1,right);
        ans+=count(nums,left,mid,right);
        merge(nums,left,mid,right);
        return ans;
    }
    public int count(int nums[],int left,int mid,int right){
        int ans=0;
        int i=left;
        int j=mid+1;
        while(i<=mid && j<=right){
            if(nums[i]<=2L*nums[j]){
                i++;
            }else{
                ans+=(mid-i+1);
                j++;
            }
        }
        return ans;
    }
    public void merge(int nums[],int left,int mid,int right){
        int k=0;
        int i=left;
        int j=mid+1;
        while(i<=mid && j<=right){
            if(nums[i]<=nums[j]){
                temp[k++]=nums[i++];
            }else{
                temp[k++]=nums[j++];
            }
        }
        while(i<=mid){
            temp[k++]=nums[i++];
        }
        while(j<=right){
            temp[k++]=nums[j++];
        }
        k=0;
        for(int a=left;a<=right;a++){
            nums[a]=temp[k++];
        }
    }

    
}