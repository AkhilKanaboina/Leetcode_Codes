class Solution {
    List<List<String>> ans=new ArrayList<>();
    List<String> list=new ArrayList<>();
    int n;
    public List<List<String>> partition(String s) {
        n=s.length();
        backTracking(s,0);
        return ans;
    }
    public void backTracking(String s,int start){
        if(start==n){
            ans.add(new ArrayList<>(list));
            return ;
        }
        for(int i=start;i<n;i++){
            if(isPalindrome(s,start,i)){
                list.add(s.substring(start,i+1));
                backTracking(s,i+1);
                list.remove(list.size()-1);
            }
        }
    }
    public boolean isPalindrome(String str,int s,int e){
        while(s<=e){
            if(str.charAt(s++)==str.charAt(e--)){
                continue;
            }
            return false;
        }
        return true;
    }
}