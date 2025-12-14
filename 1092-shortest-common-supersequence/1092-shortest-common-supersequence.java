class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int n=str1.length();
        int m=str2.length();
        int dp[][]=new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        int i=n;
        int j=m;
        StringBuilder lcs=new StringBuilder();
        while(i>0 && j>0){
            if(str1.charAt(i-1)==str2.charAt(j-1)){
                lcs.append(str1.charAt(i-1));
                i--;j--;
            }else if(dp[i-1][j]>dp[i][j-1]){
                i--;
            }else{
                j--;
            }
        }
        //revese as backtracked form last
        StringBuilder ans=new StringBuilder();
        lcs.reverse();
         i=0;//str1
         j=0;//str2
        int k=0;//lcs
        while(k<lcs.length()){
            char c=lcs.charAt(k);
            while(i<str1.length() && str1.charAt(i)!=c){
                ans.append(str1.charAt(i));
                i++;
            }
            while(j<str2.length() && str2.charAt(j)!=c){
                ans.append(str2.charAt(j));
                j++;
            }
            ans.append(c);
            k++;
            i++;
            j++;
        }
        while(i<str1.length()){
                ans.append(str1.charAt(i));
                i++;
            }
            while(j<str2.length() ){
                ans.append(str2.charAt(j++));
            }
            return ans.toString();

    } 
}