class Engine{
    public int start(){
        System.out.println("Engine started..");
        return 1;
    }
}

class Car extends Engine{
    public void drive(){
        int engStatus=super.start();
        if(engStatus==1)
            System.out.println("Journey started...");
        else
            System.out.println("Engine problem...");
    }
}

public class IsA {
    public static void main(String[] args) {
        Car car=new Car();
        System.out.println(car.hashCode());
        car.drive();
    }
}
