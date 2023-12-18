package webProgramming.recommendTravel.repository.destination;

import org.springframework.data.jpa.repository.JpaRepository;
import webProgramming.recommendTravel.domain.destination.Destination;

public interface DestinationRepository extends JpaRepository<Destination, Long> {
    Destination findByMbti(String Mbti);
}
