/**
*Buffered Input/Output Stream is faster than FileInput/OutputStream.
*Setting the suitable buffer size could make the progress more effeciency.
*/
import java.io.*;

class BufferedInputOutputStream {
	public static void main(String[] args) throws Exception{
		String filePath="/IO/test.jpg";
		String copyTo="/IO/test_copy.jpg";
		//using buffered Input/Output Stream to copy a file;
		copyByBufferedInputOutputStream(filePath, copyTo);
	}
	
	static void copyByBufferedInputOutputStream(String filePath, String copyTo) throws Exception{
		//Instants the buffered IO stream should give an Input/Output Stream type instant as argument.
		BufferedInputStream bis=new BufferedInputStream(new FileInputStream(filePath));
		BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(copyTo));
		//Set a byte type of array as buffer space. Array length is the size of buffer space.
		byte[] buffer=new byte[2048];
		//Buffered input stream read() method with an arguement which is a byte type array(Read with buffer).
		System.out.println("Copy Progress Started");
		int temp=bis.read(buffer);
		while(temp>=0){
			//Buffered output stream write() method with three arguesments which are buffer(byte[]), offset(int) and the length of reading each time(int);
			bos.write(buffer, 0, temp);	//Using the length of BufferedInputStream read() method result is for avoid the error if last data need to write is not enough to the size of buffer.
			temp=bis.read(buffer);
		}
		bos.flush();
		
		bis.close();
		bos.close();
		System.out.println("Buffered IO Copy Progress Finished");
	}
}
