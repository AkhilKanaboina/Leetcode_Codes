class Solution {
    public String removeOuterParentheses(String s) {
        int n=s.length();
        StringBuffer str=new StringBuffer("");
        int counter=0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='(' && counter==0){
                counter++;
                continue;
            }
            if(s.charAt(i)=='('){
                str.append(s.charAt(i));
                counter++;
            }else{
                counter--;
                if(counter!=0)
                str.append(s.charAt(i));
            }
        }
        return str.toString();
    }
}