class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        boolean assigned[]=new boolean[s.length];
        int ans=0;
        for(int i=0;i<g.length;i++){
            for(int j=0;j<s.length;j++){
                if(!assigned[j]&&s[j]>=g[i]){
                    assigned[j]=true;
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }
}