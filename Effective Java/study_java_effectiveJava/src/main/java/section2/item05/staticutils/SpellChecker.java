package section2.item05.staticutils;


import section2.item05.DefaultDictionary;
import section2.item05.Dictionary;

import java.util.List;

public class SpellChecker {
    private static final Dictionary dictionary = new DefaultDictionary(); // 자원(new Dictionary)을 직접 생성하기 때문에, 사전에 따라 달라질수있기때문에 테스트 유연성도 떨어지고,, 함
    private SpellChecker(){}; // private 기본 생성자 ,, >> 인스턴스 생성 방지

    public static boolean isValid(String word){
        // TODO SpellChecker의 비즈니스 로직 코드
        return dictionary.contains(word);
    }
    public static List<String> suggestions(String typo){
        // TODO SpellChecker의 비즈니스 로직 코드
        return dictionary.closeWordsTo(typo);
    }
}
