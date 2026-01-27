class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        int n=asteroids.length;
        long m=mass;
        for(int i=0;i<n;i++){
            if(m>=asteroids[i]){
                m+=asteroids[i];
                continue;
            }
            return false;
        }
        return true;
    }
}