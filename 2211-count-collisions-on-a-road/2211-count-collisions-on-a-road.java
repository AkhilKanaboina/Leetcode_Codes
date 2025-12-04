class Solution {
    public int countCollisions(String directions) {
        Stack<Character> stack=new Stack<>();
        int n=directions.length();
        int ans=0;
        for(int i=0;i<n;i++){
            if(!stack.isEmpty() && stack.peek()=='R'){
                if(directions.charAt(i)=='L'){
                    stack.pop();
                    ans+=2;
                    stack.push('S');
                }else if(directions.charAt(i)=='S'){
                    ans++;
                    stack.pop();
                    stack.push('S');

                }else{
                    stack.push('R');
                }
            }else if(!stack.isEmpty() && stack.peek()=='S'){
                if(directions.charAt(i)=='L'){
                    ans++;
                    continue;
                }else{
                   stack.push(directions.charAt(i)); 
                }
            }else{
                stack.push(directions.charAt(i));
            }
           
        }
        return ans;
    }
}