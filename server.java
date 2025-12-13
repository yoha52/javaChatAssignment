import java.io.*;
import java.net.*;
import java.util.*;

public class server {
    public static void main(String[] args) {
        Socket socket;
        InputStreamReader in;
        OutputStreamWriter out;
        BufferedReader bfin;
        BufferedWriter bfout;
        ServerSocket serverSocket;

        try {
            serverSocket = new ServerSocket(8100);
            System.out.println("wait to connect");
            while (true) {
                
                try {
                    socket = serverSocket.accept();
                    in = new InputStreamReader(socket.getInputStream());
                    out = new OutputStreamWriter(socket.getOutputStream());
                    bfin = new BufferedReader(in);
                    bfout = new BufferedWriter(out);
                    System.out.println("wait for message... ");
                    System.out.print(">-");

                    while (true) {

                        String msgfromclient = bfin.readLine();
                        System.out.println("Client: " + msgfromclient);

                        Scanner scanner = new Scanner(System.in);
                        String reply = scanner.nextLine();
                        bfout.write(reply);
                        bfout.newLine();
                        bfout.flush();

                        System.out.print(">- ");

                        if (msgfromclient.equalsIgnoreCase("bye"))
                            break;
                    }
                    socket.close();
                    in.close();
                    out.close();
                    bfin.close();
                    bfout.close();
                } catch (IOException e) {
                }

            }

        } catch (IOException e) {
        }
    }
}
