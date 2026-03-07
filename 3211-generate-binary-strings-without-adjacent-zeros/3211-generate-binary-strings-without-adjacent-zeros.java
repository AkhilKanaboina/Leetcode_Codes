class Solution {
    public List<String> validStrings(int n) {
        List<String> list=new ArrayList<>();
        backtracking(list,"0",n);
        backtracking(list,"1",n);
        return list;
    }
    public void backtracking(List<String> list,String str,int n){
        if(str.length()==n){
            list.add(str);
            return;
        } 
        backtracking(list,str+"1",n);
        if(str.length()>0 && str.charAt(str.length()-1)!='0')
        backtracking(list,str+"0",n);
    }
}