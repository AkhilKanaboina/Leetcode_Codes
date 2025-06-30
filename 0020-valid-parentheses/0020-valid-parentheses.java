class Solution {
    public boolean isValid(String ss) {
         //HashMap<Character,Character> val=new HashMap<>();
        // val.put('(',-1);
        // val.put(')',1);
        // val.put('{',-100);
        // val.put('}',100);
        // val.put('[',-10000);
        // val.put(']',10000);
         int n=ss.length();
         int i=n-1;
        // int temp=0;
        // while(i>=0){
        //     temp+=val.get(s.charAt(i));
        //     if(temp<0){
        //         return false;
        //     }
        //     i--;
        // }
        // if(temp>0){
        //     return false;
        // }
        Stack<Character> s=new Stack<>();
         while(i>=0){
            if(ss.charAt(i)==']'||ss.charAt(i)=='}'||ss.charAt(i)==')'){
                s.push(ss.charAt(i));
            }
            if(ss.charAt(i)=='('){
               if(!s.isEmpty()&&s.peek()==')'){
                s.pop();
               }else{
                return false;
               }
            }
            if(ss.charAt(i)=='{'){
               if(!s.isEmpty()&&s.peek()=='}'){
                s.pop();
               }else{
                return false;
               }
            }
             if(ss.charAt(i)=='['){
               if(!s.isEmpty()&&s.peek()==']'){
                s.pop();
               }else{
                return false;
               }
            }
            i--;
         }
        
        return true;
    }
}