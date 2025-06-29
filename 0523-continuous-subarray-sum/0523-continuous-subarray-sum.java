class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n=nums.length;
        int sum=0,rem=0;

        HashMap<Integer,Integer> mp=new HashMap<>();
        mp.put(0,-1);
        for(int i=0;i<n;i++){
            sum+=nums[i];
            rem=sum%k;
            if(mp.containsKey(rem)){
                int temp=mp.get(rem);
                if(i-temp>=2){
                    return true;
                }
            }else{
                mp.put(rem,i);
            }
        }    
        return false;    
    }
}