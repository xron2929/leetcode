class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        boolean contains = Arrays.stream(matrix).flatMap(ints -> {
            return Arrays.stream(ints).boxed();
        }).collect(Collectors.toList()).contains(target);
        return contains;
    }
}