package exceptionhandling;

public class ArrayOutOfBounds {
    public static void main(String[] args) {
        try {
            System.out.println(args[0]);
        }catch (ArrayIndexOutOfBoundsException e){
//            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
