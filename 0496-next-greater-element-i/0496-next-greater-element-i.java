class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack=new Stack<>();
        HashMap<Integer,Integer> mp=new HashMap<Integer,Integer>();
        for(int i:nums2){
            while(!stack.isEmpty()&&stack.peek()<i){
                mp.put(stack.pop(),i);
            }
            stack.push(i);
        }
        int n[]=new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            if(mp.containsKey(nums1[i])){
                n[i]=mp.get(nums1[i]);
            }else{
                n[i]=-1;
            }
        }
        return n;
    }
}