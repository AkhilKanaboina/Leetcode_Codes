class Solution {
    public int longestValidParentheses(String s) {
       Stack<Integer> stack=new Stack<>();
       stack.push(-1);
       int max=0;
       int n=s.length();
       for(int i=0;i<n;i++){
            if(s.charAt(i)==')'){
                stack.pop();
                if(!stack.isEmpty()){
                    int index=stack.peek();
                    max=Math.max(max,i-index);
                }else{
                    stack.push(i);
                }
            }else if(s.charAt(i)=='('){
                stack.push(i);
            }
       }
       return max;
    }
}