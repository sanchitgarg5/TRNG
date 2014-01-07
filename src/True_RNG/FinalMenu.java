package True_RNG;
import java.util.*;
public class FinalMenu {
	public static void main(String[] args){
		System.out.println("True random Number Generator");
		System.out.println("1.Enter 1 to generate a new data file");
		System.out.println("2.Enter 2 to use the random number generator");
		System.out.println("Enter Your Choice");
		Scanner scan = new Scanner(System.in);
		int choice=scan.nextInt();
		switch(choice){
		case 1: combined c=new combined();
		        break;
		case 2: RunProgram run=new RunProgram();
		        break;
		default:System.out.println("Entered the wrong Choice program Exiting....");
		
		}
	}

}
