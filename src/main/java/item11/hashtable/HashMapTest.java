package item11.hashtable;

import item11.hascode.PhoneNumber;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {
    public static void main(String[] args) {
        Map<PhoneNumber,String> map = new HashMap<>();

        // Equals는 구현이 되어있지만, hashCode가 구현이 되어있지 않은경우
//        equals는 같다고 나오지만, hashCode는 다르게나와서 map에서 생각한대로 구현이 되지 않음
        PhoneNumber number1 = new PhoneNumber(123, 456, 7890);
        PhoneNumber number2 = new PhoneNumber(123, 456, 7890);

        System.out.println(number1.equals(number2));
        System.out.println(number1.hashCode());
        System.out.println(number1.hashCode());

        map.put(number1,"이주호");
        map.put(number2,"ailiartsua");

        // 해시코드가 구현이 안되어있으면 Null이 나옴..!
        String s = map.get(new PhoneNumber(123, 456, 7890));
        System.out.println("s = " + s);


    }
}
