class Solution {
    static class SearchDto {

        private int pos;
        private int value;

        public SearchDto(int pos, int value) {
            this.pos = pos;
            this.value = value;
        }

        public int getPos() {
            return pos;
        }

        public int getValue() {
            return value;
        }
    }
    public int search(int[] nums, int target) {
        List<SearchDto> searchDtos = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            SearchDto searchDto = new SearchDto(i,nums[i]);
            searchDtos.add(searchDto);
        }
        searchDtos.sort((o1, o2) ->  o1.getValue() - o2.getValue());
        
        System.out.println();
        int lt = 0;
        int rt = searchDtos.size()-1;
        while(lt<=rt) {
            int mid = (lt+rt)/2;
            SearchDto searchDto = searchDtos.get(mid);
            System.out.println("searchDto.getValue() = " + searchDto.getValue());
            if(searchDto.getValue() == target) {
                System.out.println("searchDto = " + searchDto.getPos());
                return searchDto.getPos();
            }
            else if ( searchDto.getValue()<target) {
                lt = mid + 1;
            }
            else {
                rt = mid - 1;
            }
        }
        return -1;
    }
}