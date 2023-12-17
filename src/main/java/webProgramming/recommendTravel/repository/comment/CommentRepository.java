package webProgramming.recommendTravel.repository.comment;

import org.springframework.data.jpa.repository.JpaRepository;
import webProgramming.recommendTravel.domain.comment.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
