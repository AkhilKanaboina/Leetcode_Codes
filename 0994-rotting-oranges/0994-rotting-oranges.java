class Solution {
    public int orangesRotting(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;

        int freshOranges=0;
        Queue<int[]> queue=new LinkedList<>();

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==1){
                    freshOranges++;
                }else if(grid[i][j]==2){
                    queue.add(new int[]{i,j});
                }
            }
        }
        int dir[]={0,-1,0,1,0};
        int minutes=0;
        for( minutes=1;queue.size()>0&&freshOranges>0;minutes++){
            int n=queue.size();
            for(int i=0;i<n;i++){
                int temp[]=queue.poll();
                for(int d=0;d<4;d++){
                    int r=temp[0]+dir[d];
                    int c=temp[1]+dir[d+1];
                    if(c>=0&&c<col&&r>=0&&r<row&&grid[r][c]==1){
                        grid[r][c]=2;
                        queue.add(new int[]{r,c});
                        freshOranges--;
                    }
                }

            }
        }
        if(freshOranges>0){
            return -1;
        }
        return minutes-1;
    }
}