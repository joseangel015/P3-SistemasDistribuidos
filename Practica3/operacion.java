
/** muy importante recuerden que aquino hay main, porque este es un hilo que alguien mas debe mandar ejecutar 
*/
import java.io.*;
import java.net.*;
public class operacion extends Thread {
    int num1;
    int num2;
    String tipo;
    
    public operacion(int num1, int num2, String tipo)
    {
        this.num1 = num1; 
        this.num2 = num2;
        this.tipo =  tipo.toLowerCase();
        }
    
    
    @Override
    public void run()
        {
            final String nombreHost = "LAPTOP-V1EMNIMK";
            final int numeroPuerto = 5050;
            float resultado = 0;

            System.out.println(tipo);
            if(tipo.equals("suma")){
                resultado =  num1+num2;
            }else if(tipo.equals("multiplicacion")){
                resultado =  num1*num2;
            }else if(tipo.equals("division")){
                resultado =  num1/num2;
            }
            
            
            try (
                Socket socketEco = new Socket(nombreHost, numeroPuerto);
                PrintWriter escritor = new PrintWriter(socketEco.getOutputStream(), true);
                
                BufferedReader lector = new BufferedReader(new InputStreamReader(socketEco.getInputStream()));
                BufferedReader teclado = new BufferedReader( new InputStreamReader(System.in))
            ) {
                String mensajeResultado;
                String lineaLeida;
                
                mensajeResultado = "El resultado de la " + tipo + " es igual a " + String.valueOf(resultado);

                escritor.println(mensajeResultado);
                lineaLeida = lector.readLine();
                System.out.println("El eco del servidor dice:  " + lineaLeida);

            } catch (UnknownHostException e) {
                System.err.println("No conozco al host " + nombreHost);
                System.exit(1);
            } catch (IOException e) {
                System.err.println("no se pudo obtener E/S para la conexion " +
                    nombreHost);
                System.exit(1);
            } 

    this.yield();
     }
}
