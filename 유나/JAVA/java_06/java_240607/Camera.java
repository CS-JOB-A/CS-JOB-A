package java_06.java_240607;

public class Camera {
    // 필드 선언
    String company = "코닥";
    String model;
    String color;
    int maxPicture;

    // 생성자 선언
    Camera() {
        this("필름카메라", "바이올렛", 29);
    }
    Camera(String model) {
        this(model, "바이올렛", 29);
    }
    Camera(String model, String color) {
        this(model, color, 29);
    }
    Camera(String model, String color, int maxPicture) {
        this.model = model;
        this.color = color;
        this.maxPicture = maxPicture;
    }
}