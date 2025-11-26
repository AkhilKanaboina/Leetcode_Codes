class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n=bloomDay.length;
        if(n<(m*k*1L)){
            return -1;
        }
        int min=bloomDay[0];
        int max=bloomDay[0];
        for(int i=0;i<n;i++){
            if(bloomDay[i]>max){
                max=bloomDay[i];
            }
            if(bloomDay[i]<min){
                min=bloomDay[i];
            }
        }
        int ans=max;
        boolean b=false;
        while(min<=max){
            int mid=(min+max)/2;
            int val=0,counter=0;
            for(int i=0;i<n;i++){
                if(bloomDay[i]<=mid){
                    counter++;
                    if(counter==k){
                        val++;
                        counter=0;
                    }
                    
                }else{
                    counter=0;
                }
                
            }
            if(val>=m){
                ans=Math.min(mid,ans);
                b=true;
                max=mid-1;
            }else {
                min=mid+1;
            }

        }
        return (b)?ans:-1;




























    //     int val=0;
    //     for(int day=min;day<=max;day++){
    //         int counter=0;
    //         val=0;
    //         for(int i=0;i<n;i++){
    //             if(bloomDay[i]<=day){
    //                 counter++;
    //                 if(counter==k){
    //                     val++;
    //                     counter=0;
    //                 }
                    
    //             }else{
    //                 counter=0;
    //             }
    //             if(val>=m){
    //                 return day;
    //             }
    //         }
    //     }
    //     return max;
    }
}