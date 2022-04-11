package honest.honestbackend.service;

import honest.honestbackend.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class userService {
    @Autowired
    userRepository userRepository;

    public void joinUser(User user){
        System.out.println("회원가입 요청 들어옴");
        userRepository.save(user);
    }
}
