package section2.item08.autocloseable;

import java.io.BufferedInputStream;
import java.io.IOException;

public class AutoCloseableIsGood implements AutoCloseable{
    private BufferedInputStream bufferedInputStream;
    @Override
    public void close() throws Exception {
        try {
            bufferedInputStream.close();
        }catch (IOException e){
            throw new RuntimeException("failed to Close" + bufferedInputStream);
        }
    }

}
