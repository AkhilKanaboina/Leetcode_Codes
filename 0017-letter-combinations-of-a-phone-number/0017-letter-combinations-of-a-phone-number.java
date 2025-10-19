class Solution {
    List<String> ans=new ArrayList<>();
    String arr[]={"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    String digits;
    int n;
    public List<String> letterCombinations(String digits) {
        this.digits=digits;
        n=digits.length();
        backTrack("",0);
        return ans;
    }
    public void backTrack(String s,int index){
        if(s.length()==n){
            ans.add(s);
            return;
        }
        for(int i=0;i<arr[digits.charAt(index)-'0'-2].length();i++){
            backTrack((s+arr[digits.charAt(index)-'0'-2].charAt(i)),index+1);
        }
        
    }

}