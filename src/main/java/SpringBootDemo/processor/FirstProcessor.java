package SpringBootDemo.processor;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class FirstProcessor extends Processor{
    @Override
    public boolean canHandle(String process) {
        return "first".equalsIgnoreCase(process);
    }

    @Override
    public String doWork() {
        return "first is working on it";
    }
}
