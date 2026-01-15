import java.io.*;
import java.net.*;
import java.util.*;

public class server {
    public static void main(String[] args) {
        //initilize the io objects 
        Socket socket;
        InputStreamReader in;
        OutputStreamWriter out;
        BufferedReader bfin;
        BufferedWriter bfout;
        ServerSocket serverSocket;

        try {
            // start the server
            serverSocket = new ServerSocket(8100);
            System.out.println("wait to connect");
            while (true) {
                
                try {
                    socket = serverSocket.accept();
                    //bind the io objects to the socket
                    in = new InputStreamReader(socket.getInputStream());
                    out = new OutputStreamWriter(socket.getOutputStream());
                    bfin = new BufferedReader(in);
                    bfout = new BufferedWriter(out);
                    System.out.println("wait for message... ");
                    System.out.print(">-");

                    while (true) {
// to read client response 
                        String msgfromclient = bfin.readLine();
                        System.out.println("Client: " + msgfromclient);
//this line of code is to write to the client 
                        Scanner scanner = new Scanner(System.in);
                        String reply = scanner.nextLine();    
                        bfout.write(reply);
                        bfout.newLine();
                        bfout.flush();

                        System.out.print(">- ");

                        if (msgfromclient.equalsIgnoreCase("bye"))
                            break;
                    }
// close the connedtoion
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

