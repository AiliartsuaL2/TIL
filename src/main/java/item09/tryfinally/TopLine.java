package item09.tryfinally;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TopLine {
    static String firstLineOfFile(String path) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        try {
            return bufferedReader.readLine();
        }finally {
            bufferedReader.close();
        }
    }

    public static void main(String[] args) throws IOException{
        firstLineOfFile("abcd");
    }
}
