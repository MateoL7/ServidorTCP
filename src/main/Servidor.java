package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.*;
import java.util.Calendar;
import java.util.Scanner;

public class Servidor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {

			ServerSocket server = new ServerSocket(5000);

			System.out.println("Esperando conexion");
			Socket socket = server.accept();
			System.out.println("Conectado");
			
			String path = "D:\\Documents\\Quinto Semestre\\ProRed\\Test\\Enviar\\java.pdf";
			File file = new File(path);
			String ab = file.getAbsolutePath();
			System.out.println(ab);
			
			boolean works = file.exists();
			System.out.println(works);
			
			FileInputStream fis = new FileInputStream(file);
			OutputStream os = socket.getOutputStream();
			
			byte[] buffer = new byte[128];
			int readBytes = 0;
			
			double before = System.currentTimeMillis();
			while((readBytes = fis.read(buffer)) != -1) {
				System.out.println(readBytes);
				os.write(buffer, 0, readBytes);
				
			}
			double after = System.currentTimeMillis();
			fis.close();
			os.close();
			double time = after - before;
//			System.out.println(time);
			
			while(true) {}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			

			//ESTO LO USAMOS PARA LO DEL MENSAJE A MI MISMO

//			InputStream is = socket.getInputStream();
//			InputStreamReader isr = new InputStreamReader(is);
//			BufferedReader br = new BufferedReader(isr);
//
//			OutputStream os = socket.getOutputStream();
//			OutputStreamWriter osw = new OutputStreamWriter(os);
//			BufferedWriter bw = new BufferedWriter(osw);
//
//			String aw = "Recibido bb <3";
//
//			while(true) {
//				//Leer mensaje
//				String line = br.readLine();
//				System.out.println("Mensaje recibido: " + line);
//
//				//Enviar respuesta
//				if(line.equalsIgnoreCase("Hora")) {
//					Calendar c = Calendar.getInstance();
//					aw = c.getTime().toString();
//					bw.write(aw + "\n");
//					bw.flush();
//				}else {
//					bw.write(aw + "\n");
//					bw.flush();
//				}			
//			}


		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
