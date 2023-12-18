package webProgramming.recommendTravel.controller.zzim;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import webProgramming.recommendTravel.dto.destination.response.DestinationDTORes;
import webProgramming.recommendTravel.dto.userfavorite.request.FavoriteDTOReq;
import webProgramming.recommendTravel.dto.userfavorite.response.FavoriteDTORes;
import webProgramming.recommendTravel.service.zzim.ZZIMService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/recommend-travel/favorites")
@Slf4j
public class ZZIMController {
    // 찜 api 여기서 받음
    @Autowired
    private ZZIMService zzimService;
    /*찜하기
    jsonCopy code
    { post 요청
      UserID: "dbalsend"(토큰), - 이건 어캐 처리하는지는 쫌있다가 보자
      destinationName: "도시",
      imgUrl: "이미지 주소"
    }
    jsonCopy code
    { post 응답(성공)
        "status": 200,
        "message": "찜하기가 성공적으로 완료되었습니다."
    }
    { post 응답(성공)
        "status": 400,
        "message": "잘못된 요청입니다. 필수 정보가 누락되었거나 형식이 올바르지 않습니다."
    }
     */
    @PostMapping("/add-to-favorites")
    public ResponseEntity<FavoriteDTORes> doZZim(@RequestBody FavoriteDTOReq dto) {
        log.info("리퀘 : " + dto.toString());
        FavoriteDTORes favorite = zzimService.doZZim(dto);
        log.info("페이보릿 : " + favorite.toString());
        return favorite != null ?
                 ResponseEntity.status(HttpStatus.OK).body(favorite) :
                 ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
    /*
    jsonCopy code
        { 목록 조회 성공시
          "status": 200,
          "message": "찜 목록 조회가 성공적으로 완료되었습니다.",
          "data": {
            "favorites": [
              {
                "destination_id": 1,
                "name": "파리",
                "description": "아름다운 도시 파리를 즐기세요!"
              },
              {
                "destination_id": 2,
                "name": "제주도",
                "description": "자연의 아름다움이 가득한 제주도에서 휴식을 즐기세요!"
              }
            ]
          }
        }
    jsonCopy code
        { 목록 조회 실패시
            "status": 400,
            "message": "잘못된 요청입니다. 필수 정보가 누락되었거나 형식이 올바르지 않습니다."
        }
     */
    @GetMapping("/{user_id}")
    public ResponseEntity<DestinationDTORes> retrieveList(@PathVariable String user_id) {
        DestinationDTORes destinationDTORes = zzimService.retrieveList(user_id);
        return destinationDTORes != null ?
                ResponseEntity.status(HttpStatus.OK).body(destinationDTORes) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

    }
}
