package SpringBootDemo;

import SpringBootDemo.processor.Processor;
import SpringBootDemo.processor.ProcessorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProcessorController {

    @Autowired
    ProcessorFactory factory;

    @RequestMapping(value = "/process/{process}")
    @ResponseBody
    public ResponseEntity<String> response(@PathVariable String process) {
        Processor matchingProcessor = factory.getMatchingProcessor(process);
        return ResponseEntity.ok(matchingProcessor.doWork());
    }
}
