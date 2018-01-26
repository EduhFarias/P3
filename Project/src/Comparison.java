
import java.util.Scanner;

public class Comparison {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int num1, num2;
		
		System.out.println("Enter first integer: ");
		num1 = input.nextInt();
		
		System.out.println("Enter second integer: ");
		num2 = input.nextInt();
		
		if(num1 == num2){
			System.out.printf("%d == %d\n", num1, num2);
		} 
		
		if(num1 != num2){
			System.out.println(num1 + " != " + num2);
		} 
		
		if(num1 < num2){
			System.out.println(num1 + " < " + num2);
		}
		
		if(num1 > num2){
			System.out.println(num1 + " > " + num2);
		}
		
		if(num1 <= num2){
			System.out.printf("%d <= %d\n", num1, num2);
		}
		
		if(num1 >= num2){
			System.out.printf("%d >= %d\n", num1, num2);
		}
	}

}
