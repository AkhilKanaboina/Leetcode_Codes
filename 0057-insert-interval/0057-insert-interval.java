class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n=intervals.length;
        if(n==0){
            return new int[][]{newInterval};
        }
        int start2=newInterval[0];
        int end2=newInterval[1];
        boolean merged=true;
        for(int i=0;i<n;i++){
            int start=intervals[i][0];
            int end=intervals[i][1];
            if(start<=newInterval[0] && newInterval[0]<=end){
                intervals[i][0]=Math.min(intervals[i][0],newInterval[0]);
                intervals[i][1]=Math.max(intervals[i][1],newInterval[1]);
                merged=false;
            }else if(start<=newInterval[1] && newInterval[1]<=end){
                intervals[i][0]=Math.min(intervals[i][0],newInterval[0]);
                intervals[i][1]=Math.max(intervals[i][1],newInterval[1]);
                merged=false;
            }
        }
        ArrayList<int[]> list=new ArrayList<>();
        list.add(new int[]{intervals[0][0],intervals[0][1]});

        for(int i=1;i<n;i++){
            int start=list.get(list.size()-1)[0];
            int end=list.get(list.size()-1)[1];
            if(start<=intervals[i][0] && intervals[i][0]<=end){
                list.remove(list.size()-1);
                int newStart=Math.min(start,intervals[i][0]);
                int newEnd=Math.max(end,intervals[i][1]);
                list.add(new int[]{newStart,newEnd});
            }else if(intervals[i][0]<=start && start<=intervals[i][1]){
                list.remove(list.size()-1);
                int newStart=Math.min(start,intervals[i][0]);
                int newEnd=Math.max(end,intervals[i][1]);
                list.add(new int[]{newStart,newEnd});
            }else{
                list.add(new int[]{intervals[i][0],intervals[i][1]});
            }
        }
        if(merged){
            list.add(new int[]{newInterval[0],newInterval[1]});
        }
        int arr[][]=list.toArray(new int[list.size()][]);
        Arrays.sort(arr,(a,b)->{
            if(a[0]==b[0]){
                return Integer.compare(a[1],b[1]);
            }else {
                return Integer.compare(a[0],b[0]);
            }
        });
        return arr;
    }
}