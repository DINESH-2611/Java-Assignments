package OOps;

public class Pen implements Int1{
	String color="Red";
	int size=3;
	String shape="Cylinder";
	String state="open";
	
	public void write() {
		System.out.println("Pen writing");
	}
	
	public void open() {
		System.out.println("Pen opening");
	}
	
	public void close() {
		System.out.println("Pen closing");
	}
	

}
