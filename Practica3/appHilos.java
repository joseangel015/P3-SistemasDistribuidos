package client;
import java.io.*;
import java.net.*;
public class appHilos {

    /**
     * @los parametros de args recuerden que los recibimos de lo que escribimso en consola 
     */
    public static void main(String[] args) {
        
        String cadena;
        String[] palabras;
         try {  
        
            while(true){
            //EJERCICIO: el bucle infinito:
                BufferedReader in =
                new BufferedReader(new InputStreamReader(System.in));//EJERCICIO: Leer de teclado leo del teclado 
                cadena=in.readLine();
                palabras = cadena.split(" ");
                     //EJERCICIO: Invocar el stub
                //EJERCICIO: Imprimir por pantalla
                if(palabras[0].equals("suma")){
                    operacion suma = new operacion(palabras[1],palabras[2],"suma");
                    suma.start();
                }else if(palabras[0].equals("multiplicacion")){
                    operacion multi = new operacion(palabras[1],palabras[2],"multiplicacion");
                    multi.start();
                }else if(palabras[0].equals("division")){
                    operacion div = new operacion(palabras[1],palabras[2],"division");
                    div.start();
                }

            }
        } catch (IOException e) {
            System.err.println("Termino de correr appHilos");
        }

        
        
    
    
    
    }
}
