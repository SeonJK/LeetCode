class TimeMap {
    
    Map<String, TreeMap<Integer, String>> timeMap;

    public TimeMap() {
        timeMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        TreeMap<Integer, String> tmap = timeMap.getOrDefault(key, new TreeMap<>());
        tmap.put(timestamp, value);
        timeMap.put(key, tmap);
    }
    
    public String get(String key, int timestamp) {
        if (!timeMap.containsKey(key))
            return "";
        
        TreeMap<Integer, String> tmap = timeMap.get(key);
        Map.Entry<Integer, String> e = tmap.floorEntry(timestamp);
        if(e == null) 
            return "";
        else 
            return e.getValue();
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */