/**
read, input are inbound stream;
write, output are outbound stream;
read, write are charater stream;
input, output are byte stream.

NOTE:
=================================
read, write are using for text files accessing(Chinese/Other 4-byte code support);
input, output are using for binary file accessing(Not support the Chinese/Other 4-byte code).
*/

import java.io.*;

class ReadAndInput {
	public static void main(String[] args) throws Exception{
		//Input the full path of the file location
		String filePath="/Users/JOEL/Downloads/Room Rent/address.txt";
		//By using file read
		readFileByFileReader(filePath);
		//By using file input stream
		readFileByInputStream(filePath);
	}
	
	static void readFileByFileReader(String filePath) throws Exception{
		//Instant a file read(inbound charater stream componement/object, and pass the file location path to it;
		FileReader fReader=new FileReader(filePath);
		//Use read() mtehod of file read instant to read a charater of the file and return the ASCII(int); 
		int temp;
		temp=fReader.read();
		
		System.out.println("File content by using FileReader:\n=====================================");
		//Keep reading the charaters in the file until the ASCII value less than 0(ASCII defined from 0);
		while(temp>0){
			System.out.print((char)temp);
			temp=fReader.read();
		}
		//Close the instant of the file reader to collected back the sources of it by the JVM.
		fReader.close();
		System.out.println("\n=====================================");
	}
	
	static void readFileByInputStream(String filePath) throws Exception{
		FileInputStream fInputStream=new FileInputStream(filePath);
		
		int temp=fInputStream.read();
		System.out.println("File content by using FileInputStream:\n=====================================");
		while (temp>0) {
			System.out.print((char)temp);
			temp=fInputStream.read();
		}
		fInputStream.close();
		System.out.println("\n=====================================");
	}
}