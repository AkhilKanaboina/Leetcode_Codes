class Solution {
    public int myAtoi(String s) {
        s=new String(s.trim());
        long ans=0;
        int sign=1;
        int n=s.length();
        int i=0;
        if(s.charAt(0)=='-'){
            sign=-1;
            i++;
        }else if(s.charAt(0)=='+'){
            sign=1;
            i++;
        }
        for(;i<n;i++){
            int val=s.charAt(i)-'0';
            if(val<=9 && val>=0){
               if((ans>Integer.MAX_VALUE/10)||(ans==Integer.MAX_VALUE/10 && val>7 )){
                return sign==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
               }
            ans=ans*10+val;
            }else{
                break;
            }
        }
           
        return (int)ans*sign;
    }
}