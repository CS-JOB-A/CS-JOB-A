package java_240822.ex01;

// 제네릭 타입
public class Product<K, M> { // 타입 파라미터로 K와 M 정의
    // 필드. 타입 파라미터를 필드 타입으로 사용
    private K kind;
    private M modiel;

    // 메소드. 타입 파라미터를 리턴 타입과 매개 변수 타입으로 사용
    public K getKind() {return this.kind;}
    public M getModiel() {return this.modiel;}

    public void setKind(K kind) {
        this.kind = kind;
    }

    public void setModiel(M modiel) {
        this.modiel = modiel;
    }
}
