
package server;
import java.net.*;
import java.io.*;
import java.text.*;
import java.util.*;
import rmi.EchoInterface;
public class EchoObjectSkeleton implements EchoInterface {
    String myURL="localhost";
    public EchoObjectSkeleton(){
        try {
            myURL=InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {        
            myURL="localhost";// si no pude conocer el nombre del equipo, mantengo el nombre localhost para MyURL
        }
    }
    public String echo(String input) throws java.rmi.RemoteException {
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
