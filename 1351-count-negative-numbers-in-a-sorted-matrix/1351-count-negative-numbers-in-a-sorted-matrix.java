class Solution {
    public int countNegatives(int[][] grid) {
       // int left=0;
        int n=grid[0].length;
        int ans=0;

        int maxRow=grid.length-1;
        for(int arr[]:grid){
           int low=0;
           int high=n-1;
           while(low<=high){
                int mid=(low+high)/2;
                if(arr[mid]<0){
                    high=mid-1;
                }else {
                    low=mid+1;
                }
           }
           ans=ans+(n-high-1);
        }
        return ans;
    }
}