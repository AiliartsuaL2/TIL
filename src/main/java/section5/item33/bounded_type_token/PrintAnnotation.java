package section5.item33.bounded_type_token;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;

// asSubClass를 사용하여 한정적 타입 토큰을 안전하게 형변환 한다.
public class PrintAnnotation {
    static Annotation getAnnotation(AnnotatedElement element, String annotationTypeName) {
        Class<?> annotationType = null; // 비한정적 타입 토큰
        try {
            annotationType = Class.forName(annotationTypeName);
        } catch (Exception ex) {
            throw new IllegalArgumentException(ex);
        }
        // 비한정적인 타입을 그대로 사용하지 못하기 때문에 하위 타입으로 변환해주는 메서드를 이용하여 조회 가능
        return element.getAnnotation(annotationType.asSubclass(Annotation.class));
    }

    // 명시한 클래스의 명시한 애너테이션을 출력하는 테스트 프로그램
    public static void main(String[] args) throws Exception {
        System.out.println(getAnnotation(MyService.class, FindMe.class.getName()));
    }
}
