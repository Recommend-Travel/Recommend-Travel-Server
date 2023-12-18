package webProgramming.recommendTravel.dto.destination.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class DestinationDTOReq {
    private Long destinationId;
    private String name;
    private String description;
}
