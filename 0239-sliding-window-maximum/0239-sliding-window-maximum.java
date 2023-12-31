class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
       // 반례는 첫번째 값제일 크고 두번째 값 그 다음 크고 세번째 값 있을 때
       Deque<Integer> deque = new ArrayDeque<>();
        int res[] = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && deque.peekFirst() <= i-k) {
                deque.pollFirst();
            }
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            if (i + 1 >= k) {
                res[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return res;
    
    }    
       
    
}