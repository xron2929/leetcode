class Solution {
     public static void x(int startingCnt, int endingCnt, int n, String res,List<String>list)  {
        if(startingCnt==n && endingCnt == n) {
            list.add(res);
            return;
        }
        if(startingCnt == n && endingCnt != n) {
            x(startingCnt,endingCnt+1,n,res+")",list);
            return;
        }
        if(startingCnt != n && endingCnt == n ) {
            x(startingCnt+1,endingCnt,n,res+"(",list);
            return;
        }
        if(startingCnt == endingCnt) {
            x(startingCnt+1,endingCnt,n,res+"(",list);
            return;
        }
        x(startingCnt+1,endingCnt,n,res+"(",list);
        x(startingCnt,endingCnt+1,n,res+")",list);
        return;
    }
    public List<String> generateParenthesis(int n) {
         List<String>list = new ArrayList<>();
        x(0,0,n,"",list);
        return list;
    }
}