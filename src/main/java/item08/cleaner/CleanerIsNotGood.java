package item08.cleaner;

import java.lang.ref.Cleaner;
import java.util.ArrayList;
import java.util.List;

public class CleanerIsNotGood {
    public static void main(String[] args) throws InterruptedException{
        Cleaner cleaner = Cleaner.create();
        List<Object> resourceToCleanUp = new ArrayList<>();
        BigObject bigObject = new BigObject(resourceToCleanUp);

        // 1번째 인자 인스턴스가 해제될 때 2번째 파라미터의 방법을(runnable) 사용해라
        cleaner.register(bigObject,new BigObject.ResourceCleaner(resourceToCleanUp));


        bigObject = null;
        System.gc();
        Thread.sleep(3000L );
    }
}
