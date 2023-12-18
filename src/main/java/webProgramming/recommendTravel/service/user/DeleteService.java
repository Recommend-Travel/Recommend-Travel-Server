package webProgramming.recommendTravel.service.user;

import org.springframework.stereotype.Service;
import webProgramming.recommendTravel.domain.communitypost.CommunityPost;
import webProgramming.recommendTravel.domain.user.User;
import webProgramming.recommendTravel.repository.comment.CommentRepository;
import webProgramming.recommendTravel.repository.communitypost.CommunityPostRepository;
import webProgramming.recommendTravel.repository.user.UserRepository;
import webProgramming.recommendTravel.repository.userfavorite.UserFavoriteRepository;

import java.util.List;
import java.util.Optional;
@Service
public class DeleteService {
    private final UserRepository userRepository;
    private final CommunityPostRepository communityPostRepository;
    private final CommentRepository commentRepository;
    private final UserFavoriteRepository userFavoriteRepository;

    public DeleteService(
            UserRepository userRepository,
            CommunityPostRepository communityPostRepository,
            CommentRepository commentRepository,
            UserFavoriteRepository userFavoriteRepository) {
        this.userRepository = userRepository;
        this.communityPostRepository = communityPostRepository;
        this.commentRepository = commentRepository;
        this.userFavoriteRepository = userFavoriteRepository;
    }

    public void deleteUser(String userid) {
        // 사용자 정보 및 관련 데이터 삭제
        Optional<User> optionalUser = userRepository.findByUserid(userid);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            // 여기에서 관련된 데이터 삭제 또는 처리 수행


            // 1. Delete User's Community Posts and associated Comments
            List<CommunityPost> communityPosts = communityPostRepository.findByUser(user);
            for (CommunityPost post : communityPosts) {
                // Delete associated comments
                commentRepository.deleteByCommunityPost(post);
            }
            communityPostRepository.deleteByUser(user);

            // 2. Delete User Favorites
            userFavoriteRepository.deleteByUser(user);

            // 3. 사용자 정보 삭제
            userRepository.delete(user);
        } else {
            throw new RuntimeException("사용자를 찾을 수 없습니다.");
        }
    }
}
