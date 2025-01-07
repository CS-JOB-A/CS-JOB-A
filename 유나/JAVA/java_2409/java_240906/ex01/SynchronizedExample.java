package java_2409.java_240906.ex01;

public class SynchronizedExample {
    public static void main(String[] args) {
        Calculator calculator =  new Calculator();

        User1Thread user1Thread = new User1Thread();
        user1Thread.setCalculator(calculator);
        user1Thread.start();

        User2Thread user2Thread = new User2Thread();
        user2Thread.setCalculator(calculator);
        user2Thread.start();
    }
}
