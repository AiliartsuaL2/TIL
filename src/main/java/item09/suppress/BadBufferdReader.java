package item09.suppress;

import java.io.*;

public class BadBufferdReader extends BufferedReader {
    public BadBufferdReader(Reader in, int sz) {
        super(in, sz);
    }

    public BadBufferdReader(Reader in) {
        super(in);
    }
    @Override
    public String readLine() throws IOException{
        throw new CharConversionException();
    }

    @Override
    public void close() throws IOException {
        throw new StreamCorruptedException();
    }
}
