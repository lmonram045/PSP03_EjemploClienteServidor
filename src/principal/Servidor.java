package principal;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    static final int puerto = 2000;

    public Servidor() {
        try {
            ServerSocket skServidor = new ServerSocket(puerto);

            System.out.println("Escucho el puerto " + puerto);
            for (int nCli = 0; nCli < 3; nCli++) {
                Socket sCliente = skServidor.accept();
                System.out.println("Sirvo al cliente " + nCli);
                OutputStream aux = sCliente.getOutputStream();
                DataOutputStream flujoSalida = new DataOutputStream(aux);
                flujoSalida.writeUTF("Hola cliente " + nCli);
                sCliente.close();
            }
            System.out.println("Ya se han atendido 3 peticiones de clientes.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] arg) {
        new Servidor();
    }
}
