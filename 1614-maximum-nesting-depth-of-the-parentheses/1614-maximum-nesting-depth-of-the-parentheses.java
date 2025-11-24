class Solution {
    public int maxDepth(String s) {
        int size=0;
        int max=0;
        for(char c:s.toCharArray()){
            if(c=='('){
                size++;
            }
            if(c==')'){
                size--;
            }
            max=Math.max(size,max);
        }
        return max;
    }
}