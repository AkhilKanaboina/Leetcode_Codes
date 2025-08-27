class Solution {
    public int partitionString(String s) {
        HashSet<Character> set=new HashSet<>();
        int n=s.length();
        int ans=1;
        for(int i=0;i<n;i++){
            if(set.contains(s.charAt(i))){
                ans++;
                set.clear();
            }
                set.add(s.charAt(i));
        }
        return ans;
    }
}