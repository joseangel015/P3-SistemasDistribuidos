
package server;
import java.net.*;
import java.io.*;

public class EchoMultiServerThread implements Runnable{ //implementa la interfaz runnable
    private static EchoObjectSkeleton eo = new EchoObjectSkeleton();//instancia del skeleton
    private Socket clientSocket = null;
    private String myURL = "localhost";
    private BufferedReader is = null;
    private PrintWriter os = null;
    private String inputline = new String();
    
    EchoMultiServerThread(Socket socket) {
        clientSocket = socket;
        try {
            is = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            os = new PrintWriter(clientSocket.getOutputStream());
        } catch (IOException e) {
            System.err.println("Error sending/receiving" + e.getMessage());
            e.printStackTrace();
        }
        try {
            myURL=InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            System.out.println("Unknown Host :" + e.toString());
            System.exit(1);
        }
    }
    @Override
    public void run() {
        try {
            while ((inputline = is.readLine()) != null) {
                os.println(eo.echo(inputline));
                os.flush();
            }
            os.close();
            is.close();
            clientSocket.close();
        } catch (IOException e) {
            System.err.println("Error sending/receiving" + e.getMessage());
            e.printStackTrace();
        }
    }
}
