class Solution {
    public int lastStoneWeight(int[] stones) {
        // Arrays.sort(stones);
        // ArrayList<Integer> list=new ArrayList<>();
        // for(int val:stones){
        //     list.add(val);
        // }
        // while(list.size()>1){
        //     int val1=list.remove(list.size()-1);
        //     int val2=list.remove(list.sixe()-1);
        //     if(val1==val2){
        //         continue;
        //     }
        //     list.add()
        // }
        
        Queue<Integer> queue=new PriorityQueue<>(Collections.reverseOrder());
        for(int val:stones){
            queue.add(val);
        }
        while(queue.size()>1){
            int val1=queue.poll();
            int val2=queue.poll();
            if(val1==val2){
                    continue;
            }
            queue.add(Math.abs(val1-val2));
        }
        return (queue.size()==0)?0:queue.peek();
    }
}