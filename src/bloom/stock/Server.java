package bloom.stock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    private String host;
    private String port;

    private Socket socket;
    private PrintWriter pout;
    private BufferedReader bin;

    private String input;
    private String output;

    public Server(String host, String port) throws IOException {
        this.socket = new Socket(host, Integer.parseInt(port));
        this.pout = new PrintWriter(this.socket.getOutputStream());
        this.bin = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    public void write(String command) {
        pout.println(command);
        pout.flush();
    }

    public ArrayList<String> getOutput() throws IOException {
        ArrayList<String> output = new ArrayList<String>();
        String line;
        while ((line = this.bin.readLine()) != null) {
            String[] parts = line.trim().split("\\s++");
            for (String part : parts) {
                output.add(part);
            }
        }
        return output;
    }

    public void close() throws IOException{
        pout.println("CLOSE_CONNECTION");
        this.pout.close();
        this.bin.close();
    }
}
