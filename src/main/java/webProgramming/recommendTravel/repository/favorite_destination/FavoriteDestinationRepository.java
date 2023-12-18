package webProgramming.recommendTravel.repository.favorite_destination;

import org.springframework.data.jpa.repository.JpaRepository;
import webProgramming.recommendTravel.domain.favorite_destination.FavoriteDestination;
import webProgramming.recommendTravel.domain.userfavorite.UserFavorite;

import java.util.List;

public interface FavoriteDestinationRepository extends JpaRepository<FavoriteDestination, Long> {
    List<FavoriteDestination> findAllByUserFavorite(UserFavorite favorite);
}
