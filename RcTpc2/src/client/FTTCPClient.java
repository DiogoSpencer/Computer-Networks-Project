/**
 * FTTCPClient - File TCP Transfer Client
 * A client that can send files to a FTTCPServer
 * Initial material for background to Assignment 3
 */
package client;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class FTTCPClient {

    static final int BLOCKSIZE = 1024; // you can change if you want
	

	public static void main(String[] args) throws Exception {
		if( args.length != 3 ) {
			System.out.println("usage: java FTTCPClient <host> <port> <filename>") ;
		}
		
		System.out.println(args[0]);
		System.out.println(args[1]);
		System.out.println(args[2]);
		File f = new File(args[2]);
		
		Socket s = new Socket(args[0], Integer.parseInt(args[1]));
		OutputStream os = s.getOutputStream();
	    InputStream is = s.getInputStream();
		
		FileInputStream i = new FileInputStream(f);
		
		
		 byte[] buf = new byte[BLOCKSIZE] ;
		for (int n=0; n<BLOCKSIZE; n++ ) {  
		    // Read data sent by the client
			int send = is.read();
			if ( send!=-1 ) buf[n]=(byte)send;
			}
		
		os.write(buf);
		
		
		
			
	}
}
