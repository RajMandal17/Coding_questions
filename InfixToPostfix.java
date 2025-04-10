import java.util.Stack;

public class InfixToPostfix {

    // Method to check precedence of operators
    private static int precedence(char ch) {
        return switch (ch) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            case '^' -> 3;
            default -> -1;
        };
    }

    // Method to check if character is an operand
    private static boolean isOperand(char ch) {
        return Character.isLetterOrDigit(ch);
    }

    // Method to convert infix to postfix expression
    public static String infixToPostfix(String expression) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char c : expression.toCharArray()) {
            if (isOperand(c)) {
                result.append(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                if (!stack.isEmpty() && stack.peek() != '(')
                    return "Invalid Expression"; // invalid
                else
                    stack.pop();
            } else { // operator
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    result.append(stack.pop());
                }
                stack.push(c);
            }
        }

        // Pop all remaining operators
        while (!stack.isEmpty()) {
            if (stack.peek() == '(')
                return "Invalid Expression";
            result.append(stack.pop());
        }

        return result.toString();
    }

    // Main method
    public static void main(String[] args) {
        String infixExpr = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println("Infix Expression: " + infixExpr);

        String postfixExpr = infixToPostfix(infixExpr);
        System.out.println("Postfix Expression: " + postfixExpr);
    }
}
 