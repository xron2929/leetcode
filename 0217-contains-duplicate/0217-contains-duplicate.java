class Solution {
     public static boolean containsDuplicate(int[] nums) {
        Set<Integer> list = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(!list.contains(nums[i])) {
                list.add(nums[i]);
                continue;
            }
            return true;
        }
        return false;
    }
}