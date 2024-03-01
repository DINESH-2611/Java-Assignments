package OOps;

public class Box extends Pen implements Int1,Int2,Int4{
	String color="blue";
	int size=7;
	String shape="cuboid";
	String state="close";
	
	
	
	public void open() {
		System.out.println("Box opening");
	}
	
	public void close() {
		System.out.println("Box closing");
	}
	public void isTheft() {
		System.out.println("Box is theft");
	}

	

}
