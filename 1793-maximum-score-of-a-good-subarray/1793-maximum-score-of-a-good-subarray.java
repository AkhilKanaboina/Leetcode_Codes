class Solution {
    public int maximumScore(int[] nums, int k) {
        int ans=0;
        int n=nums.length;
        int leftRange[]=leftRange(nums);
        int rightRange[]=rightRange(nums);
        for(int i=0;i<n;i++){
            int leftIndex=i-leftRange[i]+1;
            int rightIndex=i+rightRange[i]-1;
            if(leftIndex<=k && k<=rightIndex){
                int val=(rightIndex-leftIndex+1)*nums[i];
                ans=Math.max(ans,val);
            }
        }
        return ans;
    }
    public int[] leftRange(int arr[]){
        Stack<Integer> stack=new Stack<>();
        int n=arr.length;
        int result[]=new int[n];
        Arrays.fill(result,1);
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && arr[stack.peek()]>=arr[i]){
                result[i]+=result[stack.peek()];
                stack.pop();
            }
           
            stack.push(i);
        }
        return result;
    }
    public int[] rightRange(int arr[]){
        Stack<Integer> stack=new Stack<>();
        int n=arr.length;
        int result[]=new int[n];
        Arrays.fill(result,1);
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && arr[i]<arr[stack.peek()]){
                result[i]+=result[stack.peek()];
                stack.pop();
            }
        
            stack.push(i);
        }
        return result;
    }
}