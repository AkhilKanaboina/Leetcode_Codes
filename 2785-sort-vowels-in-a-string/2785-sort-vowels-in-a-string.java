class Solution {
    public String sortVowels(String s) {
        HashSet<Character> set=new HashSet<>();
        String ovels="aeiouAEIOU";
        for(char c:ovels.toCharArray()){
            set.add(c);
        }
        
        ArrayList<Character> arr=new ArrayList<Character>();
        for(int i=0,j=0;i<s.length();i++){
            if(set.contains(s.charAt(i))){
                arr.add(s.charAt(i));
            }
        }
        Collections.sort(arr);
        StringBuffer str=new StringBuffer();
       for(char c:s.toCharArray()){
            if(set.contains(c)){
                str.append(arr.get(0));
                arr.remove(0);
            }else{
                str.append(c);
            }
       }
       return str.toString();
    }
}