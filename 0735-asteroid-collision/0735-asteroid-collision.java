class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack=new Stack<>();
        int m=asteroids.length;
        for(int i=0;i<m;i++){
            if(asteroids[i]>0){
                stack.add(asteroids[i]);
            }else{
                int val=-1*asteroids[i];
                boolean b=true;
                while(!stack.isEmpty()){
                    if(val>=stack.peek()){
                        if(val==stack.peek()){
                            b=false;
                        }
                        stack.pop();
                    }else{
                        b=false;
                        break;
                    }
                }
                if(b){
                    stack.push(asteroids[i]);
                }
            }
            
        }
        int n=stack.size();
        int arr[]=new int[n];
        for(int i=n-1;i>=0;i--){
            arr[i]=stack.pop();
        }
        return arr;
    }
}