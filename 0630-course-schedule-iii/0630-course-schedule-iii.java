class Solution {
    public int scheduleCourse(int[][] courses) {
   //     Arrays.sort(courses,(a,b)->Integers.compare(a[1],b[1]));
       Arrays.sort(courses, (a, b) -> Integer.compare(a[1], b[1]));
        int time=0;
        int max=0;
        int ans=0;
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<courses.length;i++){  
           
                if( (time+courses[i][0])<=courses[i][1]){
                time+=courses[i][0];
            //    max++;
                maxHeap.offer(courses[i][0]);
          
            } else if(!maxHeap.isEmpty()&&maxHeap.peek()>courses[i][0]){
                time+=courses[i][0]-maxHeap.poll();
                maxHeap.offer(courses[i][0]);
            }
          
            
        }
        return maxHeap.size();
    }
}