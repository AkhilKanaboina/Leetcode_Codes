class Solution {
    public int repeatedNTimes(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int size=nums.length;
        int times=size/2;

        for(int val:nums){
            map.put(val,map.getOrDefault(val,0)+1);
        }
        for(int key:map.keySet()){
            if(times==map.get(key)){
                return key;
            }
        }
        return -1;
    }
}