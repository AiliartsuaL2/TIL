package section2.item09.suppress;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TopLine {
    /**
     * try - finally
     // 처음에 발생한 예외는 안보이고, 나중에 발생한 예외는보이지 않음
     // 해당 예시에서는 readLine은 안보이고, 예외가 close만 보인다.
     */
//    static String firstLineOfFile(String path) throws IOException {
//        BufferedReader bufferedReader = new BadBufferdReader(new FileReader(path));
//        try {
//            return bufferedReader.readLine();
//        }finally {
//            bufferedReader.close();
//        }
//    }

    /**
     * try - with - resources
     * 처음 발생한 에러와, 뒤에서 추가로 발생된 에러가 Suppressed로 보여준다.
     */
        static String firstLineOfFile(String path) throws IOException {
        try(BufferedReader bufferedReader = new BadBufferdReader(new FileReader(path))) {
            return bufferedReader.readLine();
        }
    }



    public static void main(String[] args) throws IOException{
        System.out.println(firstLineOfFile("README.md"));
    }
}
