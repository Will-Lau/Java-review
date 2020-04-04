package Stream;

import java.io.*;

public class BufferedReaderAndWriter {
    public static void main(String[] args) throws IOException {
        File file=new File("src/Stream/test.txt");
        FileReader fileReader=new FileReader(file);

        StringWriter stringWriter=new StringWriter();

        char []text=new char[255];
        fileReader.read(text);

        stringWriter.write(text);
        System.out.println(stringWriter.toString());
        fileReader.close();
        stringWriter.close();

    }
}
