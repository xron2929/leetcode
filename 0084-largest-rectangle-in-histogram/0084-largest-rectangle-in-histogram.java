class Solution {
  
     public int largestRectangleArea(int[] heights) {
        List<Integer> arr = new ArrayList<>();
        Stack<Integer>stack = new Stack<>();
        arr.add(0);
        for (int i = 0; i < heights.length; i++) {
            arr.add(heights[i]);
        }
        arr.add(0);
        int res = 0;
        for (int i = 0; i < arr.size(); i++) {
            while(!stack.isEmpty()&&arr.get(stack.peek())>arr.get(i)) {
                int height = arr.get(stack.pop());
                int width = i - stack.peek() -1;
                res = Math.max(res,width*height);
            }
            stack.push(i);
        }
        return res;
         // stack[i]는 i번째일 때의 최대 높이 
         // 그래서 stack[i]랑 stack[i-1] 사이는 해당 높이의 최대갯수가 들어가있음 
         // 그걸로 최대값을 가져옴

    }
}