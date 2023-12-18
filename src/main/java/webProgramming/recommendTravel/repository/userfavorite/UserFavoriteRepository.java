package webProgramming.recommendTravel.repository.userfavorite;

import org.springframework.data.jpa.repository.JpaRepository;
import webProgramming.recommendTravel.domain.user.User;
import webProgramming.recommendTravel.domain.userfavorite.UserFavorite;

import java.util.List;

public interface UserFavoriteRepository extends JpaRepository<UserFavorite, Long> {
    List<UserFavorite> findAllByUser(User user);
}
