class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> targetMap=new HashMap<>();
        HashMap<Character,Integer> map=new HashMap<>();
        int m=t.length();
        for(int i=0;i<m;i++){
            targetMap.put(t.charAt(i),targetMap.getOrDefault(t.charAt(i),0)+1);
        }

        int n=s.length();
        int left=0;
        String ans="";
        String temp="";
        for(int i=0;i<n;i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
            while(Hash_calculate(targetMap,map)){
                temp=new String(s.substring(left,i+1));
               map.put(s.charAt(left),map.get(s.charAt(left))-1);
               left++; 
            }
            if(ans.equals("")|| ans.length()> temp.length()){
                ans=new String(temp);
            }
        }
        return ans;

    }
    public boolean Hash_calculate(HashMap<Character,Integer> targetMap,HashMap<Character,Integer> map){
        for(Character c: targetMap.keySet()){
            int val=map.getOrDefault(c,0).intValue();
            if(targetMap.get(c)<=val){
                continue;
            }
            return false;
        }
        return true;
    }
}