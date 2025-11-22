class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        StringBuffer ans=new StringBuffer();
        String s1=strs[0];
        String s2=strs[strs.length-1];
        int n1=s1.length();
        int n2=s2.length();
        int i=0;
        while(i<n1&&i<n2){
            if(s1.charAt(i)!=s2.charAt(i)){
                break;
            }
            i++;
        }
        return s1.substring(0,i);
    }
}