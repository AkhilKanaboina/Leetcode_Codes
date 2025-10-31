class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int n=nums.length;
        boolean hash[]=new boolean[n+1];
        List<Integer> list=new ArrayList<>();
        for(int i:nums){
            if(!hash[i]){
                hash[i]=true;
            }else{
                list.add(i);
            }
        }
        return list;
    }
}