package OOps;

public class Main6 {
	public static void main(String[] args) {
		Int1 int1=new Bag();
		int1.close();
		int1.open();
		int1.write();
		System.out.println("---------");
		Int2 int2=new Bag();
		int2.open();
		int2.close();
		int2.isTheft();
		System.out.println("------------");
		Int3 int3=new Bag();
		int3.open();
		int3.close();
		int3.store();
		int3.clean();
		System.out.println("------------");
		Int4 int4=new Bag();
		int4.open();
		int4.close();
		int4.write();
		int4.isTheft();
		System.out.println("---------------");
		Int5 int5=new Bag();
		int5.open();
		int5.close();
		int5.write();
		int5.store();
		int5.isTheft();
		int5.clean();
	}
	

}
