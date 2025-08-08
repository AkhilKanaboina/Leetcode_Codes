class Solution {
    static int column=0;
    public static boolean bst(int[][] matrix,int row,int target){
        int left=0;
        int right=column-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(matrix[row][mid]==target){
                return true;
            }else if(matrix[row][mid]>target){
                right=mid-1;
            }else {
                left=mid+1;
            }
        }
        return false;
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int row=matrix.length;
        column=matrix[0].length;
        int top=0;
        int bottem=row-1;

        while(top<=bottem){
            int mid=top+(bottem-top)/2;
            if(bst(matrix,mid,target)){
                return true;
            }else if(matrix[mid][0]>target){
                bottem=mid-1;
            }else{
                top=mid+1;
            }
        }
        return false;
    }
}