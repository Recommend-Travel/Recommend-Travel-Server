package webProgramming.recommendTravel.controller.community;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import webProgramming.recommendTravel.service.community.CommunityService;

@RestController
public class CommunityController {
    @Autowired
    private CommunityService communityService;
}
