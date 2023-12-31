class Solution {
    static class TemperatureDto {
        private int pos;
        private int price;

        public TemperatureDto(int pos, int price) {
            this.pos = pos;
            this.price = price;
        }

        public int getPos() {
            return pos;
        }

        public int getPrice() {
            return price;
        }
    }
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<TemperatureDto>stack = new Stack<>();
        int[] arr = new int[temperatures.length];
        int cnt=1;
        for (int i = 0; i < temperatures.length; i++) {

            while(!stack.isEmpty() && stack.peek().getPrice()<temperatures[i]) {
                arr[stack.peek().getPos()] = i - stack.peek().getPos();
                stack.pop();
            }
            stack.push(new TemperatureDto(i,temperatures[i]));

        }
        return arr;
    }
}