package honest.honestbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class fooddataController {
    @Autowired
    honest.honestbackend.service.userService fooddataService;
    @Autowired
    honest.honestbackend.service.userRepository fooddataRepository;
}
