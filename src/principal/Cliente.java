package principal;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.Socket;

public class Cliente {
    static final String HOST = "localhost";
    static final int Puerto=2000;

    public Cliente( ) {
        try{
            Socket sCliente = new Socket( HOST , Puerto );
            InputStream aux = sCliente.getInputStream();
            DataInputStream flujoEntrada = new DataInputStream( aux);
            System.out.println( flujoEntrada.readUTF() );
            sCliente.close();
        } catch( Exception e ) {
            System.out.println( e.getMessage() );
        }
    }

    public static void main( String[] arg ) {
        new Cliente();
    }
}
