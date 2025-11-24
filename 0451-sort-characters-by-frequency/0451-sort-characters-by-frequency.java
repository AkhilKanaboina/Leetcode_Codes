class Solution {
    public String frequencySort(String s) {     
        HashMap<Character,Integer> map=new HashMap<>();
        for(char c: s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        List<Character> list=new ArrayList<>();
        for(char c:map.keySet()){
            list.add(c);
        }
        Collections.sort(list,(a,b)->map.get(b)-map.get(a));
        StringBuffer str=new StringBuffer();
        for(char c:list){
            str.append(String.valueOf(c).repeat(map.get(c)));
        }
        return str.toString();
    }
}