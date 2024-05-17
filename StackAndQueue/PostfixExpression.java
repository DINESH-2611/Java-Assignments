package StackAndQueue;

import java.util.Scanner;
import java.util.Stack;

public class PostfixExpression {

    static int chracterPrecedence(char ch) {
        return switch (ch) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            case '^' -> 3;
            default -> -1;
        };
    }

    static String infixToPostfix(String infix) {
        StringBuilder res = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);
            if (Character.isLetterOrDigit(c))
                res.append(c);
            else if (c == '(')
                stack.push(c);
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(')
                    res.append(stack.pop());

                if (!stack.isEmpty() && stack.peek() != '(')
                    return "Invalid Expression";
                else
                    stack.pop();
            }
            else {
                while (!stack.isEmpty() && chracterPrecedence(c) <= chracterPrecedence(stack.peek())) {
                    if (stack.peek() == '(')
                        return "Invalid Expression";
                    res.append(stack.pop());
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            if (stack.peek() == '(')
                return "Invalid Expression";
            res.append(stack.pop());
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the string");
        String s= scanner.nextLine();
//        String infixExpression = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println("Infix expression: " + s);
        System.out.println("Postfix expression: " + infixToPostfix(s));
    }
}