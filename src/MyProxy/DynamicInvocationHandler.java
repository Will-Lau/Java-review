package MyProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class DynamicInvocationHandler implements InvocationHandler {

    private MyInterface myInterface;

    DynamicInvocationHandler(MyInterface myInterface){
        this.myInterface=myInterface;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
        System.out.println("before doing");
        return  method.invoke(myInterface,args);
    }

}