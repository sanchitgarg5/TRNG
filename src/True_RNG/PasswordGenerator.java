package True_RNG;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class PasswordGenerator {
	
	char[] Symbols=new char[64];
	

	public void ReadSymbols()
	{
		BufferedReader in=null;
		try {
					int i=0;
					 in = new BufferedReader(new FileReader("Symbols.txt"));
					
					 String S=in.readLine();
					 
					Symbols= S.toCharArray();
					 
					 
					/*for(i=0; i<Symbols.length; i++)
						System.out.println(Symbols[i]);*/
				
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		         catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					
				}
		         try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		         GeneratePass();
	}
	
	public void GeneratePass()
	{
		int len=0;
		String Password = new String();
		
		GenerateNumber gn=new GenerateNumber();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("What length password do you want?");
		
		try {
			len=Integer.parseInt(br.readLine());
			Integer codeNo[]=new Integer[len];
			codeNo=gn.GenerateNos(len, 0,64);
			
			for(int i=0; i<len; i++)
			{
				Password=Password+Symbols[codeNo[i]];
			}
			
			
			
		} catch (NumberFormatException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		System.out.println(Password);
		
	}

}
