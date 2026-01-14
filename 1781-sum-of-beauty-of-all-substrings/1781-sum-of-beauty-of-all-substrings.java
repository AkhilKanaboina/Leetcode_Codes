class Solution {
    public int beautySum(String s) {
        int n=s.length();
        HashMap<Character,Integer> map=new HashMap<>();
        int ans=0;
        for(int i=0;i<n;i++){
            map.clear();
            for(int j=i;j<n;j++){
                map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0)+1);
                int min=Integer.MAX_VALUE;
                int max=0;
                for(char key:map.keySet()){
                    min=Math.min(min,map.get(key));
                    max=Math.max(max,map.get(key));
                }
                ans+=(max-min);
            }
        }
        return ans;
    }
    // {
    //     int hash[]=new int[26];
    //     int ans=0;
    //     int n=s.length();
    //     for(int w=3;w<=n;w++){
    //         //window 
    //         Arrays.fill(hash,0);
    //         for(int i=0;i<w;i++){
    //             hash[s.charAt(i)-'a']++;   
    //         }
    //         //calculate beauty val
    //         //window later
    //         ans+=beautyVal(hash);
    //         for(int i=w;i<n;i++){
    //             hash[s.charAt(i)-'a']++;
    //             hash[s.charAt(i-w)-'a']--;
    //             //calculate beauty val
    //             ans+=beautyVal(hash);
    //         }
    //     }
    //     return ans;
    // }
    // public int beautyVal(int arr[]){
    //     int min=Integer.MAX_VALUE;
    //     int max=Integer.MIN_VALUE;
    //     for(int i=0;i<26;i++){
    //         if(arr[i]==0){
    //             continue;
    //         }
    //         if(arr[i]>max){
    //             max=arr[i];
    //         }
    //         if(arr[i]<min){
    //             min=arr[i];
    //         }
    //     }
    //     return max-min;
    // }
}