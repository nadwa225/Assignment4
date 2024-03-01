import java.util.Stack;

public class InfixtoPostfix {

    public static String infToPost(String infix) {
        StringBuilder string = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);

            if (Character.isLetterOrDigit(c)) { // if its an operand
                string.append(c);
            } else if (c == '(') { // if its ( put it in the stack
                stack.push(c);
            } else if (c == ')') { // for closing pop and append
                while (!stack.isEmpty() && stack.peek() != '(') {
                    string.append(stack.pop());
                }
                stack.pop();
            } else {
                // Pop and append operators with higher opperation
                while (!stack.isEmpty() && handle(c) <= handle(stack.peek())) {
                    string.append(stack.pop());
                }
                stack.push(c); // Push current operator to stack
            }
            //stack.push(c); // Push current operator to stack
        }
        while (!stack.isEmpty()) {
            string.append(stack.pop());
        }
        return string.toString();
    }



        private static int handle(char op) {
            switch (op) {
                case '^':
                    return 3;
                case '*':
                case '/':
                    return 2;
                case '+':
                case '-':
                    return 1;
                default:
                    return 0;
            }
        }


    public static void main(String[] args) {
        String infix = "a+b*(c^d-e)^(f+g*h)-i";
        String post = infToPost(infix);
        System.out.println("Postfix Expression: " + post);
    }

}
