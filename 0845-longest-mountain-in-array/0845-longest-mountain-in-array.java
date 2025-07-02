class Solution {
    public int longestMountain(int[] arr) {
        int start = -1, mid = -1, end = -1;
        int ans = 0;
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            

            if (arr[i] < arr[i + 1]) {
                if (start == -1) {
                    start = i;
                }else if(end!=-1){
                    start=i;
                }
                
            } else if (arr[i] > arr[i + 1]) {
                if (start != -1) {
                    end = i + 1;
                    ans = Math.max(ans, end - start + 1);
                }
            } 
           
        }

        return ans >= 3 ? ans : 0;
    }
}
