package webProgramming.recommendTravel.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import webProgramming.recommendTravel.domain.user.User;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean findByUsername(String username);
}
