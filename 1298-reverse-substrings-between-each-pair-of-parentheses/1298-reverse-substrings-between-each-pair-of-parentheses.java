class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);

            if (ch != ')') {
                stack.push(ch);
            } else {
                String sb = "";
                while (!stack.isEmpty()) {
                    if (stack.peek() == '(') {
                        stack.pop();
                        for (int j = 0; j < sb.length(); j++) {
                            stack.push(sb.charAt(j));
                        }
                        break;
                    } 
                    char popped = stack.pop();
                    sb += popped;
                }
            }
        }
        String ans = "";
        while (!stack.isEmpty ()) {
            ans = stack.pop() + ans;
        } 

        return ans;
    }
}