class Solution {
    public int latestDayToCross(int row, int col, int[][] cells) {
        int low=1;
        int high=cells.length;
        int ans=0;

        while(low<=high){
            int mid=(low+high)/2;
            if(isPossible(row,col,cells,mid)){
                ans=mid;
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return ans;
    }
    private boolean isPossible(int row,int col,int cells[][],int day){
        boolean grid[][]=new  boolean[row][col];

        for(int i=0;i<day;i++){
            grid[cells[i][0]-1][cells[i][1]-1]=true;
        }

        Queue<int[]> queue=new LinkedList<>();
        for(int i=0;i<col;i++){
            if(!grid[0][i]){
            queue.offer(new int[]{0,i});
            grid[0][i]=true;
            }
        }
        final int dir[]={-1,0,1,0,-1};

        while(!queue.isEmpty()){
            int pos[]=queue.poll();
            if(pos[0]==row-1){
                return true;
            }
            for(int i=0;i<4;i++){
                int newRow=pos[0]+dir[i];
                int newCol=pos[1]+dir[i+1];

                if(newRow>=0 && newRow<row && newCol>=0 && newCol<col && !grid[newRow][newCol]){
                    queue.add(new int[]{newRow,newCol});
                    grid[newRow][newCol]=true;
                }
            }
            
        }
        return false;
    }
}