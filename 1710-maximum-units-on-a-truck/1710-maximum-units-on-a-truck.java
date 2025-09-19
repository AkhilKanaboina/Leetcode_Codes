class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes,(a,b)->Integer.compare(b[1],a[1]));
        int temp=truckSize;
        int ans=0;
        int i=0;
        for( i=0;i<boxTypes.length&&temp>0;i++){
            int diff=temp-boxTypes[i][0];
            if(diff>0){
                temp-=boxTypes[i][0];
                ans+=(boxTypes[i][0]*boxTypes[i][1]);
            }else{
                break;
            }
        }
        while(temp>0){
            temp=temp-(1);
            ans=ans+(boxTypes[i][1]);
        }
        return ans;
    }
}