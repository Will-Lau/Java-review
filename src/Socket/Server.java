package Socket;

import com.sun.xml.internal.messaging.saaj.util.CharReader;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.CharBuffer;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket=new ServerSocket(8080);
        Socket socket=serverSocket.accept();
        //把socket的InputStream转为Reader，以字符流读取。
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(socket.getInputStream()));

        char [] chars=new char[255];
        bufferedReader.read(chars);

        String s=String.valueOf(chars);
        System.out.println(s);
    }
}
