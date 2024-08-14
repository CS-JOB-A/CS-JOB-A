package ch1.ex02;

class CoffeFactory {
    public static Coffee getCoffe(String  type, int price) {
        if ("Latte".equalsIgnoreCase(type)) return new Latte(price);
        else if ("Americano".equalsIgnoreCase(type)) return new Americano(price);
        else  {
            return new DefaultCoffee();
        }
    }
}
