package SpringBootDemo.processor;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class SecondProcessor extends Processor {
    @Override
    public boolean canHandle(String process) {
        return "second".equalsIgnoreCase(process);
    }

    @Override
    public String doWork() {
        return "second is working on it";
    }
}
