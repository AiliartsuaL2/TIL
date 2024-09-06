package section5.item28.array_to_list;

import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ChooserArray {
    private final Object[] choiceList;

    public ChooserArray(Collection choiceList) {
        this.choiceList = choiceList.toArray();
    }

    public Object choose() {
         Random rnd = ThreadLocalRandom.current();
         return choiceList[rnd.nextInt(choiceList.length)];
    }

    // 클라이언트 코드
    public static void main(String[] args) {
        List<Integer> intList = List.of(1, 2, 3, 4, 5, 6);

        ChooserArray chooserArray = new ChooserArray(intList);

        for (int i = 0; i < 10; i++) {
            // choiceList가 범용적으로 쓰이기위해 Object로 선언되었으나,
            // 해당 클래스를 사용하는 클라이언트 측에서 아래와 같이 강제 형변환을 하게되면
            // 예외가 발생 할 수 있다.
            Number choice = (Number) chooserArray.choose();
            System.out.println(choice);
        }
    }
}
