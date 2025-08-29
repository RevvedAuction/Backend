package za.co.revvedAuctions.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping(path={"/","/hello"})
    public String hellotest() {
        return "Hello, You are testing controller!";
    }
}
