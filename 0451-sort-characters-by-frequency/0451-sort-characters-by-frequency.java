class Solution {
    public String frequencySort(String s) {     
        HashMap<Character,Integer> map=new HashMap<>();
        for(char c: s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        List<Character>[] buckets=new List[s.length()+1];

        for(Character c: map.keySet()){
            if(buckets[map.get(c)]==null)
            buckets[map.get(c)]=new ArrayList<>();
            buckets[map.get(c)].add(c);
        }
        StringBuilder str=new StringBuilder();
        for(int i=s.length();i>0;i--){
            if(buckets[i]!=null){
                for(char cha: buckets[i]){
                    for(int j=1;j<=i;j++)
                    str.append(cha);
                }
            }
        }
        return str.toString();
    }
}