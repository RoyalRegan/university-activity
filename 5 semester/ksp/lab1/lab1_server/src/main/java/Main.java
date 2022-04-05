import java.io.*;
import java.net.ServerSocket;
import java.util.logging.Logger;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
    private static final int PORT_NUMBER = 12345;


    public static void main(String[] args) throws IOException {
        final var server = new ServerSocket(PORT_NUMBER);
        LOGGER.info("SERVER STARTED");

        final var client = server.accept();
        LOGGER.info("CLIENT CONNECTED");

        final BufferedReader input = new BufferedReader(new InputStreamReader(client.getInputStream()));
        final PrintWriter output = new PrintWriter(new OutputStreamWriter(client.getOutputStream()), true);

        output.println(Parser.of(input.readLine()).getResult());
        LOGGER.info("RESPONSE SEND");

        input.close();
        output.close();
        server.close();
        LOGGER.info("SERVER SHUTDOWN");
    }
}
