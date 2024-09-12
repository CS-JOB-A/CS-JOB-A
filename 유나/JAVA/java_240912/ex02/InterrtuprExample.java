package java_240912.ex02;

public class InterrtuprExample {
    public static void main(String[] args) {
        Thread thread = new PrintThread();
        thread.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {

        }

        thread.interrupt(); // interrupt() 메소드 호출
    }
}
