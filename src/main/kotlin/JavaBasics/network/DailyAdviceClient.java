package JavaBasics.network;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class DailyAdviceClient {

    String[] adviceList = {"Take smaller bites", "Go for the tight jeans. No they do NOT make you look fat.",
    "One word: inappropriate", "Just for today, be honest. Tell your boss what you *really* think",
    "You might want to rethink that haircut"};

    public void go() {
        try {
            ServerSocket serverSocket = new ServerSocket(4242);

            while (true) {
                Socket s = serverSocket.accept();

                PrintWriter writer = new PrintWriter(s.getOutputStream());

                String advice = getAdvice();
                writer.println(advice);
                writer.close();
                System.out.println("Today you should: " + advice);
                break;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private String getAdvice() {
        int random = (int) (Math.random() * adviceList.length);
        return adviceList[random];
    }

    public static void main(String[] args) {
        DailyAdviceClient client = new DailyAdviceClient();
        client.go();
    }
}
