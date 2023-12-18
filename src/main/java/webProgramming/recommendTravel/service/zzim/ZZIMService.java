package webProgramming.recommendTravel.service.zzim;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webProgramming.recommendTravel.domain.destination.Destination;
import webProgramming.recommendTravel.domain.favorite.Favorite;
import webProgramming.recommendTravel.domain.favorite_destination.FavoriteDestination;
import webProgramming.recommendTravel.domain.user.User;
import webProgramming.recommendTravel.domain.userfavorite.UserFavorite;
import webProgramming.recommendTravel.dto.destination.response.DestinationDTORes;
import webProgramming.recommendTravel.dto.userfavorite.request.FavoriteDTOReq;
import webProgramming.recommendTravel.dto.userfavorite.response.FavoriteDTORes;
import webProgramming.recommendTravel.repository.destination.DestinationRepository;
import webProgramming.recommendTravel.repository.favorite.FavoriteRepository;
import webProgramming.recommendTravel.repository.favorite_destination.FavoriteDestinationRepository;
import webProgramming.recommendTravel.repository.user.UserRepository;
import webProgramming.recommendTravel.repository.userfavorite.UserFavoriteRepository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class ZZIMService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private FavoriteRepository favoriteRepository;
    @Autowired
    private DestinationRepository destinationRepository;

    public FavoriteDTORes doZZim(FavoriteDTOReq dto) { // 대대적인 수정을 해야함
        return null;
    }

    public DestinationDTORes retrieveList(String userId) { // 대대적인 수정을 해야함
        User user = userRepository.findByuserid(userId); // 사용자 조회
        if (user == null) throw new IllegalArgumentException("사용자가 없어유");
        List<Favorite> favorites = favoriteRepository.findAllByUser(user); // 사용자의 찜목록 조회
//        if (favorites.size() == 0)
//            throw new IllegalArgumentException("사용자가 찜한 도시가 아무곳도 없어유");
        Destination destination = destinationRepository.findByMbti(user.getMbti_type());
        // 사용자 mbti 따른 Destination 조회
        return destination.getDestDTO(favorites); // destination과 favorites로 DTO 반환
    }
}
