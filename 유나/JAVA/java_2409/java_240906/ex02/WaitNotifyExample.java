package java_2409.java_240906.ex02;

public class WaitNotifyExample {
    public static void main(String[] args) {
        WorkObject workObject = new WorkObject(); // 공유 작업 객체 생성

        ThreadA threadA = new ThreadA(workObject);
        ThreadB threadB = new ThreadB(workObject);

        // 작업 스레드 생성 및 실행
        threadA.start();
        threadB.start();
    }
}
