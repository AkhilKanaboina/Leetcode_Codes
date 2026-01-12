class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int ans=0;
        int n=points.length;
        int points1=points[0][0];
        int points2=points[0][1];
        for(int i=1;i<n;i++){
            ans+=Math.max(Math.abs(points1-points[i][0]),Math.abs(points2-points[i][1]));
            points1=points[i][0];
            points2=points[i][1];
        }
        return ans;
    }
}