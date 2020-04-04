package Stream;

import java.io.*;

public class FileReadderAndWriter {
    public static void main(String[] args) throws IOException {
        File file=new File("src/Stream/test.txt");
        FileReader fileReader=new FileReader(file);

        File outFile=new File("src/Stream/outtest.txt");
        FileWriter fileWriter=new FileWriter(outFile);
        char []text=new char[255];
        fileReader.read(text);

        fileWriter.write(text);

        fileReader.close();
        fileWriter.close();

    }
}
