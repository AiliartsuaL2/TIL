package item13;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack implements Cloneable {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        this.elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public Object pop() {
        if (size == 0)
            throw new EmptyStackException();
        Object result = elements[--size];
        elements[size] = null; // 다 쓴 참조 해제
        return result;
    }

    public boolean isEmpty() {
        return size ==0;
    }

    // 코드 13-2 가변 상태를 참조하는 클래스용 clone 메서드
    @Override public Stack clone() {
        try {
            Stack result = (Stack) super.clone();
            // 배열도 같이 복사를 해줘야함,
            // deepCopy가 아닌, shallow copy이기 때문에 배열의 주소값이 다르지만, 배열이 참조하고있는 원소들의 주소값은 같기 때문에
            // 재귀적으로 배열을 clone 해주거나, 반복자를 써서 순회하는 방향으로 deepCopy를 해준다.
            result.elements = elements.clone();
            return result;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    // 원소를 위한 공간을 적어도 하나 이상 확보한다.
    private void ensureCapacity() {
        if (elements.length == size)
            elements = Arrays.copyOf(elements, 2 * size + 1);
    }

    // clone이 동작하는 모습을 보려면 명령줄 인수를 몇 개 덧붙여서 호출해야 한다.
    public static void main(String[] args) {
        Object[] values = new Object[2];
        values[0] = new PhoneNumber(010,212,8406);
        values[1] = new PhoneNumber(010,124,5678);

        Stack stack = new Stack();
        for (Object arg : values)
            stack.push(arg);
        Stack copy = stack.clone();

        System.out.println("pop from original");
        while (!stack.isEmpty())
            // 원본에서 하나 뺌
            System.out.print(stack.pop() + " ");

        // 카피본에서 하나 뺌
        System.out.println("pop from copy");
        while (!copy.isEmpty())
            System.out.print(copy.pop() + " ");

        // 기대값 : 오리지날 빠지고, 카피본에서 빠져야함
        // 실제값 : 배열은 다르나, 배열에서 참조하고있는 원소들의 주소는 같기 때문에 카피본에서는 null이 빠짐
    }
}
