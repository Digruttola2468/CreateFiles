

import javax.swing.JOptionPane;		//Lib
import java.io.File;			//file management
import java.io.IOException;
import java.awt.Dimension;
//		Reader
import java.io.BufferedReader;
import java.io.FileReader;


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
        String Name = JOptionPane.showInputDialog(null,"Colocar la extencion si no es Block de Nota\nNombre Fichero: ");
        
        if(!Name.contains("."))
            Name = Name + ".txt";
        
        File archivo = new File(direccion + "\\" + Name);
  
        if(archivo.exists()){
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
  
        }else
            JOptionPane.showMessageDialog(null,"No Existe");

     }





    //Moverse de Ruta
    public String MoveFile(String direccion){
        File UbicacionActual = new File(direccion);
        
        String lugar = JOptionPane.showInputDialog("Ruta: " + UbicacionActual.getAbsolutePath() + "\nCopie la Ruta y dejelo en donde quiera transladarse");
        
        File Verificar = new File(lugar);
        
        if(Verificar.isDirectory() == false){
            JOptionPane.showMessageDialog(null,"Error de la Ruta");
            return lugar = "";
        }else
           return lugar;
     }
     
}
