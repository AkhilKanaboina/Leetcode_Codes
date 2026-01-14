class Solution {
    public String longestPalindrome(String s) {
       int start=0;
       int end=0;
       int max=0;
       for(int center=0;center<s.length();center++){
            int odd=possibleIndex(s,center,center);
            int even=possibleIndex(s,center-1,center);
            //possibleIndex(s,center,center+1);
            max=Math.max(odd,even);
            if(max>(end-start)){
                start=center-(max)/2;

                end=center+(max-1)/2;
            }
       }
       return s.substring(start,end+1);
    }
    public int possibleIndex(String s,int left,int right){
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        return right-left-1;
    }
}