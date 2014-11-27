package cliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class temperaturaMedia implements ActionListener {

	ventanaCliente v;
	recuperarListener r;
	
	public temperaturaMedia(ventanaCliente v){
		
		this.v=v;
		
	}
	
	public void actionPerformed(ActionEvent arg0) {
		
		// indica el nombre de la ciudad en el textfield
		this.v.city.setText(String.valueOf(v.combo.getSelectedItem()));
		
		//indica la temperatura media en el textfield
		try {
			this.v.temp.setText(calcularMedia(Integer.toString(v.combo.getSelectedIndex())));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		this.v.city.setVisible(true);
		this.v.media.setVisible(true);
		this.v.temp.setVisible(true);
		this.v.c.setVisible(true);
		
		
		
	}
	
	
	// metodo que calcula la media de la temperatura por ciudad 
	public String calcularMedia(String dato) throws IOException{
		
		String cadena;
		StringTokenizer marca;
		FileReader r= new FileReader("datos_ciudades.txt");
		BufferedReader b = new BufferedReader(r);
		ArrayList<String> temp= new ArrayList <String>();
		int i=0;
		
		String codigo=null, temperatura=null;
		int elemento = 0;
		
		try {
			
			while((cadena=b.readLine())!=null){
				  marca= new StringTokenizer(cadena,",;");
				 
				 while(marca.hasMoreTokens()){
					 
					 codigo= marca.nextToken();
					 temperatura= marca.nextToken();
					 if(codigo.equals(dato)){
						  
						 temp.add(temperatura);
						  
					  }
					   
				 }
				 for(String s : temp){
					 elemento+=Double.parseDouble(s);
					 i++;
					 
				 }
				 }
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Integer.toString(elemento=elemento/i);
		
	}

}
