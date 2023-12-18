package webProgramming.recommendTravel.service.community;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webProgramming.recommendTravel.domain.comment.Comment;
import webProgramming.recommendTravel.domain.communitypost.CommunityPost;
import webProgramming.recommendTravel.domain.user.User;
import webProgramming.recommendTravel.repository.comment.CommentRepository;
import webProgramming.recommendTravel.repository.communitypost.CommunityPostRepository;
import webProgramming.recommendTravel.repository.user.UserRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class CommunityService
{
    private CommunityPostRepository communityPostRepository;
    private UserRepository userRepository;

    private CommentRepository commentRepository;

    @Autowired
    public void CommunityPostRepository(CommunityPostRepository communityPostRepository) {this.communityPostRepository = communityPostRepository;}
    @Autowired
    public void UserRepository(UserRepository userRepository) {this.userRepository = userRepository;}
    @Autowired
    public void CommentRepository(CommentRepository commentRepository) {this.commentRepository = commentRepository;}

    public CommunityPost makePost(String userid, String title, String content)
    {
        User tempuser = userRepository.findByuserid(userid);
        Date currentDate = new Date();
        if (tempuser == null) { throw new RuntimeException("User not found"); }

        CommunityPost newPost = new CommunityPost(null, tempuser, tempuser.getMbti_type(), title, content, currentDate);
        communityPostRepository.save(newPost);
        return newPost;
    }

    public Comment addComment(String userid, Long postId, String content)
    {
        User user = userRepository.findByuserid(userid);
        CommunityPost checkPost = communityPostRepository.findBypostId(postId);
        Date currentDate = new Date();
        if(checkPost == null)
        {
            throw new RuntimeException("null Post");
        }

        Comment newComment = new Comment(null, checkPost, user, content, currentDate);
        commentRepository.save(newComment);

        return newComment;
    }

    public List<CommunityPost> getPosts()
    {
        return new ArrayList<>(communityPostRepository.findAll());
    }
}
