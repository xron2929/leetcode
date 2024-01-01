class Solution {
    public int search(int[] nums, int target) {
        int lt = 0;
        int rt = nums.length-1;
        while(lt<=rt) {
            int mid = (lt+rt)/2;
            if(nums[mid]<target) {
                lt = mid+1;
                continue;
            }
            else if(nums[mid] == target) {
                return mid;
            }
            else {
                rt = mid-1;
            }
        }
        return -1;
    }
}