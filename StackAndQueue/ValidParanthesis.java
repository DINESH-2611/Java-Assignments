package StackAndQueue;

import java.util.Scanner;
import java.util.Stack;

public class ValidParanthesis {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String s=scanner.nextLine();
//        String str="(()){}{}{}{({})}";
        if(isValid(s)){
            System.out.println("Valid");
        }
        else
            System.out.println("Invalid");

    }
    public static boolean isValid(String str){
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<str.length();i++){
            char charAt=str.charAt(i);
            if(charAt=='(')
                stack.push(')');
            else if(charAt=='[')
                stack.push(']');
            else if(charAt=='{')
                stack.push('}');
            else if(stack.isEmpty() || stack.pop() != charAt){
                return false;
            }
        }
        return stack.isEmpty();
    }
}
