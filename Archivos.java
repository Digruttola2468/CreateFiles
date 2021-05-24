

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;		//Lib
import java.io.File;			//file management
import java.io.IOException;
import java.awt.Dimension;
//		Reader
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;


public class Archivos {

    //Creacion de Ficheros
    public void Ficheros(String direccion){
        String nombre = JOptionPane.showInputDialog("Opcional colocar la extencion" + 
                              "\nNombre del Fichero:");
        
        //Comprobacion si tiene colocado la extencion
        if(!nombre.contains(".")){
           nombre = nombre + ".txt";
        }
        
        try{
       
           File archivo = new File(direccion + "\\" + nombre);
           if(!archivo.exists()){
           archivo.createNewFile();
           JOptionPane.showMessageDialog(null,"**********Archivo Creado*********" + 
                        "\nNombre: " + archivo.getName() + 
                        "\nRuta Completa: " + archivo.getAbsolutePath() + 
                        "\nByte: " + archivo.length());
       }else{
            JOptionPane.showMessageDialog(null,"Ya existe");
            Ficheros(direccion);
        }

        }catch(IOException e){JOptionPane.showMessageDialog(null,"Error: " + e);}
     }






     //Creacion de Carpetas
     public void Carpetas(String direccion){
        //Pedimos el Nombre de la Carpeta a crear
        String Name = JOptionPane.showInputDialog("Nombre de la Carpeta: ");
        
        try{
            //Se guardara en la direccion + Name de la carpeta
            File archivo = new File(direccion + "\\" + Name);

            if(!archivo.exists()){
                archivo.mkdir();    //Creamos la carpeta
                JOptionPane.showMessageDialog(null, "La Carpeta Creada con Exito");
            }
            else
                JOptionPane.showMessageDialog(null,"Ya Existe");
            
        }catch(Exception e){JOptionPane.showMessageDialog(null,"Error: " + e);}
     }




    //Lectura de Archivos
    public void LeerFicheros(String direccion){
    	
    	JFileChooser chooser = new JFileChooser(direccion);
    	chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
    	int i = chooser.showSaveDialog(null);
    	
    	if( i == chooser.APPROVE_OPTION) {
    		File archivo = new File(chooser.getSelectedFile().getAbsolutePath());
    		
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
             //Mostramos lo Leido en un CampoDeTexto
             javax.swing.JTextArea textArea = new javax.swing.JTextArea(completo);
             javax.swing.JScrollPane scrollPane = new javax.swing.JScrollPane(textArea);  
             textArea.setLineWrap(true);         //Metodo Nuevo
             textArea.setWrapStyleWord(true);    //Metodo Nuevo
             scrollPane.setPreferredSize( new Dimension( 500, 500 ) );   //MetodoNuevo
             JOptionPane.showMessageDialog(null,scrollPane);

             }catch(Exception e){JOptionPane.showMessageDialog(null,"Error: " + e);}
   
    	}

     }


    //Moverse de Ruta
    public String MoveFile(String direccion){
        
    	JFileChooser chooser = new JFileChooser(direccion);
    	chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    	int i = chooser.showSaveDialog(null);
    	
    	if( i == chooser.APPROVE_OPTION) {
    		return chooser.getSelectedFile().getAbsolutePath();
    	}else
    		return "";
    	
     }
     
}

