package Stream;

import java.io.*;

public class FileStream {
    public static void main(String[] args) throws IOException {
        File file=new File("src/Stream/test.txt");
        InputStream inputStream=new FileInputStream(file);

        File outFile=new File("src/Stream/outtest.txt");
        OutputStream outputStream=new FileOutputStream(outFile);
        byte [] bytes=new byte[1024];
        inputStream.read(bytes);

        outputStream.write(bytes);

        inputStream.close();
        outputStream.close();

    }
}
