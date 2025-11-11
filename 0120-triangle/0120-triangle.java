class Solution {
    List<List<Integer>> dp=new ArrayList<>();
    public int minimumTotal(List<List<Integer>> triangle) {
        return dp_function(triangle);
    }
    public int dp_function(List<List<Integer>> triangle){
        int size=triangle.size();
        for(int list=0;list<size;list++){
            dp.add(new ArrayList<>());
            for(int i=0;i<triangle.get(list).size();i++){
                int val=triangle.get(list).get(i);
                if(list==0){
                    dp.get(list).add(val);
                }else if(i==0){
                    dp.get(list).add(val+dp.get(list-1).get(0));
                }else if(i==triangle.get(list).size()-1){
                    dp.get(list).add(val+dp.get(list-1).get(i-1));
                }else {
                    dp.get(list).add(val+Math.min(dp.get(list-1).get(i),dp.get(list-1).get(i-1)));
                }
            }
        }
        int ans=dp.get(size-1).get(0);
        for(int i=1;i<triangle.get(size-1).size();i++){
            ans=Math.min(ans,dp.get(size-1).get(i));
        }
        return ans;
    }
}