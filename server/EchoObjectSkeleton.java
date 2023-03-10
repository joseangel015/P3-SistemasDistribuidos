
package server;
import java.net.*;
import java.io.*;
import java.text.*;
import java.util.*;
import rmi.EchoInterface;
public class EchoObjectSkeleton implements EchoInterface {
    String myURL="localhost";
    //Constructor de la clase EchoObjectSkeleton
    public EchoObjectSkeleton()
    {
        try {
// obtengo el nombre del equipo donde estoy ejecutando y lo guardo en la propiedad MyURL
            myURL=InetAddress.getLocalHost().getHostName();
            } catch (UnknownHostException e) 
               {
                // si no pude conocer el nombre del equipo, mantengo el nombre localhost para MyURL
               myURL="localhost";
              }
    }
// el Metodo Echo que es la implementacion de la interfaz EchoInterface
    public String echo(String input) throws java.rmi.RemoteException 
    {
// toma la fecha y hora 
        // // escribe la fecha y la hora, nombre de compuadora y lo regresa
        // Date h = new Date();
        // // obtengo la fecha y hora actual 
        // String fecha = DateFormat.getTimeInstance(3,Locale.FRANCE).format(h);
        // String ret = myURL + ":" + fecha + "> " + input;
        // System.out.println("Procesando: '" + input + "'");


        // try {
        //     Thread.sleep(3000); // hilo actual
        //     ret = ret + " (retrasada 3 segundos)";
        // } catch (InterruptedException e) {}
        // System.out.println("Procesamiento de '"+ input +"'terminado.");
        // return ret;

        String[] argumentos = input.split(" ");
        String tipo = "",rFinal = "El resultado de la ";
        int num1, num2;
        float resultado = 0;
        tipo = argumentos[0].toLowerCase();
        num1 = Integer.parseInt(argumentos[1]);
        num2 = Integer.parseInt(argumentos[2]);
        if(tipo.equals("sumar")){
            resultado = sumar(num1,num2);
            rFinal += "suma es: ";
        }else if(tipo.equals("restar")){
            resultado = restar(num1,num2);
            rFinal += "resta es: ";
        }else if(tipo.equals("multiplicar")){
            resultado = multiplicar(num1,num2);
            rFinal += "multiplicacion es: ";
        }else if(tipo.equals("dividir")){
            resultado = dividir(num1,num2);
            rFinal += "division es: ";
        }
        rFinal += String.valueOf(resultado);
        
        return rFinal;

    }
    private float sumar(int num1,int num2){
        float resultado = num1 + num2;
        return resultado;
    }
    private float restar(int num1,int num2){
        float resultado = num1 - num2;
        return resultado;
    }
    private float multiplicar(int num1,int num2){
        float resultado = num1 * num2;
        return resultado;
    }
    private float dividir(int num1,int num2){
        float resultado = num1 / num2;
        return resultado;
    }
    
   }
