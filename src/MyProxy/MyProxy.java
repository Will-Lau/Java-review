package MyProxy;

import java.lang.reflect.Proxy;

public class MyProxy {
    public static void main(String[] args) {
        MyInterface test=new MyInterfaceImpl();
        DynamicInvocationHandler myTestInvocationHandler = new DynamicInvocationHandler(test);

        MyInterface Proxytest = (MyInterface) Proxy.newProxyInstance(MyInterfaceImpl.class.getClassLoader(), new Class[] {
                MyInterface.class
        }, myTestInvocationHandler);

        Proxytest.testIt();
    }
}