package section2.item05.dependencyinjection;

import section2.item05.Dictionary;

import java.util.List;
import java.util.function.Supplier;

public class SpellChecker {
    private final Dictionary dictionary ; // 인터페이스인경우 재사용이 전부 가능함,

    /**
     * 의존관계로 생성자를 만들어주는 팩터리를 전달해줌.
     * 저 Factory 클래스를 만들어 단순히 생성자만 생성해주는 형태의 경우 아래 Supplier로 표현 가능
     */
    public SpellChecker(DictionaryFactory dictionaryFactory){
        this.dictionary = dictionaryFactory.get(); // 패턴변형 1. 객체를 만들어주는 팩터리를 받아서 중간 단계를 더 추상화시킴
    } // 의존성을 주입을 받는다.


    /**
     * Supplier를 사용하여 팩터리 메서드를 간단하게 표현 가능
     */

    public SpellChecker(Supplier<Dictionary> dictionarySupplier){
        this.dictionary = dictionarySupplier.get(); // 패턴변형 1-1. 객체를 만들어주는 팩터리를 받아서 중간 단계를 더 추상화시킴
    } // 의존성을 주입을 받는다.

    public SpellChecker(Dictionary dictionary){
        this.dictionary = dictionary; // 1. 패턴 변형 자원을 바로 받는 방법
    } // 의존성을 주입을 받는다.



    public boolean isValid(String word){
        // TODO SpellChecker의 비즈니스 로직 코드
        return dictionary.contains(word);
    }
    public List<String> suggestions(String typo){
        // TODO SpellChecker의 비즈니스 로직 코드
        return dictionary.closeWordsTo(typo);
    }
}
