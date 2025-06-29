class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> s1=new HashSet<>();
        HashSet<Integer> s2=new HashSet<>();
        for(int i:nums1){
            if(!s1.contains(i)){
                s1.add(i);
            }
        } 
        for(int i:nums2){
            if(!s2.contains(i)){
                s2.add(i);
            }
        } 
        ArrayList<Integer> a=new ArrayList<>();
        for(int i:s1){
            if(s2.contains(i)){
                a.add(i);
            }
        }
        
        int arr[]=a.stream().mapToInt(i->i).toArray();
        // int key=0;
        // for(int i:a){
        //     arr[key]=i;
        //     key++;
        // }
        return arr;    
    }
}