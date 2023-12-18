package webProgramming.recommendTravel.repository.favorite_destination;

import org.springframework.data.jpa.repository.JpaRepository;
import webProgramming.recommendTravel.domain.favorite_destination.FavoriteDestination;

public interface FavoriteDestinationRepository extends JpaRepository<FavoriteDestination, Long> {
}
