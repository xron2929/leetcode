class Solution {
    public int findMin(int[] nums) {
       
        LinkedList<Integer> list = new LinkedList<>();
        List<Integer> list2 = new LinkedList<>();
        LinkedList<Integer> list3 = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
            list3.add(nums[i]);
        }
        list2 = list.stream().sorted().collect(Collectors.toList());
        int num = 1;

        while(true) {
            boolean flag =false;
            for (int i = 0; i < list.size(); i++) {
                if(!list.get(i).equals(list2.get(i))) {
                    flag = true;
                    break;
                }
            }
            if(flag == false) {
                break;
            }
            list.add(list.getFirst());
            list.removeFirst();
            num++;
        }

        return list3.get(num -1);
    }
}