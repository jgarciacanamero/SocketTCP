package cliente;

import java.awt.event.*;
import java.io.*;
import java.net.*;



public class recuperarListener implements ActionListener{
	
	private ventanaCliente v;
	int puerto =5002;
	String host="localhost";
	String mensaje=null;
	

	recuperarListener(ventanaCliente v){
		this.v=v;
		
	}


	public void actionPerformed(ActionEvent e) {
		
		
		
	//conectamos con el servidor
		try{
			String codigoCiudad= String.valueOf(v.combo.getSelectedIndex());
			String envio= codigoCiudad;
			
			Socket conexion= new Socket(host,puerto);
			PrintWriter out= new PrintWriter(conexion.getOutputStream(),true);
			out.println(envio);
			out.flush();
			
			//recuperamos respuesta del servidor
			
			BufferedReader lectorSocket= new BufferedReader(new InputStreamReader(conexion.getInputStream()));
			while ((mensaje=lectorSocket.readLine())!= null){
				System.out.println("ini|"+codigoCiudad+"|"+ mensaje+"fin");
			}
			conexion.close();
			
		}
		catch(UnknownHostException ex){
			System.out.println("El host no existe");
		}
		catch(IOException ex){
			System.out.println("Error en la entrada/salida de datos");
		}
	}

	
	
}
