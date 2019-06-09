package ebook.model.outOfDB;

import java.util.Date;

public class Reply {
    public String from;
    public String to_whom;
    public String content;
    public Date time;

    public Reply(){
        this.time = new Date();
    }

    public Reply(String from, String to_whom, String content) {
        this.time = new Date();
        this.from = from;
        this.to_whom = to_whom;
        this.content = content;
    }

}
