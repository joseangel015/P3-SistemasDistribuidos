//Para el servidor
package rmi;
public interface EchoInterface extends java.rmi.Remote 
{
    public String echo(String input)throws java.rmi.RemoteException;
}