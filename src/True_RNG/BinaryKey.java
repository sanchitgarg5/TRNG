package True_RNG;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BinaryKey {
	public void generatekey()
	{
		int size=0;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("How many bit key do you want?");
		
		try {
			size=Integer.parseInt(br.readLine());
		}
		catch(Exception E){}
		
	BufferedReader in = null;
	char[] cbuf=new char[size];
	try {
		
		in = new BufferedReader(new FileReader("C:\\Users\\Sanchit Garg\\Desktop\\IIIT\\Java Programs\\Project\\DataFiles\\44000.txt"));
		in.read(cbuf, 0, size);
	} catch (FileNotFoundException e) {
		
		e.printStackTrace();
	}
     catch (IOException e) {
		
		e.printStackTrace();
		
	}
     finally{
    	 try {
		in.close();
	} catch (IOException e) {
		
		e.printStackTrace();
	}
	}
     int i;
     String s=new String();
     
     for(i=0;i<size;i++){
    	 s=s+cbuf[i];
     }
     System.out.println(s);
	}
	
	

}
