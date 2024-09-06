package section4.item20.templatemethod.callback;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.function.BiFunction;

// 템플릿 콜백
// 구현체는 알고리즘을 정의하지않아도 되고, 상속을 사용하지 않아도 된다.
public class CallbackFileProcessor {

    private String path;

    public CallbackFileProcessor(String path) {
        this.path = path;
    }

    // BiFunction : 2개의 인자를 받아서 1개의 인자로 return
    public final int processCallback(BiFunction<Integer, Integer, Integer> operator) {
        // try - with resource
        try(BufferedReader reader = new BufferedReader(new FileReader(path))) {
            int result = 0;
            String line = null;
            while((line = reader.readLine()) != null) {
                result = operator.apply(result, Integer.parseInt(line));
            }
            return result;
        } catch (IOException e) {
            throw new IllegalArgumentException(path+"에 해당하는 파일이 없습니다", e);
        }
    }
}
