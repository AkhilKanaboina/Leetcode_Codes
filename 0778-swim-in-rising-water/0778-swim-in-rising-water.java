class Solution {
    class Pair{
        int row;
        int col;
        public Pair(int r,int c){
            row=r;
            col=c;
        }
    }
    public int swimInWater(int[][] grid) {
        int n=grid.length;
        int low=0;
        int high=Integer.MAX_VALUE;
        int ans=high;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(grid[0][0]<=mid){
                if(bfs(new Pair(0,0),grid,n,mid)){
                    ans=Math.min(ans,mid);
                    high=mid-1;
                }else{
                    low=mid+1;
                }
            }else{
                low=mid+1;
            }
               
        }
        return ans;
    }
    public boolean bfs(Pair pair,int[][] grid,int n,int max){
        Queue<Pair> queue=new LinkedList<>();
        boolean[][] vis = new boolean[n][n];
        vis[0][0]=true;
        queue.offer(pair);
        int dir[]={0,-1,0,1,0};
        while(!queue.isEmpty()){
            int row=queue.peek().row;
            int col=queue.peek().col;
            queue.poll();
            if(n-1==row && col==n-1) return true;
            if(grid[row][col]>max) continue;

            for(int d=0;d<4;d++){
                int newRow=row+dir[d];
                int newCol=col+dir[d+1];
                if(isValid(newRow,newCol,n) && !vis[newRow][newCol] && grid[newRow][newCol]<=max){
                    vis[newRow][newCol]=true;
                    queue.offer(new Pair(newRow,newCol));
                }
            }
        }
        return false;
    }
    public boolean isValid(int r,int c,int n){
        if(r>=0 && c>=0 && r<n && c<n) return true;
        return false;
    }
}