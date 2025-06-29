class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,(a, b) -> Integer.compare(a[1], b[1]));
        int n=pairs.length;
        int a[]=new int[n];
        for(int i=0;i<n;i++){
            a[i]=1;
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(pairs[j][1]<pairs[i][0]){
                    a[i]=Math.max(a[i],a[j]+1);
                }
            }
        }
        int max=0;
        for(int i=0;i<n;i++){
            max=Math.max(max,a[i]);
        }
        return max;
    }
}