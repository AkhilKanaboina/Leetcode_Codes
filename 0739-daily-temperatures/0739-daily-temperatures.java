class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack=new Stack<Integer>();
        int n=temperatures.length;
        int result[]=new int[n];
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && temperatures[stack.peek()]<temperatures[i]){
                result[stack.peek()]=i-stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        // while(!stack.isEmpty()){
        //     result[stack.pop()]=0;
        // }
        return result;
    }
}