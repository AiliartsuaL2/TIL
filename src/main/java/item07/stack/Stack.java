package item07.stack;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e){
        ensureCapacity();
        elements[size++] = e;
    }

    /**
     * 이렇게 단순히 사이즈를 줄이며 빼기만 하다보면 나중엔 배열의 사이즈가 증가하지 않을 때가 결국 옴.
     * 따라서 pop으로 빼낸 데이터는 실제로 참조를 해제해준다.
     */
//    public Object pop(){
//        if(size == 0){
//            throw new EmptyStackException();
//        }
//        return elements[--size];
//    }
    public Object pop(){
        if(size == 0)
            throw new EmptyStackException();
        Object result = elements[--size];
        elements[size] = null;
        return result;
    }

    /**
     * 원소를 위한 공간을 적어도 하나 이상 확보한다.
     * 배열 크기를 늘려야 할 때마다 대략 2배씩 늘린다.
     */
    public void ensureCapacity(){
        if(elements.length == size){
            elements = Arrays.copyOf(elements,2*size + 1);
        }
    }

}
