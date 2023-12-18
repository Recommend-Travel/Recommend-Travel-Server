package webProgramming.recommendTravel.dto.destination.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class DestinationDTORes {
    private String mbti;
    private List<RecommendDestination> favoriteDestinations;
}
