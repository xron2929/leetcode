class Solution {
    public int evalRPN(String[] tokens) {
          Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if(tokens[i].equals("+") || tokens[i].equals("-") ||
                    tokens[i].equals("*") || tokens[i].equals("/")) {
                int num0 = stack.pop();
                int num1 = stack.pop();
                 if(tokens[i].equals("+")) {
                     stack.push(num1+num0);
                     continue;
                 }
                if(tokens[i].equals("-")) {
                    stack.push(num1-num0);
                    continue;
                }
                if(tokens[i].equals("*")) {
                    stack.push(num1*num0);
                    continue;
                }
                if(tokens[i].equals("/")) {
                    stack.push(num1/num0);
                    continue;
                }
            }
            stack.push(Integer.parseInt(tokens[i]));
        }
        return stack.pop();
    }
}