class Solution {
    public long subArrayRanges(int[] nums) {
        int minLeft[]=leftToRight_Influnce_min(nums);
        int minRight[]=righttoLeft_Influnce_min(nums);
        
        int maxLeft[]=leftToRight_Influnce_max(nums);
        int maxRight[]=righttoLeft_Influnce_max(nums);
        long min=sum(minLeft,minRight,nums);
        long max=sum(maxLeft,maxRight,nums);
        return max-min;
    }
    public long sum(int minLeft[],int minRight[],int nums[]){
        int n=nums.length;
        long ans=0;
        for(int i=0;i<n;i++){
            ans=ans+(long)minLeft[i]*minRight[i]*nums[i];
        }
        return ans;
    }
    public int[] leftToRight_Influnce_min(int nums[]){
        Stack<Integer> stack=new Stack<>();
        int n=nums.length;
        int ans[]=new int[n];
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && nums[stack.peek()]>nums[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                ans[i]=i+1;
            }else{
                ans[i]=(i-stack.peek());
            }
            stack.push(i);
        }
        return ans;
    }
    public int[] righttoLeft_Influnce_min(int nums[]){
        Stack<Integer> stack=new Stack<>();
        int n=nums.length;
        int ans[]=new int[n];
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && nums[stack.peek()]>=nums[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                ans[i]=n-i;
            }else{
                ans[i]=(stack.peek()-i);
            }
            stack.push(i);
        }
        return ans;
    }
    public int[] leftToRight_Influnce_max(int nums[]){
        Stack<Integer> stack=new Stack<>();
        int n=nums.length;
        int ans[]=new int[n];
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && nums[stack.peek()]<nums[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                ans[i]=i+1;
            }else{
                ans[i]=(i-stack.peek());
            }
            stack.push(i);
        }
        return ans;
    }
    public int[] righttoLeft_Influnce_max(int nums[]){
        Stack<Integer> stack=new Stack<>();
        int n=nums.length;
        int ans[]=new int[n];
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && nums[stack.peek()]<=nums[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                ans[i]=n-i;
            }else{
                ans[i]=(stack.peek()-i);
            }
            stack.push(i);
        }
        return ans;
    }


}