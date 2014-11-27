package cliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class ventanaCliente extends JFrame implements ActionListener{
	JButton recuperar, salir;
	JLabel ciudad,c,media;
	JComboBox combo;
	JTextField city, temp;
	String[] ciudades={"Castellón","Valencia","Barcelona","Madrid","Sevilla","Zaragoza","Bilbao"};
	
	
	public ventanaCliente(String title, int x, int y, int w, int h){
		super(title);
		this.getContentPane().setLayout(null);
		this.setBounds(x, y, w, h);
		
		//Creamos controles
		
		ciudad= new JLabel("Seleccione ciudad:");
		ciudad.setBounds(80, 90, 300, 40);
		
		
		combo = new JComboBox(ciudades);
		combo.setBounds(260, 90, 100, 30);
		//System.out.println(combo.getSelectedIndex());

		
		recuperar= new JButton("Recuperar");
		recuperar.setBounds(90, 200, 150, 30);
		
		salir= new JButton("Salir");
		salir.setBounds(280, 200, 100, 30);
		
		c= new JLabel("Ciudad:");
		c.setBounds(80, 250, 200, 40);
		c.setVisible(false);
		
		media= new JLabel("Temperatura media:");
		media.setBounds(80,320,250,40);
		media.setVisible(false);
		
		city= new JTextField();
		city.setBounds(260, 250, 350, 40);
		city.setVisible(false);
		
		temp= new JTextField();
		temp.setBounds(260, 320, 350, 40);
		temp.setVisible(false);
		
		//añadimos controles al contenedos
		this.getContentPane().add(ciudad);
		this.getContentPane().add(combo);
		this.getContentPane().add(recuperar);
		this.getContentPane().add(salir);
		this.getContentPane().add(c);
		this.getContentPane().add(city);
		this.getContentPane().add(media);
		this.getContentPane().add(temp);
		
		// visualizamos ventana
		
		this.setVisible(true);
		
		//manejadores de evento
		recuperar.addActionListener(new recuperarListener(this));
		recuperar.addActionListener(new temperaturaMedia(this));
		salir.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e){
		this.dispose();
	}

}
