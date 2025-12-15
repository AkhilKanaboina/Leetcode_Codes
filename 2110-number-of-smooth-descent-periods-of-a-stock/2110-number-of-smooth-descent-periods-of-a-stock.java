class Solution {
    public long getDescentPeriods(int[] prices) {
        long ans=0;
        int n=prices.length;
        int result[]=new int[n];
        Arrays.fill(result,1);
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() &&  prices[stack.peek()]==prices[i]+1){
                result[i]+=result[stack.peek()];
                stack.pop();
            }
            stack.push(i);
        }
        for(int i=0;i<n;i++){
            ans=(long)ans+result[i];
        }
        return ans;
    }
}