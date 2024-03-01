package OOps;

public class Main5 {
	public static void main(String[] args) {
         Int1 int1=new Box();
         int1.close();
         int1.open();
         int1.write();
         System.out.println("--------------");
         Int2 int2=new Box();
         int2.open();
         int2.close();
         int2.isTheft();
         System.out.println("---------------");
         Int4 int4=new Box();
         int4.open();
         int4.close();
         int4.write();
         int4.isTheft();
         
	}

}
/*
 * Box closing
Box opening
Pen writing
--------------
Box opening
Box closing
Box is theft
---------------
Box opening
Box closing
Pen writing
Box is theft
*/
