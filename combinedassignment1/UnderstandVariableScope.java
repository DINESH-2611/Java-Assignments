package combinedassignment1;

import java.util.Scanner;

public class UnderstandVariableScope {
    public static void main(String[] args) {
        int temp=10;
        if(temp%2==0){
            String ans="Even";
            System.out.println(temp);
            System.out.println(ans);

        }
        System.out.println(temp);
//        System.out.println(ans);//cannot resolve symbol ans`

    }

}
