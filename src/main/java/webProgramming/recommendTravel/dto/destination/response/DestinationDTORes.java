package webProgramming.recommendTravel.dto.destination.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class DestinationDTORes {
    private Long destinationId;
    private String name;
    private String description;
}
