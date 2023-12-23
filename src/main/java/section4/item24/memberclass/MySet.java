package section4.item24.memberclass;

import java.util.AbstractSet;
import java.util.Iterator;

public class MySet<E> extends AbstractSet<E> {
    @Override
    public Iterator<E> iterator() {
        return new MyIterator();
    }

    @Override
    public int size() {
        return 0;
    }

    // 따로 구현해야하면 비정적 이너클래스를 통해 구현하여 위와같이 사용 할 수 있음
    // 어댑터 패턴이 아래처럼 직접 구현한 Itereator
    private class MyIterator implements Iterator<E> {

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public E next() {
            return null;
        }
    }
}
