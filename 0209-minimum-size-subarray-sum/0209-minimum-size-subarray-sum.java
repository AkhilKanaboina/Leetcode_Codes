class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n=nums.length,ans=Integer.MAX_VALUE;
        int pref[]=new int[n];
        pref[0]=nums[0];
        for(int i=1;i<n;i++){
            pref[i]+=(pref[i-1]+nums[i]);
        }
        HashMap<Integer,Integer> mp=new HashMap<>();
        for(int i=0;i<n;i++){
            int temp=pref[i]%target;
            if(!mp.containsKey(temp)){
                mp.put(temp,i);
            }else{
                ans=Math.min(ans,(i-mp.get(temp)));
                mp.put(temp,i);
            }
        }
        if(ans==Integer.MAX_VALUE){
            return 0;
        }
        return ans;
    
    }
}