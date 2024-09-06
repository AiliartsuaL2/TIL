package section4.item20.templatemethod;

import section4.item20.templatemethod.callback.CallbackFileProcessor;

public class Client {
    public static void main(String[] args) {
        FileProcessor fileProcessor = new Plus("/number.txt");
        System.out.println(fileProcessor.process());

        CallbackFileProcessor callbackFileProcessor = new CallbackFileProcessor("/number.txt");
        System.out.println(callbackFileProcessor.processCallback(Integer::sum));
        System.out.println(callbackFileProcessor.processCallback((a,b) -> a+b));
    }
}
