package item09.tryfinally;

import java.io.*;

public class Copy {
    private static final int BUFFER_SIZE = 1024 * 8;

    // try- finally 구문, 너무 지저분 함, (이렇게 중첩으로 해야 In, out 둘 다 자원 반납 가능
    static void copy(String src, String dst) throws IOException {
        InputStream fileInputStream = new FileInputStream(src);
        try {
            OutputStream fileOutputStream = new FileOutputStream(dst);
            try {
                byte[] buf = new byte[BUFFER_SIZE];
                int n;
                while ((n = fileInputStream.read(buf)) >= 0)
                    fileOutputStream.write(buf,0,n);
            } finally {
                fileOutputStream.close();
            }
        } finally {
            fileInputStream.close();
        }
    }
}
