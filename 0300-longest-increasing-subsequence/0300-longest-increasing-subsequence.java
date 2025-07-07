class Solution {
    public int binarySearch(List<Integer> list,int target){
        int l=0;
        int r=list.size()-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(list.get(mid)==target){
                return mid;
            }else if(list.get(mid)>target){
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return l;
    }
    public int lengthOfLIS(int[] nums) {
       ArrayList<Integer> list=new ArrayList<>();
       for(int n:nums){
        if(list.isEmpty()||list.get(list.size()-1)<n){
            list.add(n);
        }else{
            int indx=binarySearch(list,n);
            list.set(indx,n);
        }
       }
       return list.size();
    }
}

// class Solution {
//     public int lengthOfLIS(int[] nums) {
//         int n=nums.length;
//         int dp[]=new int[n];   
//         int max=0;
//         for(int i=0;i<n;i++){
//             dp[i]=1;
//         }
//         Queue<Integer> min=new PriorityQueue<>();
//         min.add(nums[0]);
//         int j=0;
//         for(int i=1;i<n;i++){
//                 while(!min.isEmpty()&&min.peek()<nums[i]&&j<i){
//                     dp[i]=Math.max(dp[i],dp[j]+1);
//                     min.poll();
//                     j++;
//                 }
//             min.add(nums[i]);
//         }
//         for(int i=0;i<n;i++){
//             if(dp[i]>max){
//                 max=dp[i];
//             }
//         }
//         return max;
//     }
// }

