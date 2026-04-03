class TimeMap {
    HashMap<String,HashMap<Integer,String>> map;
    public TimeMap() {
        map=new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key,new HashMap<>());
        map.get(key).putIfAbsent(timestamp,value);
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";
        int time=-1;
        for(int timestamps:map.get(key).keySet()){
            if(timestamp==timestamps){
                return map.get(key).get(timestamp);
            }else if(time<timestamps && timestamps<timestamp){
                time=timestamps;
            }
        }
        if(time==-1){
            return "";
        }
        return map.get(key).get(time);
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */