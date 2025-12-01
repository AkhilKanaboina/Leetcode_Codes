class Solution {
    public int largestRectangleArea(int[] heights) {
        int left[]=left_range(heights);
        int right[]=right_range(heights);
        int ans=0;
        int n=heights.length;
        for(int i=0;i<n;i++){
            int val=left[i]+right[i]-1;
            ans=Math.max(ans,val*heights[i]);
        }
        return ans;
    }
    public int[] left_range(int arr[]){
        int n=arr.length;
        Stack<Integer> stack=new Stack<>();
        int result[]=new int[n];
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && arr[stack.peek()]>arr[i]){
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
    public int[] right_range(int arr[]){
        int n=arr.length;
        Stack<Integer> stack=new Stack<>();
        int result[]=new int[n];
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && arr[stack.peek()]>=arr[i]){
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