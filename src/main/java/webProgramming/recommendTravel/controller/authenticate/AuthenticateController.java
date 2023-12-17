package webProgramming.recommendTravel.controller.authenticate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import webProgramming.recommendTravel.service.authenticate.AuthenticateService;

@RestController
public class AuthenticateController {
    // 아이디 비번 api 여기서 받음
    @Autowired
    private AuthenticateService authenticateService;
}
