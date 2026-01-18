class Solution {
    public boolean validPalindrome(String s) {
        if(isPalindrome(s,0,s.length()-1)){
            return true;
        }
        int left=0;
        int right=s.length()-1;
        while(left<=right){
            if(s.charAt(left)==s.charAt(right)){
                left++;
                right--;
            }else{
                return isPalindrome(s,left+1,right)||isPalindrome(s,left,right-1);
            }
        }
        return true;
    }
    public boolean isPossible(String s,int left,int right){
        if(left>=right){
            return true;
        }
        if(s.charAt(left)==s.charAt(right)){
            return isPossible(s,left+1,right-1);
        }else if(s.charAt(left)!=s.charAt(right)){
            return isPossible(s,left+1,right)||isPossible(s,left,right-1);
        }
        return true;
    }
    public boolean isPalindrome(String s,int left,int right){
        while(left<=right){
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}