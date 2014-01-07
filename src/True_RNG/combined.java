package True_RNG;




class mouse implements Runnable
{
	
	MouseMotionEventDemo ob=new MouseMotionEventDemo();
	
	
	public void run()
	{
		ob.runmouse();
	}
	
	
}

class noise implements Runnable
{
	
	Sound ob=new Sound();
	
	
	public void run()
	{
		ob.captureAudio();
	}
	
	
}

	


public class combined
{
	//public static void main(String arg[])
	public combined()
	{
		
		mouse ob1=new mouse();
		noise ob2=new noise();
		Thread t1=new Thread(ob1);		
		Thread t2=new Thread(ob2);
		t2.start();		
		t1.start();
	}
}
