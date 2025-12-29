class Solution {
    public int maxJump(int[] stones) {
        int maxJump=stones[1]-stones[0];
        int n=stones.length;

        for(int i=2;i<n;i++){
            maxJump=Math.max(maxJump,stones[i]-stones[i-2]);
        }
        return maxJump;
    }
}