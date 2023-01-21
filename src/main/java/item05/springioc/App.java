package item05.springioc;

import item05.DefaultDictionary;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        //SpellChecker spellChecker = new SpellChecker(new DefaultDictionary()); // 스프링이 모르.,, 빈에 등록되어있지 않은 spellChecker 객체
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        SpellChecker spellChecker = applicationContext.getBean(SpellChecker.class); // 스프링에 등록된 빈
        spellChecker.isValid("true");
    }
}
