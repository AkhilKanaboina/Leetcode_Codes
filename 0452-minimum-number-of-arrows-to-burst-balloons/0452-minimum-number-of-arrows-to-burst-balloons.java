class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points,(a,b)->Integer.compare(a[1],b[1]));
        int total=points.length;
        int temp=total;
        int pre=points[0][1];
        for(int i=1;i<total;i++){
            if(pre>=points[i][0]){
                temp--;
            }else{
                pre=points[i][1];
            }
        }
        return temp;
    }
}