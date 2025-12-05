class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int totalScore=cardPoints[0];
        int n=cardPoints.length;
        for(int i=1;i<n;i++){
            totalScore+=cardPoints[i];
        }
        int windowSize=n-k;
        int slidingWindow=0;
        for(int i=0;i<windowSize;i++){
            slidingWindow+=cardPoints[i];
        }
        int ans=Math.max(0,totalScore-slidingWindow);
        int j=0;
        for(int i=windowSize;i<n;i++,j++){
            slidingWindow=slidingWindow+cardPoints[i]-cardPoints[j];
            ans=Math.max(ans,totalScore-slidingWindow);
        }
        return ans;
    }
}