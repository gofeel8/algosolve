import java.util.Scanner;

public class P11726 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		
		int[] A = new int[n+1];
		int[] B = new int[n+1];
		
		A[1] =1;
		
		for(int i=2;i<=n;i++) {
			A[i]=A[i-1]+B[i-1];
			B[i]=A[i-1];
		}
		
//		System.out.println(Arrays.toString(A));
//		System.out.println(Arrays.toString(B));
		
		System.out.println((A[n]+B[n])%10007);

	}

}
