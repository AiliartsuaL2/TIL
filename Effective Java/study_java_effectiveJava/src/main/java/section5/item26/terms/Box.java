package section5.item26.terms;

// E의 타입에 제약을 둘 수 있다. (한정적인 타입 매개변수)
public class Box<E extends Number> {
    private E item;

    private void add(E e) {
        this.item = e;
    }

    private E get() {
        return this.item;
    }

    public static void main(String[] args) {
        // 매개변수화 타입
        Box<Integer> box = new Box<>();

        // 비한정적 와일드카드 타입(extends 받지 않은 제네릭을 사용하는 쪽에서)
        Box<?> box2 = new Box<>();
        box.add(10);
        printBox(box);
    }

    // 비한정적 와일드카드 타입은 이렇게 매개변수로 사용 할 때 사용해준다.
    private static void printBox(Box<?> box) {
        System.out.println(box.get());
    }
}
