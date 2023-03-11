//librerías y paquetes
package client;
import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import rmi.EchoInterface;

public class EchoObjectStub implements EchoInterface{ //implementa la interfaz de echo
    private Socket echoSocket = null;
    private PrintWriter os = null;
    private BufferedReader is = null;
    private String host = "localhost";
    private int port=7;
    private String resultado = "Error";

    public void setHostAndPort(String host, int port) {
        this.host= host; 
        this.port =port;
    }

    private synchronized void connect() throws java.rmi.RemoteException, IOException {
        echoSocket = new Socket(host, port);//crea el socket para realizar la funcion eco
        os=new PrintWriter(echoSocket.getOutputStream()); //obtiene el output stream
        is=new BufferedReader( new InputStreamReader(echoSocket.getInputStream()));//obtiene el inputstream
    }
    
    private synchronized void disconnect() throws IOException{
        os.close();
        is.close();
        echoSocket.close();
    }

    public String echo(String instRecibida)throws java.rmi.RemoteException { //funcion eco
       
        try {
            connect();
        } catch (IOException ex) {
            Logger.getLogger(EchoObjectStub.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (echoSocket != null && os != null && is != null) {
            try {
                os.println(instRecibida);// escribe en el socket
                os.flush();// limpia el canal de comunicacion del socket
                resultado= is.readLine(); // lee del socket
            } catch (IOException e) {
                System.err.println("I/O Fallo al leer /escribir socket");
                throw new java.rmi.RemoteException("I/O failed in reading/writing socket");
            }
        }
        try {
            disconnect();
        } catch (IOException ex) {
            Logger.getLogger(EchoObjectStub.class.getName()).log(Level.SEVERE, null, ex);
        }
    return resultado;
    }
    
}
