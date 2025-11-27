class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        int arr[]=new int[n];
        Arrays.fill(arr,-1);
        Stack<Integer> stack=new Stack<>();
        Stack<Integer> index=new Stack<>();
        boolean once=true;
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && stack.peek()<nums[i]){
                arr[index.pop()]=nums[i];
                stack.pop();
            }
            stack.push(nums[i]);
            index.push(i);
            if( i==n-1 && once && !stack.isEmpty()){
                i=-1;
                once=false;
            }
        }
        return arr;
    }
}