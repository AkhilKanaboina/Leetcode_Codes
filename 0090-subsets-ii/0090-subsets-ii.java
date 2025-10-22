class Solution {
    List<Integer> list=new ArrayList<>();
    List<List<Integer>> ans=new ArrayList<>();
    int nums[];
    int n;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        this.nums=nums;
        n=nums.length;
        backTrack(0);
        ans.add(new ArrayList<>());
        return ans;
    }
    public void backTrack(int index){
        for(int i=index;i<n;i++){
            if(i>index&& nums[i]==nums[i-1]){
                continue;
            }
            list.add(nums[i]);
            ans.add(new ArrayList<>(list));
            backTrack(i+1);
            list.remove(list.size()-1);

        }
    }
}