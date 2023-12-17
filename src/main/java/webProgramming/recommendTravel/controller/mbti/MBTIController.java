package webProgramming.recommendTravel.controller.mbti;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import webProgramming.recommendTravel.service.mbti.MBTIService;

@RestController
public class MBTIController {
    // MBTI api 여기서 받음
    @Autowired
    private MBTIService mbtiService;
}
