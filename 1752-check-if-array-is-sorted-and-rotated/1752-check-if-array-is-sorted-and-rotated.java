class Solution {
    public boolean check(int[] nums) {
        int counter=-1;
        int n=nums.length;
        for(int i=0;i<n-1;i++){
            if(nums[i]>nums[i+1]){
                 if(counter!=-1){
                    return false;
                 }
                counter=i+1;
            }
           
        }
        if(counter==-1){
            return true;
        }
        // for(int i=counter;i<n-1;i++){
        //     if(nums[i]>nums[i+1]){
        //         return false;
        //     }
        // }
     
            if(nums[0]>=nums[n-1]){
              return true;
            }else{
                return false;
            }

    }
}