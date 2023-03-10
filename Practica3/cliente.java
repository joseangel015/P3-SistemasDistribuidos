
//LAPTOP-V1EMNIMK
import java.io.*;
import java.net.*;

public class cliente {
    public static void main(String[] args) throws IOException {
        
        // if (args.length != 2) {
        //     System.err.println(
        //         "Uso desde consola: java Cliente_de_Eco <nombre de host (computadora)> <numero puerto>");
        //     System.exit(1);
        // }
        final String nombreHost = "LAPTOP-V1EMNIMK";
        int numeroPuerto = 5050;

        try (
            Socket socketEco = new Socket(nombreHost, numeroPuerto);
            PrintWriter escritor = new PrintWriter(socketEco.getOutputStream(), true);
            
            BufferedReader lector = new BufferedReader(new InputStreamReader(socketEco.getInputStream()));
            BufferedReader teclado = new BufferedReader( new InputStreamReader(System.in))
        ) {
            String usuarioEscribio;
            String lineaLeida;
            while ((usuarioEscribio = teclado.readLine()) != null) {
                escritor.println(usuarioEscribio);
                lineaLeida = lector.readLine();
               System.out.println("El eco del servidor dice:  " + lineaLeida);
            }
        } catch (UnknownHostException e) {
            System.err.println("No conozco al host " + nombreHost);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("no se pudo obtener E/S para la conexion " +
                nombreHost);
            System.exit(1);
        } 
    }
}
