package honest.honestbackend.controller;

import honest.honestbackend.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import honest.honestbackend.service.userRepository;
import honest.honestbackend.service.userService;

@Controller
public class testController {

    @Autowired
    userService userService;
    @Autowired
    userRepository userRepository;


    @RequestMapping(value="/json" , produces="application/json; charset=utf-8")  // json.do 라는 객체로
    public HttpStatus json(@RequestBody User user) {
        System.out.println(user.pringStirng());
        return HttpStatus.OK;
    }
}
