package SpringBootDemo.processor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.List;

@Component
public class ProcessorFactory {

    //spring list injection
    @Autowired
    List<Processor> processors;

    public Processor getMatchingProcessor(String process) {
        for (Iterator<Processor> iter = processors.iterator(); iter.hasNext(); ) {
            Processor processor = iter.next();
            if (!iter.hasNext() || processor.canHandle(process)) {
                return processor;
            }
        }
        return null;
    }
}
