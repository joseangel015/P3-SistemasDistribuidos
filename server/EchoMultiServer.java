package server;
import java.net.*;
import java.io.*;
public class EchoMultiServer {
    private static ServerSocket serverSocket = null;
    public static void main(String[] args) throws IOException {
        try {
            serverSocket = new ServerSocket(7); //crea socket para el puerto 7
        } catch (IOException e) {
            System.out.println("EchoMultiServer: could not listen on port: 7, " + e.toString());
            System.exit(1);
        }
        System.out.println("EchoMultiServer listening on port: 7");
        boolean listening = true;
        Socket clientSocket = null;
        while (listening) {//se queda escuchando
            clientSocket = serverSocket.accept();//aceptacn peticiones
            Runnable Cliente =new EchoMultiServerThread(clientSocket);
            Thread hilo=new Thread(Cliente);//se crea un hilo
            hilo.start();//corre el hilo
        }
        try {
            serverSocket.close();
        } catch (IOException e) {
            System.err.println("Could not close server socket." +
            e.getMessage());
        }
    }
}
