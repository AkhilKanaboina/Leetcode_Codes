class Solution {
    public boolean isAnagram(String s, String t) {
        int dp[]=new int[26];
        int dp2[]=new int[26];
        for(char c:s.toCharArray()){
            dp[c-'a']++;
        }
        for(char c:t.toCharArray()){
            dp2[c-'a']++;
        }
        for(int i=0;i<26;i++){
            if(dp[i]==dp2[i]){
                continue;
            }
            return false;
        }
        return true;
    }
}