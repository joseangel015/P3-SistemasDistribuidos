
public class appHilos {

    /**
     * @los parametros de args recuerden que los recibimos de lo que escribimso en consola 
     */
    public static void main(String[] args) {
        
        String tipo = args[0].toLowerCase();
        int num1 = Integer.parseInt(args[1]);
        int num2 = Integer.parseInt(args[2]);

        if(tipo.equals("suma")){
            operacion suma = new operacion(num1,num2,"suma");
            suma.start();
        }else if(tipo.equals("multiplicacion")){
            operacion multi = new operacion(num1,num2,"multiplicacion");
            multi.start();
        }else if(tipo.equals("division")){
            operacion div = new operacion(num1,num2,"division");
            div.start();
        }
        
    
    
    
    }
}
