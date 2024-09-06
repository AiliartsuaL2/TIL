package section2.item09.trywithresources;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TopLine {
    static String firstLineOfFile(String path) throws IOException {
        // resources 반납을 () 구문에서 처리 , Reader가 closeable 구현,
        try (BufferedReader bufferedReader = new BufferedReader(
                new FileReader(path)
        )) {
            return bufferedReader.readLine();
        }
    }
}
