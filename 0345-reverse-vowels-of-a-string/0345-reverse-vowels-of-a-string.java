class Solution {
    public String reverseVowels(String s) {
        Stack<Character> stack=new Stack<>();
        for(char c:s.toCharArray()){
            if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u'||c=='A'||c=='E'||c=='I'||c=='O'||c=='U'){
                stack.push(c);
            }
        }
        StringBuffer str=new StringBuffer();
        for(char c:s.toCharArray()){
            if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u'||c=='A'||c=='E'||c=='I'||c=='O'||c=='U'){
               str.append(stack.pop());
            }else{
                str.append(c);
            }
        }
        return str.toString();
    }
}