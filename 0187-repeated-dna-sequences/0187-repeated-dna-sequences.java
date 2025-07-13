class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> ans=new HashSet<>();

        // if(s.length()<=10){
        //     return ;
        // }
        HashSet<String> proc=new HashSet<>();
        int key=0;
        for(int i=10;i<=s.length();i++){
            String temp=s.substring(key,i);
            if(proc.contains(temp)&&!ans.contains(temp)){
                ans.add(temp);
            }else{
                proc.add(temp);
            }
            key++;
        }
        List<String> final_ans=new ArrayList<>(ans);
        return final_ans;
    }
}