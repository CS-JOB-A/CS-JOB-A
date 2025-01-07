package java_2409.java_240906.ex02;

public class ThreadB extends Thread{
    private  WorkObject workObject;

    // 공유 작업 객체를 받음
    public ThreadB(WorkObject workObject) {
        setName("ThreadB"); // 스레드 이름 변경
        this.workObject = workObject;
    }

    @Override
    public void run() {
        for (int i=0 ; i <10; i++){
            workObject.methodA(); // 동기화 메소드 호출
        }
    }
}
