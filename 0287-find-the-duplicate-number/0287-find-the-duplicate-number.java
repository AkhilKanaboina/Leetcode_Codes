class Solution {
    public int findDuplicate(int[] nums) {
        boolean b[]=new boolean[nums.length];
        for(int i:nums){
            if(!b[i]){
                b[i]=true;
            }else{
                return i;
            }
        }
        return 0;
    }
}