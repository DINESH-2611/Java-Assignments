package OOps;

public class Bag extends Box implements Int1,Int2,Int3,Int4,Int5{
	String color="black";
	int size=10;
	String shape="Rectangle";
	String state="open";
	
	public void store() {
		System.out.println("Bag writing");
	}
	
	public void clean() {
		System.out.println("Bag cleaning");
	}
	
	
	public void open() {
		System.out.println("Bag opening");
	}
	
	public void close() {
		System.out.println("Bag closing");
	}
	
	
	

}
