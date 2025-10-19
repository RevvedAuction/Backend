package za.co.revvedAuctions.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/main-controller")
public class MainController {

    @RequestMapping("/on")
    public String main_On(HttpServletRequest request) {
        return "Testing Spring Security Application " + request.getSession().getId();
    }

    @RequestMapping("/off")
    public String main_Off(HttpServletRequest request){
        return "Not Testing Spring Security Application " + request.getSession().getId();
    }
}
