class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i=0;
        int j=0;
        int n1=nums1.length;
        int n2=nums2.length;
        int size=n1+n2;

        int firstIndex=(size/2);
        int secondIndex=(size-1)/2;
        int idx=-1;
        int ans=0;
        int val=0;

        while(i<n1 && j<n2){
            
            if(nums1[i]<nums2[j]){
                idx++;
                val=nums1[i++];
            }else{
                idx++;
                val=nums2[j++];
            }
            if(idx==firstIndex){
                ans=ans+val;
            }
            if(idx==secondIndex){
                ans=ans+val;
              //  return (double)((double)ans/2.0);
               // return ans;
            }
        }
        while(i<n1){
            val=nums1[i++];
            idx++;
            if(idx==firstIndex){
                ans+=val;
            }
            if(idx==secondIndex){
                ans+=val;
               // return (double)((double)ans/2.0);
            }
        }
        while(j<n2){
            val=nums2[j++];
            idx++;
             if(idx==firstIndex){
                ans+=val;
            }
            if(idx==secondIndex){
                ans+=val;
               // return (double)((double)ans/2.0);
            }
        }
        return (double)((double)ans/2.0);
    }
}