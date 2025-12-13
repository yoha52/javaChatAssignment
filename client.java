import java.io.*;
import java.net.*;
import java.util.*;

public class client {
    public static void main(String[] args) {
        Socket socket;
        InputStreamReader in;
        OutputStreamWriter out;
        BufferedReader bfin;
        BufferedWriter bfout;
        try {
            socket = new Socket("localhost", 8100);
            in = new InputStreamReader(socket.getInputStream());
            out = new OutputStreamWriter(socket.getOutputStream());
            bfin = new BufferedReader(in);
            bfout = new BufferedWriter(out);
            Scanner scanner = new Scanner(System.in);
            System.out.println("write message to server ");
            System.out.print(">- ");
            while (true) {
                String msgTosend = scanner.nextLine();
                bfout.write(msgTosend);
                bfout.newLine();
                bfout.flush();

                String msgfromserver = bfin.readLine();
                if (msgfromserver.equalsIgnoreCase("bye"))
                    break;
                System.out.println("server: " + msgfromserver);
                System.out.print(">- ");
                // if("chaw".equals(msgTosend)){
                // break;
                // }
            }
        } catch (UnknownHostException e) {
            System.out.println("Unknown host: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("I/O error: " + e.getMessage());
        }
    }
}
