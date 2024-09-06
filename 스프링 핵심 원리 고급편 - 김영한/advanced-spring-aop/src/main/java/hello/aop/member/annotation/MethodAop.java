package hello.aop.member.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 적용대상
@Target(ElementType.METHOD)
// 생명주기
@Retention(RetentionPolicy.RUNTIME)
public @interface MethodAop {
    String value();
}
