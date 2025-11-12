class Solution {
    public int minFlipsMonoIncr(String s) {
        int zeros=0;
        int ones=0;
        int n=s.length();
        int dp[]=new int[n];
        dp[0]=0;
        for(int i=1;i<n;i++){
            if(s.charAt(i)=='1'){
                ones++;
            }else{
                zeros++;
            }
            if(s.charAt(i)=='0' && s.charAt(i-1)=='0'){//0->0
                dp[i]=Math.min(dp[i-1]+1,ones);
            }else if(s.charAt(i-1)=='0' && s.charAt(i)=='1'){//0->1
                dp[i]=dp[i-1];
            }else if(s.charAt(i)=='1' && s.charAt(i-1)=='1'){//1->1
                dp[i]=dp[i-1];
            }else{//1->0
                dp[i]=Math.min(dp[i-1]+1,ones);
            }
        }
        return dp[n-1];
    }
}