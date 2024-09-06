package section5.item27.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// Documented -> javadoc 을 만들 때 해당 애노테이션을 붙인 클래스에서 애노테이션도 포함이 된다.
@Documented
// Retention -> 해당 애노테이션을 언제까지 참조하게 할 것 인지.
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
}
