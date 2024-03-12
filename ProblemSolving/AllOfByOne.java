package ProblemSolving;

public class AllOfByOne {
	public static void main(String[] args) {
		int[] a= {4,15,40,99};
		int[] b= {5,16,41,100};
		if(a.length!=b.length) {
			System.out.println(true);
			return;
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
