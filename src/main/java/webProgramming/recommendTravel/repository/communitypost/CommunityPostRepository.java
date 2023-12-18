package webProgramming.recommendTravel.repository.communitypost;

import org.springframework.data.jpa.repository.JpaRepository;
import webProgramming.recommendTravel.domain.communitypost.CommunityPost;
import webProgramming.recommendTravel.domain.user.User;

public interface CommunityPostRepository extends JpaRepository<CommunityPost, Long>
{
    CommunityPost findBypostId(Long postId);
}
