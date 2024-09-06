package section2.item05.factorymethod;

import section2.item05.Dictionary;
import section2.item05.MockDictionary;

public class MockDictionaryFactory implements DictionaryFactory{
    @Override
    public Dictionary getDictionary() {
        return new MockDictionary();
    }
}
