package item05.factorymethod;

import item05.Dictionary;
import item05.MockDictionary;

public class MockDictionaryFactory implements DictionaryFactory{
    @Override
    public Dictionary getDictionary() {
        return new MockDictionary();
    }
}
