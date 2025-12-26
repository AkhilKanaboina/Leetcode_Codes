class Solution {
    public int bestClosingTime(String customers) {
        int yCount=0;
        int nCount=0;
        int n=customers.length();
        for(int i=0;i<n;i++){
            if(customers.charAt(i)=='Y'){
                yCount++;
            }
        }
        int ans=Integer.MAX_VALUE;
        int index=0;
        for(int i=0;i<n;i++){
            if(nCount+yCount<ans){
                ans=nCount+yCount;
                index=i;
            }
            if(customers.charAt(i)=='N'){
                nCount++;
            }
            if(customers.charAt(i)=='Y'){
                yCount--;
            }

        }
        if(nCount+yCount<ans){
                ans=nCount+yCount;
                index=n;
        }
        return index;
    }
}