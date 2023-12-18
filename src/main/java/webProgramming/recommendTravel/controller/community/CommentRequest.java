package webProgramming.recommendTravel.controller.community;

public class CommentRequest
{
    private String userid;
    private Long postid;
    private String content;

    public CommentRequest(String userid, Long postid, String content)
    {
        this.userid = userid;
        this.postid = postid;
        this.content = content;
    }

    public String getUserid() { return userid; }
    public String getContent() { return content; }
    public Long getpostid() { return postid; }
}
