package section5.item31.example;

public class Box<T extends Comparable<T>> implements Comparable<Box<T>> {
    final T value;

    public Box(T value) {
        this.value = value;
    }

    @Override
    @SuppressWarnings("unchecked")
    public int compareTo(Box anotherBox) {
        return this.value.compareTo((T) anotherBox.value);
    }

    @Override
    public String toString() {
        return "Box{" +
                "value=" + value +
                '}';
    }
}
