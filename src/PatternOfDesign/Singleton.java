package PatternOfDesign;

/**
 * 单例模式，主要有3中：
 * 饿汉模式
 * 懒汉模式
 * 双检索模式
 */


//饿汉模式
public class Singleton {
    private static Singleton singleton = new Singleton();

    private Singleton(){}

    public Singleton getSingleton() {
        return singleton;
    }
}

//懒汉模式
class Singleton1 {
    private Singleton1 singleton1 = null;

    private Singleton1(){}

    public Singleton1 getSingleton() {
        if( singleton1 == null)
            this.singleton1 = new Singleton1();
        return singleton1;
    }
}

//双检索模式
class Singleton2{
    private static Singleton2 singleton2 = null;

    private Singleton2(){}

    public Singleton2 getSingleton2(){
        if(singleton2 == null){
            synchronized (Singleton2.class){
                if(singleton2 == null)
                    singleton2 = new Singleton2();
            }
        }
        return singleton2;
    }
}
