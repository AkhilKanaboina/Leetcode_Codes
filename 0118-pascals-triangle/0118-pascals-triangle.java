class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i<numRows;i++){
            List<Integer> list=new ArrayList<>();
            if(i==0){
                list.add(1);
                ans.add(new ArrayList<>(list));
                continue;
            }
            int prev=0;
            for(int temp: ans.get(ans.size()-1)){
                list.add(prev+temp);
                prev=temp;
            }
            list.add(prev);
            ans.add(new ArrayList<>(list));
        }
        return ans;
    }
}