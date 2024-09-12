package java_08.java_240802;

import java_07.java_240726.ex02.A;

public class AccountExample {
    public static void main(String[] args) {
        Account account = new Account();
        // 예금하기
        account.deposit(10000);
        System.out.println("예금액: " + account.getBalance());

        // 출금하기
        try {
            account.withdraw(30000);
        } catch (InsufficientException e) {
            // 에러 처리 코드와 함께 withdraw() 메소드 호출
            String message = e.getMessage();
            System.out.println(message);
        }
    }
}
