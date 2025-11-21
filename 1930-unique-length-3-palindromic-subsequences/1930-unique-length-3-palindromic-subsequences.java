class Solution {
    String str;
    int n;
    HashSet<String> set=new HashSet<>();
    public int countPalindromicSubsequence(String s) {
        n=s.length();
        str=s;
        int first[]=new int[26];
        Arrays.fill(first,-1);
        int last[]=new int[26];
        Arrays.fill(last,-1);
        for(int i=0;i<n;i++){
            if(first[s.charAt(i)-'a']==-1){
                 first[s.charAt(i)-'a']=i;
            }
            last[s.charAt(i)-'a']=i;
        }
        int ans=0;
        for(int i=0;i<26;i++){
            int start=first[i];
            int end=last[i];
            
            HashSet<Character> set=new HashSet<>();
            for(int temp=start+1;temp<end && end-start>1;temp++){
               set.add(s.charAt(temp));
            }
            ans+=set.size();
        }
        return ans;
    }
    
    // public void backTracking(int index,String s,int size){
    //     if(size==3 ){
    //         if(isPalindrome(s))
    //          set.add(s);
    //         return;
    //     }
    //     for(int i=index;i<n;i++){
    //         backTracking(i+1,s+str.charAt(i),size+1);
    //     }
    // }
    public boolean isPalindrome(String s){
        if(s.charAt(0)==s.charAt(2)){
            return true;
        }
        return false;
    }
}