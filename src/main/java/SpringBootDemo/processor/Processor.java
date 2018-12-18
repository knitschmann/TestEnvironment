package SpringBootDemo.processor;

public abstract class Processor {

    public abstract boolean canHandle(String process);
    public abstract String doWork();
}
