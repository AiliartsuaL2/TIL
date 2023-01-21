package item05.springioc;

import item05.Dictionary;

import java.util.List;


public class SpellChecker {
    private Dictionary dictionary;

    public SpellChecker(Dictionary dictionary) {
        this.dictionary = dictionary;
    }
    public boolean isValid(String word){
        // TODO SpellChecker의 비즈니스 로직 코드
        return dictionary.contains(word);
    }
    public List<String> suggestions(String typo){
        // TODO SpellChecker의 비즈니스 로직 코드
        return dictionary.closeWordsTo(typo);
    }
}
