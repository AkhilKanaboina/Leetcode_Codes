class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->{
            return Integer.compare(a[0],b[0]);
        });
        List<int[]> list=new ArrayList<>();
        for(int temp[]:intervals){
            if(list.size()==0){
                list.add(temp);
                continue;
            }
            int tempPrev[]=list.get(list.size()-1);
            System.out.println(tempPrev[0]);
            System.out.println(tempPrev[1]);
            if(tempPrev[1]>=temp[0]){
                tempPrev[1]=Math.max(tempPrev[1],temp[1]);
                list.remove(list.size()-1);
                list.add(tempPrev);
            }else{
                list.add(temp);
            }
        }

        return list.toArray(new int[list.size()][]);

    }
}