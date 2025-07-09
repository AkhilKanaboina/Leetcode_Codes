class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i:nums){
            sum+=i;
        }
        if(sum%2==1)
        return false;
        int target=sum/2;
        boolean b[]=new boolean[target+1];
        b[0]=true;
        for(int i:nums){
            for(int j=target;j>=i;j--){
                b[j]=b[j]||b[j-i];
            }
            if(b[target]==true){
                return true;
            }
        }
        return b[target];
    }
}