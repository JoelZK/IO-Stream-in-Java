import java.io.*;

class WriteAndOutput {
	public static void main(String[] args) throws Exception{
		String filePath="IO/Test.jpg";
		String copyTo="IO/Test_copy.jpg";
		//By using Write stream;
		//copyFileByFileReadWrite(filePath, copyTo);
		//By using Output stream;
		copyFileByFileInputOutput(filePath, copyTo);
	}
		
//FileReader and FileWriter unable to use to copy a un-Text file(Text File access only)	
	static void copyFileByFileReadWrite(String filePath, String copyTo) throws Exception{
		FileReader fReader=new FileReader(filePath);
		FileWriter fWriter=new FileWriter(copyTo);
		
		int temp=fReader.read();
		while(temp>=0){
			fWriter.write(temp);
			temp=fReader.read();
		}
		//Using flush() method to avoid some of the stream left in the pipe;
		fWriter.flush();
		fReader.close();
		fWriter.close();
	}
	
		
//FileInputStream and FileOutputStream are able to use on both Text files and Binary files(But 2-Byte code file not support)	
	static void copyFileByFileInputOutput(String filePath, String copyTo) throws Exception{
		FileInputStream fInputStream=new FileInputStream(filePath);
		FileOutputStream fOutputStream=new FileOutputStream(copyTo);
		
		int temp=fInputStream.read();
		while(temp>=0){
			fOutputStream.write(temp);
			temp=fInputStream.read();
		}
		fOutputStream.flush();
		fInputStream.close();
		fOutputStream.close();
	}	
}
