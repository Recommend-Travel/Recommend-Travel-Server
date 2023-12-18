package webProgramming.recommendTravel.dto.destination.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class RecommendDestination {
    private String name; // 장소
    private String url; // 사진
}
