package True_RNG;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.sound.sampled.*;

public class Sound {
	protected boolean running;
	//ByteArrayOutputStream out;
	//main constructor first this will execute
	/*public Sound() {

		captureAudio();
	}*/

	public  void captureAudio() {
		try {//try catch block
			final AudioFormat format = getFormat();//go to get format function line 147
			//A target data line is a type of DataLine from which audio data can be read.
			DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);// Constructs a data line's info object from the specified information, which includes a single audio format.
			final TargetDataLine line = (TargetDataLine)AudioSystem.getLine(info);//????
			line.open(format);//Opens the line with the specified format, causing the line to acquire any required system resources and become operational.
			line.start();
			Runnable runner = new Runnable() {
				int bufferSize = (int)format.getSampleRate()* format.getFrameSize();
				

				public void run() {
					int i;	
					
					File outputFile = new File("newfile.txt");
					//FileWriter fileWriter = null;
					//out = new ByteArrayOutputStream();//Creates a new byte array output stream.
					running = true;
					while (running) {
						byte buffer[] = new byte[bufferSize];
						
						FileWriter fileWriter = null;

						int count =line.read(buffer, 0, buffer.length);
						try {
							fileWriter = new FileWriter(outputFile, true);
							//System.out.println(buffer.length);
							for(i=0;i<buffer.length;i++){
								byte x=buffer[i];
								//System.out.println(x);
								//System.out.println(buffer[i]);
								String kuch=Integer.toBinaryString(x);
								//System.out.println(kuch.length());
								//System.out.println(kuch.charAt(kuch.length()-1));
								fileWriter.flush();
								fileWriter.write(kuch.charAt(kuch.length()-1));
								fileWriter.flush();
								//byte buffer[] = new byte[bufferSize];
							}
						} catch (IOException e) {
							e.printStackTrace();

						}     
					

						
						//if (count > 0) {
							//out.write(buffer, 0, count);

						//}
						//System.out.println(count);

					}//System.out.println("hi");
				}
			};
			Thread captureThread = new Thread(runner);
			captureThread.start();
		} catch (LineUnavailableException e) {
			System.err.println("Line unavailable: " + e);
			System.exit(-2);
		}
	}


	//return audio format with linear pcm encoding and given parameters
	private AudioFormat getFormat() {
		float sampleRate = 16000;//The number of samples played or recorded per second, for sounds that have this format.
		int sampleSizeInBits = 8;//The number of bits in each sample of a sound that has this format.
		int channels = 1;// 1:mono 2:stereo
		boolean signed = true;//indicates whether the data is signed or unsigned
		boolean bigEndian = true;//Indicates whether the audio data is stored in big-endian or little-endian order.
		return new AudioFormat(sampleRate, 
				sampleSizeInBits, channels, signed, bigEndian);
	}

	/*void runsound() {
		Sound c=new Sound();

	}*/
}
