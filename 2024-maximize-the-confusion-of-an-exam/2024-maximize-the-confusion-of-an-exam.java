class Solution {
    String s;
    int max=0;
    public int maxConsecutiveAnswers(String answerKey, int k) {
        s=answerKey;
        max=k;
        return Math.max(slideWindow('T'),slideWindow('F'));
    }
    public int slideWindow(char target){
        int count=0;
        int left=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=target){
                count++;
            }
            if(count>max){
                if(s.charAt(left)!=target){
                    count--;
                }
                left++;
            }
        }
        return s.length()-left;
    }
}