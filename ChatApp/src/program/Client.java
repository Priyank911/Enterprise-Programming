package program;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    Socket socket;
    BufferedReader br;
    PrintWriter out;

    public Client() {
        try {
            System.out.println("Sending request to the server!");
            socket = new Socket("127.0.0.1", 8012);
            System.out.println("Connection done!");

            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream());

            StartReading();
            StartWriting();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void StartReading() {
        System.out.println("Client - Reader starting");
        Runnable read = () -> {
            try {
                while (true) {
                    String msg = br.readLine();
                    if (msg.equals("exit")) {
                        System.out.println("Server terminated the chat!");
                        socket.close();
                        break;
                    }
                    System.out.println("Server: " + msg);
                }
            } catch (Exception e) {
                System.out.println("Connection is closed");
            }
        };
        new Thread(read).start();
    }

    public void StartWriting() {
        System.out.println("Client - Writer starting");
        Runnable write = () -> {
            try {
                while (true && !socket.isClosed()) {
                    BufferedReader bris = new BufferedReader(new InputStreamReader(System.in));
                    String recdata = bris.readLine();
                    out.println(recdata);
                    out.flush();
                    if (recdata.equals("exit")) {
                        socket.close();
                        break;
                    }
                }
            } catch (Exception e) {
                System.out.println("Connection is closed");
            }
        };
        new Thread(write).start();
    }

    public static void main(String[] args) {
        System.out.println("Client start!");
        new Client();
    }
}
