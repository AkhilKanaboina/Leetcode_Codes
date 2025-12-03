class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int countOdd=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int n=nums.length;
        int ans=0;
        for(int i=0;i<n;i++){
            if(nums[i]%2==1){
                countOdd++;
            }
            if(map.containsKey(countOdd-k)){
                ans+=map.get(countOdd-k);
            }
            map.put(countOdd,map.getOrDefault(countOdd,0)+1);
        }
        return ans;
    }
}