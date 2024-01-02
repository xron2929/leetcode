class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
       List<Integer> collect = Arrays.stream(matrix).flatMap(ints -> {
            return Arrays.stream(ints).boxed();
        }).collect(Collectors.toList());
        int lt = 0;
        int rt = collect.size() - 1;
        while(lt<=rt) {
            int mid= (lt+rt) / 2;
            if(collect.get(mid)==target) {
                return true;
            }
            else if(collect.get(mid)<target) {
                lt = mid + 1;
            }
            else {
                rt = mid - 1;
            }
        }
        return false;
    }

}