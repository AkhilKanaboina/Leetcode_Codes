class Solution {
    public void nextPermutation(int[] nums) {
      
        for(int i=nums.length-1;i>0;i--){
            int j=i-1;
            while(j>=0){
                if(nums[j]<nums[i]){
                    int temp=nums[j];
                    nums[j]=nums[i];
                    nums[i]=temp;
                    helper(nums,j+1);
                    return;
                }
                j--;
            }
        }
        Arrays.sort(nums);
    }
    public void helper(int nums[],int index){
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=index;i<nums.length;i++){
            list.add(nums[i]);
        }
        Collections.sort(list);
        for(int i=index;i<nums.length;i++){
            nums[i]=list.get(i-index);
        }
    }
}