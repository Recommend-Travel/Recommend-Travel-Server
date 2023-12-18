package webProgramming.recommendTravel.domain.destination;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class RecommendedDestination {
    private Long destinationId;
    private String name;
    private String url;
}
