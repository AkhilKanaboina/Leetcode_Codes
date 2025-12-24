class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int apples=0;
        int n=apple.length;
        int m=capacity.length;
        for(int i=0;i<n;i++){
            apples+=apple[i];
        }
        Arrays.sort(capacity);
        int ans=0;
        int sum=0;
        for(int i=m-1;i>=0;i--){
            sum+=capacity[i];
            ans++;
            if(sum>=apples){
                return ans;
            }
        }
        return ans;
    }
}