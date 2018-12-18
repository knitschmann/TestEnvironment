package SpringBootDemo.processor;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(Ordered.LOWEST_PRECEDENCE)
public class DefaultProcessor extends Processor{

    @Override
    public boolean canHandle(String process) {
        return "default".equalsIgnoreCase(process);
    }

    @Override
    public String doWork() {
        return "default is working on it";
    }
}
