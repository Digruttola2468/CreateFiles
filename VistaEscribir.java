import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class VistaEscribir extends JFrame implements ActionListener{
	
	JTextArea taEscribir;
	JButton btGuardar,btVolver,btAgregarFichero;
	JScrollPane scroll;
	JFileChooser chooser;
	JLabel ruta;
	
	public VistaEscribir() {
		
		setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Escribir Fichero");
		setSize(460,500);
		setDefaultCloseOperation(3);
		
		ruta = new JLabel("");
		ruta.setBounds(20,0,400,20);
		add(ruta);
		
		taEscribir = new JTextArea(5,5);
		taEscribir.setBounds(20,20,400,400);
		taEscribir.setBorder(BorderFactory.createLineBorder(Color.black));
		//add(taEscribir);
		
		scroll = new JScrollPane(taEscribir);
		scroll.setBounds(20,20,400,400);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(scroll);
		
		btVolver = new JButton("<----");
		btVolver.setBounds(10,430,75,20);
		btVolver.addActionListener(this);
		add(btVolver);
		
		btAgregarFichero = new JButton("Otro Fichero");
		btAgregarFichero.setBounds(130,430,130,20);
		btAgregarFichero.addActionListener(this);
		add(btAgregarFichero);
		
		btGuardar = new JButton("Guardar");
		btGuardar.setBounds(310,430,100,20);
		btGuardar.addActionListener( this);
		add(btGuardar);
		
		chooser = new JFileChooser("");
		chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == btGuardar) {
			
			try {
				
				FileWriter escribir = new FileWriter(chooser.getSelectedFile().getAbsolutePath());
				escribir.write(taEscribir.getText());
				
				JOptionPane.showMessageDialog(null, "Se ha Guardado Correctamente");
				taEscribir.setText("");
				
				String rutaVieja = ruta.getText();
				ruta.setText("Ruta anterior: " + rutaVieja);
				
				escribir.close();
				
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(null, e1);
				e1.printStackTrace();
			}
			
		}
		
		if(e.getSource() == btAgregarFichero) {
			int seleccion = chooser.showSaveDialog(null);
			if(seleccion == chooser.APPROVE_OPTION) {
				 
				 File archivo = new File(chooser.getSelectedFile().getAbsolutePath());
				 
				 ruta.setText(archivo.toString());
				 
				 FileReader Leer;
	             BufferedReader lea;
	   
	             String Texto = "", bfRead;
	   
	             try{
	                 Leer = new FileReader(archivo.getAbsolutePath());
	                 lea = new BufferedReader(Leer);
	                 
	                 String completo = "";
	                 while( (bfRead = lea.readLine()) != null){
	                	Texto += bfRead; 			//Texto = Texto + Leer
	                 	completo = completo + Texto;
	                 	completo += "\n";
	                 	Texto = "";
	                 }
	                 
	                 taEscribir.setText(completo);
	                 
	             }catch (IOException ex) {
	            	 JOptionPane.showMessageDialog(null, ex);
	             }
			
		}
		
		if(e.getSource() == btVolver) {
			
		}
		
	}
	
	}
	
	
}