import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;


public class Main {


    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        while (true){
            System.out.println("Wait TCP-connection...");
            //todo: что именно происходит при accept;
            //todo: описать попакетно TCP handshace
            Socket socket = serverSocket.accept();
            System.out.println("Get one package");
            try (InputStream in = socket.getInputStream();
                 OutputStream out = socket.getOutputStream()){
                //todo: Read request

                System.out.println("-------------------");
                System.out.println( socket );
                System.out.println("-------------------");
                //todo: Write response
               byte[] response = new Date().toString().getBytes() ;
                        out.write(response);

            }
            finally {
                socket.close();
            }
        }
    }
}
