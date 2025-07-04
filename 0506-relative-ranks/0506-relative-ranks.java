class Solution {
   
    public String[] findRelativeRanks(int[] score) {
        int n=score.length;
        int dmm[]=Arrays.copyOf(score,n);
        Arrays.sort(dmm);
       for (int i = 0; i < n / 2; i++) {
            int temp = dmm[i];
            dmm[i] = dmm[n - 1 - i];
            dmm[n - 1 - i] = temp;
        }
        HashMap<Integer,Integer> mp=new HashMap<>();
        for(int i=0;i<n;i++){
            mp.put(dmm[i],i+1);
        }
        String[] str = new String[n];
        for(int i=0;i<n;i++){
            int rank=mp.get(score[i]);
            if(rank==1){
                str[i]="Gold Medal";
            }else if(rank==2){
                str[i]="Silver Medal";
            }else if(rank==3){
                str[i]="Bronze Medal";
            }else{
                str[i]=""+(rank)+"";
            }
        }
        return str;
       

       

    }
}