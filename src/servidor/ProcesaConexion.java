package servidor;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

public class ProcesaConexion extends Thread{
	Socket sc;
	
	
	public ProcesaConexion(Socket sc){
		this.sc=sc;
		
		
	}
	public void run(){
		try{
			
			PrintWriter out = new PrintWriter(sc.getOutputStream());
			BufferedReader bf= new BufferedReader (new InputStreamReader(sc.getInputStream()));
			
			//recupera los datos enviados por el cliente al establer la conexión
			String dato= bf.readLine();
			//System.out.println(dato);
		
			
			//agrega el resto de datos necesarios 
			String datos= montarCadena(dato);
			out.println(datos);
			out.flush();
			Thread.sleep(100);
			sc.close();
			
			
		}
		catch(IOException e){
			System.out.println("Error en la entrada/salida de datos");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String montarCadena(String dato) throws IOException{
		
		FileReader reader= new FileReader("datos_ciudades.txt");
		BufferedReader buffer = new BufferedReader(reader);
		String cadena;
		StringBuilder cadenaCompleta= new StringBuilder();
		String codigo_ciudad=null, temperatura=null;
		StringTokenizer marca;
		ArrayList <String> temperaturasFiltradas= new ArrayList<String>();
		String elemento="";
		
		while((cadena=buffer.readLine())!=null){
			  marca= new StringTokenizer(cadena,",;");
			 
			 while(marca.hasMoreTokens()){
				 
				  codigo_ciudad= marca.nextToken();
				  temperatura= marca.nextToken();
				  
				  if(codigo_ciudad.equals(dato)){
					  
					 temperaturasFiltradas.add(temperatura+"|");
					  
				  }
				   
			 }
			 
			 for(String s : temperaturasFiltradas){
				 elemento+=s;
			 }
			
			
	}
		
		return elemento;
		
	}
	

}
