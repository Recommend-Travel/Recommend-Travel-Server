package webProgramming.recommendTravel.dto.userfavorite.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
public class FavoriteDTOReq {
    private String user_id;
    private Long destination_id;
}
