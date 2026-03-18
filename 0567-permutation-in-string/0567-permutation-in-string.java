class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()) return false;
        int arr[]=new int[26];
        int n=s1.length();
        for(char c:s1.toCharArray()){
            arr[c-'a']++;
        }
        int hash[]=new int[26];
        for(int i=0;i<n-1;i++){
            hash[s2.charAt(i)-'a']++;
        }
        int j=0;
        for(int i=n-1;i<s2.length();i++){
            hash[s2.charAt(i)-'a']++;
            if(helper(hash,arr)){
                return true;
            }
            hash[s2.charAt(j++)-'a']--;
        }
        return false;
        
    }
    public boolean helper(int arr[],int hash[]){
        int n=arr.length;
        int m=hash.length;
        if(m!=n) return false;
        for(int i=0;i<n;i++){
            if(arr[i]!=hash[i]) return false;
        }
        return true;
    }
}