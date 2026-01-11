class Solution {
    public int maximalRectangle(char[][] matrix) {
        int row=matrix.length;
        int col=matrix[0].length;
        int dp[][]=new int[row][col];
        for(int j=0;j<col;j++){
            dp[0][j]=matrix[0][j]-'0';
        }
        for(int j=0;j<col;j++){
            for(int i=1;i<row;i++){
                if(matrix[i][j]=='0'){
                    dp[i][j]=0;
                }else {
                    dp[i][j]=1+dp[i-1][j];
                }
            }
        }
        int ans=0;
        for(int i=0;i<row;i++){
            int left[]=leftRange(dp[i],col);
            int right[]=rightRange(dp[i],col);
            for(int j=0;j<col;j++){
                int val=left[j]+right[j]-1;
                ans=Math.max(val*(matrix[i][j]-'0')*dp[i][j],ans);
            }
        }

        return ans;
    }
    public int[] leftRange(int arr[],int col){
        Stack<Integer> stack=new Stack<>();
        int result[]=new int[col];
        for(int i=0;i<col;i++){
            while(!stack.isEmpty() && arr[stack.peek()]>arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                result[i]=i+1;
            }else{
                result[i]=i-stack.peek();
            }
            stack.push(i);
        }
        return result;
    }
    public int[] rightRange(int arr[],int col){
        Stack<Integer> stack=new Stack<>();
        int result[]=new int[col];
        for(int i=col-1;i>=0;i--){
            while(!stack.isEmpty() && arr[i]<=arr[stack.peek()]){
                stack.pop();
            }
            if(stack.isEmpty()){
                result[i]=col-i;
            }else{
                result[i]=stack.peek()-i;
            }
            stack.push(i);
        }
        return result;
    }

}