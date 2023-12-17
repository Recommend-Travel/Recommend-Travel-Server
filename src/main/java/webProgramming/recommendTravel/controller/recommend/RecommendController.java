package webProgramming.recommendTravel.controller.recommend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import webProgramming.recommendTravel.service.recommend.RecommendService;

@RestController
public class RecommendController {
    // 여행지 추천 api 여기서 받음
    @Autowired
    private RecommendService recommendService;
}
