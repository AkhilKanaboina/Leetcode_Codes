class Solution {
    public boolean judgeSquareSum(int c) {
        double mid=Math.ceil(Math.sqrt(c));
        double i=0;
        double j=mid;
        double ans=0;
        while(i<=j){
            ans=Math.pow(i,2)+Math.pow(j,2);
            if(ans==c)
                return true;
            if(ans>c){
                j--;
            }else{
                i++;
            }
        }
        return false;
    }
}