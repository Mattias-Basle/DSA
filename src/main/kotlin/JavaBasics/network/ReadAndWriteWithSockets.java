package JavaBasics.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ReadAndWriteWithSockets {
    public static void main(String[] args) {
        try {
            Socket chatSocket = new Socket("127.0.0.1", 5000);

            //Reading
            InputStreamReader streamReader = new InputStreamReader(chatSocket.getInputStream());
            BufferedReader reader = new BufferedReader(streamReader);
            String message = reader.readLine();

            //Writing
            PrintWriter writer = new PrintWriter(chatSocket.getOutputStream());
            writer.println("message to send");
            writer.print("another mesasge");

            streamReader.close();
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
