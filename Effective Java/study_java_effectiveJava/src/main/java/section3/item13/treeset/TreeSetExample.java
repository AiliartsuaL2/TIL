package section3.item13.treeset;

import section3.item12.PhoneNumber;

import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetExample {
    public static void main(String[] args) {
        TreeSet<PhoneNumber> treeSet = new TreeSet<>(Comparator.comparingInt(PhoneNumber::hashCode));
        Set<PhoneNumber> phoneNumbers = Collections.synchronizedSet(treeSet);
        // Thread - safe한 Synchronize처리 되는데, 성능이 느려짐


        // NaturalOrder가 없는 Custom 객체의 경우 Comparator을 객체에서 정의하거나, TreeSet에서 정의해줘야함
        treeSet.add(new PhoneNumber(123,456,789));
        treeSet.add(new PhoneNumber(123,456,7890));
        treeSet.add(new PhoneNumber(123,456,7891));

        for (PhoneNumber phoneNumber : treeSet) {
            System.out.println("phoneNumber = " + phoneNumber);
        }
    }
}
