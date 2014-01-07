package True_RNG;
import java.io.*;
public class GenerateNumber {
	
	  
	public Integer[] input()
	{
		int NoOfNumbers=0;
		int min=0; int max=0;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the number of random numbers you want :");
		
		try {
			NoOfNumbers=Integer.parseInt(br.readLine());
			System.out.println("Enter minimum number :");
			min=Integer.parseInt(br.readLine());
			System.out.println("Enter maximum number :");
			max=Integer.parseInt(br.readLine());
			
		}
		catch(Exception e){}
		Integer array[]=new Integer[NoOfNumbers];
		array=GenerateNos(NoOfNumbers, min, max);
		WriteToFile(array);
		return array;
		
	}
	
	public Integer[] GenerateNos(int num, int min, int max) //Takes no. of nos required and minimum and max number
	{
		int x=(int) Math.round(Math.log(max)/Math.log(2));
 		
        int i=0;
        int NoOfBitsToBeRead=x*num;
		char[] cbuf=new char[NoOfBitsToBeRead];
		BufferedReader in = null;
		
try {
		
			 in = new BufferedReader(new FileReader("newfile.txt"));
			in.read(cbuf, 0, NoOfBitsToBeRead);
		
		} catch (FileNotFoundException e) {
			
			System.out.println("Pls create a file first");
		}
         catch (Exception e) {
			
			
			
		}
         finally
         {
        	 try {
				in.close();
			} catch (Exception e) {
				
				System.exit(0);
			}
         }
         
         int base = 2;
         int decimal=0;
         int count=0;
         
         Integer Numbers[]=new Integer[num];
         
         while(i<NoOfBitsToBeRead){
        	 String s=new String();
               int j=0;
               while(j<x){
            	   s=s+cbuf[i];
            	   j++;
            	   i++;
            	   
            	   
               }
               
         
         decimal = Integer.parseInt(s, base);
         Numbers[count]=min+(decimal%(max-min));
         count++;
         
         
         }
         
		return Numbers;
	}
	public void WriteToFile(Integer[] array){
		File outputFile = new File("generatenumber.txt");
		FileWriter fileWriter = null;
		int i;
		try {
			fileWriter = new FileWriter(outputFile, true);
			for(i=0;i<array.length;i++){
				fileWriter.write(array[i].toString());
				fileWriter.write("  ");
				fileWriter.flush();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
		}finally
		{
			try {
				fileWriter.close();
			} catch (Exception e) {
				
				
			}
		}
	}
	
}
	      
		