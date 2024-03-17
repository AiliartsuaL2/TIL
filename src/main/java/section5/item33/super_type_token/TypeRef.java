package section5.item33.super_type_token;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Objects;

// 해당 클래스를 상속받는 익명 클래스를 생성해서 type을 map의 key로 사용
public abstract class TypeRef<T> {
    private final Type type;

    protected TypeRef() {
        ParameterizedType superclass = (ParameterizedType) getClass().getGenericSuperclass();
        this.type = superclass.getActualTypeArguments()[0];
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof TypeRef && ((TypeRef) o).type.equals(type);
    }

    @Override
    public int hashCode() {
        return type.hashCode();
    }

    public Type getType() {
        return type;
    }
}
