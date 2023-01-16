package item03.methodrefernce;

import org.springframework.aop.support.DelegatePerTargetObjectIntroductionInterceptor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
    LocalDate birthday;

    public Person() {
    }

    public Person(LocalDate birthday){
        this.birthday = birthday;
    }

    public int getAge(){
        return LocalDate.now().getYear() - birthday.getYear();
    }

//    public static int compareByAge(Person a, Person b){ // 스태틱 메서드
//        return a.birthday.compareTo(b.birthday);
//    }
    public int compareByAge(Person b){ // 인스턴스 메서드
        return this.birthday.compareTo(b.birthday);
    }

    public static void main(String[] args) {
        List<LocalDate> dates = new ArrayList<>();
        dates.add(LocalDate.of(1982,7,15));
        dates.add(LocalDate.of(1997,3,15));
        dates.add(LocalDate.of(2018,9,15));
        dates.stream().map(d-> new Person(d)).collect(Collectors.toList()); // 람다로 생성자를 만듬
        dates.stream().map(Person::new).collect(Collectors.toList()); // 이렇게 변경 가능

        List<Person> people = new ArrayList<>();
        people.add(new Person(LocalDate.of(1982,7,15)));
        people.add(new Person(LocalDate.of(1997,3,27)));
        people.add(new Person(LocalDate.of(2019,9,07)));

//        people.sort(new Comparator<Person>() { // 익명 내부 클래스(클래스의 이름이 없는 내부의 클래스)
//            @Override
//            public int compare(Person o1, Person o2) {
//                return o1.birthday.compareTo(o2.birthday);
//            }
//        });
        //people.sort((p1,p2) -> p1.birthday.compareTo(p2.birthday)); // 람다 익스프레션

        //people.sort((p1,p2) -> Person.compareByAge(p1,p2)); // 람다에서 사용하는 일이 메서드를 호출해주는 한가지밖에 없다면,, 메서드 레퍼런스를 사용 가능
        people.sort(Person::compareByAge); // 메서드 레퍼런스



    }


}
