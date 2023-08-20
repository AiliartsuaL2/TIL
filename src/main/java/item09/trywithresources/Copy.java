package item09.trywithresources;

import java.io.*;

public class Copy {
    private static final int BUFFER_SIZE = 1024 * 8;

    // 다음과같이 복수의 자원의 close를 안전하게 해줄 수 있음
    static void copy(String src, String dst) throws IOException {
        try (InputStream fileInputStream = new FileInputStream(src);
             OutputStream fileOutputStream = new FileOutputStream(dst)) {
            byte[] buf = new byte[BUFFER_SIZE];
            int n;
            while ((n = fileInputStream.read(buf)) >= 0)
                fileOutputStream.write(buf, 0, n);
        }
    }
}
