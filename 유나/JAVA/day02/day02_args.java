package day02;

public class day02_args {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("입력값이 부족합니다.");
            System.exit(0); // 프로그램 강제 종료
        }

        String strNum1 = args[0];
        String strNum2 = args[1];

        int num1 = Integer.parseInt(strNum1);
        int num2 = Integer.parseInt(strNum2);

        System.out.println(num1 + num2);
    }
}
