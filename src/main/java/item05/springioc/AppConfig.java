package item05.springioc;

import item05.Dictionary;
import item05.springioc.SpellChecker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public SpellChecker spellChecker(Dictionary dictionary){
        return new SpellChecker(dictionary);
    }
    @Bean
    public Dictionary dictionary(){
        return new SpringDictionary();
    }
}
