class Solution {
   
    public int nearestExit(char[][] maze, int[] entrance) {
      int steps=0;
      int row=maze.length;
      int column=maze[0].length;
      Queue<int[]> queue=new LinkedList<>();
      queue.offer(new int[]{entrance[0],entrance[1]});
      int directions[]={-1,0,1,0,-1};
      while(!queue.isEmpty()){
        int size=queue.size();
        steps++;
        for(int a=0;a<size;a++){
            int arr[]=queue.poll();
            int i=arr[0];
            int j=arr[1];
            for(int d=0;d<4;d++){
                int newRow=i+directions[d];
                int newCol=j+directions[d+1];
                if(newRow>=0&&newRow<row &&newCol>=0&&newCol<column &&maze[newRow][newCol]=='.'){
                    if((newRow==0||newCol==0||newRow==row-1||newCol==column-1)&&!(newRow==entrance[0]&&newCol==entrance[1])){
                        return steps;
                    }
                    maze[newRow][newCol]='+';
                    queue.offer(new int[]{newRow,newCol});
                }
            }
        }
      }
      
      return -1;
    }
}