import java.util.*;
class Solution {
    public int[][] merge(int[][] intervals) {
        int n=intervals.length;
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        ArrayList<int[]> list=new ArrayList<>();
        list.add(intervals[0]);

        for(int i=1;i<n;i++){
            int temp[]=list.get(list.size()-1);
            if(temp[1]>=intervals[i][0]){
                temp[1]=Math.max(temp[1],intervals[i][1]);
            }else{
                list.add(new int[]{intervals[i][0],intervals[i][1]});
            }
        }
      //  Collections.reverse(list);
        int[][] arr = list.toArray(new int[list.size()][]);

        return arr;

    }
}