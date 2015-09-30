package SpringDemo;

/**
 * Created by kevin on 18/09/15.
 */
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.*;

import javax.xml.transform.Result;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

//    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
//    public String greeting(@RequestParam(value="name", defaultValue="World") String name) {
//        return "redirect:index.html";
//        return new Greeting(counter.incrementAndGet(), String.format(template, name));
//    }

    @RequestMapping(value ="/greetings", method = RequestMethod.POST)
    @ResponseBody
    Greeting home(@RequestBody String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template,name));
    }
}