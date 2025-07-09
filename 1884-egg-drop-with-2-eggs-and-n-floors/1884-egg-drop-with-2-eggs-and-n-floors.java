class Solution {
    public int twoEggDrop(int n) {
        if(n==2){
            return 2;
        }
        int sum=0;
        int i=0;
        while(sum<n){
            i++;
            if(sum+i==n){
                break;
            }
            sum+=i;
        }
        return i;
    }
}