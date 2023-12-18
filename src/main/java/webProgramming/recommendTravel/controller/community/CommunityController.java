package webProgramming.recommendTravel.controller.community;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import webProgramming.recommendTravel.domain.comment.Comment;
import webProgramming.recommendTravel.domain.communitypost.CommunityPost;
import webProgramming.recommendTravel.service.community.CommunityService;

import java.util.List;

@RestController
@RequestMapping("/recommend-travel")
public class CommunityController
{

    private CommunityService communityService;
    @Autowired
    public void communityService(CommunityService communityService)
    {
        this.communityService = communityService;
    }

    @PostMapping("/create-post")
    public CommunityPost createPost(@RequestBody PostRequest postRequest)
    {
        CommunityPost newPost = communityService.makePost(postRequest.getUserid(), postRequest.gettitle(), postRequest.getContent());

        if(newPost != null)
        {
            return newPost;
        }
        else return null;
    }

    @PostMapping("/add-comment")
    public Comment addComment(@RequestBody CommentRequest commentRequest)
    {
        Comment newComment = communityService.addComment(commentRequest.getUserid(), commentRequest.getpostid(), commentRequest.getContent());

        if(newComment != null)
        {
            return newComment;
        }
        else return null;
    }

    @GetMapping("/posts")
    public List getPosts()
    {
        return communityService.getPosts();
    }
}
