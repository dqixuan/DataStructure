package PatternOfDesign;

/**
 * Factory pattern
 * 适用于创建具有共同接口的类
 * 与简单工厂模式的不同在于，创建需要的对象时，不需要传入参数
 */

//抽象对象的共同接口

    interface Shape{
        void draw();
}
class Circle implements Shape{

    @Override
    public void draw() {
        System.out.println("This is a circle.");
    }
}
class Rectangle implements Shape{

    @Override
    public void draw() {
        System.out.println("This is a rectangle.");
    }
}
class Square implements Shape{

    @Override
    public void draw() {
        System.out.println("This is a square.");
    }
}
class ShapeFactory{//可以将每个方法转化为（static）静态方法，那么工厂模式就转化成了静态工厂模式
        public Circle produceCircle(){
            return new Circle();
        }
        public Rectangle produceRectangle(){
            return new Rectangle();
        }
        public Square produceSquare(){
            return new Square();
        }
}
public class Factory {
        public static void main(String[] args){
            ShapeFactory sf = new ShapeFactory();
            Circle c = sf.produceCircle();
            c.draw();
        }
}
