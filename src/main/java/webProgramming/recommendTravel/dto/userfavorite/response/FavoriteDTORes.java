package webProgramming.recommendTravel.dto.userfavorite.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
public class FavoriteDTORes {
    private String user_id;
    private Long destination_id;
}
