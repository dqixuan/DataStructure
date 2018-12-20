package PatternOfDesign;

/**
 * 简单工厂模式
 * 避免了客户端直接生成产品对象
 * 不利于扩展，添加新的产品，需要在工厂中修改
 */
//汽车抽象类
abstract class Car{
    private String name;

    public abstract void driver();

    public String getName() {
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
}
//创建具体的产品类别
//benz
class Benz extends Car{
    public void driver(){
        System.out.println(this.getName() + " is starting driver");
    }
}
//bmw
class Bmw extends Car{
    public void driver(){
        System.out.println(this.getName()+" is starting driver");
    }
}


class Driver{
    public static Car getCar(String car){
        Car carr = null;
        if(car.equalsIgnoreCase("benz"))
            carr =  new Benz();
        if(car.equalsIgnoreCase("bmw"))
            carr = new Bmw();

        return carr;
    }

}

public class SampleFactory {
    public static void main(String[] args){
        Car car = Driver.getCar("benz");
        car.setName("Benz");
        car.driver();
    }
}
