public class Solution {
    public String removeKdigits(String num, int k) {
        if (num.length() == k) {
            return "0";
        }
        Stack<Character> stack = new Stack<Character>();
        int i = 0;
        for (int j = 0; j < k; j ++) {
            if (i >= num.length() || (!stack.isEmpty() && stack.peek() > num.charAt(i))) {
                stack.pop();
                continue;
            }
            while (i < num.length() - 1 && num.charAt(i) <= num.charAt(i + 1)) {
                stack.push(num.charAt(i));
                i ++;
            }
            i ++;
        }
        while (i < num.length()) {
            stack.push(num.charAt(i));
            i ++;
        }
        String sb = "";
        while (!stack.isEmpty()) {
            sb = stack.pop() + sb;
        }
        i = 0;
        while (i < sb.length() - 1 && sb.charAt(i) == '0') {
            i ++;
        }
        return sb.substring(i);
    }
}