package com.phoebus.assignment.endpoint;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//TO TEST THE END POINT

@RestController
public class HelloController {


    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String start() {

        return "start";
    }
}
