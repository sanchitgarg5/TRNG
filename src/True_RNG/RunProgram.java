package True_RNG;

import java.util.Scanner;

public class RunProgram {

	/**
	 * @param args
	 */
	public RunProgram (){
		int i;
		System.out.println("1.Generate random Numbers");
		System.out.println("2.Generate Password");
		System.out.println("3.Generate a binary Key");
		System.out.println("Enter Your Choice");
		Scanner scan = new Scanner(System.in);
		int choice=scan.nextInt();
		switch(choice){
		case 1: 
		        GenerateNumber GN = new GenerateNumber();
		        Integer[] array=GN.input();
		        System.out.println("The random Number Generated are");
		        for(i=0;i<array.length;i++){
		        	System.out.println(array[i]);
		        }
		        break;
		
		case 2: PasswordGenerator PG=new PasswordGenerator();
		        PG.ReadSymbols();
		        break;
		case 3: BinaryKey BK=new BinaryKey();
		        BK.generatekey();
		        break;
		        
		default:System.out.println("Entered the wrong Choice program Exiting....");
		
		}
		
		System.out.println("Thankyou for using the program!");
		
		
	}

}
