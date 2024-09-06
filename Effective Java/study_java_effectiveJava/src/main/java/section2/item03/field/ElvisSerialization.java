package section2.item03.field;

import java.io.*;

public class ElvisSerialization {
    public static void main(String[] args) {
        try (ObjectOutput out = new ObjectOutputStream(new FileOutputStream("elvis.obj"))) { // 직렬화
            out.writeObject(Elvis.INSTANCE); // 엘비스 객체를 저장함
        }catch (IOException e){
            e.printStackTrace();
        }

        try(ObjectInput in = new ObjectInputStream(new FileInputStream("elvis.obj"))){ // 역직렬화
            Elvis elvis3 = (Elvis) in.readObject(); // 저장해둔 엘비스 객체를 읽어옴
            System.out.println(elvis3 == Elvis.INSTANCE);
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

}
