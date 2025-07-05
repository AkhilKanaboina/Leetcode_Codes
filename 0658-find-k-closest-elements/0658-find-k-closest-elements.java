class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list=new ArrayList<>(k);
      Queue<Integer> left=new   PriorityQueue<>(Collections.reverseOrder());
      Queue<Integer> right=new   PriorityQueue<>();
      for(int i:arr){
        if(i<x){
            left.add(i);
        }else{
            right.add(i);
        }
      }
      int key=0;
      int rightVal,leftVal;
      while(key!=k&&!left.isEmpty()&&!right.isEmpty()){
        rightVal=right.peek();
        leftVal=left.peek();
        if((rightVal-x)<(x-leftVal)){
            list.add(right.poll());
           
        }else{
             list.add(left.poll());
           
        }   key++;
      }
     while (key != k && !left.isEmpty()) {
            list.add(left.poll());
            key++;
        }

        while (key != k && !right.isEmpty()) {
            list.add(right.poll());
            key++;
        }
      Collections.sort(list);
        return list;
    }
}