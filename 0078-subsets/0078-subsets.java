class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        int counter=0;
        for(int i:nums){
             List<List<Integer>> temp = new ArrayList<>(ans);  // Safe copy
              for (List<Integer> a : temp) {
                  List<Integer> duplicate = new ArrayList<>(a);
                  duplicate.add(i);  // Add your desired element
                 ans.add(duplicate);  // Modify original list
              } 
            List<Integer> temp1=new ArrayList<>();
            temp1.add(i);
            ans.add(temp1);

        }
        ans.add(new ArrayList<>());
        return ans;
    }
}