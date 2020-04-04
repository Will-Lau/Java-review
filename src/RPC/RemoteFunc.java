package RPC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;


public class RemoteFunc {

    public static void main(String[] args) throws IOException {
        //监听8080端口
        ServerSocket serverSocket=new ServerSocket(8080);

        while (true){
            Socket socket=serverSocket.accept();

            new Thread(()->{

                BufferedReader bufferedReader= null;
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                } catch (IOException e) {
                    e.printStackTrace();
                }

                char[] chars=new char[255];

                try {
                    //读到字符数组内
                    bufferedReader.read(chars);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                //取出并+1
                String content=String.valueOf(chars);
                int num=Integer.valueOf(content.trim());
                num++;

                //写回调用端
                try {
                    socket.getOutputStream().write(String.valueOf(num).getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
