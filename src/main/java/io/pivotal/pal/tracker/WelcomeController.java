package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    //@Value("${welcome.message}")
    public String message;


    public WelcomeController(@Value("${welcome.message}") String mssg){

        this.message = mssg;
    }

    @GetMapping("/")
    public String sayHello() {
        return message;
    }
}
