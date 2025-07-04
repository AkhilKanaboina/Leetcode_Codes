class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        int temp=0;
        for(int i:nums){
            if(hm.containsKey(i)){
                temp=hm.get(i);
                hm.put(i,temp+1);
            }else{
                hm.put(i,1);
            }
        }
       Queue<Map.Entry<Integer,Integer>> minHeap=new PriorityQueue<>((a,b)->a.getValue()-b.getValue());
        int arr[]=new int[k];
        int key=0;
        for(Map.Entry<Integer,Integer> entry:hm.entrySet()){
            minHeap.add(entry);
            if(minHeap.size()>k){
                minHeap.poll();
            }
        }
        for(Map.Entry<Integer,Integer> entry:minHeap){
            arr[key]=entry.getKey();
            key++;
        }
        return arr;
    }
}