package webProgramming.recommendTravel.service.zzim;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webProgramming.recommendTravel.domain.user.User;
import webProgramming.recommendTravel.repository.user.UserRepository;

@Service
public class ZZIMService {
    @Autowired
    private UserRepository userRepository;
    public User getTest() {
        User user = new User(10l, "dbalsend", "유민재", "Godyell", "dbalsend@naver.com", "INFJ");
        return userRepository.save(user);
    }
}
