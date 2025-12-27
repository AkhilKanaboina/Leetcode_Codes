class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings,(a,b)->Integer.compare(a[0],b[0]));
        Queue<long[]> queue=new PriorityQueue<>((a,b)->{
            if(a[1]==b[1]){
                return Long.compare(a[2],b[2]);
            }
            return Long.compare(a[1],b[1]);
        });
        Queue<Integer> freeRoom=new PriorityQueue<>();
        for(int i=0;i<n;i++){
            freeRoom.offer(i);
        }
        
        int ans[]=new int[n];
        int len=meetings.length;
        // int minRoom=0;

        for(int i=0;i<len;i++){
            while(!queue.isEmpty() && meetings[i][0]>=queue.peek()[1]){
                freeRoom.offer((int)queue.peek()[2]);
                queue.poll();
            }
            if(!freeRoom.isEmpty()){
                queue.offer(new long[]{meetings[i][0],meetings[i][1],freeRoom.peek()});
                ans[freeRoom.poll()]++;
            }else{
                long temp[]=queue.poll();
                long difference=temp[1]-meetings[i][0];
                queue.offer(new long[]{meetings[i][0]+difference,meetings[i][1]+difference,temp[2]});
                ans[(int)temp[2]]++;
            }
        }
        int room=-1;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(ans[i]>max){
                max=ans[i];
                room=i;
            }
        }
        return room;
    }
}