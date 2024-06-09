package day05;

public class Calculator {
    // 정사각형
    double areaRect(double width){
        return width * width;
    }
    // 직사각형
    double areaRect(double width, double height){
        return width * height;
    }

    // 정적 필드 선언
    static double pi = 3.14159;

    // 정적 메소드
    static int plus(int x, int y){
        return x + y;
    }
}
