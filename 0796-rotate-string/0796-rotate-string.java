class Solution {
    public boolean rotateString(String s, String goal) {
        int n=s.length();
        if(n!=goal.length()){
            return false;
        }
        if(s.equals(goal)){
            return true;
        }
        StringBuffer str=new StringBuffer(s);
        for(int i=0;i<n;i++){
            String temp=str.substring(0,1);
            str.delete(0,1);
            str.append(temp);
            if(str.toString().equals(goal)){
                return true;
            }

        }
        return false;
    }
}