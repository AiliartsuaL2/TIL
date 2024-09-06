package section5.item31.typeinference;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BoxExample {
    private static <U> void addBox(U u, List<Box<U>> boxes) {
        Box<U> box = new Box<>();
        box.set(u);
        boxes.add(box);
    }

    private static <U> void outputBoxes(List<Box<U>> boxes) {
        int counter = 0;
        for (Box<U> box : boxes) {
            U boxContents = box.get();
            System.out.println("Box #" + counter + " contains [" +
                    boxContents.toString() + "]");
            counter ++;
        }
    }

    private static void processStringList(List<String> stringList) {

    }

    public static void main(String[] args) {
        ArrayList<Box<Integer>> listOfIntegerBox = new ArrayList<>();
        BoxExample.<Integer>addBox(10, listOfIntegerBox);
        // 매개변수를 통해 타입 추론
        BoxExample.addBox(20, listOfIntegerBox);
        BoxExample.addBox(30, listOfIntegerBox);
        BoxExample.outputBoxes(listOfIntegerBox);

        // Target Type을 보고 추론
        List<String> stringList = Collections.emptyList();
        List<Integer> integerList = Collections.emptyList();

        // java 8 버전에서 메서드의 매개변수로까지 확장시켜줌.
        BoxExample.processStringList(Collections.emptyList());
    }
}
