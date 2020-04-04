package Stream;

import java.io.*;

public class BufferedStream {
    public static void main(String[] args) throws IOException {
        File file=new File("src/Stream/test.txt");
        InputStream inputStream=new FileInputStream(file);

        OutputStream outputStream=new BufferedOutputStream(System.out);
        byte [] bytes=new byte[1024];
        inputStream.read(bytes);

        outputStream.write(bytes);

        inputStream.close();
        outputStream.close();

    }
}
