package section5.item28.array_to_list;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ChooserGeneric<T> {
    private final List<T> choiceList;
//    private final T[] choiceList;

//    @SuppressWarnings("unchecked")
    public ChooserGeneric(Collection<T> choiceList) {
        // 타입 안정성을 컴파일러가 보장하지 못함
//        this.choiceList = (T[]) choiceList.toArray();
        this.choiceList = new ArrayList<>(choiceList);
    }

    public T choose() {
        Random rnd = ThreadLocalRandom.current();
        return choiceList.get(rnd.nextInt(choiceList.size()));
    }

    // 클라이언트 코드
    public static void main(String[] args) {
        List<Integer> intList = List.of(1, 2, 3, 4, 5, 6);

        ChooserGeneric<Integer> chooser = new ChooserGeneric<>(intList);

        for (int i = 0; i < 10; i++) {
            // choiceList가 범용적으로 쓰이기위해 Object로 선언되었으나,
            // 해당 클래스를 사용하는 클라이언트 측에서 아래와 같이 강제 형변환을 하게되면
            // 예외가 발생 할 수 있다.
//            Number choice = (Number) chooser.choose();

            Number choice = chooser.choose();
            System.out.println(choice);
        }
    }
}
