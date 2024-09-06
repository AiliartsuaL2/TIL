package section5.item31.example;

public class PresentBox extends Box<Integer> {
    private final String message;

    public PresentBox(Integer value, String message) {
        super(value);
        this.message = message;
    }

    @Override
    public String toString() {
        return "PresentBox{" +
                "message='" + message + '\'' +
                ", value=" + value +
                '}';
    }
}
