class Solution {
    public boolean lemonadeChange(int[] bills) {
        int sum=0;
        int arr[]={0,0,0};
        for(int temp:bills){
            if(temp==5){
                arr[0]++;
            }else if(temp==10){
                if(arr[0]>0){
                    arr[0]--;
                    arr[1]++;
                }else{
                    return false;
                }
            }else if(temp==20){
                if(arr[0]>=1&&arr[1]>=1){
                    arr[0]--;
                    arr[1]--;
                    arr[2]++;
                }else if(arr[0]>=3){
                    arr[0]=arr[0]-3;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}