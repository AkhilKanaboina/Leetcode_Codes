class Solution {
    public int titleToNumber(String columnTitle) {
        int ans=0;
        int n=columnTitle.length();
        int power=0;
        for(int i=n-1;i>=0;i--){
            ans+=Math.pow(26,power)*(columnTitle.charAt(i)-'A'+1);
            power++;
        }
        return ans;
    }
}