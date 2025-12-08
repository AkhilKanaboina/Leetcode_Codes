class Solution {
    public int countTriples(int n) {
        HashSet<Integer> set=new HashSet<>();
        for(int i=1;i<=n;i++){
            set.add(i*i);
        }
        int ans=0;
        int nSquare=n*n;
        for(int a=1;a<=n;a++){
            int aVal=a*a;
            for(int b=1;((b*b)+aVal)<=nSquare;b++){
                if(set.contains((b*b)+aVal)){
                    ans++;
                }
            }
        }
        return ans;
    }

}