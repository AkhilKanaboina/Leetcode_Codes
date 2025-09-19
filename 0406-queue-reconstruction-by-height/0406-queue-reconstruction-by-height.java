class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,(a,b)->{
            if(a[0]==b[0]){
                return Integer.compare(a[1],b[1]);
            }else{
                return Integer.compare(b[0],a[0]);
            }
        });
        ArrayList<int[]> list=new ArrayList<>(people.length);
        for(int temp[]:people){
          list.add(temp[1],temp);  
        }
        
        return list.toArray(new int[list.size()][]);
    }
}