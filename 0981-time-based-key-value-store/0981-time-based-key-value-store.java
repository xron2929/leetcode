class TimeMap {

   
    class TimeStampDto {
        private int timeStamp;
        private String value;

        public TimeStampDto(int timeStamp, String value) {
            this.timeStamp = timeStamp;
            this.value = value;
        }

        public int getTimeStamp() {
            return timeStamp;
        }

        public String getValue() {
            return value;
        }
    }
    Map<String,List<TimeStampDto>> map = new HashMap<>();
    public void set(String key, String value, int timestamp) {
        if(map.containsKey(key)) {
            List<TimeStampDto> timeStampDtos = map.get(key);
            timeStampDtos.add(new TimeStampDto(timestamp,value));
            return;
        }
        List<TimeStampDto> timeStampDtos = new ArrayList<>();
        timeStampDtos.add(new TimeStampDto(timestamp,value));
        map.put(key,timeStampDtos);

    }

     public String get(String key, int timestamp) {
            if(!map.containsKey(key)) {
                return "";
            }
            List<TimeStampDto> timeStampDtos = map.get(key);
            int closestTimeStamp = -1;
            int lt = 0;
            int rt = timeStampDtos.size()-1;
            int data = 0;
             while(lt<=rt) {
                int mid = (lt+rt)/2;
                if(timeStampDtos.get(mid).getTimeStamp()== timestamp) {
                    return timeStampDtos.get(mid).getValue();
                }
                else if(timeStampDtos.get(mid).getTimeStamp() < timestamp) {
                    lt = mid +1;
                }
                else {
                    rt = mid -1;
                }
            }

            if (rt < 0) {
                return "";
            }
            return timeStampDtos.get(rt).getValue();
     }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */