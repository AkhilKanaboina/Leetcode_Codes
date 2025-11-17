class Solution {
    public double myPow(double x, int n) {
        return (n>0)?ansFun(x,n):1/ansFun(x,(n));
    }
    public double ansFun(double val,long n){
        n=Math.abs(n);
        double ans=1.0000;
        while(n>0){
            if(n%2==1){
                n=n-1;
                ans=ans*val;
            }else{
                val=val*val;
                n/=2;
            }
        }
        return ans;
    }
}