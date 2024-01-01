class Solution {
    
    public int carFleet(int target, int[] position, int[] speed) {
        int[] dist = new int[position.length];
        double[] timeArr = new double[position.length];
        Map<Integer,Double>map = new HashMap<>();
        Stack<Double>stack = new Stack<>();
        for (int i = 0; i < position.length; i++) {
            dist[i] = target - position[i];
            // 2 4 12 7 9
            timeArr[i] = ((double) dist[i] / (double) speed[i]);

            if(map.containsKey(dist[i])) {
                Double time = map.get(dist[i]);
                time = Math.min(time,timeArr[i]);
                map.put(dist[i],time);
                continue;
            }
            map.put(dist[i],timeArr[i]);
        }
        Arrays.sort(dist);
        for (int i = 0; i < dist.length; i++) {
            Double time = map.get(dist[i]);
            if(stack.isEmpty() || stack.peek()<time) {
                stack.push(time);
            }
        }
        return stack.size();
    }
}