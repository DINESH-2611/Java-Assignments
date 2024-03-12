package ProblemSolving;

public class AllOfByOne {
	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Enter the size of 1st array");
		int n1=sc.nextInt();
		System.out.println("Enter the size of 2nd array");
		int n2=sc.nextInt();
		if(n1!=n2) {
			System.out.println(false);
			return;
		}
		int[] a= new int[n1];
		int[] b=new int[n2];
		for(int i=0;i<n1;i++){
			System.out.println("Enter the elements of 1st array");
			a[i]=sc.nextInt();
		}
		for(int i=0;i<n2;i++){
			System.out.println("Enter the elements of 2nd array");
			b[i]=sc.nextInt();
		}
		
		System.out.println(isSame(a, b, 0));
	}
	
	public static boolean isSame(int[] a,int[] b,int index) {
		if(index==a.length)
			return true;
		if(a[index]+1!=b[index])
			return false;
		return isSame(a, b, index+1);
	}

}
