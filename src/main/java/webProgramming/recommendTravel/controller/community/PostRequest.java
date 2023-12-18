package webProgramming.recommendTravel.controller.community;

public class PostRequest
{
    private String userid;
    private String title;
    private String content;

    public PostRequest(String userid, String title, String content)
    {
        this.userid = userid;
        this.title = title;
        this.content = content;
    }

    public String getUserid() { return userid; }
    public String getContent() { return content; }
    public String gettitle() { return title; }
}

