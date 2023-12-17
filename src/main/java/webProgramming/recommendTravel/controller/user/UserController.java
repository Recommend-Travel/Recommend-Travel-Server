package webProgramming.recommendTravel.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import webProgramming.recommendTravel.domain.user.User;
import webProgramming.recommendTravel.dto.UserRequest;
import webProgramming.recommendTravel.service.user.UserService;

@RestController
public class UserController {
    // 아이디 비번 api 여기서 받음

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public User registerUser(@RequestBody UserRequest userRequest) {
        return userService.registerUser(userRequest.getUserid() ,userRequest.getUsername(),
                userRequest.getPassword(), userRequest.getEmail(), userRequest.getMbti_type());
    }

}
