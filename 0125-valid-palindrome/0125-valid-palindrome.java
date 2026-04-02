class Solution {
    public boolean isPalindrome(String s) {
        List<Character> str=new ArrayList<>();
        for(char c:s.toLowerCase().toCharArray()){
            if(Character.isLetter(c)||Character.isDigit(c)){
                str.add(c);
            }
        }
        int i=0;
        int j=str.size()-1;
        while(i<j){
            if(str.get(i)!=str.get(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}