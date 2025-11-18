class Solution {
    List<String> str=new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        backTracking("",0,0,n);
        return str;
    }
    public void backTracking(String s,int open,int close,int n){
        if(open==n && close==n){
            str.add(s);
        }
        if(open<n){
            backTracking(s+'(',open+1,close,n);
        }
        if(close<open){
            backTracking(s+')',open,close+1,n);
        }
        // if(s.length()==n*2){
        //     set.add(s);
        // }
        // if(s.length()>n*2){
        //     return;
        // }
        // backTracking(s+"()");
        // backTracking("()"+s);
        // backTracking(s.substring(0,s.length()/2)+"()"+s.substring(s.length()/2,s.length()));
    }
}