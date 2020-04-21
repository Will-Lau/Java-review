package GenericDemo;

public class SuperAndExtends {
    public static class Man{
        public void dosth(){

        }

        public void say(){
            System.out.println("hello");
        }
    }
    public static class Doctor extends Man{
        private int doctorId;
        Doctor(){
            doctorId=1;
            System.out.println("doctor 的构造方法");
            System.out.println(doctorId);
        }
        public void dosth(){
            System.out.println("doctor");
        }
    }
    public static void main(String[] args) {
        Man man=new Doctor();//用父类是可以接受子类的，因为父类毕竟有子类的一部分内容。
        //其实很好理解，就比如你可以说一个医生是人，医生有人的属性.
        //但是这里调用的是Doctor构造方法，实际上是什么意思呢。其实是构造了一个Doctor的实例，但是是由man去指向它的

        //下面的解释是在Man类还没有写dosth方法时
        //man.dosth//这里就不能调用这个方法了，因为man根本不知道dosth是个啥，就像屠龙刀被普通人拿到也只能用作切菜。
        //man.doctorId//这里也是一样

        //然后呢，我们在Man类里面加了一个dosth（一开始是没有的）方法，调用它
        man.dosth();
        //神奇的发现调用的是子类的dosth方法，这也很好理解，因为它指向的就是一个doctor类啊，就像普通人拿刀切菜时把桌子都切断了一样。
        //这里子类都不用加上override的注解，因为调用的就是子类的方法

        man.say();//自然父类的方法也可调用，因为已经被子类继承了

        //我们也可以把man强转为一个Doctor引用，毕竟它指向的本就是一个Doctor类的实例
        Doctor d=(Doctor)(man);
        d.dosth();//输出doctor

        //Man类的实例就不能用Doctor来承接了，因为子类有好多东西父类是没有的，没有怎么承接？
        //不是每个人都是医生。不是每一个把刀都能叫屠龙宝刀。
        //Doctor doctor=new Man();//报错

    }
}
