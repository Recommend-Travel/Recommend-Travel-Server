package webProgramming.recommendTravel.service.zzim;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webProgramming.recommendTravel.domain.destination.Destination;
import webProgramming.recommendTravel.domain.favorite_destination.FavoriteDestination;
import webProgramming.recommendTravel.domain.user.User;
import webProgramming.recommendTravel.domain.userfavorite.UserFavorite;
import webProgramming.recommendTravel.dto.destination.response.DestinationDTORes;
import webProgramming.recommendTravel.dto.userfavorite.request.FavoriteDTOReq;
import webProgramming.recommendTravel.dto.userfavorite.response.FavoriteDTORes;
import webProgramming.recommendTravel.repository.destination.DestinationRepository;
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
    private DestinationRepository destinationRepository;
    @Autowired
    private UserFavoriteRepository userFavoriteRepository;
    @Autowired
    private FavoriteDestinationRepository favoriteDestinationRepository;

    public FavoriteDTORes doZZim(String user_id, Long destination_id) {
        User user = userRepository.findByuserid(user_id);
        if (user == null) throw new IllegalArgumentException("사용자를 못찾았어유");
        Destination destination = destinationRepository.findById(destination_id).orElse(null);
        if (destination == null) throw new IllegalArgumentException("여행지를 못찾았어유");
        // 위에서 사용자, 여행지 있는지 확인
        LocalDateTime lDate = LocalDateTime.now();
        Date date = Timestamp.valueOf(lDate);
        UserFavorite userFavorite = new UserFavorite(null, user, date);
        // 시간 받고, UserFavorite 새로 생성
        if (userFavoriteRepository.save(userFavorite) == null)  // Favorite 저장
            throw new IllegalArgumentException("UserFavorite 저장 실패했어유");
        FavoriteDestination favoriteDestination = new FavoriteDestination(null, destination, userFavorite);
        favoriteDestinationRepository.save(favoriteDestination); // favoriteDestination 저장
        FavoriteDTORes dto = new FavoriteDTORes(user_id, destination_id);
        log.info(user.toString() + ", " + destination.toString());
        return dto;
    }

    public List<DestinationDTORes> retrieveList(String userId) {
        log.info("아이디 : " + userId);
        List<DestinationDTORes> result = new ArrayList<DestinationDTORes>();
        User user = userRepository.findByuserid(userId);
        if (user == null) throw new IllegalArgumentException("사용자를 못찾았어유");
        List<UserFavorite> favorites = userFavoriteRepository.findAllByUser(user); // 검색한 사용자가 찜한 목록 받아오기(user를 직접 넘겨줌)
        if (favorites.size() == 0) throw new IllegalArgumentException("사용자가 찜한 여행지가 한 곳도 없어유");
        // FavoriteDestination -> UserFavorite으로 아이디 받아올 수 있음
        for (UserFavorite favs : favorites) { // 찜목록에서 찜을 하나씩 꺼냄
            List<FavoriteDestination> fDests = favoriteDestinationRepository.findAllByUserFavorite(favs); // 그 찜에는 Dest정보가 리스트로 있음
            for (FavoriteDestination favoriteDestination : fDests){
                // Destination 엔티티 -> FavoriteDestination에서 아이디 받아올 수 있음
                Destination destination = favoriteDestination.getDestination();
                // DestinationDTORes -> Destination 엔티티에서 받아올 수 있음
                result.add(destination.getDTO());
            }
        }
        return result;
    }
}
