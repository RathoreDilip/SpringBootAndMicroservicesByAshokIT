class EngineDemo{
    public int start(){
        System.out.println("EngineDemo started...");
        return 1;
    }
}

class CarDemo{
    EngineDemo engineDemo=new EngineDemo();
    public void drive(){
        int start = engineDemo.start();
        if(start==1)
            System.out.println("Journey started..");
        else
            System.out.println("Engine problem..");
    }
}

public class HasA {
    public static void main(String[] args) {
        CarDemo carDemo=new CarDemo();
        System.out.println(carDemo.hashCode());
        carDemo.drive();
    }
}
