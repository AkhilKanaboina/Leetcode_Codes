class Solution {
    public String removeKdigits(String num, int k) {
        int n=num.length();
        if(n==k){
            return "0";
        }
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<n;i++){
            while(k>0 && !stack.isEmpty() && stack.peek()>num.charAt(i)){
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
        }
        while(k>0){
            stack.pop();
            k--;
        }
        Stack<Character> reverse=new Stack<>();
        while(!stack.isEmpty()){
            reverse.push(stack.pop());
        }
        while(!reverse.isEmpty() && reverse.peek()=='0'){
            reverse.pop();
        }
        char c[]=new char[reverse.size()];
        int index=0;
        while(!reverse.isEmpty()){
            c[index++]=reverse.pop();
        }
        String ans=new String(c);
        if(ans.equals("")){
            return "0";
        }
        return ans;
    }
}