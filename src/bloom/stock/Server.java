package bloom.stock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Server {
    private String host;
    private String port;

    private Socket socket;
    private PrintWriter pout;
    private BufferedReader bin;

    private String input;
    private String output;

    private String user;
    private String pass;

    public Server(String host, String port, String user, String pass) throws IOException {
        this.socket = new Socket(host, Integer.parseInt(port));

        this.pout = new PrintWriter(this.socket.getOutputStream());
        this.bin = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        this.user = user;
        this.pass = pass;
        this.pout.println(this.user + " " + this.pass);
    }

    public void write(String command) {
        this.pout.println(command);
        this.pout.flush();
    }

    public ArrayList<String> getOutput() throws IOException {
        ArrayList<String> output = new ArrayList<String>();
        String line;
        if ((line = this.bin.readLine()) != null) {
            List<String> wordList = Arrays.asList(line.trim().split("\\s++"));
            output = new ArrayList<String>(wordList);
        }
        return output;
    }

    public void close() throws IOException{
        pout.println("CLOSE_CONNECTION");
        this.pout.close();
        this.bin.close();
    }
}
