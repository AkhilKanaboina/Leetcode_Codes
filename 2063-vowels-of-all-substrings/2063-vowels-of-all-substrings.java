class Solution {
    public long countVowels(String word) {
        long ans=0;
        HashSet<Character> set=new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        int n=word.length();
        for(int i=0;i<n;i++){
            if(set.contains(word.charAt(i))){
                ans+=(long)(i+1)*(n-i);
            }
        }
        return ans;
    }
}