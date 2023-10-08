package section2.item08.finalizer;

public class FinalizerIsBad {
    // Object에 있는 메서드
    // Java 9 버전부터는 Deprecated 되었음

    @Override
    protected void finalize() throws Throwable{

    }
}
