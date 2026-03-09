class Solution {
    int n=0;
    HashMap<Integer,Integer> map;
    public Solution(int n, int[] blacklist) {
        this.n=n;
        map=new HashMap<>();

        HashSet<Integer>  set=new HashSet<>();
        for(int val:blacklist) set.add(val);
        int size=n-blacklist.length;
        int last=size-1;
        for(int val:blacklist){
            if(val<size){
                while(set.contains(last)) last--;
                map.put(val,last);
                last--;
            }
        }
    }
    
    public int pick() {
        int val = (int)(Math.random() * n);
        if(map.containsKey(val)){
            return map.get(val);
        }
        return val;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(n, blacklist);
 * int param_1 = obj.pick();
 */