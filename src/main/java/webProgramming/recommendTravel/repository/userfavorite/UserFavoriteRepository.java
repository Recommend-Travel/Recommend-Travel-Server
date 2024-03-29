package webProgramming.recommendTravel.repository.userfavorite;

import org.springframework.data.jpa.repository.JpaRepository;
import webProgramming.recommendTravel.domain.user.User;
import webProgramming.recommendTravel.domain.userfavorite.UserFavorite;

public interface UserFavoriteRepository extends JpaRepository<UserFavorite, Long> {
    void deleteByUser(User user);

}
