package Stream;

import java.io.*;

public class FileStream {
    public static void main(String[] args) throws IOException {
        File file=new File("C:\\Users\\ann_l\\Downloads\\output.mid");
        InputStream inputStream=new FileInputStream(file);

        File outFile=new File("src/Stream/outtest.txt");
        OutputStream outputStream=new FileOutputStream(outFile);
        byte [] bytes=new byte[1024];

        inputStream.read(bytes);

        for(int i=0;i<1024;i++){
            int out=bytes[i]&0xff;
            System.out.printf("%02x ",out);
        }

        outputStream.write(bytes);

        inputStream.close();
        outputStream.close();

    }
}
