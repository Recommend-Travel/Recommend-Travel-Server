package webProgramming.recommendTravel.controller.community;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import webProgramming.recommendTravel.domain.comment.Comment;
import webProgramming.recommendTravel.service.community.CommunityService;

@RestController
public class CommunityController {
    @Autowired
    private CommunityService communityService;
}
