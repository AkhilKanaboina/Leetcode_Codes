class Solution {
    public int numberOfWays(String corridor) {
        int ans=0;
        int n=corridor.length();
        int count=countSeats(corridor,n);
        if(count==0 || count%2==1){
            return 0;
        }
        ans=count(corridor,n,count,1000000007);
        return ans;
    }
    public int countSeats(String corridor,int n){
        int  count=0;
        for(int i=0;i<n;i++){
            if(corridor.charAt(i)=='S'){
                count++;
            }
        }
        return count;
    }
    public int count(String corridor,int n,int totalseats,int mod){
        int seats=0;
        int ans=1;
        int totalpairs=totalseats/2;
        int currentPair=0;
        for(int i=0;i<n;i++){
            
            if(corridor.charAt(i)=='S'){
                seats++;
                    if(seats>0 && seats%2==0 && seats<totalseats){
                          int plants=countPlants(corridor,i+1,n,mod)%mod;
                          ans=(int)((long)ans*plants%mod);
                    }
            }
        }
        return ans;
    }
    public int countPlants(String corridor,int i,int n,int mod){
        int plants=0;
       while(i<n && corridor.charAt(i)!='S'){
            plants++;
            i++;
        }
        return plants+1;
    }
}