package webProgramming.recommendTravel.service.user;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import webProgramming.recommendTravel.common.Exceptions;
import webProgramming.recommendTravel.domain.user.User;
import webProgramming.recommendTravel.repository.user.UserRepository;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(String userid, String username, String password, String email, String mbtiType) {
        try {
            User user = new User();
            user.setUserid(userid);
            user.setUsername(username);
            user.setPassword(password);
            user.setEmail(email);
            user.setMbti_type(mbtiType);
            return userRepository.save(user);
        } catch (DataIntegrityViolationException e) {
            throw new Exceptions.DuplicateEntryException("Username or email is already taken.", e);
        } catch (Exception e) {
            throw new Exceptions.RegistrationException("Failed to register user.", e);
        }
    }


    public User loginUser(String userid, String password) {
        Optional<User> optionalUser = userRepository.findByUserid(userid);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();

            // Simplified password check without Spring Security
            if (user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }



//    public boolean isUsernameTaken(String username) {
//        return userRepository.findByUsername(username) != null;
//    }
}
