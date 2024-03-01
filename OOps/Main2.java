package OOps;

public class Main2 {
    public static void main(String[] args) {
    	 Box b=new Box();
         System.out.println("Box color : "+b.color);
         System.out.println("Box shape : "+b.shape);
         System.out.println("Box size : "+b.size);
         System.out.println("Box state : "+b.state);
         b.open();
         b.close();
         b.isTheft();
         b.write();
         System.out.println("------------");
    	 Pen p=new Box();
         System.out.println("Pen color : "+p.color);
         System.out.println("Pen shape : "+p.shape);
         System.out.println("Pen size : "+p.size);
         System.out.println("Pen state : "+p.state);
         p.close();
         p.open();
         p.write();
         
	}

}
/*
 * Output
 * Box color : blue
Box shape : cuboid
Box size : 7
Box state : close
Box opening
Box closing
Box is theft
Pen writing
------------
Pen color : Red
Pen shape : Cylinder
Pen size : 3
Pen state : open
Box closing
Box opening
Pen writing
*/
