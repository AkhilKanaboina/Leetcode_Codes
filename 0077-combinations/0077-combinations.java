class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    List<Integer> list=new ArrayList<>();
    int n;
    int k;
    public List<List<Integer>> combine(int n, int k) {
        this.n=n;
        this.k=k;
        backTrack(1);
        return ans;
    }
    public void backTrack(int val){
        if(list.size()==k){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=val;i<=n;i++){
            list.add(i);
            backTrack(i+1);
            list.remove(list.size()-1);
        }
    }
}