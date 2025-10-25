class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    List<Integer> list=new ArrayList<>();
    boolean visited[];
    int n;
    int nums[];
    public List<List<Integer>> permuteUnique(int[] nums) {
        n=nums.length;
        visited=new boolean[n];
        Arrays.sort(nums);
        this.nums=nums;
        bacTracking();
        return ans;
    }
    public void bacTracking(){
        if(list.size()==n){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<n;i++){
            if(i>0&&nums[i]==nums[i-1]&&!visited[i]&&!visited[i-1]){
                continue;
            }
            if(!visited[i]){
                list.add(nums[i]);
                visited[i]=true;
                bacTracking();
                list.remove(list.size()-1);
                visited[i]=false;
            }
        }
    }
}