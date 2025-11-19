class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    List<Integer> list=new ArrayList<>();
    int k;
    int n;
    public List<List<Integer>> combinationSum3(int k, int n) {
        this.k=k;
        this.n=n;
        backTracking(0,0,1);
        return ans;
    }
    public void backTracking(int sum,int counter,int index){
        if(counter==k &&sum==n){
            ans.add(new ArrayList<>(list));
            return;
        }
        if(counter>k || sum>n){
            return;
        }
        for(int i=index;i<=9;i++){
            list.add(i);
            backTracking(sum+i,counter+1,i+1);
            list.remove(list.size()-1);
        }
    }
}