class Solution {
    public int minEatingSpeed(int[] piles, int h) {
       int lt = 1;
        int rt = 0;
        int res=0;

        for (int i = 0; i < piles.length; i++) {
            rt = Math.max(rt,piles[i]);
        }
        while(lt<=rt) {
            int mid = (lt + rt) / 2;
            Long hour = 0l;
            for (int i = 0; i < piles.length; i++) {
                if(piles[i] % mid ==0) {
                    hour = hour + (piles[i] / mid);

                } else {
                    hour = hour + (piles[i] / mid)+1;

                }

            }
            if(hour == h) {
                res = mid;
                rt = mid - 1;
            } else if(h > hour) {
                res = mid;
                rt = mid - 1;
            } else {
                lt = mid + 1;

            }

        }
        return res;
    }
}