import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;


public class SortStringsArray {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.println("n=");
		int n=input.nextInt();
		TreeSet<String> sortedStrings=new TreeSet<String>();
		System.out.println();
		for (int i = 0; i < n; i++) {
			System.out.printf("String[%d]=", i);
			sortedStrings.add(input.next());
			//System.out.println();
		}
		System.out.println("Here are the sorted strings:");
		for (String text : sortedStrings) {
			System.out.println(text);			
		}
	}

}
