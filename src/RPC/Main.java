package RPC;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        UseHelp useHelp=new UseHelp();
        int result=useHelp.use(4);
        System.out.println(result);
    }
}
