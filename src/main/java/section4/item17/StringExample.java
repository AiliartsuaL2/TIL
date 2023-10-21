package section4.item17;

public class StringExample {
    public static void main(String[] args) {
        // String은 불변이지만
        String name = "ailiartsua";
        // 가변 동반 클래스를 제공
        StringBuilder nameBuilder = new StringBuilder(name);
        nameBuilder.append("juho");
    }
}
