package webProgramming.recommendTravel.domain.favorite_destination;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import webProgramming.recommendTravel.domain.destination.Destination;
import webProgramming.recommendTravel.domain.userfavorite.UserFavorite;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class FavoriteDestination {
    // 보류
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fdId;
    @ManyToOne
    @JoinColumn(name = "destinationId")
    private Destination destination;
    @ManyToOne
    @JoinColumn(name = "favoriteId")
    private UserFavorite userFavorite;
}
