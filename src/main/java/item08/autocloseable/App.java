package item08.autocloseable;

public class App {
    public static void main(String[] args) {
        // 작업 이후 해당 AutoCloseable을 통해 자원이 반납 처리 됨
        // try-with-resource 전략
        try(AutoCloseableIsGood autoCloseableIsGood = new AutoCloseableIsGood()){

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
