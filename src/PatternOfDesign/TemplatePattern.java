package PatternOfDesign;

/**
 * Template method pattern
 * 优点：封装不变部分，扩展可变部分；提取公共部分代码，利于维护；行为由父类控制，由子类实现
 * 缺点：子类执行的结果，影响父类
 */

//抽象模板类
abstract class HummerModel{
    //基本方法, 由子类实现，并在模板方法中调用
    public abstract void start();
    public abstract void alarm();
    public abstract void stop();
    public abstract void engineBoom();
    //模板方法，由父类定义一个框架，一般加上final,防止篡改
    public void run(){
        this.start();
        this.engineBoom();
        this.alarm();
        this.stop();
    }
}
//悍马类型1
class HummerModelOne extends HummerModel{
    @Override
    public void start() {
        System.out.println("The type of hummer is one.");
    }
    @Override
    public void alarm() {
        System.out.println("The hummer of alarm is model one.");
    }
    @Override
    public void stop() {
        System.out.println("The hummer of model one stops.");
    }
    @Override
    public void engineBoom() {
        System.out.println("The hummer of model one is booming");
    }
}

//悍马类型2
class HummerModelTwo extends HummerModel{
    @Override
    public void start() {
        System.out.println("The type of hummer is two.");
    }
    @Override
    public void alarm() {
        System.out.println("The hummer of alarm is model two.");
    }
    @Override
    public void stop() {
        System.out.println("The hummer of model two stops.");
    }
    @Override
    public void engineBoom() {
        System.out.println("The hummer of model two is booming");
    }
}

public class TemplatePattern {
    public static void main(String[] args){
        HummerModel hummer1 = new HummerModelOne();
        HummerModel hummer2 = new HummerModelTwo();

        hummer1.run();

        hummer2.run();
    }
}
