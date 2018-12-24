package PatternOfDesign;
import java.util.*;

/**
 * 建造者模式
 * 封装性好；建造者独立，容易扩展；容易控制细节风险
 */

abstract class CarModel{
    private ArrayList<String> sequence ;
    //基本方法
    protected abstract void stopCar();
    protected abstract void start();
    protected abstract void alarm();
    protected abstract void engineBoom();
    //算是模板方法，但是用户可以定义执行
    final public void run(){
        for(int i = 0; i < sequence.size(); ++i){
            String action = sequence.get(i);
            if(action.equalsIgnoreCase("stopCar"))
                stopCar();
            else if(action.equalsIgnoreCase("start"))
                start();
            else if(action.equalsIgnoreCase("alarm"))
                alarm();
            else if(action.equalsIgnoreCase("engineBoom"))
                engineBoom();
            else
                continue;
        }
    }
    final public void setSequence(ArrayList<String> sequence){
        this.sequence = sequence;
    }
}

//实现类，奔驰
class BenzCar extends CarModel{

    @Override
    protected void stopCar() {
        System.out.println("奔驰车停车了！");
    }

    @Override
    protected void start() {
        System.out.println("奔驰车启动了！");
    }

    @Override
    protected void alarm() {
        System.out.println("奔驰车鸣笛了！");
    }

    @Override
    protected void engineBoom() {
        System.out.println("奔驰车加油了！");
    }
}

//实现类，宝马
class BmwCar extends CarModel{

    @Override
    protected void stopCar() {
        System.out.println("宝马车停了");
    }

    @Override
    protected void start() {
        System.out.println("宝马车开了");
    }

    @Override
    protected void alarm() {
        System.out.println("宝马车鸣笛了");
    }

    @Override
    protected void engineBoom() {
        System.out.println("宝马车加油了，轰鸣声好大");
    }
}

//建造者
abstract class Builder{
    public abstract void setSequence(ArrayList<String> sequence);
    public abstract CarModel getCarModel();
}

//奔驰车组装者
class BenzBuilder extends Builder{
    private BenzCar benzCar = new BenzCar();
    @Override
    public void setSequence(ArrayList<String> sequence) {
        this.benzCar.setSequence(sequence);
    }

    @Override
    public CarModel getCarModel() {
        return this.benzCar;
    }
}

//宝马车组装者
class BmwBuilder extends Builder{
    private BmwCar bmwCar = new BmwCar();
    @Override
    public void setSequence(ArrayList<String> sequence) {
        this.bmwCar.setSequence(sequence);
    }

    @Override
    public CarModel getCarModel() {
        return this.bmwCar;
    }
}

//导演类，统一处理模型
class Director{
    private ArrayList<String> sequence = new ArrayList<>();
    BmwBuilder bmwBuilder = new BmwBuilder();
    BenzBuilder benzBuilder = new BenzBuilder();

    //返回模型1
    public BenzCar getBenzCar1(){
        this.sequence.clear();
        sequence.add("stopCar");
        sequence.add("engineBoom");
        benzBuilder.setSequence(sequence);
        return (BenzCar) benzBuilder.getCarModel();
    }
    //返回模型2
    public BmwCar getBmwCar2(){
        this.sequence.clear();
        sequence.add("start");
        sequence.add("alarm");
        sequence.add("engineBoom");
        sequence.add("stopCar");
        bmwBuilder.setSequence(sequence);
        return (BmwCar)bmwBuilder.getCarModel();
    }
    //可以自己定义多种模型

}

public class BuilderPattern {
    public static void main(String[] args){
        Director director = new Director();
        BmwCar bmwCar = director.getBmwCar2();
        bmwCar.run();
    }
}
