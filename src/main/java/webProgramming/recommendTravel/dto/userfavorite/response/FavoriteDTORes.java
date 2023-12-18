package webProgramming.recommendTravel.dto.userfavorite.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
public class FavoriteDTORes {
    private String UserId;
    private String destinationName;
    private String imgUrl;
}
