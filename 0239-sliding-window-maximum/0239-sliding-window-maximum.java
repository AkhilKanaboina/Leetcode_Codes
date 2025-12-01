class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        int left[]=leftRange(nums,n);
        int right[]=rightRange(nums,n);
        int ans[]=new int[n-k+1];
        int index=0;
        for(int i=0;i<n;i++){
            if(Math.max(left[i],right[i])>=k){
                int val=Math.min(left[i],right[i]);
                while(val>0){
                    ans[index++]=nums[i];
                    val--;
                }
            }
        }   
        return ans;     
    }
    public int[] leftRange(int arr[],int n){
        Stack<Integer> stack=new Stack<Integer>();
        int result[]=new int[n];
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && arr[stack.peek()]<arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                result[i]=i+1;
            }else{
                result[i]=i-stack.peek();
            }
            stack.push(i);
        }
        return result;
    }
    public int[] rightRange(int arr[],int n){
        Stack<Integer> stack=new Stack<>();
        int result[]=new int[n];
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && arr[i]>=arr[stack.peek()]){
                stack.pop();
            }
            if(stack.isEmpty()){
                result[i]=n-i;
            }else{
                result[i]=stack.peek()-i;
            }
            stack.push(i);
        }
        return result;
    }
}