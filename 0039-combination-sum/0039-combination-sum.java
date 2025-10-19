class Solution {
    public List<Integer> list=new ArrayList<>();
    public List<List<Integer>> ans=new ArrayList<>();
    int n=0;
    int nums[];
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        nums=candidates;
        n=nums.length;
        backTrack(0,0,target);
        
        return ans;
    }
    public void backTrack(int index,int currSum,int target){
        if(currSum==target){   
            ans.add(new ArrayList<>(list));
            return;
        }
        if(currSum>target){
            return;
        }
        for(int i=index;i<n;i++){
            if((currSum+nums[i])<=target){
                currSum+=nums[i];
                list.add(nums[i]);
                backTrack(i,currSum,target);
                currSum-=nums[i];
                list.remove(list.size()-1);
            }
        }
    }
}