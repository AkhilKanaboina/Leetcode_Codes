class Solution {
    public List<Integer> list=new ArrayList<>();
    public List<List<Integer>> ans=new ArrayList<>();
    boolean visited[];
    int n=0;
    int nums[];
    public List<List<Integer>> permute(int[] nums) {
        n=nums.length;
        this.nums=nums;
        visited=new boolean[n];
        backTrack(0);
        return ans;
    }
    public void backTrack(int depth){
        if(depth==n){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<n;i++){
            if(!visited[i]){
                visited[i]=true;
                list.add(nums[i]);
                backTrack(depth+1);
                list.remove(list.size()-1);
                visited[i]=false;
            }
        }
    }

}