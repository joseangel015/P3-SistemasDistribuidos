//librerías
package client;
import java.io.*;

public class EchoClient {
    
    private static EchoObjectStub ss;//definimos el Stub del cliente
    
    public static void main(String[] args) 
    {
        String instruccion="";

        if (args.length<2) {// revisamos que los argumentos para ejecutar el programa son correctos
            System.out.println("Para ejecutar , hazlo en este formato: Echo <nombre o IP del Equipo> <numero de puerto>");
            System.exit(1);
        }
       
        ss = new EchoObjectStub(); //instanciamos el STUB
   
        ss.setHostAndPort(args[0],Integer.parseInt(args[1])); // le asignamos al STUB el puerto y nombre del equipo HOST (el nombre del servidor) 

        try {  
            while(true){//construyo un bucle infinito:
                //preparo "apuntador" que es el lector de flujo para el teclado
                BufferedReader in =
                new BufferedReader(new InputStreamReader(System.in));
                
                instruccion=in.readLine();// asigno a una variable y leo una linea del lector de flujo que leyo del teclado
                System.out.println(ss.echo(instruccion));// Invocar el stub con el metodo remoto echo e Imprimir por pantalla lo que regreso el metodo remoto echo

            }
        } catch (IOException e) {
            System.err.println("Falla conexion de E/S con el host:"+args[0]);
        }
    }
}
