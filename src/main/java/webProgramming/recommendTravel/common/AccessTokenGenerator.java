package webProgramming.recommendTravel.common;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class AccessTokenGenerator {
    public static String generateToken(String userid) {
        // UUID 생성
        UUID uuid = UUID.randomUUID();

        // UUID를 문자열로 변환하여 토큰으로 사용
        String token = uuid.toString();

        // Include userid in the token payload
        Map<String, Object> payload = new HashMap<>();
        payload.put("userid", userid);

        // You can append the payload to the token or use a library to create a JWT
        // For simplicity, let's just concatenate them with a separator (you may want to use a better approach)
        token = token + "|" + payload.toString();

        return token;
    }
}
