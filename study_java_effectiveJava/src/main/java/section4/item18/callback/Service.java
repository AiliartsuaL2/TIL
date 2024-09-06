package section4.item18.callback;

public class Service {
    public void run(FunctionToCall functionToCall){
        System.out.println("다른 작업을 하다가...");
        functionToCall.call();
    }

    public static void main(String[] args) {
        Service service = new Service();
        BobFunction bobFunction = new BobFunction(service);
        BobFunctionWrapper bobFunctionWrapper = new BobFunctionWrapper(bobFunction);
        // BobFunction의 run에서 전달되는 this는 해당 BobFunction을 호출한 Wrapper가 아닌 자기 자신이기 때문에
        // self호출이 되는 문제가 생김.

        bobFunctionWrapper.run();
    }
}
