package Collections;

import java.util.Stack;

public class ParanthesisCheckerStack {
    public static boolean checkBalancedParentheses(String expression) {
        Stack<Character> stack = new Stack<>();

        for (char c : expression.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if ((c == ')' && top != '(') || (c == ']' && top != '[') || (c == '}' && top != '{')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String balancedExpression = "{[()]()}";
        String unbalancedExpression = "{[()()]";

        System.out.println("Is '" + balancedExpression + "' balanced? " + checkBalancedParentheses(balancedExpression));
        System.out.println("Is '" + unbalancedExpression + "' balanced? " + checkBalancedParentheses(unbalancedExpression));
    }
}
