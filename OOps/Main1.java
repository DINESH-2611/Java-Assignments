package OOps;

public class Main1 {
	public static void main(String[] args) {
		Pen p=new Pen();
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
 * Pen color : Red
Pen shape : Cylinder
Pen size : 3
Pen state : open
Pen closing
Pen opening
Pen writing*/
 