package section5.item29.bounded_type;

import java.util.Arrays;
import java.util.List;
import section5.item29.EmptyStackException;

public class Stack<E extends Number> {
    // 컴파일시 E가 Object가 아닌 Number로 바뀜
    private E[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    // 코드 29-3 배열을 사용한 코드를 제네릭으로 만드는 방법 1 (172쪽)
    // 배열 elements는 push(E)로 넘어온 E 인스턴스만 담는다.
    // 따라서 타입 안전성을 보장하지만,
    // 이 배열의 런타임 타입은 E[]가 아닌 Object[]다!
    @SuppressWarnings("unchecked")
    public Stack() {
        // Number의 배열을 Object로 캐스팅하면 위험해짐
//        elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
        elements = (E[]) new Number[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(E e) {
        // 파라미터로 들어온 e 인스턴스가 Number가 사용 할 수 있는 메서드 사용 가능
        ensureCapacity();
        elements[size++] = e;
    }

    public E pop() {
        if (size == 0)
            throw new EmptyStackException();
        E result = elements[--size];
        elements[size] = null; // 다 쓴 참조 해제
        return result;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void ensureCapacity() {
        if (elements.length == size)
            elements = Arrays.copyOf(elements, 2 * size + 1);
    }

    public static void main(String[] args) {
        // Number를 상속한 Integer, Double, Long 등만 가능
//        Stack<String> stack = new Stack<>();
//        for (String arg : List.of("1","2","3"))
//            stack.push(arg);
        Stack<Integer> stack = new Stack<>();
        for (Integer integer : List.of(1, 2, 3)) {
            stack.push(integer);
        }
        while (!stack.isEmpty())
            System.out.println(stack.pop());
    }
}
