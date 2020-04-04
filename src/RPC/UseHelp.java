package RPC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class UseHelp {
    public int use(int num) throws IOException {
        Socket socket=new Socket("120.55.161.129",41825);
        String s=String.valueOf(num);
        socket.getOutputStream().write(s.getBytes());
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(socket.getInputStream()));

        char[] chars=new char[255];
        bufferedReader.read(chars);
        return Integer.valueOf(String.valueOf(chars).trim());
    }
}
