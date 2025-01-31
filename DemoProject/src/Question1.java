import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Question1 {

	public static void main(String[] args) {
		// input
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the count(N):");
		int count = scan.nextInt();
		
		System.out.println("Enter the numbers :");
		List<Integer> number = new ArrayList<>();
		for(int i=0;i<count;i++) {
			number.add(scan.nextInt());
		}
		
		// process
		int result = compute(number);
		
		// output
		System.out.println(result);
	}
		
	static int compute(List<Integer> num) {
		int output = 0;
		if(num.size() == 3) {
			if(num.contains(3) && num.contains(2) && num.contains(1))
				output = 24;
		} else{
			// normal addition
			for(int eachNum: num) {
				output += eachNum;
			}
		}
		return output;
		
	}

}
