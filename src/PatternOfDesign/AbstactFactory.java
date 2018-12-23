package PatternOfDesign;

/**
 * abstract factory
 * 特点：存在多个抽象类，产生多级产品
 */
//人类公共的接口
interface Human{
    void getColor();//肤色
    void talk();//语言
    void getSex();//性别
}
//三个抽象类，白、黄、黑
abstract class AbstractWhiteHuman implements Human{
    public void getColor(){
        System.out.println("White Human");
    }
    public void talk(){
        System.out.println("White Human is talking");
    }
}
abstract class AbstractYellowHuman implements Human{
    public void getColor(){
        System.out.println("Yellow Human");
    }
    public void talk(){
        System.out.println("Yellow Human is talking");
    }
}
abstract class AbstractBlackHuman implements Human{
    public void getColor(){
        System.out.println("Black Human");
    }
    public void talk(){
        System.out.println("Black Human is talking");
    }
}
//具体实现类

//白人女性
class FemaleWhiteHuman extends AbstractWhiteHuman{
    @Override
    public void getSex() {
        System.out.println("Female white human");
    }
}
//白人男性
class MaleWhiteHuman extends AbstractWhiteHuman{
    @Override
    public void getSex() {
        System.out.println("Male white human");
    }
}
//黄人男性
class MaleYellowHuman extends AbstractYellowHuman{
    @Override
    public void getSex() {
        System.out.println("Male yellow human");
    }
}
//黄人女性
class FemaleYellowHuman extends AbstractYellowHuman{
    @Override
    public void getSex() {
        System.out.println("Female yellow human");
    }
}
//黑人男性
class MaleBlackHuman extends AbstractBlackHuman{
    @Override
    public void getSex() {
        System.out.println("Male black human");
    }
}
//黑人女性
class FemaleBlackHuman extends AbstractBlackHuman{
    @Override
    public void getSex() {
        System.out.println("Female black human");
    }
}


//工厂
interface HumanFactory{
    public Human createYellowHuman();
    public Human createBlackHuman();
    public Human createWhiteHuman();
}

//生产男性的工厂
class MaleFactory implements HumanFactory{

    @Override
    public Human createYellowHuman() {
        return new MaleYellowHuman();
    }

    @Override
    public Human createBlackHuman() {
        return new MaleBlackHuman();
    }

    @Override
    public Human createWhiteHuman() {
        return new MaleWhiteHuman();
    }
}

//生产女性的工厂
class FemaleFactory implements HumanFactory{

    @Override
    public Human createYellowHuman() {
        return new FemaleYellowHuman();
    }

    @Override
    public Human createBlackHuman() {
        return new FemaleBlackHuman();
    }

    @Override
    public Human createWhiteHuman() {
        return new FemaleWhiteHuman();
    }
}

public class AbstactFactory {
    public static void main(String[] args){
        //男性生产线
        HumanFactory maleFactory = new MaleFactory();
        //女性生产线
        HumanFactory femaleFactory = new FemaleFactory();

        Human fwh = femaleFactory.createWhiteHuman();

        fwh.getColor();
        fwh.talk();
        fwh.getSex();
    }

}
