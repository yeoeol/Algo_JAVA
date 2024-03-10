import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _2504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        Stack<Character> stack = new Stack<>();
        int res = 0;
        int val = 1;

        for (int i = 0; i < s.length(); i++) {
            System.out.println(stack);
            System.out.println(val);
            System.out.println("---------------");
            char c = s.charAt(i);
            if (c == '(') {
                stack.add('(');
                val *= 2;
            } else if (c == '[') {
                stack.add('[');
                val *= 3;
            } else if (c == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    res = 0;
                    break;
                } else if (s.charAt(i - 1) == '(') {
                    res += val;
                }
                stack.pop();
                val /= 2;
            } else if (c == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    res = 0;
                    break;
                } else if (s.charAt(i - 1) == '[') {
                    res += val;
                }
                stack.pop();
                val /= 3;
            }
        }
        if (stack.isEmpty()) {
            System.out.println(res);
        } else {
            System.out.println(0);
        }
    }
}
