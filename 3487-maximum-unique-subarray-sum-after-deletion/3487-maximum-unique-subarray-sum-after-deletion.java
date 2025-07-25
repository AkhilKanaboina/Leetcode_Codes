class Solution {
    public int maxSum(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        for(int n:nums){
            if(!set.contains(n)&&n>=0){
                set.add(n);
            }
        }
        int sum=0;
        for(int i:set){
            sum+=i;
        }
        return sum;
    }
}