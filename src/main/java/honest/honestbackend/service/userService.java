package honest.honestbackend.service;

import honest.honestbackend.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class userService {
    @Autowired
    userRepository userRepository;

    public void joinUser(User user){
        userRepository.save(user);
    }
}
