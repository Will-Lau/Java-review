package Socket;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        String request="Get /test?args=1 HTTP/1.1";
        Socket socket=new Socket("127.0.0.1",8080);

        socket.getOutputStream().write(request.getBytes());

    }


}
