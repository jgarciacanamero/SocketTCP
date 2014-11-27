package servidor;

import java.net.*;
import java.io.*;

public class iniciarServidor {
	
	public static void main (String[]ar){
		int puerto=5002;
		
		try{
			
			ServerSocket servidor= new ServerSocket(puerto);
			
			while(true){
				System.out.println("Esperando petición...");
				//cuando recibe una petición desde un cliente crea un hilo para atenderlo
				//y le pasa el socket que representa la conexion con el cliente
				
				Socket con = servidor.accept();
				(new ProcesaConexion(con)).start();
			}
			
		}
		catch(UnknownHostException e){
			System.out.println("El host indicado no existe");
		}
		catch(IOException e){
			e.printStackTrace();
			System.out.println("Error en la entrada/salida de datos");
		}
		
	}

}
