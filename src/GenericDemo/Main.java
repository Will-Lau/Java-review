package GenericDemo;

import java.util.*;

public class Main {
    public static class Man{

    }
    public static class Doctor extends Man{

    }
    public static void main(String[] args) {
        List<?> l1=new ArrayList<>();//?表示所有类型，可以理解为通配符，此时l1可以指向任何类型的ArrayList
        l1=new ArrayList<Man>();//比如指向Man类型的
        l1=new ArrayList<Doctor>();
        //其实? 和 ? extends Object 是一回事，


        List<? extends Man> l3=new ArrayList<>();//此时的？仍然是通配符，但是有了限制，必须是Man的子类
        l3=new ArrayList<Doctor>();//这样就可
        //l3=new ArrayList<Object>();//这样就不可
        //有上界的结果就是，存入被禁止，取出有限制。
        //l3.add(new Object());不能存
        //因为List是要一个确定的类的，万一存入不同的类那这个List到底是什么类型？所以直接禁止这么干，注意是人为的禁止了，很强势的那种，是为了你的安全。
        //而取出来也不能随便承接，要用Man或者它的父类
        //原因很好理解，你取出来是什么牛鬼蛇神，我怎么知道，既然你说都是Man的子类，干脆用一个基类去承接好了，毕竟父类可以接受子类
        Object j=l3.get(0);
        Man i=l3.get(0);
        //这段代码编译能过，但会有运行时错误，毕竟咱们啥也没存进List就白嫖


        List<? super Man> l4=new ArrayList<>();//此时的？也是通配符，但是只能是Man的父类
        l4=new ArrayList<Object>();//这样就可以
        //l4=new ArrayList<Doctor>();//这样就不可
        //有下界的结果就是，存入有限制，取出也有限制，
        //存不能乱存，只能存Man和它的子类对象（其实存进去是当成Man来看的）。
        //这也是出于安全的规定，因为如果你存了一个Man的父类对象那就又不把List当人了，我们要给List点面子，它在运行时是有明确的类型的。
        l4.add(new Man());
        l4.add(new Doctor());
        //取出只能用Object来接受，因为不知道取的是个啥。别问，问就Object
        Object a=l4.get(0);



    }
}
