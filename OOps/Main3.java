package OOps;

public class Main3 {
	public static void main(String[] args) {
		 Bag bag=new Bag();
		 System.out.println("Bag color : "+bag.color);
		 System.out.println("Bag shape : "+bag.shape);
		 System.out.println("Bag size : "+bag.size);
		 System.out.println("Bag state : "+bag.state);
		 bag.clean();
		 bag.close();
		 bag.open();
		 bag.store();
		 bag.isTheft();
		 bag.write();
		 System.out.println("-----------------");
		 Box box=new Bag();
		 System.out.println("Box color : "+box.color);
		 System.out.println("Box shape : "+box.shape);
		 System.out.println("Box size : "+box.size);
		 System.out.println("Box state : "+box.state);
		 box.close();
		 box.open();
		 box.isTheft();
		 box.write();
		 System.out.println("-----------------");
		 Pen pen=new Bag();
		 System.out.println("Pen color : "+pen.color);
		 System.out.println("Pen shape : "+pen.shape);
		 System.out.println("Pen size : "+pen.size);
		 System.out.println("Pen state : "+pen.state);
		 pen.close();
		 pen.open();
		 pen.write();
		 
	}
}
/*Output
 * Bag color : black
Bag shape : Rectangle
Bag size : 10
Bag state : open
Bag cleaning
Bag closing
Bag opening
Bag writing
Box is theft
Pen writing
-----------------
Box color : blue
Box shape : cuboid
Box size : 7
Box state : close
Bag closing
Bag opening
Box is theft
Pen writing
-----------------
Pen color : Red
Pen shape : Cylinder
Pen size : 3
Pen state : open
Bag closing
Bag opening
Pen writing
*/
