class Solution {
    public int sumSubarrayMins(int[] arr) {
        int mod=1000000007;
        int n=arr.length;
        long ans=0;
        int left[]=leftToRight(arr,n);
        int right[]=rightToLeft(arr,n);

        for(int i=0;i<n;i++){
            ans=(ans+(long)left[i]*right[i]*arr[i]%mod)%mod;
        }
        return (int)ans;
    }
    public int [] leftToRight(int arr[],int n){
        int result[]=new int[n];
        Stack<Integer> stack=new Stack<>();
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
    public int[] rightToLeft(int arr[],int n){
        int result[]=new int[n];
        Stack<Integer> stack=new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && arr[i]<=arr[stack.peek()]){
               // result[i]=i;
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