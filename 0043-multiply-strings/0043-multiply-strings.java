class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0")||num2.equals("0")){
            return "0";
        }
        int n=num1.length();
        int m=num2.length();
        int ans[]=new int[n+m];
        Arrays.fill(ans,0);
        for(int i=n-1;i>=0;i--){
            int a=num1.charAt(i)-'0';
            for(int j=m-1;j>=0;j--){
                int b=num2.charAt(j)-'0';
                b*=a;
                ans[i+j+1]+=b%10;
                ans[i+j]+=b/10;
            }
        }
        for(int i=ans.length-1;i>0;i--){
            ans[i-1]+=ans[i]/10;
            ans[i]%=10;
        }
        StringBuilder str=new StringBuilder("");
        for(int i=0;i<n+m;i++){
            if(str.length()==0 && ans[i]==0){
                continue;
            }
            str.append(ans[i]);
        }
        return str.toString();
    }
}