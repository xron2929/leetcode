class Solution {
     static class WindowDto {
        private int left;
        private int minValue;
        private int right;
        public WindowDto(int left, int minValue,int right) {
            this.left = left;
            this.minValue = minValue;
            this.right = right;
        }

        public int getRight() {
            return right;
        }

        public void setRight(int right) {
            this.right = right;
        }

        public int getLeft() {
            return left;
        }

        public void setLeft(int left) {
            this.left = left;
        }

        public int getMinValue() {
            return minValue;
        }

        public void setMinValue(int minValue) {
            this.minValue = minValue;
        }
    }
    public static String minWindow(String s, String t) {
        WindowDto windowDto = new WindowDto(-1,s.length()+1,s.length()+1);
        Map<Character,Integer>map = new HashMap();
        int left = 0;
        int cnt = t.length();
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i),0)+1);
        }

        for (int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))) {
                Integer integer = map.get(s.charAt(i)) - 1;

                if (integer >= 0) {
                    cnt--;
                }
                map.put(s.charAt(i), integer);
                System.out.println();
            }
            if(cnt>0) continue;
            while(left<=i) {
                if(windowDto.minValue>=i-left+1) {
                    windowDto.setMinValue(i-left+1);
                    windowDto.setLeft(left);
                    windowDto.setRight(i);
                }
                if(map.containsKey(s.charAt(left)) && map.get(s.charAt(left))>=0 ) {
                    break;
                }
            
                if(map.containsKey(s.charAt(left))) {
                    map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
                }
                left++;
                
            }
        }
          

        if(windowDto.getLeft()==-1) {
            return "";
        }
        return s.substring(windowDto.getLeft(),windowDto.getRight()+1);

    }
}