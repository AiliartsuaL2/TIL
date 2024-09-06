package section2.item05.factorymethod;

import section2.item05.DefaultDictionary;
import section2.item05.Dictionary;

public class DefaultDictionaryFactory implements DictionaryFactory{
    @Override
    public Dictionary getDictionary() { // 구체적인 인스턴스를 구체적인 팩토리에서 만듬
        return new DefaultDictionary();
    }
}
