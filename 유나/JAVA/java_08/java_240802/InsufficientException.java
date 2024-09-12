package java_08.java_240802;

public class InsufficientException extends Exception {
    // 두 개의 생성자 선언
    public InsufficientException() {}

    public InsufficientException(String message) {
        super(message);
    }
}
