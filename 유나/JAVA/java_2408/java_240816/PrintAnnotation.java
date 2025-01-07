package java_2408.java_240816;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD}) // 적용대상 METHOD
@Retention(RetentionPolicy.RUNTIME) // 유지정채 RUNTIME
public @interface PrintAnnotation {
    String value() default "-"; // 선의 종류
    int number() default 15; // 출력 횟수
}
