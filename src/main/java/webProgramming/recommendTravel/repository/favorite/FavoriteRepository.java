package webProgramming.recommendTravel.repository.favorite;

import org.springframework.data.jpa.repository.JpaRepository;
import webProgramming.recommendTravel.domain.favorite.Favorite;
import webProgramming.recommendTravel.domain.user.User;

import java.util.List;

public interface FavoriteRepository extends JpaRepository<Favorite, Long> {
    List<Favorite> findAllByUser(User user);
}
