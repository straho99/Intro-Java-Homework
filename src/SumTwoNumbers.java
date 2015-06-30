import java.util.Scanner;


public class SumTwoNumbers {

	public static void main(String[] args) {
		int a, b;
		Scanner input=new Scanner(System.in);
		System.out.print("a=");
		a=input.nextInt();
		System.out.println("b=");
		b=input.nextInt();
		System.out.printf("a+b = %d", (a+b));
		System.out.println();
		input.close();
	}

}
