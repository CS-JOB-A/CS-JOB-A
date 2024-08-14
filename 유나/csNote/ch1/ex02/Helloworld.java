package ch1.ex02;

public class Helloworld {
    public static void main(String[] args) {
        Coffee latte = CoffeFactory.getCoffe("Latte", 4000);
        Coffee ame = CoffeFactory.getCoffe("Americano", 3000);
        System.out.println("Factory Latte ::" + latte);
        System.out.println("Factory ame ::" + ame);

    }
}
