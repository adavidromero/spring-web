package hello.restcontroller;

import hello.controllers.*;
import hello.models.Customer;
import hello.models.Greeting;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestTestController {
    
    private static final String template = "Hello, %s!";
    private static AtomicLong counter = new AtomicLong();
        
    @RequestMapping("/greeting2")
    public Greeting greeting(@RequestParam(value="name", required=false, defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
    
    @RequestMapping("/new_customer")
    public Customer newCustomer(@RequestParam Map<String,String> requestParams) {
        String firstName=requestParams.get("firstName");
        String lastName=requestParams.get("lastName");
        Customer nc = new Customer(firstName, lastName);
        return nc;
    }
    
}
