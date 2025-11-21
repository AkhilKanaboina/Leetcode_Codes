class Solution {
    public boolean canBeValid(String s, String locked) {
        int min=0;
        int n=s.length();
        int max=0;
        if(n%2==1){
            return false;
        }
        for(int i=0;i<n;i++){
            if(locked.charAt(i)=='1'){
                if(s.charAt(i)=='('){
                    min++;
                    max++;
                }else{
                    min--;
                    max--;
                }
            }else{
                    min--;
                    max++;
            }
            if(max<0){
                return false;
            }
            if(min<0){
                min=0;
            }
        }
        return (min==0 ||max==0)? true: false;
    }
    // public boolean backTracking(int index,String s,String locked,int count,int n){
    //     if(count<0){
    //         return false;
    //     }
    //     if(index==n){
    //         if(count==0){
    //             return true;
    //         }else{
    //             return false;
    //         }
    //     }
    //     if(locked.charAt(index)=='1'){
    //         int val=(s.charAt(index)=='(')?1:-1;
    //         return backTracking(index+1,s,locked,val+count,n);
    //     }else{
    //         return (backTracking(index+1,s,locked,count+1,n)||backTracking(index+1,s,locked,count-1,n));
    //     }
    // }
}