package webProgramming.recommendTravel.service.user;

import org.springframework.stereotype.Service;
import webProgramming.recommendTravel.domain.user.User;
import webProgramming.recommendTravel.repository.user.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(String userid, String username, String password, String email, String mbtiType) {
        User user = new User();
        user.setUserid(userid);
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setMbti_type(mbtiType);
        return userRepository.save(user);
    }

//    public boolean isUsernameTaken(String username) {
//        return userRepository.findByUsername(username) != null;
//    }
}
