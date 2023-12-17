package webProgramming.recommendTravel.repository.communitypost;

import org.springframework.data.jpa.repository.JpaRepository;
import webProgramming.recommendTravel.domain.communitypost.CommunityPost;

public interface CommunityPostRepository extends JpaRepository<CommunityPost, Long> {
}
