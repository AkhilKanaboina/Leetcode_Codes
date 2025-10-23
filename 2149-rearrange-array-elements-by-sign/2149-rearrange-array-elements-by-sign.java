class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n=nums.length;
        int pos[]=new int[n/2];
        int neg[]=new int[n/2];
        int i=0;
        int j=0;
        for(int k=0;k<n;k++){
            if(nums[k]>=0){
                pos[i]=nums[k];
                i++;
            }else{
                neg[j]=nums[k];
                j++;
            }
        }
        i=0;
        j=0;
        for(int k=0;k<n;k++){
            if(k%2==0){
                nums[k]=pos[i++];
            }else{
                nums[k]=neg[j++];
            }
        }
        return nums;
        
        // ArrayList<Integer> pos=new ArrayList<>();
        // ArrayList<Integer> neg=new ArrayList<>();
        // int n=nums.length;
        // for(int i=0;i<n;i++){
        //     if(nums[i]>=0){
        //         pos.add(nums[i]);
        //     }else{
        //         neg.add(nums[i]);
        //     }
        // }
        // for(int i=0;i<n-1;i+=2){
        //     nums[i]=pos.get(0);
        //     pos.remove(0);
        //     nums[i+1]=neg.get(0);
        //     neg.remove(0);
        // }
        // return nums;
    }
}