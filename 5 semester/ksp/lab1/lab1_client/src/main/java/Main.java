import java.io.*;
import java.net.Socket;
import java.util.logging.Logger;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
    private static final int PORT_NUMBER = 12345;
    private static final String HOST = "localhost";

    public static void main(String[] args) throws IOException {
        final var client = new Socket(HOST, PORT_NUMBER);

        final PrintWriter input = new PrintWriter(new OutputStreamWriter(client.getOutputStream()), true);
        final BufferedReader output = new BufferedReader(new InputStreamReader(client.getInputStream()));

        input.println("1,2,3,4,5,6,7,8,9,10");
        LOGGER.info("REQUEST SEND");

        LOGGER.info("RESPONSE DATA:\n" + output.readLine());
        LOGGER.info("CLIENT SHUTDOWN");
    }
}
