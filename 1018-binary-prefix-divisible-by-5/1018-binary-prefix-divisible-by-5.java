class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> list=new ArrayList<>();
        int n=nums.length;
        int val=0;
        for(int i=0;i<n;i++){
            val=(val*2+nums[i])%5;
            list.add(val%5==0);
        }
        return list;
    }
}