
import javax.swing.JOptionPane;
import java.io.File;

public class Main {
    boolean Mostrar;

    public static void main(String args[]) {

        Archivos txt = new Archivos();

        File archivo = new File("");

        for (int i = 0; i < 10; i++) {
            String Eleccion = JOptionPane.showInputDialog(null, "Ruta: " + archivo.getAbsolutePath()
                    + "\n1.CrearFichero\n2.CrearCarpeta" + "\n3.LeerFichero\n4.MoverseRuta" + "\n5.Salir");

            switch (Eleccion) {
            case "1":
                txt.Ficheros(archivo.getAbsolutePath());
                break;

            case "2":
                txt.Carpetas(archivo.getAbsolutePath());
                break;

            case "3":

                txt.LeerFicheros(archivo.getAbsolutePath());
                break;

            case "4":
                String direccion = txt.MoveFile(archivo.getAbsolutePath());
                archivo = new File(direccion);
                System.out.println("La direccion es: " + direccion);
                break;

            case "5":
                JOptionPane.showMessageDialog(null, "Que tenga un Lindo Dia");
                System.exit(0);
                break;

            default:
                JOptionPane.showMessageDialog(null, "Error en la Eleccion");
            }
        }

        JOptionPane.showMessageDialog(null, "Que tenga un Lindo Dia");
    }

}
