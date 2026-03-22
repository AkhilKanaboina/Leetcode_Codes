class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        backtracking(1,9,k,n,list,ans);
        return ans;
    }
    public void backtracking(int start,int last,int k,int n, List<Integer> list,List<List<Integer>>  ans){

        if(k==0 && n==0){
            ans.add(new ArrayList<>(list));
            return;
        }
        if(k<=0 || n<=0){
            return;
        }
        if(start>last) return;
        list.add(start);
        backtracking(start+1,last,k-1,n-start,list,ans);
        list.remove(list.size()-1);
        
        backtracking(start+1,last,k,n,list,ans);
    }
}